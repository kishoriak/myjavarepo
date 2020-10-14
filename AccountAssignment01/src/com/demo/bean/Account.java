package com.demo.bean;
import java.util.Date;

public class Account {
	private int id;
	private String name;
	private String accountType;
	private double balance;
	private Date dateOfJoining;
	
	//Default Constructor
	public Account() {
		id = 0;
		name = null;
		accountType = null;
		balance = 0;
		dateOfJoining = null;
	}
	
	//Parameterized Constructor
	public Account(int id, String name, String accountType, double balance, Date dateOfJoining) {
		this.id = id;
		this.name = name;
		this.accountType = accountType;
		this.balance = balance;
		this.dateOfJoining = dateOfJoining;
	}
	
	//Method to deposite amount
	public void deposit(double amount) {
		this.balance = this.balance + amount;
		
	}

	//Method to withdraw amount
	public int withdraw(double amount) {
		if(this.balance-10000 >= amount) {
			this.balance = this.balance - amount;
			return 1;
		}	
		return -1;
	}
	
	//Setters and Getters Methods
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAccountType() {
		return this.accountType;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public Date getDateOfJoining() {
		return this.dateOfJoining;
	}

	//Method to display object
	public String toString() {
		return "Id : " + id + "\nName : " + name + "\nAccount Type : " + accountType + "\nBalance : " + balance + "\nDate of Joining :" + dateOfJoining;
	}
}
