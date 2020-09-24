package com.demo.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.demo.bean.Product;

//Vedantini gaikwad
//Data access layer implementation

public class ProductDaoImpl implements ProductDao {

	//member declaration
	static Map<Integer,Product> hashMap;
	
	static {
		hashMap = new HashMap<>();
	}
	
	//add data function
	@Override
	public void addData(Product product) {
		
		hashMap.put(product.getItemCode(), product);
	}

	public Map<Integer,Product> displayAll() {
		return hashMap;
	}

	//diplayfooditmes function
	@Override
	public Map<Integer, Product> displayAllFoodItems() {
		Map<Integer,Product> map=new HashMap<>();
		for(Product p:hashMap.values()) {
			if(p.getItemType()==1) {
				map.put(p.getQtySold(), p);
			}
			
		}
		return map;
	}

	//display apparels function
	@Override
	public Map<Integer, Product> displayAllApparels() {
		Map<Integer,Product> map=new HashMap<>();
		for(Product p:hashMap.values()) {
			if(p.getItemType()==2) {
				map.put(p.getQtySold(), p);
			}
			
		}
		return map;
	}

	//display electronics
	@Override
	public Map<Integer, Product> displayAllElectronics() {
		Map<Integer,Product> map=new HashMap<>();
		for(Product p:hashMap.values()) {
			if(p.getItemType()==3) {
				map.put(p.getQtySold(), p);
			}
			
		}
		return map;
	}
}
