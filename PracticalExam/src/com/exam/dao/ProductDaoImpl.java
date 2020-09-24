//Author : Akanksha Shrivastava
//Purpose : Implementation of ProductDao interface.

package com.exam.dao;

import java.util.Set;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import com.exam.bean.Apparel;
import com.exam.bean.Electronics;
import com.exam.bean.FoodItem;
import com.exam.bean.Product;
import com.exam.exception.DuplicateIdException;
import com.exam.exception.ItemNotFoundException;

public class ProductDaoImpl implements ProductDao {
	
	static Set<FoodItem> foodItems;
	static Set<Apparel> apparelList;
	static Set<Electronics> electronicItems;
	
	static {
		
		foodItems = new TreeSet<>();
		apparelList = new TreeSet<>();
		electronicItems = new TreeSet<>();
	}

	@Override
	public boolean addNewProduct(Product ob) throws DuplicateIdException {
		
		
		
		if(ob instanceof FoodItem) {
			foodItems.add((FoodItem)ob);
			return true;
		}
		else if(ob instanceof Apparel) {
			apparelList.add((Apparel)ob);
			return true;
		}
		else if(ob instanceof Electronics) {
			electronicItems.add((Electronics)ob);
			return true;
		}
	}

	@Override
	public void retrieve(Product ob) throws ItemNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void report(Product ob) {
		// TODO Auto-generated method stub
		
	}

}
