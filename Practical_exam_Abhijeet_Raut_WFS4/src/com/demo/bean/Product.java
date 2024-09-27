package com.demo.bean;

public class Product implements Comparable<Product>{
	private int itemCode;
	private String itemName;
	private double unitPrice;
	private int quantity;
	
	// default constructor
	public Product() {
		super();
		this.itemCode = 0;
		this.itemName = null;
		this.unitPrice = 0.0;
		this.quantity = 0;
	}
	
	//Parametrized constructor
	public Product(int itemCode, String itemName, double unitPrice, int quantity) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
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
	
	
	
	@Override
	public int hashCode() {
		return itemCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (itemCode != other.itemCode)
			return false;
		return true;
	}

	//To print the object
	@Override
	public String toString() {
		return "Product [itemCode=" + itemCode + ", itemName=" + itemName + ", unitPrice=" + unitPrice + ", quantity="
				+ quantity + "]";
	}

	//Method to sort the products based on quantity
	@Override
	public int compareTo(Product obj) {
		if(this.getQuantity() < obj.getQuantity()) {
			return 1;
		}
		else if(this.getQuantity() == obj.getQuantity()) {
			return 0;
		}
		else {
			return -1;
		}
	}

}
