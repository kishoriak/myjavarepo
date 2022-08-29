package com.demo.bean;
import java.text.SimpleDateFormat;


public class FoodItems extends Products{
	private int item_code;
	private String Item_name;
	private int unit_price;
	private String dateOfManufacture;
	private String  dateOfExpiry;
	private boolean vegitarian;
	
	
//default constructor	
	public FoodItems() {
		super();
		this.item_code = 0;
		Item_name = null;
		this.unit_price = 0;
		this.dateOfManufacture =null;
		this.dateOfExpiry = null;
		this.vegitarian = false;
	}


	
	
	//parameterised constructor
	public FoodItems(int Type,int item_code, String item_name, int unit_price, Date dateOfManufacture, Date dateOfExpiry,
		boolean vegitarian) {
		super(Type);
		this.item_code = item_code;
		Item_name = item_name;
		this.unit_price = unit_price;
		this.dateOfManufacture = dateOfManufacture;
		this.dateOfExpiry = dateOfExpiry;
		this.vegitarian = vegitarian;
	}

	

	
	
	
	
	
	
	

}
