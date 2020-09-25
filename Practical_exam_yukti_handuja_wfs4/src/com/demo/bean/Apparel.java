package com.demo.bean;

public class Apparel extends Item{
	
	//Variable created
	private int size;
	private String material;
	
	//Default Constructor
	public Apparel() {
		super();
	}
	
	//Parameterized Constructor
	public Apparel(int itemCode, String itemName, Double price,int quantity, int size, String material) {
		super(itemCode, itemName, price,quantity);
		this.size = size;
		this.material = material;
	}
	
	//Getter Setter methods
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
	
	//tostring function to display
	@Override
	public String toString() {
		return super.toString()+"size=" + size + ", material=" + material ;
	}
	
	

}
