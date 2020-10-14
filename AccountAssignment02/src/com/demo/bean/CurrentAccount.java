package com.demo.bean;

import java.util.Date;

import com.demo.exception.InsufficientBalanceException;

public class CurrentAccount extends Account{
	private int noOfTransactions;
	private static final int interestRate;
	static {
		interestRate = 0;
	}
	//Default constructor
	public CurrentAccount(){
		noOfTransactions = 3;
	}
	
	//Parameterized constructor
	public CurrentAccount(String name, int pin, double balance, Date dateOfJoining, String accountType) {
		super(name, pin, balance, dateOfJoining, accountType);
	}
	
	//Display object
	@Override
	public String toString() {
		return super.toString() + "\nNo of Transactions : " + noOfTransactions + "\nInterest :" + this.calculateInterest();
	}

	@Override
	public int withdraw(double amount) throws InsufficientBalanceException  {
		if(this.getBalance() - amount >= 0) {
			this.setBalance(this.getBalance() - amount);
			return 1;
		}
		throw new InsufficientBalanceException("Insufficient balance in your account");
	}

	@Override
	public double calculateInterest() {
		return this.getBalance() * interestRate /100;
	}
}
