package com.demo.bean;

abstract public class Account {
	private int id;
	private String Name;
	private double balance;
	private int pinNumber;
	final static float interestRate = 0.07f;
	private static int cnt = 0;
	
	public Account(String name, double balance, int pinNumber) {
		super();
		this.id = cnt++;
		Name = name;
		this.balance = balance;
		this.pinNumber = pinNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	
	abstract public double calculateInterest();

	@Override
	public String toString() {
		return "Account [id=" + id + ", Name=" + Name + ", balance=" + balance + ", pinNumber=" + pinNumber + "]";
	}
	
}
