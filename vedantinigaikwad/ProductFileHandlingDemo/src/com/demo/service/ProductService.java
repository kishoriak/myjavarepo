package com.demo.service;

import java.util.List;

import com.demo.bean.Product;
import com.demo.exception.InvalidPriceException;
import com.demo.exception.ProductAlreadyExistsException;
import com.demo.exception.ProductNotFoundException;

public interface ProductService {

	void readData(String fname);

	void writedata(String fname);

	boolean addProduct() throws ProductAlreadyExistsException, InvalidPriceException;

	List<Product> displayAll();

	Product displayById(int id)throws ProductNotFoundException;

	boolean deleteProduct(int id) throws ProductNotFoundException;

	boolean updateProduct(int id, double price, int qty) throws ProductNotFoundException;

}
