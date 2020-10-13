package com.demo.bean;

import java.util.Date;

import com.demo.exception.InsufficientBalanceException;

public abstract class Account {
	static {
		count=0;
	}
	
	public static int count;
	
	private String id;
	private String name;
	private double balance;
	private int pin;
	private String acctype;
		
	final String ifsc="HSBC00";
		
	//default constructor
	public Account() {
		id= "";
		name=null;
		balance=0.0;
		acctype=null;
		pin=0;
	}
	//parameterized constructor
	public Account(String name,double bal,String type,int pin) {
		++count;
		id=ifsc+ Integer.toString(count);
		name=name;
		balance=bal;
		this.acctype=type;
		this.pin=pin;
	}
	
	//setters and getters
	
	public String getAccId() {
		return this.id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void setBalance(double bal) {
		this.balance=bal;
	}
	public double getBalance() {
		return this.balance;
	}
	public int getPin() {
		return this.pin;
	}
	public void setPin(int pin) {
		this.pin=pin;
	}
	public String getTypeAcc() {
		return acctype;
	}
	public void setTypeAcc(String acctype) {
		this.acctype = acctype;
	}
			
	//to withdraw amount from an account
	public abstract int withdrawal(double amt) throws InsufficientBalanceException;
	
	//to deposit in an account
	public void deposition(double amt) {
			balance=balance+amt;
			System.out.println("Successfully deposited");
	}
	
	//to display data of the user
	@Override
	public String toString() {
		return "id: "+id+"\nName: "+name+"\nBalance: "+balance+"\nType: "+acctype+"\npin: "+pin;
		
	}

}
