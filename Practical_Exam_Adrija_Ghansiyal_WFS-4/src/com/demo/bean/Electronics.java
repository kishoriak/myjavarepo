package com.demo.bean;
//Author: Adrija Ghansiyal
//Purpose: Creates a child class of product which has properties related to Electronics

public class Electronics extends Product{
	
	private int warranty;
	
	//default
	public Electronics() {
		this.warranty=0;
	}
	//paramterized
	public Electronics(int itemCode, String itemName, double unitPrice, int qty,int warranty) {
		super(itemCode,itemName,unitPrice,qty);
		this.warranty = warranty;
	}
	//setter and getter
	public int getWarranty() {
		return warranty;
	}
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	
	

}
