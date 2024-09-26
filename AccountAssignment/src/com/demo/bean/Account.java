package com.demo.bean;
import java.util.Date;

public class Account {

	private int accId;
	private String accName;
	private Date dateOfOpening;
	private String typeOfAcc;
	private double balance;
	
	final String ifsc="HSBC001";
		
	//default constructor
	public Account() {
		accId= 0;
		accName=null;
		dateOfOpening=null;
		typeOfAcc=null;
		balance=0;
	}
	//parameterized constructor
	public Account(int id,String name,String typeAcc,double bal) {
		accId=id;
		accName=name;
		dateOfOpening=new Date();
		typeOfAcc=typeAcc;
		balance=bal;
	}

	//setters and getters
	public void setAccId(int id) {
		this.accId=id;
	}
	public int getAccId() {
		return this.accId;
	}
	public void setName(String name) {
		this.accName=name;
	}
	public String getName() {
		return this.accName;
	}
	public void setDate(Date dOpen) {
		this.dateOfOpening=dOpen;
	}
	public Date getDate() {
		return this.dateOfOpening;
	}
	public void setBalance(double bal) {
		this.balance=bal;
	}
	public double getBalance() {
		return this.balance;
	}
	public void setType(String typeAcc) {
		this.typeOfAcc=typeAcc;
	}
	public String getType() {
		return this.typeOfAcc;
	}
	
	//to withdraw amount from an account
	public void withdrawal(double amt) {
		if((balance-10000)>=amt) {
			balance=balance-amt;
			System.out.println("Successfully withdrawn");
		}
		else 
			System.out.println("not enough balance");
	}
	
	//to deposit in an account
	public void deposition(double amt) {
			balance=balance+amt;
			System.out.println("Successfully deposited");
	}
	
	//to display data of the user
	public String toString() {
		return "AccId: "+accId+"\nName: "+accName+"\ndate Of Opening: "+dateOfOpening+"\nAccount Type: "
	+typeOfAcc+"\nBalance: "+balance;
		
	}

}
