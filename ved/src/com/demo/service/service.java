package com.demo.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import com.demo.bean.account;
public class service {
	static Scanner s=new Scanner(System.in);
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	
	//function to add the account details of the users
	public static void enteraccdetails(account[] acc){
		
		for(int i=0;i<acc.length;i++) {
		System.out.println("Enter id");
		int id=s.nextInt();
		System.out.println("Enter name");
		String name=s.next();
		
	Date date=new Date();
	try {
		String bdate=sdf.format(date);
	
	
		System.out.println("Enter type");
		String type=s.next();
		int balance=0;
	
			
		acc[i]=new account(id,name,bdate,type,balance);
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	}
	// function to view the details of the account by id
	
	public static void viewdetails(account[] acc) {
		System.out.println("Enter account id");
		int id=s.nextInt();
		
		for(int i=0;i<acc.length;i++) {
			if (acc[i].getId()==id) {
				System.out.println(acc[i].getId()+" \n"+acc[i].getName()+" \n"+acc[i].getAcctype()+" \n"+acc[i].getDateofopening()+" \n"+acc[i].getBalance());
			break;
			}
		}
		
	}
	
	//function to deposit funds in the account
	
	public static void deposit(account[] acc) {
		System.out.println("Enter account id");
		int id=s.nextInt();
		System.out.println("Enter deposit amount");
		int amt=s.nextInt();
		for(int i=0;i<acc.length;i++) {
			if (acc[i].getId()==id) {
				acc[i].setBalance(acc[i].getBalance()+amt);
			break;
			}
	}
	}
	
	
	//function to withdraw funds from the account
		
	public static void withdraw(account[] acc) {
		System.out.println("Enter account id");
		int id=s.nextInt();
		System.out.println("Enter withdraw amount");
		int amt=s.nextInt();
		for(int i=0;i<acc.length;i++) {
			if (acc[i].getId()==id) {
				acc[i].setBalance(acc[i].getBalance()-amt);
			break;
			}
	}
	}
}


