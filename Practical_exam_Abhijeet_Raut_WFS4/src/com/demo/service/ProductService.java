package com.demo.service;

import java.util.List;

import com.demo.bean.Product;

//Interface for service layer
public interface ProductService {

	//Methods for service layer
	void addProduct(int i);

	List<Product> getProducts(int choice2);

}
