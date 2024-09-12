package com.demo.bean;
//Author: Adrija Ghansiyal
//Purpose: Creates a parent class of product which has common attributes among all categories of product

public class Product {
	private int itemCode;
	private String itemName;
	private double unitPrice;
	private int qty;
	
	//default constructor
	public Product() {
		super();
		this.itemCode = 0;
		this.itemName = null;
		this.unitPrice = 0.0;
		this.qty = 0;
	}
	//parameterized constructor
	public Product(int itemCode, String itemName, double unitPrice, int qty) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.qty = qty;
	}
	
	//setters and getters for all variables
	
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
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	//Item Id will be considered as hashcode
	@Override
	public int hashCode() {
    	return itemCode;
	}
	//equals for comparing Item code of 2 products
	@Override
	public boolean equals(Object obj) {
	    if(this.itemCode==((Product)obj).itemCode)
	    	return true;
	    return false;
	}
	
	//to display object
	public String toString() {
		return "Item Code: "+itemCode+"\nItem Name: "+itemName+"\nunit Price: "+unitPrice+"\nQuantity: "+qty;
	}
	
		

}
