package com.demo.service;
import java.util.*;

import com.demo.bean.Apparel;
import com.demo.bean.Electronics;
import com.demo.bean.FoodItems;
import com.demo.bean.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;
import com.demo.exceptions.InvalidQuantityException;
public class ProductServiceImpl implements ProductService{
	static {
		sc=new Scanner(System.in);
	}
	
	private ProductDao productdao;
	
	public ProductServiceImpl() {
		this.productdao = new ProductDaoImpl();
	}

	static Scanner sc;
	
	//input values for the data
	public void newProduct(int n) throws InvalidQuantityException{    
		System.out.println("enter item code:");
		int itemCode=sc.nextInt();
		System.out.println("enter item name:");
		String itemname=sc.next();
		System.out.println("enter Unit Price");
		double unitPrice=sc.nextDouble();
		System.out.println("enter Quantity:");
		int q=sc.nextInt();
		if(q>0) {
		if(n==1) {//if food items is selected
			System.out.println("enter Date of Manufacture:");
			String dom=sc.next();
			System.out.println("enter Date of Expiry:");
			String doe=sc.next();
			System.out.println("Veg(y/n)");
			String veg=sc.next();
			Product p=new FoodItems(itemCode,itemname,unitPrice,q,dom,doe,veg);
			productdao.newProduct(p);
		} if(n==2) {//if Apparal is selected
			System.out.println("enter Size");
			String size=sc.next();
			System.out.println("enter Material:");
			String mat=sc.next();
			Product p=new Apparel(itemCode,itemname,unitPrice,q,size,mat);
			productdao.newProduct(p);
			
		}if(n==3) {//if electronics is selected
			System.out.println("enter Warrent of product");
			int warr=sc.nextInt();
			Product p=new Electronics(itemCode,itemname,unitPrice,q,warr);
			productdao.newProduct(p);
		}
	}else {
		throw new InvalidQuantityException("Please check the quantity stored");
		
	}
	}
	
	public List<Product> sortOnQuantity()
	{
		return productdao.sortData();
	}

	



	
}

