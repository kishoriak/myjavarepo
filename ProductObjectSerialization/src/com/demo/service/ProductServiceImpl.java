package com.demo.service;

import java.util.List;
import java.util.Scanner;
import com.demo.bean.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;
import com.demo.exception.CheckValueException;
import com.demo.exception.ProductNotFoundException;
import com.demo.exception.SimilarIdException;

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
	public boolean addProduct() throws CheckValueException, SimilarIdException {
		System.out.println("enter Prduct Id");
		int id=sc.nextInt();
		//check if id already exists
		boolean check=productDao.checkId(id);
		if(check==true) {
			throw new SimilarIdException("This Id already exists... Start again.");
		}
		System.out.println("enter Prduct Name");
		sc.nextLine();
		String pname=sc.nextLine();
		System.out.println("enter Prduct price");
		double price=sc.nextDouble();
		System.out.println("enter Prduct quantity");
		int qty=sc.nextInt();
		if((price)>0.0 & (qty)>0.0) {
			Product p=new Product(id,pname,price,qty);
			return productDao.addProduct(p);
		}else {
			throw new CheckValueException("Please check the value you have entered....");
		}
		}
		
	//get product list from Dao layer
	@Override
	public List<Product> getProductList() {
		return productDao.getAllProduct();
	}
	//read data from file
	@Override
	public void readData(String fname) {
		productDao.readDatafromFile(fname);
		
	}
	
	//writing data to file before exiting
	@Override
	public void writeData(String fname, boolean del, boolean upd) {
		if(del==true) {
			productDao.writeDataToFileDel(fname);}
		else if(upd==true) {
			productDao.writeDataToFileUpd(fname);
		}
	}
	//delete the product searched using id
	@Override
	public boolean deleteProduct() throws ProductNotFoundException {
		System.out.println("enter Prduct Id");
		int id=sc.nextInt();
		return productDao.deleteProduct(id);
	}
	//search for product using id
	@Override
	public Product searchProdID(int id) throws ProductNotFoundException {
		return productDao.searchId(id);
	}
	//update the product price and quantity
	@Override
	public boolean updateProduct() throws ProductNotFoundException {
		System.out.println("enter Prduct Id");
		int id=sc.nextInt();
		System.out.println("enter updated price");
		double price=sc.nextDouble();
		System.out.println("enter updated quantity");
		int qty=sc.nextInt();
		return productDao.updateProduct(id,price,qty);
	}

}
