package com.demo.bean;

public class Electronics extends Products {
	private int warranty;
	
	//parameterised constructor
	public Electronics() {
		super();
	}
	
	//default constructor
	public Electronics(int itmCode, String itmName, double price, int qty,String pType,int warranty) {
		super(itmCode,itmName,price,qty,pType);
		this.warranty = warranty;
	}
	
	//getter and setter methods
	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	@Override
	public String toString() {
		return super.toString()+"Electronics [warranty=" + warranty + "]";
	}
	
	
	
	
}
