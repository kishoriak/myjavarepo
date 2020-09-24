package com.demo.bean;
//Author: Adrija Ghansiyal
//Purpose: Creates a child class of product which has properties related to Apparels

public class Apparels extends Product{
	
	private String size;
	private String material;
	
	//default
	public Apparels() {
		this.size = null;
		this.material = null;
	}
	
	//parameterized
	public Apparels(int itemCode, String itemName, double unitPrice, int qty,String size, String material) {
		super(itemCode,itemName,unitPrice,qty);
		this.size = size;
		this.material = material;
	}
	
	//setters and getters

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
	
	

}
