//ankit bhadoriya
//Dataacess layer interface implemented by TestDao implemtation layer


package com.demo.dao;

import java.util.List;

import com.demo.bean.Products;

public interface TestDao {

	static Object getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	void addProducts(Products e);

	List<Product> sortData();//sortdata method called

}
