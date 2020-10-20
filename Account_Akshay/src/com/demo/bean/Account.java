package com.demo.bean;
import java.util.Date;

public class Account {
	static {
		//ifsc = "AKSH";
		cnt = 0;
	}
	//public static String ifsc
	private static int cnt;
	private int perId;
	private String pName;
	private String typeOfAcc;
	private Date dOj;
	private double balance;
	
	//default constructor
	public Account() {
		perId = 0;
		pName = null;
		typeOfAcc = null;
		dOj = null;
		
	}
	
	//parameterized constructor
	public Account(String pName, String typeOfAcc, Date dOj, double bal) {
		this.perId = cnt++ ;
		this.pName = pName;
		this.typeOfAcc = typeOfAcc;
		this.dOj = dOj;
		this.balance = bal;
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
	
	//function for depositing operation
	public void deposit(double amt) {
		balance = balance + amt;
	}
	
	//function for withdrawing operation
	public void withdraw(double amt) {
		if(balance-10000 >= amt) {
			balance = balance - amt;
		}
		else {
			System.out.println("Less balance");
		}
	}
	
	@Override
	public String toString() {
		return "Id: "+perId +"\nName: " +pName + "\nType of account:"+ typeOfAcc + "\nDate of opening :"+ dOj+"\nbalance: "+balance;
	}
}
