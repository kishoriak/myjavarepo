package com.collect.bean;

import java.util.Date;

import com.collect.exception.InsufficientBalanceException;

public class CurrentAcc extends Account{
	static {
		noOfTransPerDay = 3;
	}
	static int noOfTransPerDay;
	
	//default constructor
	public CurrentAcc() {
		
	}
	//parameterized constructor
	public CurrentAcc(String id, String nm, Date dt, String type, double bal, int pin) {
		super(id,nm,dt,type,bal,pin);
		calInterest();
	}
	
	//additional constructor for searchById
	public CurrentAcc(String id) {
		
		super(id);
	}
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