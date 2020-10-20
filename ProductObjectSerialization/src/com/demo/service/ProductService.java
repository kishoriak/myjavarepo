package com.demo.service;

import java.util.List;

import java.util.Set;

import com.demo.bean.Product;
import com.demo.exception.CheckValueException;
import com.demo.exception.ProductNotFoundException;
import com.demo.exception.SimilarIdException;

public interface ProductService {

	boolean addProduct() throws CheckValueException, SimilarIdException;

	

	List<Product> getProductList();



	void readData(String string);



	void writeData(String string, boolean b, boolean c);



	boolean deleteProduct() throws ProductNotFoundException;



	Product searchProdID(int id) throws ProductNotFoundException;



	boolean updateProduct() throws ProductNotFoundException;

}
