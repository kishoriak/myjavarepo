package com.demo.service;

import java.util.TreeSet;

import ccom.demo.bean.Product;

public interface ProductServiceInterface {
	void addDummyData();

	TreeSet<Product> getTopProducts(String name);
}
