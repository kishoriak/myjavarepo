package com.demo.dao;

import java.util.Set;

import com.demo.bean.Product;

public interface ProductDao {

	boolean addProduct(Product p);

	Set<Product> getAllProduct();

	void readDatafromFile(String fname);

	void writeDataToFile(String fname);

	boolean deleteAProduct(int id);

	boolean updatePriceAndQuantity(int id, double price, int qty);

	Product displayProductById(int id);



}
