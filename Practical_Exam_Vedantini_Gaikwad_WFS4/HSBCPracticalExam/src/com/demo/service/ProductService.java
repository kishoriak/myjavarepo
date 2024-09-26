package com.demo.service;

import java.util.Map;

//Vedantini gaikwad
//Business layer interface

import com.demo.bean.Product;

public interface ProductService {

	void addItems();
	
	Map<Integer,Product> displayItems();

	Map<Integer,Product> displayFoodItems();

	Map<Integer, Product> displayApparel();

	Map<Integer, Product> displayElectronic();
	
}
