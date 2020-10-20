//Shubham Ramesh Tapele
//Electronics Class which extends Item Class and Stores Electronics Specific Variables

package com.demo.bean;

public class Electronics extends Item{
	private int warranty;
	private int qnty;

	
	//default Constructor
	public Electronics() {
		super();
	}
	
	//parameterised Constructor	
	public Electronics(int warranty, int qnty, int itemCode, String itemName, double price) {
		super();
		this.warranty = warranty;
		this.qnty = qnty;
	}




	
	//Getter and Seter Methods
	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	public int getQnty() {
		return qnty;
	}


	public void setQnty(int qnty) {
		this.qnty = qnty;
	}
	@Override
	public String toString() {
		return "Electronics [warranty=" + warranty + ", qnty=" + qnty + "]";
	}
	//compare function to sort by qnty
	public int compareTo(Electronics ob) {
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
