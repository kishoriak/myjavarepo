package com.demo.dao;
//name:adrija ghansiyal
//purpose:implementing product dao (data layer)
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.demo.bean.Apparels;
import com.demo.bean.Electronics;
import com.demo.bean.FoodItems;
import com.demo.bean.Product;
import com.demo.exception.ItemNotFoundException;

public class ProductDaoImpl implements ProductDao {
	
	static Set<Product> productSet;

	static {
		productSet=new HashSet<>();
		
	}
	//manually adding entries in the HashSet of Product, otherwise in future, file handling and user input will be used
	public void addItems() {
		productSet.add(new FoodItems(1000, "maggi", 12.0, 100, new Date(), new Date(), "yes"));
		productSet.add(new FoodItems(1001, "Pulses", 55.0, 50, new Date(), new Date(), "yes"));
		productSet.add(new FoodItems(1004, "Meat", 101.53, 5, new Date(), new Date(), "no"));
		productSet.add(new FoodItems(1006, "Jelly", 30.0, 73, new Date(), new Date(), "no"));
		
		productSet.add(new Apparels(1005, "t-shirt", 1000.0, 10, "small", "cotton"));
		productSet.add(new Apparels(1002, "sweater", 2000.0, 5,"medium", "woolen"));
		productSet.add(new Apparels(1003, "cardigan", 1001.53,22, "large", "cotton"));
		productSet.add(new Apparels(1007, "shirt", 500.99, 45,"large","woolen"));
		
		productSet.add(new Electronics(1010, "tv", 100000.0, 13, 10));
		productSet.add(new Electronics(1012, "mobile", 20000.0, 20,12));
		productSet.add(new Electronics(1013, "watch", 1101.53,50, 5));
		productSet.add(new Electronics(1009, "headphones", 300.0, 60,2));
		
	}
	//to get the set of particular category
	@Override
	public Set<Product> getSet(String category) throws ItemNotFoundException{
		addItems();
		Set<Product> targetSet=new HashSet<>();

		if((category.toLowerCase()).equals("food items")){ //creating a set of food items
			for(Product p:productSet) {
				if(p instanceof FoodItems) {
					targetSet.add(p);
				}
			}			
		}
		else if((category.toLowerCase()).equals("apparels")) {//creating a set of apparels
			for(Product p:productSet) {
				if(p instanceof Apparels) {
					targetSet.add(p);
					//System.out.print(p);
				}
			}
		}
		else if((category.toLowerCase()).equals("electronics")) {//creating a set of electronics
			for(Product p:productSet) {
				if(p instanceof Electronics) {
					targetSet.add(p);
				}
			}
		}
			
		if (targetSet!=null) //thowing exception
			return targetSet;
		else 
			throw new ItemNotFoundException("item not found");
		
	}

}
