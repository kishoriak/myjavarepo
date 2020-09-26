package com.demo.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.demo.service.AccountService;

public class SavingAcc extends Account{
        
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");  
	public static Scanner sc =new Scanner(System.in);
	  final public static float iRate;
	private String  checkBookNo;
	  static
	  {
		  iRate=4.1f;
		  
	  }
	  
	//Default Constructor
	public SavingAcc() {
		
		//super();
		checkBookNo=null;
	}
	



  //paramaterized constructor
	public  SavingAcc(String accName,Date date,double balance,int pin,String accType) {
		super(accName,date,balance,pin,accType);
		this.checkBookNo =  pin+"-"+super.getAccId();
	}

	//Withdraw override
	@Override
	public void withdraw(double bal)
	{
		if(this.getAccbalance()-10000>=bal)
			this.setAccBalance(this.getAccbalance()-bal);
		
		 
	}
  //display object
	@Override
	public String toString()
	{
		return super.toString()+"\nCheck Book No :"+checkBookNo;
	}
}
