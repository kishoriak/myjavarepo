package com.demo.bean;

public class Electronics extends Product{
	private int months;
	
	//Default constructor
	public Electronics() {
		super();
		this.months = 0;
	}

	//Parameterized constructor
	public Electronics(int itemCode, String itemName, double unitPrice, int quantity,int months) {
		super(itemCode, itemName, unitPrice, quantity);
		this.months = months;
	}

	//setters and getters
	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	//to display the product
	@Override
	public String toString() {
		return super.toString() + "Electronics [months=" + months + "]";
	}
	
}
