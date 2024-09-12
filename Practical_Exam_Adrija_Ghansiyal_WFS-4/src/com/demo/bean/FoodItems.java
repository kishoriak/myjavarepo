package com.demo.bean;

import java.util.Date;

//Author: Adrija Ghansiyal
//Purpose: Creates a child class of product which has properties related to FoodItems
public class FoodItems extends Product{
	private Date manufactureDate;
	private Date expiryDate;
	private String vegetarian;
	
	//default constructor
	public FoodItems() {
		super();
		this.manufactureDate = null;
		this.expiryDate = null;
		this.vegetarian = null;
	}
	
	//parameterized
	public FoodItems(int itemCode, String itemName, double unitPrice, int qty, Date manufactureDate, Date expiryDate, String vegetarian) {
		super(itemCode,itemName,unitPrice,qty);
		this.manufactureDate = manufactureDate;
		this.expiryDate = expiryDate;
		this.vegetarian = vegetarian;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String isVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(String vegetarian) {
		this.vegetarian = vegetarian;
	}
	
	
	

}
