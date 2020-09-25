package com.demo.bean;

import java.sql.Date;

public class FoodItem extends Item {
	//Variable Declaration

	private Date mDate;
	private Date eDate;
	private String vegetarianType;
	//Default Constructor
	public FoodItem() {
		super();
	}
	
	//Parameterized constructor
	
	
	//Getter Setter Methods
	public FoodItem(int itemCode, String itemName, Double price,int Quantity, Date mDate, Date eDate, String vegetarianType,int Quantity) {
		super(itemCode, itemName, price,Quantity);
		this.mDate = mDate;
		this.eDate = eDate;
		this.vegetarianType = vegetarianType;
	}

	public Date getmDate() {
		return mDate;
	}
	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}
	public Date geteDate() {
		return eDate;
	}
	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}
	public String getVegetarianType() {
		return vegetarianType;
	}
	public void setVegetarianType(String vegetarianType) {
		this.vegetarianType = vegetarianType;
	}
	
	//toString method for display
	@Override
	public String toString() {
		return super.toString()+ ", mDate=" + mDate
				+ ", eDate=" + eDate + ", vegetarianType=" + vegetarianType ;
	}
	
	

}
