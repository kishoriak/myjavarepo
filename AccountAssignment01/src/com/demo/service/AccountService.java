package com.demo.service;
import java.text.ParseException;
import java.math.*;
import java.lang.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.demo.bean.Account;

public class AccountService {
	
	public static Scanner sc = new Scanner(System.in);
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//Accept data and create accounts
	public static void acceptAccountData(Account[] acc) {
		for(int i=0;i<acc.length;i++) {
			System.out.println("Enter Id :");
			int id = sc.nextInt();
			System.out.println("Enter Name :");
			String name = sc.next();
			System.out.println("Enter Account Type :");
			String accountType = sc.next();
			System.out.println("Enter Balance :");
			double balance = sc.nextDouble();
			System.out.println("Enter Date :");
			String doj= sc.next();
			try {
				Date dateOfJoining = sdf.parse(doj);
				acc[i] = new Account(id, name, accountType, balance, dateOfJoining);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Display the account information by Id
	public static void displayAccountData(Account[] acc, int id) {
		for(int i=0;i<acc.length;i++) {
			if(acc[i].getId() == id) {
				System.out.println(acc[i]);
			}
		}
	}

	//Withdraw amount from account
	public static int withdrawAmount(int id, double amount, Account[] acc) {
		int pos = AccountService.searchAccountById(acc, id);
		if(pos != -1) {
			int result = acc[pos].withdraw(amount);
			if(result != -1)
			return 1;
		}
		return -1;
	}

	//Deposite amount into account
	public static int depositAmount(int id, double amount, Account[] acc) {
		int pos = AccountService.searchAccountById(acc, id);
		if(pos != -1) {
			acc[pos].deposit(amount);
			return pos;
		}
		return -1;
	}
	
	//Search account by Id
	private static int searchAccountById(Account[] acc, int id) {
		for(int i=0;i<acc.length;i++) {
			if(acc[i].getId() == id) {
				return i;
			}
		}
		return -1;
	}

}
