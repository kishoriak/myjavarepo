package com.demo.bean;

public class Apparel extends Product {
	
	private String size;
	private String material;
	
	//default constructor
	public Apparel() {
		size=null;
		material=null;
	}

	//parameterized constructor
	public Apparel(int code, String name, int qty, double price, int type,String size, String material) {
		super(code, name, qty, price,type);
		this.size = size;
		this.material = material;
	}

	//setter and getter methods
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

	//toString of apparels
	@Override
	public String toString() {
		return super.toString() +", size=" + size + ", material=" + material;
	}
	
	
}
