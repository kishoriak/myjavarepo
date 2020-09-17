package com.demo.bean;
import java.util.Date;
public class Account {
	
	private int accId;
	private String accName;
	private double accBalance;
	//public static int cnt;
	private Date bDate;
	//Default Constructor
	public Account()
	{
		accId=0;
		accName=null;
		bDate=null;
		accBalance = 0;
	}
	//Parametrized Constructor
	public Account(int Id,String accName,double accBalance,Date bDate)
	{
		this.accId=Id;
		this.accName=accName;
		this.accBalance=accBalance;
		this.bDate=bDate;	
	}
	
	//Deposit calculation method
	public void deposit(Double amt)
	{
		accBalance=accBalance+amt;	
	}
	//Withdraw amount calculation method
	public void withdraw(Double amt)
	{
		if (accBalance-10000>amt)
			accBalance=accBalance-amt;
	}
	//setter and getter functions for changing or retrieving values
	public void setID(int accId)
	{
		this.accId=accId;
	}
	
	public int getID()
	{
		return this.accId;
	}
	
	public void setName(String accName)
	{
		this.accName=accName;
	}
	
	public String getName()
	{
		return this.accName;
	}
	
	public void setBalance(int accBalance)
	{
		this.accBalance=accBalance;
	}
	
	public Double getBalance()
	{
		return this.accBalance;
	}
	
	public String toString()
	{
		return "Id :"+accId +"\n name :"+accName+"\nBalance :"+accBalance;
	}
	
	public Date getDate()
	{
		return this.bDate;
	}

}

