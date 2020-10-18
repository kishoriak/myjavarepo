package com.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.demo.bean.Products;

public class ProdDaoImpl implements ProdDao {
	static {
		eSet = new TreeSet<>();
		fSet = new TreeSet<>();
		aSet = new TreeSet<>();
	}
	static Set<Products> eSet;
	static Set<Products> fSet;
	static Set<Products> aSet;
	
	//dao layer function to add products
	@Override
	public void addProduct(Products prod, String type) {
		// TODO Auto-generated method stub
		if(type.equals("food")) {
			fSet.add(prod);
		}else if(type.equals("apparel")) {
			aSet.add(prod);
		}else {
			eSet.add(prod);
		}
	}
	//function to get 3 produ
	@Override
	public Set<Products> getProds(String type) {
		List<Products> list = new ArrayList<>();
		if(type.equals("food")) {
			
		}
	}
	
	
}
