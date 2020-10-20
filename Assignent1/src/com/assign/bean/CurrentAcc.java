package com.assign.bean;

import java.util.Date;

public class CurrentAcc extends Account{
	static {
		noOfTransPerDay = 3;
	}
	static int noOfTransPerDay;
	
	//default constructor
	public CurrentAcc() {
		
	}
	//parameterized constructor
	public CurrentAcc(String nm, Date dt, String type, double bal, int pin) {
		super(nm,dt,type,bal,pin);
		calInterest();
	}
	//setter and getter methods
	@Override
	public String toString() {
		return super.toString()+"\nNo. of transactions per day : "+noOfTransPerDay+"\nInterest : "+interest; 
	}
	@Override
	public int withdrawal(double amt) {
		
		if(amt <= balance) {
			balance-=amt;
			return 0;
			//System.out.println("Withdrawal Successful!");
			//System.out.println("Balance : "+balance);
		}
		return -1;
	}
	@Override
	public void calInterest() {
	
		interest = balance*rate;
	}
}
