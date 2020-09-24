//Shubham Ramesh Tapele
//Item Class(Parent Class)

package com.demo.bean;

public class Item {
	private int itemCode;
	private String itemName;
	private double price;
	
	//default constructor
	public Item() {
		super();
	}
	
	//parameterised constructor
	public Item(int itemCode, String itemName, double price) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.price = price;
	}
	
	
	//Getter and Setter methods of all the variables
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	//toString method
	@Override
	public String toString() {
		return "Item [itemCode=" + itemCode + ", itemName=" + itemName + ", price=" + price + "]";
	}
	

}
