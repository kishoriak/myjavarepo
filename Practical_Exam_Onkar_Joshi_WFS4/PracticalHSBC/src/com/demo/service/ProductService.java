package com.demo.service;

import java.util.List;

import com.demo.bean.Product;
import com.demo.exceptions.InvalidQuantityException;

public interface ProductService {
	public void newProduct(int n) throws InvalidQuantityException;
	
	public List<Product> sortOnQuantity() ;
}
