package com.demo.bean;

import java.util.Date;

public class FoodItems extends Product{
	private Date dateOfManufacture;
	private Date dateOfExpiry;
	private boolean vegetarian;
	
	//parameterized constructor
	public FoodItems(int itemCode, String itemName, double unitPrice, int quantity, Date dateOfManufacture, Date dateOfExpiry, boolean vegetarian) {
		super(itemCode, itemName, unitPrice, quantity);
		this.dateOfManufacture = dateOfManufacture;
		this.dateOfExpiry = dateOfExpiry;
		this.vegetarian = vegetarian;
	}
	
	//setters and getters
	public Date getDateOfManufacture() {
		return dateOfManufacture;
	}
	public void setDateOfManufacture(Date dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}
	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}
	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}
	public boolean isVegetarian() {
		return vegetarian;
	}
	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}
	
	//to display product
	@Override
	public String toString() {
		return super.toString() + "FoodItems [dateOfManufacture=" + dateOfManufacture + ", dateOfExpiry=" + dateOfExpiry + ", vegetarian="
				+ vegetarian + "]";
	}
	
	
}
