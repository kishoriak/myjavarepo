package com.demo.dao;

import java.util.Set;

import com.demo.bean.Products;

public interface ProdDao {

	void addProduct(Products prod, String type);

	Set<Products> getProds(String type);

}
