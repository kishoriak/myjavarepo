package com.demo.bean;

public class CurrentAccount extends Account {
	private int noOfTransactions;
	final public static double minBalance = 10000.0;

	public CurrentAccount(String name, double balance, int pinNumber) {
		super(name, balance, pinNumber);
		this.noOfTransactions = 3;
	}

	@Override
	public double calculateInterest() {
		return this.getBalance() * Account.interestRate;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nCurrentAccount [noOfTransactions=" + noOfTransactions + "]";
	}
}
