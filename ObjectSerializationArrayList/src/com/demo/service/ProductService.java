package com.demo.service;

import java.util.ArrayList;
import java.util.Set;

import com.demo.bean.Product;
import com.demo.exception.ProductNotFoundException;
import com.demo.exception.QuantityNotFoundException;
import com.demo.exception.QuantityNotValidException;

public interface ProductService {

	boolean addProduct() throws QuantityNotValidException ;

	

	ArrayList<Product> getProductList();



	void readData(String string);



	void writeData(String string, int f);



	boolean deletePerson(int id);



	boolean updateEmp(int id, double price, int qty) throws ProductNotFoundException;



	Product SearchById(int id) throws ProductNotFoundException;

}
