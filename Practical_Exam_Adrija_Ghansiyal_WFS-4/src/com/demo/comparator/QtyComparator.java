package com.demo.comparator;

import java.util.Comparator;

import com.demo.bean.Product;

public class QtyComparator implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		if(o1.getQty()<o2.getQty())
		return 1;
		else if(o1.getQty()==o2.getQty())
			return 0;
		else 
			return -1;
	}

}
