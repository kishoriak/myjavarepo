package com.demo.service;
import java.util.Date;
import java.util.Scanner;

import com.demo.bean.Account;

//import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AccountService {

	public static Scanner sc=new Scanner(System.in);
	
	//to search person account by id
	public static int searchById(Account[] acarr,int id) {
		for(int i=0;i<acarr.length;i++) {
			if(id==acarr[i].getAccId()) {
				return i;
			}
		}
		return -1;
		
	}
	
	//to create an account --->currently creating 3 accounts together
	public static void acceptAccountData(Account acarr[]) {
		for(int i=0;i<acarr.length;i++) {
			System.out.println("Enter id");
			int id=sc.nextInt();
			System.out.println("Enter name");
			String name=sc.next();
			System.out.println("Enter Type of account");
			String typeAcc=sc.next();
			System.out.println("Enter balance");
			double bal=sc.nextDouble();
			acarr[i]=new Account(id,name,typeAcc,bal);
		}
		//displayAllAccounts(acarr);
		
	}
	
	//to withdraw from an account based on account id
	public static void withdraw(Account acarr[],int id,Double withdrawAmt) {
		
		int pos=searchById(acarr,id);
		if(pos!=-1) {
			acarr[pos].withdrawal(withdrawAmt); //calling Account method
			}
		else
			System.out.println("user not found");
	
	}
	
	//to deposit to an account based on account id
	public static void deposit(Account acarr[],int id,Double depositAmt) {
		int pos=searchById(acarr,id);
		if(pos!=-1) {
			acarr[pos].deposition(depositAmt);
			}
		else
			System.out.println("No user exist");

	}
	
	//to display data for an account by id
	public static void displayAccount(Account acarr[],int id) {
		int pos=searchById(acarr,id);
		if(pos!=-1)
			System.out.println(acarr[pos]);
		else
			System.out.println("no user found");

	}
	
	//to display data for all accounts
	public static void displayAllAccounts(Account[] acarr) {
		for(int i=0;i<acarr.length;i++) {
			if(acarr[i]!=null)
				System.out.println(acarr[i]);
			else
				break;
		}
		
	}
}
