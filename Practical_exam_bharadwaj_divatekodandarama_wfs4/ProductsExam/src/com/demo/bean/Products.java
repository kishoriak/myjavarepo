package com.demo.bean;

//product class described as base class
public class Products implements Comparable {
	private int itmCode;
	private String itmName;
	private double price;
	private int qty;
	private String pType;

	// default constructor
	public Products() {
		super();
		this.itmCode = 0;
		this.itmName = null;
		this.price = 0;
		this.qty = 0;
		this.pType = null;
	}

	// parameterised constructor
	public Products(int itmCode, String itmName, double price, int qty, String pType) {
		super();
		this.itmCode = itmCode;
		this.itmName = itmName;
		this.price = price;
		this.qty = qty;
		this.pType = pType;
	}

	// getter and setter methods for variables
	public int getItmCode() {
		return itmCode;
	}

	public void setItmCode(int itmCode) {
		this.itmCode = itmCode;
	}

	public String getItmName() {
		return itmName;
	}

	public void setItmName(String itmName) {
		this.itmName = itmName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}

	// tostring method to print the values
	@Override
	public String toString() {
		return "Products [itmCode=" + itmCode + ", itmName=" + itmName + ", price=" + price + ", qty=" + qty
				+ ", pType=" + pType + "]";
	}
	//compareto method for treeset to sort on quantities
	@Override
	public int compareTo(Object o) {
		if(this.qty > ((Products)o).qty)
			return -1;
		if(this.qty < ((Products)o).qty)
			return 1;
		else
			return 0;
	}

}
