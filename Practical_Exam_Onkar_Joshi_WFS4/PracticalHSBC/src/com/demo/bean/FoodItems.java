package com.demo.bean;

public class FoodItems extends Product{
	private String manDate;   //Variable for date of manufacture
	private String expDate;   //Variable for date of expiry
	private String veg;      //check if veg or not
	
	//default constructor
	public FoodItems() {
		super();
	}
	
	//parameterized constructor
	public FoodItems(int itemCode, String itemName, double unitPrice,int quantity,String manDate, String expDate, String veg) {
		super(itemCode,itemName,unitPrice,quantity);
		this.manDate = manDate;
		this.expDate = expDate;
		this.veg = veg;
	}
	//setter-getter methods
	public String getManDate() {
		return manDate;
	}

	public void setManDate(String manDate) {
		this.manDate = manDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getVeg() {
		return veg;
	}

	public void setVeg(String veg) {
		this.veg = veg;
	}
	//end of setter getter methods
	
	@Override//overrides toString method to print the object contents
	public String toString() {
		return super.toString()+"\nDate of Manufacture: "+manDate+"\nDate of Expiry: "+expDate+"\nVeg: "+veg;
	}
	
	
}
