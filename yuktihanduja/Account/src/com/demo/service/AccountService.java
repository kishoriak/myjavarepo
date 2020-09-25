package com.demo.service;
import com.demo.bean.Account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
//AccountService class
public class AccountService {
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	public static void acceptAccountData(Account[] acc)
	{
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<acc.length;i++)
		{
			System.out.println("Enter id");
			int id=sc.nextInt();
			System.out.println("Enter name");
			String name=sc.next();
			System.out.println("Enter amount you want to deposit");
			Double amt=sc.nextDouble();
			
			System.out.println("Enter Date:(dd/MM/yyyy)");
			String dt=sc.next();
			try {
				Date bdate=sdf.parse(dt);
				acc[i]=new Account(id, name, amt,bdate);
			}
			catch(ParseException e)
			{
				e.printStackTrace();
			}
			
		}
	}
	//Function to display account information of the costumer
	public static void displayAccountData(Account[] acc)
	{
		for(int i=0;i<acc.length;i++)
		{
			if(acc[i]!=null)
			{
				System.out.println(acc[i]);
		    }
		}

	}
	//function to search the id 
	public static int searchbyid(int id,Account[] acc)
	{
		for(int i=0;i<acc.length;i++)
		{
			if(acc[i].getID()==id)
			{
				return i;
			}
				
		}
		return -1;
	}
	//function to search for the account where amount is to be withdrawn
	public static int withdrawAmt(Account[] acc,int id ,Double amt)
	{
		int pos = searchbyid(id,acc);
		if(pos!=-1)
		{
			acc[pos].withdraw(amt);
			return pos;
		
		}
		else
			return -1;
	}
	//function to search for the account where amount is to be deposited
	public static int depositAmt(Account[] acc,int id,Double amt)
	{
		int pos=searchbyid(id, acc);
		if(pos!=-1)
		{
			acc[pos].deposit(amt);
			return pos;
		}
		else
			return -1;
	}
		
	
}
