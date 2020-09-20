package com.demo.bean;
import java.util.Date;

import com.demo.exception.InvalidAmountException;

abstract public class Account {
        
	private int accId;
	private String accName;
	private Date accDate;
	private String accType;
	public double balance;
	private int pin;
	
	private static int cnt;
	
	static {
		
		cnt = 0;
	}

	//Default Constructor
	public Account()
	{
		accId=++cnt;
		accName=null;
		accDate=null;
		accType=null;
		balance=0.0;
		pin=0;
		
		
	}
	
	
	//Parametrised Constructor
	public Account(String accName,Date date,double balance,int pin,String accType )
	{
		this.accId=++cnt;
		this.accName=accName;
		this.accDate=date;
		
		this.balance=balance;
		this.pin=pin;
		this.accType=accType;
		
		
	}
	
	//Setter Getter
	
	public int getAccId()
	{
		return this.accId;
	}
	
	public void setAccName(String aname)
	{
		this.accName=aname;
	}
	public String getAccName()
	{
		return this.accName;
	}
	
	public void setAccType(String atype)
	{
		this.accType=atype;
	}
	public String getAccType()
	{
		return this.accType;
	}
	
	public void setAccDate(Date dt)
	{
		this.accDate=dt;
	}
	public Date getAccDate()
	{
		return this.accDate;
	}
	public void setAccBalance(double balance)
	{
		this.balance=balance;
	}
	public double getAccbalance()
	{
		return this.balance;
	}
	public void setPin(int pin)
	{
		this.pin=pin;
	}
	public int getPin()
	{
		return this.pin;
	}
	//withdraw amount from account
	abstract public void withdraw(double bal);
	
	//Deposit amount in account
	public void deposite(double bal) throws InvalidAmountException
	{   if(bal>0)
	   { 
		this.setAccBalance(this.getAccbalance()+bal);
	   }
	else
	{
		throw new InvalidAmountException("Enter valid amount");
	}

	}
	@Override
	public String toString()
	{
		return "Id : "+accId+"\nName : "+accName+"\nAccount Type: "+accType+"\nDate :"+accDate+"\nBalance :"+balance+"\nPin :"+pin;
	}
}
