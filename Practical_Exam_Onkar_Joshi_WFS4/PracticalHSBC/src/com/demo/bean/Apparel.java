package com.demo.bean;

public class Apparel extends Product{
	private String size;
	private String material;
	
	//default constructor
	public Apparel() {
		super();
	}


	//parameterized constructor
	public Apparel(int itemCode, String itemName, double unitPrice,int quantity,String size, String material) {
		super(itemCode,itemName,unitPrice,quantity);
		this.size = size;
		this.material = material;
	}

	//setter-getter methods
	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}
	
	//end of setter getter methods
	
	@Override//overrides toString method to print the object contents
	public String toString() {
		return super.toString()+"\nSize: "+size+"\nMaterial: "+material;
	}

}
