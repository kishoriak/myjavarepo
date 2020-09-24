package com.demo.bean;

public class Product  {
	private int itemCode;
	private String itemName;
	private double unitPrice;
	private int quantity;
	
	//default constructor
	public Product() {
		super();
	}
	//parameterlized constructor
	public Product(int itemCode, String itemName, double unitPrice,int quantity) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.quantity=quantity;
	}
	public Product(int itemcode) {
		super();
	}
	
	@Override//override equals method 
	public boolean equals(Object obj) {
		if(this.itemCode==((Product)obj).itemCode)
	    	return true;
	    return false;
	}
	
	//Setter-Getter Methods
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	//End of setter getter methods
	
	@Override//overrides toString method to print the object contents
	public String toString() {
		return "Product : item code=" + itemCode + ", \nitem name=" + itemName + ", \nprice=" + unitPrice + "\nquantity="+quantity;
	}
	
}
