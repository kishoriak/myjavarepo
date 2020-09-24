package com.demo.bean;

public class Electronics extends Item {
	private int warranty;
	private int quantity;
	
	
	
	public Electronics(int itemCode, String itemName, Double price, int quantity,int warranty) {
		super(itemCode, itemName, price,quantity);
		this.warranty = warranty;
		
	}
	public int getWarranty() {
		return warranty;
	}
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	@Override
	public String toString() {
		return super.toString+ "warranty=" + warranty + ", quantity=" + quantity ";
	}
	


}
