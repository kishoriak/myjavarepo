package com.demo.service;
//This is the service layer interface 

import java.util.List;

import com.demo.bean.product;

public interface ProductService {
	void add(product p);
	List<product> top3food();
	List<product> top3apparel();
	List<product> top3electronics();

}
