package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.bean.product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImp;

// service layer implimentation

public class ProductServiceImp implements ProductService {
	
	static {
		Scanner s=new Scanner(System.in);
	}
	private ProductDao productDao;
	public ProductServiceImp() {
		this.productDao=new ProductDaoImp();
	}
	static Scanner s;
	
	
	

	@Override
	public void addProduct(product p) {
		
		
	}

	@Override
	public List<product> top3food() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<product> top3apparel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<product> top3electronics() {
		// TODO Auto-generated method stub
		return null;
	}

}
