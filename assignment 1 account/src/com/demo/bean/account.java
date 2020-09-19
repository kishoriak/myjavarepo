package com.demo.bean;
//creating the account class
public class account {
	private int id;
	private String name;
	private String dateofopening;
	private String acctype;
	private int balance;
	
	//creating constructor
	public account(int id,String name,String dateofopening, String acctype,int balance) {
		this.id=id;
		this.name=name;
		this.dateofopening=dateofopening;
		this.acctype=acctype;
		this.balance=balance;
	}
	
	//creating the getters and setters for the attributes of the account object
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateofopening() {
		return dateofopening;
	}
	public void setDateofopening(String dateofopening) {
		this.dateofopening = dateofopening;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	}
	
	
	
	
	

