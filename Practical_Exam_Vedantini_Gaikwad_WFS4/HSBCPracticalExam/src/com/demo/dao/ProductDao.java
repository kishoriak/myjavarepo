package com.demo.dao;

import java.util.Map;

import com.demo.bean.Product;


//Vedantini gaikwad
//data acess layer implementation

public interface ProductDao {

	void addData(Product product);
	
	Map<Integer,Product> displayAll();

	Map<Integer, Product> displayAllFoodItems();

	Map<Integer, Product> displayAllApparels();

	Map<Integer, Product> displayAllElectronics();

}
