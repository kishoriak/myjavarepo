package com.demo.dao;

import java.awt.List;
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
import java.util.HashSet;
import java.util.Set;

import com.demo.bean.Person;
import com.demo.bean.Product;
import com.demo.comparator.MyQuantityComparator;
import com.demo.comparator.MySalaryComparator;
import com.demo.exception.ProductNotFoundException;

public class ProductDaoImpl implements ProductDao{
     static ArrayList<Product> arrayList;
     static {
    	 arrayList=new ArrayList<>();
     }
     
     //adding data to product
	@Override
	public boolean addProduct(Product p) {
		return arrayList.add(p);
	}
	
	//displa all product
	@Override
	public ArrayList<Product> getAllProduct() {
		return arrayList;
	}
	
	//readDatafromFile
	@Override
	public void readDatafromFile(String fname) {
		System.out.println("in read data of dao");
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
			//e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		
	}
	
	//writeDataToFile
	@Override
	public void writeDataToFile(String fname,int f) {
		System.out.println("in write data of dao");
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fname));
				ObjectOutputStream oos1=new Appendable(new FileOutputStream(fname,true));){
			
			if(f==2)
			{
						
			  for(Product p:arrayList) {
				oos.writeObject(p);
			  }
			}
			else if(f==1)
			{
							
			  for(Product p:arrayList) {
				 oos1.writeObject(p);
				
			  }
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	
	//remove product
	@Override
	public boolean deletePerson(int id) {
		// TODO Auto-generated method stub
		Product p=new Product(id,null,0.0,0);
		return arrayList.remove(p);
	}
	
	//update person
	@Override
	public boolean updatePerson(Product p, double price, int qty) {
		// TODO Auto-generated method stub
		p.setPrice(price);
		p.setQty(qty);
		return true;
	}
	
	//search product 
	@Override
	public Product searchById(int id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		
		//indexOf
	   	Product e=null;
		
	    e=new Product(id,null,0.0,0);

		int pos=arrayList.indexOf(e);
		if(pos!=-1)
		{
			return arrayList.get(pos);
		}
		throw new ProductNotFoundException("Product with id "+id+" Not Found");
		
		//Iterate
	/*	
		for(Product p:arrayList) {
			if(p.getPid()==id) {
				return p;
			}
		}
		throw new ProductNotFoundException("Product with id "+id+" Not Found");
		*/
	}
	
	//sort data on quantity
	@Override
	
	public ArrayList<Product> sortData() {
		Collections.sort(arrayList, new MyQuantityComparator());
		return arrayList;
	}
}
