package com.demo.dao;

import java.util.HashMap;

import com.demo.bean.Product;

public interface ProductDaoInterface {
	void readDatafromFile(String fileName);

	void writeDataToFile(String fileName);

	void appendDataToFile(String fileName, Product p);

	boolean addProduct(Product p, String fileName);

	HashMap<Integer, Product> getAllProduct();

	String deleteProduct(int id, String fileName);

	Product updateProduct(int id, int qty, String fileName);

	Product getProductById(int id);

}
