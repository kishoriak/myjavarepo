package com.demo.bean;

import com.demo.exception.InsufficientBalanceException;

public class SavingsAcc extends Account {
	private static final float interestRate=4.0f;
	private String chequeBookNo;
	//default constructor
	public SavingsAcc() {
		chequeBookNo=ifsc+"CH"+(++count).toString();
	}
	//parameterized constructor
	public SavingsAcc(String name,double bal,String type,int pin) {
		super(name,bal,type,pin);
		chequeBookNo=ifsc+"CH"+(++count).toString();
	}
	
	//setters and getters
	public String getChequeBookNo() {
		return this.chequeBookNo;
	}
	//overriding withdrawal method
	public int withdrawal(double amt) throws InsufficientBalanceException {
		if((getBalance()-10000)>=amt) {
			setBalance(getBalance()-amt);
			System.out.println("Successfully withdrawn from savings a/c");
			return 1;
		}
		else 
			throw new InsufficientBalanceException("Insufficient Balance");
		//return -1;
	}
	//to get total interest
	public double getInterest() {
		return getBalance()*interestRate+0.02*getBalance();
	}
	//toString method overridden
	public String toString() {
		return super.toString()+"\ninterest rate: "+this.interestRate+"\ncheque no.: "
				+this.chequeBookNo+"\ntotal interest amt: "+this.getInterest();
	}
	

}

