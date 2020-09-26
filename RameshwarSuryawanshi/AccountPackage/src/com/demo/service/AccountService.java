package com.demo.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.demo.bean.Person;
import com.demo.bin.Account;

public class AccountService {
	
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
	public static Scanner sc =new Scanner(System.in);
	
	//accept data for person
	public static void acceptAccountdata(Account[] acc)
	{   
		for(int i=0;i<acc.length;i++)
		{		
		
		System.out.println("Enter name");
		String nm=sc.next();
		System.out.println("Enter Acc Type");
		String mob=sc.next();
		System.out.println("Enter Date (dd/mm/yyyy)");
		String date=sc.next();
		System.out.println("Enter deposit Amount");
		int amt=sc.nextInt();
       try {
    	   Date bdate =sdf.parse(date);
    	  
       
		   acc[i]=new Account(nm,bdate,mob,amt);
		   
	
		  
		  
		}catch(ParseException e) {
		 
			e.printStackTrace();
		}
		}
	
	}
	
	
	//Display data of person
	  public static void displayAccount(Account[] acc, int id)
	    {
		int pos= AccountService.searchById(acc, id);
		System.out.println(acc[pos]);
		
		}
	
	public static int withdrawAmt(Account[] acc,int id,double amt)
	{
		int pos= AccountService.searchById(acc, id);
		if(pos!=-1)
			{ acc[pos].withdraw(amt);
			  return pos;
			 
			}
		else
			return -1;
		
	}
	
	//Deposit Amount
	public static int depositeAmt(Account[] acc,int id,double amt)
	{
		int pos= AccountService.searchById(acc, id);
		if(pos!=-1)
			{ acc[pos].deposite(amt);
			  return pos;
			 
			}
		else
			return -1;
		
	}
	
	//Search By ID
	public static int searchById(Account[] acc, int id)
	{
		for(int i=0;i<acc.length;i++)
		{
			if(acc[i].getAccId()==id)
			{
				return i;
			}	
			
		}
		return -1;
	}
    
	//Search By Name
	public static int searchByName(Account[] acc, String nm) {
		// TODO Auto-generated method stub
		for(int i=0;i<acc.length;i++)
		{
			if(acc[i].getAccName().equals(nm))
			{
				return i;
			}
		}
		return -1;
	}
	
	}


