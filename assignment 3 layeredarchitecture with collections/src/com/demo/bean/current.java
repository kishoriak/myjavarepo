package com.demo.bean;

import com.demo.exception.InsufficientBalanceException;

public class current extends Account {
	
	private final int maxtransactions=3;
	private static final float interestRate=0.2f;
	private int nooftransactions;
	//default constructor
	public current() {
		nooftransactions=0;

	}
	//parameterized constructor
	public current(String name,double bal,String type,int pin) {
		super(name,bal,type,pin);

		nooftransactions=0;
	}
	//setters and getters
		public int getTrans() {
			return this.nooftransactions;
		}
		public void setTrans(int trans) {
			this.nooftransactions=trans;
		}

	
	//overriden withdrawal
	public int withdrawal(double amt) throws InsufficientBalanceException{
		if((getBalance())>=amt) {
			setBalance(getBalance()-amt);
			System.out.println("Successfully withdrawn from current account");
			++nooftransactions;
			return 1;
		}
		else 
			throw new InsufficientBalanceException("Insufficient Balance");
		//return -1;
	}
	//total interest
	public double getInterest() {
			return getBalance()*interestRate;
	}
}