package com.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.demo.bean.Product;
import com.demo.exception.ProductNotFoundException;

public interface ProductDao {

	boolean addProduct(Product p);

	ArrayList<Product> getAllProduct();

	void readDatafromFile(String fname);

	void writeDataToFile(String fname, int f);

	boolean deletePerson(int id);

	boolean updatePerson(Product p, double price, int qty);

	Product searchById(int id) throws ProductNotFoundException;

	List<Product> sortData();



}
