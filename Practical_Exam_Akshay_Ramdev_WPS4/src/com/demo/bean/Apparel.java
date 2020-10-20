//Shubham Ramesh Tapele
//Apparel Class which extends Item Class and Stores Apparel Specific Variables

package com.demo.bean;

public class Apparel extends Item{
	private String size;
	private String material;
	private int qnty;
	
	//default constructor
	public Apparel() {
		super();
	}
	
	//parameterised Constructor	
	public Apparel(String size, String material, int qnty, int itemCode, String itemName, double price) {
		super();
		this.size = size;
		this.material = material;
		this.qnty = qnty;
	}
	
	//Getter and Setter Methods 
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
	public int getQnty() {
		return qnty;
	}
	public void setQnty(int qnty) {
		this.qnty = qnty;
	}

	
	@Override
	public String toString() {
		return "Apparel [size=" + size + ", material=" + material + ", qnty=" + qnty + "]";
	}
	//compare function to sort by qnty
	public int compareTo(Apparel ob) {
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
