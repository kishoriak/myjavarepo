package com.demo.dao;

import java.util.Date;
import java.util.TreeSet;

import ccom.demo.bean.Apparel;
import ccom.demo.bean.Electronics;
import ccom.demo.bean.FoodItems;
import ccom.demo.bean.Product;

public class ProductDao implements ProductDaoInterface {
	static {
		foodItems = new TreeSet<FoodItems>();
		apparel = new TreeSet<Apparel>();
		electronics = new TreeSet<Electronics>();
	}
	static TreeSet<FoodItems> foodItems;
	static TreeSet<Apparel> apparel;
	static TreeSet<Electronics> electronics;

	// add dummy data
	@Override
	public void addDummyData() {
		for (int i = 0; i < 10; i++) {
			foodItems.add(new FoodItems("FoodItem" + (i + 1), Math.random() * 1000, (int) Math.random() * 10000,
					new Date(), new Date(), i % 2 == 0 ? true : false));
		}
		for (int i = 0; i < 10; i++) {
			apparel.add(new Apparel("Apparel" + (i + 1), Math.random() * 1000, i,
					(i + 1) * 10, i % 2 == 0 ? "cotton" : "wool"));
		}
		for (int i = 0; i < 10; i++) {
			electronics.add(
					new Electronics("Electronics" + (i + 1), Math.random() * 10000, i, 12));
		}

	}

	// get top 3 products
	@Override
	public TreeSet<Product> getTopProducts(String name) {
		int count = 0;
		TreeSet<Product> temp = new TreeSet<Product>();
		switch (name) {
		case "foodItems":
			for (Product p : foodItems) {
				if (count == 3) {
					break;
				}
				temp.add(p);
				count++;
			}
			return temp;

		case "apparel":
			for (Product p : apparel) {
				if (count == 3) {
					break;
				}
				temp.add(p);
				count++;
			}
			return temp;

		case "electronics":
			for (Product p : electronics) {
				if (count == 3) {
					break;
				}
				temp.add(p);
				count++;
			}
			return temp;
		}
		return null;
	}

}
