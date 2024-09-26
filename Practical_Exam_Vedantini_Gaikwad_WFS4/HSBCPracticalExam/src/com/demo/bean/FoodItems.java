package com.demo.bean;

import java.util.Date;

public class FoodItems extends Product {
	private Date dateOfManu;
	private Date dateOfExp;
	private boolean veg;
	
	//default constructor
	public FoodItems() {
		super();
	}

	//parameterized constructor
	public FoodItems(int code, String name, int qty, double price,int type, Date dateOfManu, Date dateOfExp, boolean veg) {
		super(code, name, qty, price,type);
		this.dateOfManu = dateOfManu;
		this.dateOfExp = dateOfExp;
		this.veg = veg;
	}

	//setter and getter methods
	public Date getDateOfManu() {
		return dateOfManu;
	}


	public void setDateOfManu(Date dateOfManu) {
		this.dateOfManu = dateOfManu;
	}


	public Date getDateOfExp() {
		return dateOfExp;
	}


	public void setDateOfExp(Date dateOfExp) {
		this.dateOfExp = dateOfExp;
	}


	public boolean isVeg() {
		return veg;
	}


	public void setVeg(boolean veg) {
		this.veg = veg;
	}


	//toString of FoodItems 
	@Override
	public String toString() {
		return super.toString()+", dateOfManu=" + dateOfManu + ", dateOfExp=" + dateOfExp + ", veg=" + veg + "]";
	}
	
	
	
}
