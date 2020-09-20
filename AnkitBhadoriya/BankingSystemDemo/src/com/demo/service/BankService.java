package com.demo.service;

import java.util.Date;
import  java.util.Scanner;

import com.demo.bean.Bank;
import com.demo.test.TestBanking;

import java.text.ParseException;
import  java.text.SimpleDateFormat;

public class BankService {
	 	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	 	public static Scanner sc=new Scanner(System.in);
	
	 	
	 	
	 //accept data for n accounts
	 	public static void acceptAccountData(Bank[] p) { 
	 			for(int i=0;i<p.length; i++) {
	 				System.out.println("enter account Id");
	 				int id=sc.nextInt();
	 				 System.out.println("enter account  Name");
	 				String  nm=sc.next(); 
	 				System.out.println("enter account type");
	 				String  type=sc.next();
	 				System.out.println("enter date of opeining in dd/MM/yyyy");
	 				String dt=sc.next();
	 				System.out.println("enter balance");
	 				double balance=sc.nextDouble();
	 			
	 				try {
	 					Date bDate=sdf.parse(dt);
	 					p[i]=new Bank (id,nm,bDate,type,balance);
	 					
	 				}catch(ParseException e) {
	 						e.printStackTrace();
	 				
	 				
	 			}
	 	}
	 	
	 	}
	 	
	
	 	 
	//display data for n accounts 
	 		public static void displayAccount(Bank[] parr) {
	 				for(int i=0;i<parr.length;i++) {
	 				if(parr[i]!=null) {
	 						System.out.println(parr[i]);
	 				}
	 				else {
	 					
	 					}
	 				}
	 		}


  //method to search by id
	 		public static int SearchById(Bank[] p, int id) {
	 				for(int i=0;i<p.length;i++) {
	 						if(p[i].getAccountId()==id) {
	 							return i;
	 						}
	 				}
	 				return 0;
	 			}


  //method to deposit amount
	 			public static void deposit(Bank[] p,int id, int amt) {
	 					int pos=SearchById(p,id);
	 					double balance=p[pos].getBalance();
	 					double newbalance=balance+amt;
	 					p[pos].setAccountBalance(newbalance);
				
				}
			
	//method to withdraw amount	
			public static void withdraw(Bank[] p,int id, int amt) {
					int pos=SearchById(p,id);
					double balance=p[pos].getBalance();
					if(balance>10000&&balance>amt){
							double newbalance=balance-amt;
							p[pos].setAccountBalance(newbalance);
					}
					else {
							System.out.println("not sufficient funds");
						}
					
					}
		
		
	
		
}




	 	

