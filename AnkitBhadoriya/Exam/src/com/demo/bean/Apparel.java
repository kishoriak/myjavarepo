package com.demo.bean;

import java.util.Date;

public class Apparel extends Products {
	
	
	private boolean  material;
	private int size;
	private int item_code;
	private String Item_name;
	private int unit_price;
	
	//default constructor
	public Apparel() {
		super();
		this.material = material;
		this.size = 0;
		this.item_code = 0;
		Item_name = null;
		this.unit_price = 0;
	}
	
	
	//parameterised constructor
	public Apparel(int Type,boolean material, int size, int item_code, String item_name, int unit_price) {
		super(Type);
		this.material = material;
		this.size = size;
		this.item_code = item_code;
		Item_name = item_name;
		this.unit_price = unit_price;
	}

	
//tostring method	
@Override
	public String toString() {
		return "Apparel [material=" + material + ", size=" + size + ", item_code=" + item_code + ", Item_name="
				+ Item_name + ", unit_price=" + unit_price + "]";
	}
	
	
	
	
	
	
	
	
}
