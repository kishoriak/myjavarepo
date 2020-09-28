package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.bean.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;
import com.demo.exception.ProductAlreadyExistsException;
import com.demo.exception.ProductNotFoundException;
import com.demo.exception.InvalidPriceException;

public class ProductServiceImpl implements ProductService {

	static Scanner sc;
	static {
		sc=new Scanner(System.in);
	}
	public ProductServiceImpl(){
		this.productDao=new ProductDaoImpl();
	}
	private ProductDao productDao;
	@Override
	public void readData(String fname) {
		
		productDao.readDataFromFile(fname);
		
	}
	@Override
	public void writedata(String fname) {
		
		productDao.writeDataToFile(fname);
		
	}
	@Override
	public boolean addProduct() throws ProductAlreadyExistsException, InvalidPriceException {
		System.out.println("enter Prduct Id");
		int id=sc.nextInt();
		System.out.println("enter Prduct Name");
		sc.nextLine();
		String pname=sc.nextLine();
		System.out.println("enter Prduct quantity");
		int qty=sc.nextInt();
		int i=0;
		try {
			for(i=0;i<3;i++) {
				System.out.println("enter Prduct price");
				double price=sc.nextDouble();
				if(price<10) {
					throw new InvalidPriceException("Price should be >0");
				}
				Product p=new Product(id,pname,price,qty);
				return productDao.addNewProduct(p);
			}
				
		}catch(InvalidPriceException e) {
			if(i==2) {
				System.out.println(e.getMessage());
				throw e;
			}
		}
		return false;
		
	}
	@Override
	public List<Product> displayAll() {
		return productDao.getAllProducts();
	}
	@Override
	public Product displayById(int id) throws ProductNotFoundException{
		
		if(productDao.searchById(id)!=null) {
			return productDao.searchById(id);
		}
		else {
			throw new ProductNotFoundException("Invalid id");
		}
		
	}
	@Override
	public boolean deleteProduct(int id) throws ProductNotFoundException {
		Product p=productDao.searchById(id);
		if(p!=null) {
			return productDao.deleteOneProduct(id);
		}
		else {
			throw new ProductNotFoundException("Invalid id");
		}
	}
	@Override
	public boolean updateProduct(int id, double price, int qty) throws ProductNotFoundException {
		Product p=productDao.searchById(id);
		if(p!=null) {
			return productDao.updateOneProduct(p,price,qty);
		}
		else {
			throw new ProductNotFoundException("Invalid id");
		}
	}

}
