package com.demo.bean;

abstract public class apparel extends product {
	private int size;
	private String material;
	
	//default constructor
	public apparel() {
		size=0;
		material=null;
	}
	//patrametrised constructor

	public apparel(int itemCode, String itemName, int unitPrice,int size,String material, int quantity) {
		super(itemCode, itemName, unitPrice, quantity);
		this.material=material;
		this.size=size;
	}

	public apparel(int id) {
		super(id);
		
	}
	
	//generating getters and setters

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
	
	

	
	
	
	

}
