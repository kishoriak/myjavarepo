package com.demo.bean;

import java.util.Date;

public class Food extends Products {
	private Date dOfManf;
	private Date dOfExp;
	private boolean veg;
	

	// default constructor
	public Food() {
		super();
	}

	// parameterised constructor
	public Food(int itmCode, String itmName, double price, int qty,String pType,Date dOfManf, Date dOfExp, boolean veg) {
		super(itmCode,itmName,price,qty,pType);
		this.dOfManf = dOfManf;
		this.dOfExp = dOfExp;
		this.veg = veg;
	}
	
	//setter and getter methods
	public Date getdOfManf() {
		return dOfManf;
	}

	public void setdOfManf(Date dOfManf) {
		this.dOfManf = dOfManf;
	}

	public Date getdOfExp() {
		return dOfExp;
	}

	public void setdOfExp(Date dOfExp) {
		this.dOfExp = dOfExp;
	}

	public boolean isVeg() {
		return veg;
	}

	public void setVeg(boolean veg) {
		this.veg = veg;
	}
	
	//tostring method
	@Override
	public String toString() {
		return super.toString()+"Food [dOfManf=" + dOfManf + ", dOfExp=" + dOfExp + ", veg=" + veg + "]";
	}
	
	

}
