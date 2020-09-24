//Ankit Bhadoriya
//TestDaoIMpl implements the Testdao interface which is a data acess layer
//it accepts the data from the user and then sorts the data in stored in array list and provides top three to service layer



package com.demo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.demo.bean.Products;

public class TestDaoImpl implements TestDao {
	
	
		static List<Products> elist=null;
		static {
			elist=new ArrayList<>();
		}
		
		
		
		




		@Override
		public void addProducts(Products e) {
			elist.add(e);
			
		}
		
		

	  	//sortData method internally calls MyquantityComparator to compare the products based on quantity
		@Override
		public List<Product> sortData() {
			Collections.sort(elist, new MyQuantityComparator());
			return elist;
		}

		



	

}



