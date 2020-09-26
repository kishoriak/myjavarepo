package com.demo.comparator;

import java.util.Comparator;

import com.demo.bean.Product;

public class MyQuantityComparator implements Comparator {

	@Override
	public int compare(Object ob1, Object ob2) {
		// TODO Auto-generated method stub
		if(((Product)ob1).getQty()<((Product)ob2).getQty()){
			return -1;
		}
		else if(((Product)ob1).getQty()==((Product)ob2).getQty()) {
		    return 0;	
		}
		else {
			return 1;
		}
		
	}

	}


