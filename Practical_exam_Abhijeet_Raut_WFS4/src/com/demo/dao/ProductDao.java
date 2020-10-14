package com.demo.dao;

import java.util.List;
import java.util.Set;

import com.demo.bean.Product;

//Interface for dao layer
public interface ProductDao {

	//Dao layer methods
	void addProduct(Product product, int choice);

	List<Product> getProducts(int choice2);

	



}
