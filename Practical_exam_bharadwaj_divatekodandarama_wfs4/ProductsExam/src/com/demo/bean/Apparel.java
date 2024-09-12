package com.demo.bean;

public class Apparel extends Products{
	private int size;
	private String material;
	
	//default  constructor
	public Apparel() {
		super();
		this.size =0;
		this.material=null;
	}
	
	//parameterised constructor
	public Apparel(int itmCode, String itmName, double price, int qty,String pType,int size, String material) {
		super(itmCode,itmName,price,qty,pType);
		this.size = size;
		this.material = material;
	}

	//generate getter and setter methods
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

	@Override
	public String toString() {
		return super.toString()+"Apparel [size=" + size + ", material=" + material + "]";
	}
	
	
	

}
