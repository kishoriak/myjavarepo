package com.demo.dao;

import java.util.List;

import com.demo.bean.Product;
import com.demo.exception.ProductAlreadyExistsException;
import com.demo.exception.ProductNotFoundException;

public interface ProductDao {

	void readDataFromFile(String fname);

	void writeDataToFile(String fname);

	boolean addNewProduct(Product p) throws ProductAlreadyExistsException;

	List<Product> getAllProducts();

	Product searchById(int id);

	boolean deleteOneProduct(int id);

	boolean updateOneProduct(Product p, double price, int qty);

}
