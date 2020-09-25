package com.demo.bean;

import com.demo.exception.InsufficientBalanceException;

public class CurrentAcc extends Account {
	
	private final int maxNoOfTrans=3;
	private static final float interestRate=0.2f;
	private int noOfTrans;
	//default constructor
	public CurrentAcc() {
		noOfTrans=0;
		//System.out.println("default constructor current a/c");
	}
	//parameterized constructor
	public CurrentAcc(String name,double bal,String type,int pin) {
		super(name,bal,type,pin);
		//System.out.println("Param constructor current a/c");
		noOfTrans=0;
	}
	//setters and getters
		public int getTrans() {
			return this.noOfTrans;
		}
		public void setTrans(int trans) {
			this.noOfTrans=trans;
		}

	
	//overriding withdrawal method
	public int withdrawal(double amt) throws InsufficientBalanceException{
		if((getBalance())>=amt) {
			setBalance(getBalance()-amt);
			System.out.println("Successfully withdrawn from current a/c");
			++noOfTrans;
			return 1;
		}
		else 
			throw new InsufficientBalanceException("Insufficient Balance");
		//return -1;
	}
	//to get total interest
	public double getInterest() {
			return getBalance()*interestRate;
	}
	//toString method overridden
	public String toString() {
		return super.toString()+"\ninterest rate: "+this.interestRate+"\nno of transactions.: "
				+this.noOfTrans+"\ntotal interest amt: "+this.getInterest();
	}
	
	

}
