package com.acc.bean;

import java.util.Date;

public class Account {
	static {
		cnt = 0;
	}
	static int cnt;
	private int accId;
	private String name;
	private Date openingDate;
	private String accType;
	private double balance;
	//private float rate;
	
	//default constructor
	public Account() {
		accId = ++cnt;
		name = null;
		openingDate = null;
		accType = null;
		balance = 0.0;
	}
	//parameterized constructor
	public Account(String nm, Date dt, String type, double bal) {
		accId = ++cnt;
		name = nm;
		openingDate = dt;
		accType = type;
		balance = bal;
	}
	//setter and getter methods
	/*public void setAccId(int id) {
		this.accId = id;
	}*/
	public int getAccId() {
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
	
	@Override
	public String toString() {
		return "Id : "+accId+"\nName : "+name+"\nOpening Date : "+openingDate+"\nAccount Type : "+accType+"\nBalance : "+balance; 
	}
	//withdrawal function
	public void withdrawal(double amt) {
		if(amt <= balance-10000) {
			balance-=amt;
			System.out.println("Withdrawal Successful!");
			//System.out.println("Balance : "+balance);
		}
		else
			System.out.println("Insufficient balance");
	}
	//deposit function
	public void deposit(double amt) {
		balance+=amt;
		System.out.println("Deposit Successful!");
		//System.out.println("Balance : "+balance);
	}
}
