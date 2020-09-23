package com.demo.dao;
import com.demo.exception.*;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import com.demo.bean.Product;

public class ProductDaoImpl implements ProductDao{
     static List<Product> arrayList=null;
     static {
    	 arrayList=new ArrayList<>();
     }
	@Override
	public boolean addProduct(Product p) {
		return arrayList.add(p);
	}
	@Override
	public List<Product> getAllProduct() {
		return arrayList;
	}
	@Override
	public void readDatafromFile(String fname) {
		//System.out.println("in read data of dao");
		File f=new File(fname);
		if(f.exists()) {
			try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fname))){
				while(true) {
					try {
					Product p=(Product) ois.readObject();
					arrayList.add(p);
					}catch(EOFException e) {
						System.out.println("Reched to EOF......");
						break;
					}
				}
				System.out.println(arrayList.size());
			
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void writeDataToFileDel(String fname) {
		//System.out.println("in write data of dao");
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fname));){
			
			for(Product p:arrayList) {
				oos.writeObject(p);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void writeDataToFileUpd(String fname) {
		//System.out.println("in write data of dao");
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fname,true));){
			
			for(Product p:arrayList) {
				oos.writeObject(p);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public Product searchId(int id) throws ProductNotFoundException{
		for(Product p:arrayList) {
			if(p.getPid()==id) {
				return p;
			}
		}
		throw new ProductNotFoundException("Product not Found.. Please Check Id again.....");
		}

	public boolean deleteProduct(int id) throws ProductNotFoundException {
		Product p=new Product();
		p=searchId(id);
		if(p!=null) {
		arrayList.remove(p);
		return true;
		}else {
			throw new ProductNotFoundException("Product not Found.. Please Check Id again.....");
	}
		}
	@Override
	public boolean updateProduct(int id, double price, int qty) throws ProductNotFoundException {
		Product p=new Product();
		p=searchId(id);
		if(p!=null) {
		p.setPrice(price);
		p.setQty(qty);
		//arrayList.add(p);
		return true;
		}else {
		throw new ProductNotFoundException("Product not Found.. Please Check Id again.....");
		}
	}
	public boolean checkId(int id) {
		for(Product p:arrayList) {
			if(p.getPid()==id) {
				return true;
				}
			}
		return false;
	}
}