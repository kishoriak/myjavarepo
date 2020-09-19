package com.demo.bean;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Account {
	private static int cnt=1;
	private int id;
	private String name;
    private Date bDate;
	private double balance;
	
	//Default Constructor
	public Account() {
		id=0;
		name=null;
	    bDate=null;
		balance=0;
	}
	//date
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	
	//parametrised constructor
	public Account(String name,double bal) {
	this.id=cnt;
	cnt++;
	this.name=name;
	this.bDate=date;
	this.balance=bal;
	}
	
  //getters and setters
	public int getid() {
    	return this.id;
    }
    public void name(String name) {
    	this.name=name;
    }
    public String getname() {
    	return this.name;
    }
    	
    	public void setbDate(Date dt) {
    		this.bDate=dt;
    	
    }
    	public Date getbDate() {
    		return this.bDate;
    	}
    public void setBalanceDep(double balance) {
    	this.balance=balance;
    }
   
    public double getbalance() {
    	return this.balance;
    }
    //withdraw function
    public void withdraw(double amt) {
    if(this.balance>500) {
    	this.balance-=amt;
    }
    else {
    	System.out.println("Insufficicent Balance");
    }
    	
   }
    //deposit function
    public void deposit(double amt) {
    	this.balance+=amt;
    }
    
    //display function override
public String toString() {
return "pId:"+id+"\nName"+name+"\nbalance"+balance+"\n Date"+bDate;
}
}

