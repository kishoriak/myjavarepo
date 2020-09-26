package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


import com.demo.bean.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;
import com.demo.exception.ProductNotFoundException;

import com.demo.exception.QuantityNotValidException;

public class ProductServiceImpl implements ProductService{
	static {
		sc=new Scanner(System.in);
	}
   static Scanner sc;
   public ProductServiceImpl() {
	  this.productDao=new ProductDaoImpl();
    }

private ProductDao productDao;
   //to add product 
	@Override
	public boolean addProduct() throws QuantityNotValidException  {
		
		System.out.println("enter Prduct Id");
		int id=sc.nextInt();
		System.out.println("enter Prduct Name");
		sc.nextLine();
		String pname=sc.nextLine();
		System.out.println("enter Prduct price");
		double price=sc.nextDouble();
		System.out.println("enter Prduct quantity");
		int qty=sc.nextInt();
		Product p=new Product(id,pname,price,qty);
		if(qty>0)
		{
			return productDao.addProduct(p);
			
		}
		else
		{
			throw new QuantityNotValidException("Enter Valid quantity");
		}
		/*Product p=new Product();
		p.setPid(id);
		p.setPname(pname);
		p.setPrice(price);
		p.setQty(qty);*/
		
	}
	//get product list from Dao layer
	@Override
	public ArrayList<Product> getProductList() {
		return productDao.getAllProduct();
	}
	@Override
	public void readData(String fname) {
		productDao.readDatafromFile(fname);
		
	}
	
	//writing data to file before exiting
	@Override
	public void writeData(String fname,int f) {
		productDao.writeDataToFile(fname,f);
		
	}
	@Override
	public boolean deletePerson(int id) {
		// TODO Auto-generated method stub
		return productDao.deletePerson(id);
	}
	@Override
	public boolean updateEmp(int id, double price, int qty) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		Product p=productDao.searchById(id);
		if(p!=null) {
		return productDao.updatePerson(p,price,qty);
		}
		return false;
	}
	@Override
	public Product SearchById(int id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return productDao.searchById(id);
	}

	
	//sort data on quantity
	public List<Product> sortOnBalance() {
		return productDao.sortData();
	}
	
	
}
