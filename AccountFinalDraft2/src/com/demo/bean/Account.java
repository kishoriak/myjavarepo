package com.demo.bean;
import java.util.Date;

import com.demo.exception.InsufficientBalanceException;


abstract public class Account {
	static {
		cnt=0;
		iR=0;
	}
	public static int cnt;
	private int aID;
	protected String code;
	protected String acNo;
	private String aName;
	private int pin;
	private String accType;
	private double balance;
	public static int iR;
	
	
	public Account() {
		aID=++cnt;
		acNo="BANKxxx"+cnt;;
		aName=null;
		pin=0;
		accType=null;
		balance=0;
		
	}
	
	public Account(String aName,int pin, double bal,String accType) {
		this.aID=++cnt;
		acNo="BANKxxx"+cnt;
		this.aName=aName;
		this.pin=pin;
		this.accType=accType;
		this.balance=bal;
	}
	//Setter and Getter methods
	
	public String getAcNo() {
		return acNo;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getPerId() {
		return this.aID;
	}
	public String getPerAcc() {
		return this.acNo;
	}
	public void setPerName(String name) {
		this.aName=name;
	}
	public String getPerName() {
		return this.aName;
	}
	
	public void setBalance(double bal) {
		this.balance=bal;
	}
	public double getBalance() {
		return this.balance;
	}
	

	public void setAccType(String type) {
		this.accType=type;
	}
	public String getAccType() {
		return this.accType;
	}
	// end of getter and setter methods
	
	abstract public int withdraw(double amt) throws InsufficientBalanceException;
	
	public void deposit(double amt) {
		balance=balance+amt;
	}
	
	@Override
	public String toString() {
		return "Id : "+aID+"\nAccount No.:"+acNo+" \nName : "+aName+" \nBalance: "+balance+" Type : "+accType;
	}
	
	
	
}

