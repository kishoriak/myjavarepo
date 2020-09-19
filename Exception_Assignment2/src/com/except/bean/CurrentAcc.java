package com.except.bean;

import java.util.Date;

import com.except.exception.InsufficientBalanceException;

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
	public boolean withdrawal(double amt) throws InsufficientBalanceException{
		
		if(amt <= balance) {
			balance-=amt;
			return true;
			//System.out.println("Withdrawal Successful!");
			//System.out.println("Balance : "+balance);
		}
		else
			throw new InsufficientBalanceException("Insufficient Balance");
	}
	@Override
	public void calInterest() {
	
		interest = balance*rate;
	}
}