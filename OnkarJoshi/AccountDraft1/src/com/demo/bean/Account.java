package com.demo.bean;
import java.util.Date;


public class Account {
	static {
		cnt=0;              
	}
	public static int cnt;
	private int aID;
	private String aName;
	private String accType;
	private double balance;
	private Date oDate;
	
	//default constructor
	public Account() {
		aID=++cnt;                            //Generates ID
		aName=null;
		accType=null;
		balance=0;
		oDate=null;
	}
	//parameterized constructor
	
	public Account(String aName,String accType, double bal, Date oDate ) {
		this.aID=++cnt;
		this.aName=aName;
		this.accType=accType;
		this.balance=bal;
		this.oDate=oDate;
	}
	//Setter and Getter methods
	
	public int getPerId() {
		return this.aID;
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
	public void setDate(Date dt) {
		this.oDate=dt;
	}
	public Date getDate() {
		return this.oDate;
	}
	public void setAccType(String type) {
		this.accType=type;
	}
	public String getAccType() {
		return this.accType;
	}
	// end of getter and setter methods
	
	//withdraw function with limit 10000
	public void withdraw(double amt) {
		if(balance-10000>=amt) {
			 balance=balance-amt;
		}else {
			System.out.println("Not enough balance!!..");
		}
	}
	//deposit function
	
	public void deposit(double amt) {
		balance=balance+amt;
	}
	
	@Override //used to print using System.out.println
	public String toString() {
		return "Id : "+aID+" \nName : "+aName+" \nBalance: "+balance+" Type : "+accType+"\nDate of Opening: "+oDate;
	}
	
	
	
}

