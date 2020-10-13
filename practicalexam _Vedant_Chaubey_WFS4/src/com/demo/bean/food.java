package com.demo.bean;

abstract public class food extends product{
	private String dateOfManufacture;
	private String dateOfExpiry;
	private boolean vegetarian;
	
	
	//default constructor
	public food() {
		dateOfManufacture=null;
		dateOfExpiry=null;
		vegetarian=(Boolean) null;
	}


	public food(int itemCode, String itemName, int unitPrice, String dateOfManufacture, String dateOfExpiry, boolean vegetarian, int quantity) {
		super(itemCode, itemName, unitPrice, quantity);
		this.dateOfManufacture=dateOfManufacture;
		this.dateOfExpiry=dateOfExpiry;
		this.vegetarian=vegetarian;
		
	}
	
	public food(int id) {
		super(id);
	}
	
	
	//generating getters and setters
	public String getDateOfManufacture() {
		return dateOfManufacture;
	}


	public void setDateOfManufacture(String dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}


	public String getDateOfExpiry() {
		return dateOfExpiry;
	}


	public void setDateOfExpiry(String dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}


	public boolean isVegetarian() {
		return vegetarian;
	}


	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}
	
	
	
}
