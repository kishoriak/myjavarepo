package com.demo.bean;

public class Electronics extends Products {
	
		private int warranty;
		private int item_code;
		private String Item_name;
		private int unit_price;
		
		//default constructor
		public Electronics() {
			super();
			this.warranty = 0;
			this.item_code = 0;
			this.Item_name = null;
			this.unit_price = 0;
		}
		
		//parameterised constructor
		public Electronics(int Type,int warranty, int item_code, String item_name, int unit_price) {
		super(Type);
		this.warranty = warranty;
		this.item_code = item_code;
		Item_name = item_name;
		this.unit_price = unit_price;
	}

		
		
		//toSTring method to print data
		@Override
		public String toString() {
			return "Electronics [warranty=" + warranty + ", item_code=" + item_code + ", Item_name=" + Item_name
					+ ", unit_price=" + unit_price + "]";
		}
		
		
	
	
	
	
	
	

}
