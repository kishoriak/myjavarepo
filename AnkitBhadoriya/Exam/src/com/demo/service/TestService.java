//Ankit Bhadoriya
//this is service layer interface its works as ablueprint for bussiness logic implementation




package com.demo.service;
import java.util.List;

import com.demo.bean.Products;


public interface TestService {

	
	List<Products> getProducts(int type);
	
	
	}

