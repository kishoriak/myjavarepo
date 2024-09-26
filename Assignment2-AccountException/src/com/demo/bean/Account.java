package com.demo.bean;

import java.util.Date;

import com.demo.exception.InsufficientBalanceException;

public abstract class Account {
	static {
		count=0;
	}
	
	public static Integer count;
	
	private String accId;
	private String accName;
	private double balance;
	private int pin;
	private String typeAcc;
		
	final String ifsc="HSBC00";
		
	//default constructor
	public Account() {
		accId= "";
		accName=null;
		balance=0.0;
		typeAcc=null;
		pin=0;
	}
	//parameterized constructor
	public Account(String name,double bal,String type,int pin) {
		++count;
		accId=ifsc+ count.toString();
		accName=name;
		balance=bal;
		this.typeAcc=type;
		this.pin=pin;
	}
	
	//setters and getters
	
	public String getAccId() {
		return this.accId;
	}
	public void setName(String name) {
		this.accName=name;
	}
	public String getName() {
		return this.accName;
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
		return typeAcc;
	}
	public void setTypeAcc(String typeAcc) {
		this.typeAcc = typeAcc;
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
		return "AccId: "+accId+"\nName: "+accName+"\nBalance: "+balance+"\nType: "+typeAcc+"\npin: "+pin;
		
	}

}
