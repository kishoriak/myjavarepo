package com.demo.bean;

import java.util.Date;

import com.demo.exception.InsufficientBalanceException;
import com.demo.exception.InvalidAmountException;

abstract public class Account {
	
	protected int id;
	private String name;
	private int pin;
	public static int interestRate;
	private double balance;
	private Date dateOfJoining;
	private String accountType;
	
	static {
		interestRate = 4;
	}
	
	//Default Constructor
	public Account() {
		id = 0;
		name = null;
		pin = 0;
		balance = 0;
		dateOfJoining = null;
		accountType = null;
	}
	
	//Parameterized Constructor
	public Account(int id, String name, int pin, double balance, Date dateOfJoining, String accountType) {
		this.id = id;
		this.name = name;
		this.pin = pin;
		this.balance = balance;
		this.dateOfJoining = dateOfJoining;
		this.accountType = accountType;
	}

	public Account(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateOfJoining == null) ? 0 : dateOfJoining.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pin;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this.id == ((Account)obj).getId()) {
			return true;
		}
		return false;
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
