package com.demo.dao;

import java.util.List;

import com.demo.bean.Product;


public interface ProductDao {

	public void newProduct(Product p);
	public List<Product> sortData();

}
