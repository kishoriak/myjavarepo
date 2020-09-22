package com.collect.bean;

import java.util.Date;

import com.collect.exception.InsufficientBalanceException;

abstract public class Account {
	static {
		rate = 4.0f;
	}
	static float rate;
	private String accId;
	private String name;
	private Date openingDate;
	private String accType;
	protected double balance;
	private int pin;
	protected double interest;
	
	//default constructor
	public Account() {
		accId = null;
		name = null;
		openingDate = null;
		accType = null;
		balance = 0.0;
		rate = 0.0f;
		pin = 0;
	}
	//parameterized constructor
	public Account(String id, String nm, Date dt, String type, double bal, int pin) {
		accId = id;
		name = nm;
		openingDate = dt;
		accType = type;
		balance = bal;
		this.pin = pin;
	}
	
	//additional constructor for searchById
	public Account(String id) {
		accId = id;
	}
	//setter and getter methods
	public void setAccId(String id) {
		this.accId = id;
	}
	public String getAccId() {
		return this.accId;
	}
	public void setName(String nm) {
		this.name = nm;
	}
	public String getName() {
		return this.name;
	}
	public void setOpeningDate(Date dt) {
		this.openingDate = dt;
	}
	public Date getOpeningDate() {
		return this.openingDate;
	}
	public void setAccType(String type) {
		this.accType = type;
	}
	public String getAccType() {
		return this.accType;
	}
	public void setBalance(double bal) {
		this.balance = bal;
	}
	public double getBalance() {
		return this.balance;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getPin() {
		return this.pin;
	}
	@Override
	public String toString() {
		return "Id : "+accId+"\nName : "+name+"\nOpening Date : "+openingDate+"\nAccount Type : "+accType+"\nBalance : "+balance+"\nRate of Interest : "+rate; 
	}
	
	@Override
	public boolean equals(Object ob) {
		
		System.out.println("in equals : "+accId+"-----"+((Account)ob).accId);
		if(this.accId.equals(((Account)ob).accId))
			return true;
		else
			return false;
	}
	
	//withdrawal function
	abstract public boolean withdrawal(double amt) throws InsufficientBalanceException; 
	//deposit function
	public void deposit(double amt) {
		balance+=amt;
		//System.out.println("Deposit Successful!");
		//System.out.println("Balance : "+balance);
	}
	//for calculating interest
	abstract public void calInterest();
}