package com.demo.dao;

import java.util.List;
import java.util.Set;

import com.demo.bean.Product;
import com.demo.exception.ProductNotFoundException;

public interface ProductDao {

	boolean addProduct(Product p);

	List<Product> getAllProduct();

	void readDatafromFile(String fname);

	void writeDataToFileDel(String fname);
	
	void writeDataToFileUpd(String fname);
	
	boolean deleteProduct(int id) throws ProductNotFoundException;

	Product searchId(int id) throws ProductNotFoundException;
	
	boolean checkId(int id);

	boolean updateProduct(int id, double price, int qty) throws ProductNotFoundException;

	



}
