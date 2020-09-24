package com.demo.bean;

public class Apparel extends Product{
	private int size;
	private String material;
	
	//default constructor
	public Apparel() {
		super();
		this.size = 0;
		this.material = null;
	}
	
	//parameterized constructor
	public Apparel(int itemCode, String itemName, double unitPrice, int quantity, int size, String material) {
		super(itemCode, itemName, unitPrice, quantity);
		this.size = size;
		this.material = material;
	}

	//setters and getters
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	//to display product
	@Override
	public String toString() {
		return super.toString() + "Apparel [size=" + size + ", material=" + material + "]";
	}
	
	
	
	
}
