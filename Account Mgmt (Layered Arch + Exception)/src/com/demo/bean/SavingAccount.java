package com.demo.bean;

public class SavingAccount extends Account {
	private String checkBookNo;
	final public static double minBalance = 0.0; 
	
	public SavingAccount(String name, double balance, int pinNumber) {
		super(name, balance, pinNumber);
		this.checkBookNo = "" + this.getId() + name;
	}

	public String getCheckBookNo() {
		return checkBookNo;
	}

	public void setCheckBookNo(String checkBookNo) {
		this.checkBookNo = checkBookNo;
	}
	
	@Override
	public double calculateInterest() {
		if(this.getBalance() > 50000) {
			return (this.getBalance() * Account.interestRate) + (this.getBalance() * 0.02);
		}else {
			return this.getBalance() * Account.interestRate;
		}
		
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nSavingAccount [checkBookNo=" + checkBookNo + "]";
	}
	
}
