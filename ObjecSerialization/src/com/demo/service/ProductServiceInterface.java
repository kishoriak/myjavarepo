package com.demo.service;

import java.util.HashMap;

import com.demo.bean.Product;

public interface ProductServiceInterface {
	void readDataFromFile(String fileName);

	HashMap<Integer, Product> getProductList();

	void readData(String string);

	String deleteProduct(int id, String fileName);

	Product updateProduct(int id, int qty, String fileName);

	Product getProductById(int id);

}
