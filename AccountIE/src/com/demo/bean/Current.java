package com.demo.bean;

import java.util.Date;

public class Current extends Account {
	private int nOfTxn = 3;
	final static private float intRate = 2.4f;
	
	//default constructor
	public Current() {
	}
	
	//parameterized constructor
	public Current(String pName, int pin, Date dOp, double bal, String aType) {
		super(pName,pin,dOp,bal,aType);
		
	}
	
	//calculate interest
	public double interest(double bal) {
		return bal*intRate;
	}
	
		//function for withdraw operation
		public void withdraw(double amt) {
			if(!(balance <=0)) {
				balance = balance - amt;
			}
			else {
				System.out.println("Less balance");
			}
		}
	
	public String toString() {
		return super.toString() + "\n";
	}
}
