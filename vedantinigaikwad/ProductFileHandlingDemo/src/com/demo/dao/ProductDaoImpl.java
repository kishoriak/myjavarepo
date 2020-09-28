package com.demo.dao;

import java.util.List;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.demo.bean.Product;
import com.demo.exception.ProductAlreadyExistsException;
import com.demo.exception.ProductNotFoundException;

public class ProductDaoImpl implements ProductDao {
	
	static List<Product> arrayList;
	static {
		arrayList=new ArrayList();
	}
	@Override
	public void readDataFromFile(String fname) {
			
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
						}catch(ClassCastException e) {
							System.out.println("Class cast did not happen");
						}
					}
				
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
	public void writeDataToFile(String fname) {
		
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fname));){
			for(Product p:arrayList) {
				oos.writeObject(p);
			}
		}catch(IOException e) {
			System.out.println("Error Occured");
		}
		
	}
	@Override
	public boolean addNewProduct(Product p) throws ProductAlreadyExistsException  {
		if(arrayList.contains(p)) {
			throw new ProductAlreadyExistsException("Can not add duplicate product");
		}
		return arrayList.add(p);
	}
	@Override
	public List<Product> getAllProducts() {
		return arrayList;
	}
	@Override
	public Product searchById(int id){
			Product p=new Product(id);
			int pos=arrayList.indexOf(p);
			if(pos!=-1) {
				return arrayList.get(pos);
			}
			return null;
	}
	@Override
	public boolean deleteOneProduct(int id) {
		Product p=new Product(id);
		return arrayList.remove(p);
	}
	@Override
	public boolean updateOneProduct(Product p, double price, int qty) {
		p.setPrice(price);
		p.setQty(qty);
		return true;
	}
		
}

	
	
