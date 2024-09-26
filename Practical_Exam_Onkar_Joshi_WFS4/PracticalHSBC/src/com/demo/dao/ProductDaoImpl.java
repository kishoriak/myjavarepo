package com.demo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.demo.bean.Apparel;
import com.demo.bean.Electronics;
import com.demo.bean.FoodItems;
import com.demo.bean.Product;
import com.demo.comparator.QuantityBasedComparator;

public class ProductDaoImpl implements ProductDao {
	
	static List<Product> prodList,food,apparal,elec;
	static {
		prodList=new ArrayList<>();
		food=new ArrayList<>();
		apparal=new ArrayList<>();
		elec=new ArrayList<>();
	}
	
	public void newProduct(Product p) { //variable p is used for Product object
		prodList.add(p);
	}
	
	public void newProductF(FoodItems p) { //variable p is used for Product object
		food.add(p);
	}
	public void newProductA(Apparel p) { //variable p is used for Product object
		apparal.add(p);
	}
	public void newProductE(Electronics p) { //variable p is used for Product object
		elec.add(p);
	}
	
	public List<Product> sortData() {
		Collections.sort(prodList, new QuantityBasedComparator());
		return prodList;
	}

	
	/*public Product searchByCode(int itemcode) {
		Product p=null;
		p.setItemCode(itemcode);
		int pos=prodList.indexOf(p);
		if(pos!=-1)
		{
			return prodList.get(pos);
		}
		
	}*/



}
