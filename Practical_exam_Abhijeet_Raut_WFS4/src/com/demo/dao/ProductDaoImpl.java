package com.demo.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.demo.bean.Product;

//Class to handle storage related operations
public class ProductDaoImpl implements ProductDao{
	
	//static block to initialize same storage for all products
	static {
		foodItemsList = new ArrayList<>();
		apparelsList = new ArrayList<>();
		electronicsList = new ArrayList<>();
	}
	private static List<Product> foodItemsList; 
	private static List<Product> apparelsList; 
	private static List<Product> electronicsList; 
	

	//Method to add new product to storage
	@Override
	public void addProduct(Product product, int choice) { //choice for checking the category of product
		if(choice == 1) {
			foodItemsList.add(product);
		}
		else if(choice ==2) {
			apparelsList.add(product);
		}
		else {
			electronicsList.add(product);
		}
	}


	//To get top 3 the products based on quantity
	@Override
	public List<Product> getProducts(int choice) {
		List<Product> tempList = new ArrayList<>();
		if(choice == 1) {
			Collections.sort(foodItemsList);
			int size = foodItemsList.size();
			for(int i = 0;i<3;i++) {
				if(i < size) {
					tempList.add(foodItemsList.get(i));
				}
			}
		}
		else if(choice ==2) {
			Collections.sort(apparelsList);
			int size = apparelsList.size();
			for(int i = 0;i<3;i++) {
				if(i < size) {
					tempList.add(apparelsList.get(i));
				}
				
			}
		}
		else {
			Collections.sort(electronicsList);
			int size = electronicsList.size();
			for(int i = 0;i<3;i++) {
				if(i < size) {
				tempList.add(electronicsList.get(i));
				}
			}
		}
		return tempList;
		
	}
	
	
     
}
