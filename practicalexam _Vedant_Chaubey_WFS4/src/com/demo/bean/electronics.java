package com.demo.bean;

abstract public class electronics extends product{
	private int warranty;
	
	//default constructor
	public electronics() {
		warranty=0;
	}
	//parameterized constructor
	public electronics(int itemCode, String itemName, int unitPrice, int warranty, int quantity) {
		super(itemCode, itemName, unitPrice, quantity);
	
	}

	public electronics(int id) {
		super(id);
		
	}
	
	//generating gtters and setters
	public int getWarranty() {
		return warranty;
	}
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	
	
	
	
	
	
}
