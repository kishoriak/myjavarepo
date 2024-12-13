//Shubham Ramesh Tapele
//Food Class which extends Item Class and Stores Food Specific Variables

package com.demo.bean;

import java.util.Date;

public class Food extends Item{
	private String manu;
	private String exp;
	private String type;
	private int qnty;
	
	//default constructor
	public Food() {
		super();
	}
	
	
	//parameterised constructor
	public Food(String string, String string2, String type, int qnty, int itemCode, String itemName, double price) {
		super();
		this.manu = string;
		this.exp = string2;
		this.type = type;
		this.qnty = qnty;
	}
	
	
	//Getter and Setter Methods

	
	public String getManu() {
		return manu;
	}
	public void setManu(String manu) {
		this.manu = manu;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public int getQnty() {
		return qnty;
	}


	public void setQnty(int qnty) {
		this.qnty = qnty;
	}


	//toString Method
	@Override
	public String toString() {
		return "Food [manu=" + manu + ", exp=" + exp + ", type=" + type + ", qnty=" + qnty + "]";
	}
	//compare function to sort by qnty
	public int compareTo(Food ob) {
		System.out.println("In person compareTo"+qnty+"----"+ob.qnty);
		if(this.qnty>ob.qnty) {
			return -1;
		}else if(this.qnty==ob.qnty) {
			return 0;
		}
		else {
			return 1;
		}
	}

	
	
	
	
}
