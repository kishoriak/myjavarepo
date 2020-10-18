package com.demo.bean;
import java.util.Date;

abstract public class Account {
	static {
		
		cnt = 0;
	}
	public static int cnt;
	private int perId;
	private String pName;
	private int pin;
	private Date dOp;
	protected double balance;
	private String accType;
	
	//default constructor
	public Account() {
		
		perId = 0;
		pName = null;
		int pin = 0;
		dOp = null;
		balance = 0.0;
		String accType = null;
	}
	
	//parameterized constructor
	public Account(String pName, int pin, Date dOp, double bal, String aType) {
		this.perId = ++cnt ;
		this.pName = pName;
		this.pin = pin;
		this.dOp = dOp;
		this.balance = bal;
		this.accType = aType;
	}
	//setter and getter methods
	public int getId() {
		return this.perId;
	}
	
	public void setId(int perId) {
		this.perId = perId;
	}
	
	public void setBal (double bal) {
		this.balance = bal;
	}
	
	public double getBal() {
		return this.balance;
	}
	
	public String getpName() {
		return this.pName;
	}
	
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public int getPin() {
		return this.pin;
	}
	
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public String getAcType() {
		return this.accType;
	}
	
	//function for deposit operation
	public void deposit(double amt) {
		balance = balance + amt;
	}
	abstract public void withdraw(double amt);
	
	@Override
	public String toString() {
		return "Id: "+perId +"\nName: " +pName+ "\nDate of opening :"+ dOp+"\nbalance: "+balance;
	}

	
}
