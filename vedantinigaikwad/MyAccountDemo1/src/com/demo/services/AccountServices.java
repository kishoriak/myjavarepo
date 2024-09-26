package com.demo.services;

import com.demo.bean.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AccountServices {
	
	public static void acceptData(Account[] arr) {
		
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
		
		for(int i=0;i<arr.length;i++) {
			int id=0;
			id = Account.assignId();
			System.out.println("Your Account id is: "+id);
			System.out.println("Enter name: ");
			String nm=sc.next();
			System.out.println("Enter Date : (dd/mm/yyyy)");
			String dt=sc.next();
			System.out.println("Account Type : (current/savings)");
			String typ=sc.next();
			System.out.println("Enter balance : ");
			double bal=sc.nextDouble();
			try {
				Date bDate=sdf.parse(dt);
				arr[i]=new Account(id,nm,bDate,typ,bal);
			}catch(ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void displayAccountData(Account[] arr, int pos) {
			if(pos!=-1) {
				System.out.println(arr[pos].toString());
			}
			else {
				System.out.println("Invalid id.");
			}
	}

	public static void withdrawAmt(Account[] arr, int id, double wd) {
		
		int pos=AccountServices.searchById(arr, id);
		if(pos!=-1) {
			Account.withdraw(arr, pos, arr[pos].getaBalance(), wd);
		}
		else {
			System.out.println("Invalid id.");
		}
		
	}

	public static int searchById(Account[] arr, int id) {
		
		for(int i=0;i<arr.length;i++) {
			if(id == arr[i].getPerId()) {
				return i;
			}
		}
		return -1;
	}

	public static void depositAmt(Account[] arr, int id1, double dep) {
		
		int pos=AccountServices.searchById(arr, id1);
		if(pos!=-1) {
			Account.deposit(arr, pos, arr[pos].getaBalance(), dep);
		}
		else {
			System.out.println("Invalid id.");
		}
		
	}
	
}
