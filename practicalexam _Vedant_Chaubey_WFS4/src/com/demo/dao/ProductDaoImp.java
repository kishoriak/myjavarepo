package com.demo.dao;

import java.util.*;

import com.demo.bean.product;


// product dao class which implements product dao interface
public class ProductDaoImp implements ProductDao {
	
	static List<product> productlist=null;
	static {
		productlist=new ArrayList<>();
		
	}

	@Override
	public void addProduct(product p) {
		productlist.add(p);
		
	}

	@Override
	public List<product> top3food() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<product> top3apparel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<product> top3electronics() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
