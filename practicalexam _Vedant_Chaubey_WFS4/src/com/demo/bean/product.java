package com.demo.bean;

abstract public class product {
	private int itemCode;
	private String itemName;
	private int unitPrice;
	private int quantity;
	
	public product() {
		itemCode=0;
		itemName=null;
		unitPrice=0;
		quantity=0;
	}
	
	//parametrized constructor
	public product(int itemCode, String itemName, int unitPrice, int quantity) {
		
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	
	public product(int id) {
		this.itemCode=id;
	}

	
	
	
	
	// generating getters and setters
	
	
	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
	
}
