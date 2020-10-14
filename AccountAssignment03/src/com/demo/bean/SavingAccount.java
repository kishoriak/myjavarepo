package com.demo.bean;

import java.util.Date;

import com.demo.exception.InsufficientBalanceException;

public class SavingAccount extends Account{
	private static int savingCount;
	private String chequeBookNo;
	private static final int interestRate;
	
	static {
		interestRate = 4;
		savingCount = 1;
	}
	
	//Default constructor
	public SavingAccount() {
		chequeBookNo = null;
	}
	
	//Parameterized constructor
	public SavingAccount(String name, int pin, double balance, Date dateOfJoining, String accountType) {
		super(savingCount, name, pin, balance, dateOfJoining, accountType);
		this.chequeBookNo = pin+"-"+super.getId();
		this.savingCount++;
	}
	
	//Constructor using fields
	public SavingAccount(int id) {
		super(id);
	}
	
	//Display object
	@Override
	public String toString() {
		return super.toString() + "\nCheque Book No : " + chequeBookNo + "\nInterest :" + this.calculateInterest();
	}

	@Override
	public int withdraw(double amount) throws InsufficientBalanceException {
		if(this.getBalance() - amount >= 10000) {
			this.setBalance(this.getBalance() - amount);
			return 1;
		}
		throw new InsufficientBalanceException("Insufficient balance in your account");
	}

	@Override
	public double calculateInterest() {
		if(this.getBalance() > 50000) {
			return this.getBalance() * interestRate/100 + 2 / this.getBalance();
		}
		
		return this.getBalance() * interestRate / 100;
	}

}
