package com.demo.bean;

public class Electronics extends Product {
	private int warrenty;

	//default constructor
	public Electronics() {
		super();
	}
	//parameterized constructor
	public Electronics(int itemCode, String itemName, double unitPrice,int quantity,int warrenty) {
		super(itemCode,itemName,unitPrice,quantity);
		this.warrenty = warrenty;
	}

	
	//setter-getter methods
	public int getWarrenty() {
		return warrenty;
	}

	public void setWarrenty(int warrenty) {
		this.warrenty = warrenty;
	}
	//end of setter getter methods
	
	@Override//overrides toString method to print the object contents
	public String toString() {
		return super.toString()+ "warrenty=" + warrenty;
	}
	
	
}
