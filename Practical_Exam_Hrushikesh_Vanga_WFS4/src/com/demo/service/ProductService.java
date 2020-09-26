package com.demo.service;

import java.util.TreeSet;

import com.demo.dao.ProductDao;

import ccom.demo.bean.Product;

public class ProductService implements ProductServiceInterface {
	
	private ProductDao productDao;
	
	public ProductService() {
		this.productDao = new ProductDao();
	}

	//add dummy data
	@Override
	public void addDummyData() {
		productDao.addDummyData();
	}

	//get top 3 products
	@Override
	public TreeSet<Product> getTopProducts(String name) {
		return productDao.getTopProducts(name);
		
	}

}
