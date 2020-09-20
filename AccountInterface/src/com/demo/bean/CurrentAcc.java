package com.demo.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


//import com.demo.exception.NoMoneyToWithdrawException;
import com.demo.service.AccountService;

public class CurrentAcc extends Account {
	
	final public static float icRate;
	  final public static double noOfTransaction;
	 static
	 {
		 icRate=1.1f;
		 noOfTransaction=3;
	 }
	 
	 //default constructor
	  public CurrentAcc() 
	   {
			
			
    	}
    //parametarized  constructor
	public CurrentAcc(String accName,Date accDate,double balance,int pin,String accType) 
	{
		super(accName,accDate,balance,pin,accType);
		
	}
	//Withdraw override
	@Override
	public void withdraw(double amount) 
	{
		
		if(this.getAccbalance() - amount >= 0) 
		   {
			    this.setAccBalance(this.getAccbalance() - amount);
			
			}	
		
	
	}
	
	
	
   //display object
	public String toString()
	{
		return super.toString()+"\nNo Of Transaction : "+noOfTransaction;
	}
	  
    
}
