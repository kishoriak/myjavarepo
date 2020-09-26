package com.demo.dao;

import java.util.TreeSet;


import ccom.demo.bean.Product;

public interface ProductDaoInterface {
	void addDummyData();
	TreeSet<Product> getTopProducts(String name);
}
