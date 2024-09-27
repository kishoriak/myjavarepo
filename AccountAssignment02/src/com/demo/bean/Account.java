package com.demo.bean;

import java.util.Date;

import com.demo.exception.InsufficientBalanceException;
import com.demo.exception.InvalidAmountException;

abstract public class Account {
	private static int count;
	private int id;
	private String name;
	private int pin;
	public static int interestRate;
	private double balance;
	private Date dateOfJoining;
	private String accountType;
	
	static {
		interestRate = 4;
		count = 1;
	}
	
	//Default Constructor
	public Account() {
		id = count++;
		name = null;
		pin = 0;
		balance = 0;
		dateOfJoining = null;
		accountType = null;
	}
	
	//Parameterized Constructor
	public Account(String name, int pin, double balance, Date dateOfJoining, String accountType) {
		this.id = count++;
		this.name = name;
		this.pin = pin;
		this.balance = balance;
		this.dateOfJoining = dateOfJoining;
		this.accountType = accountType;
	}

	//Display object
	@Override
	public String toString() {
		return "Id : " + id + "\nName : " + name + "\nBalance : " + balance + "\nDate of Joining :" + dateOfJoining + "\nType of Account : " + accountType;
	}

	//Setter and Getter Methods
	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public static int getInterestRate() {
		return interestRate;
	}

	public static void setInterestRate(int interestRate) {
		Account.interestRate = interestRate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	//To deposite amount in an account
	public void deposit(double amount) throws InvalidAmountException {
		if(amount > 0) {
			this.balance = this.balance + amount;
		}
		else {
			throw new InvalidAmountException("Enter valid amount");
		}
		
	}

	//To withdraw amount from an account
	public abstract int withdraw(double amount) throws InsufficientBalanceException;
	
	//To calculate interest
	public abstract double calculateInterest();

}
