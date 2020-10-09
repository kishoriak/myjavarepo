package com.demo.bean;

public class Product {
	private int itemCode;
	private String itemName;
	private int qtySold;
	private double unitPrice;
	private int type;
	
	//default constructor
	public Product() {
		itemCode=0;
		itemName=null;
		qtySold=0;
		unitPrice=0;
	}
	
	//parameterized constructor
	public Product(int code, String name, int qty, double price,int type) {
		this.itemCode = code;
		this.itemName = name;
		this.qtySold = qty;
		this.unitPrice = price;
		this.type=type;
	}

	//Setter and getter methods
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
	
	public int getItemType() {
		return type;
	}

	public void setItemType(int itemType) {
		this.type = itemType;
	}

	public int getQtySold() {
		return qtySold;
	}

	public void setQtySold(int qtySold) {
		this.qtySold = qtySold;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	

	@Override
	public int hashCode() {
		return itemCode;
	}

	@Override
	public boolean equals(Object obj) {
		if(this.itemCode==((Product)obj).getItemCode()) {
			return true;
		}
		return false;
	}

	//toString method of Product class
	@Override
	public String toString() {
		return "itemCode=" + itemCode + ", itemName=" + itemName + ", qtySold=" + qtySold + ", unitPrice="
				+ unitPrice;
	}
	
	
}
