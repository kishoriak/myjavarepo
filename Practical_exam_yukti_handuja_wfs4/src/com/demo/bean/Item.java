package com.demo.bean;

public class Item implements Comparable{
	//Declaration
	private int itemCode;
	private String itemName;
	private Double price;
	protected int quantity;

	
	public int getItemCode() {
		return itemCode;
	}
	//Default Constructor
	public Item() {
		itemCode=0;
		itemName=null;
		price=0.0;
		quantity=0;
	}
	//Parameterized Constructor
	public Item(int itemCode, String itemName, Double price, int quantity) {
	
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.price = price;
		this.quantity=quantity;
	}

	//Setter getter methods
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public boolean equals(Object obj) {
		if(this.itemCode==((Item)obj).getItemCode())
		{
			return true;
		}
		return false;
	}
	//Compare the objects on the basis of the quantity
	@Override
	public int compareTo(Object o) {
		if(this.quantity == ((Item)o).getQuantity())
		return 0;
		else if(this.quantity < ((Item)o).getQuantity())
			return 1;
		else
			return -1;
	}
	
	//Display using toString
	@Override
	public String toString() {
		return "itemCode=" + itemCode + ", itemName=" + itemName + ", price=" + price ;
	}
	
}
