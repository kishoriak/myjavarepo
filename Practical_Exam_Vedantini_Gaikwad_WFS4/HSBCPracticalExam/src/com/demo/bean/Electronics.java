package com.demo.bean;

public class Electronics extends Product {

	private int warranty;
	private String type;

	//default constructor
	public Electronics() {
		warranty=0;
	}

	//parameterized constructor
	public Electronics(int code, String name, int qty, double price,int type, int warranty) {
		super(code, name, qty, price,type);
		this.warranty = warranty;
	}

	//setter and getter methods
	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	//toString of Electronics
	@Override
	public String toString() {
		return super.toString() +", warranty=" + warranty;
	}
	
	
}
