package com.demo.service;
import com.demo.bean.Account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AccountService {

	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	public static Scanner sc=new Scanner(System.in);
	
	public static void acceptAccountData(Account[] arr) {               // accept people data
		for(int i=0;i<arr.length;i++ ) {
			System.out.println("Enter name:");
			String nm=sc.next();
			System.out.println("Enter balance:");
			double bal=sc.nextDouble();
			System.out.println("Enter account type:");
			String ty=sc.next();
			System.out.println("Enter Date of opening:");
			String dt=sc.next();
			
			try {
			Date odate=sdf.parse(dt);
			arr[i]= new Account(nm,ty,bal,odate);
			}
			catch(ParseException e) {
				e.printStackTrace();
			}
			
	    }	
		}
	
	public static void displayAccount(Account[] arr) {                //displays the details stored
			
			for (int i=0;i<arr.length;i++) {
				if(arr[i]!=null) {
					System.out.println(arr[i]);
				}else {
					break;
				}
			}	
		}
	
	public static void withdrawAmt(Account[]arr,double amt,int id) {                     // withdraw the money from account
		
			int pos=AccountService.searchById(arr, id);
			System.out.println(pos);
			arr[pos].withdraw(amt);
			System.out.println("Withdrawing....");
			System.out.println("New balance is:");
			System.out.println(arr[pos].getBalance());
			
		}
	
	public static void depositAmt(Account[]arr,double amt,int id) {                        //deposit the money to the account

		int pos=AccountService.searchById(arr, id);
		System.out.println(pos);
		arr[pos].deposit(amt);
		System.out.println("New balance is:");
		System.out.println(arr[pos].getBalance());
	}
	
	public static int searchById(Account[] arr, int id) {            //Search for a person by id
		
		for(int i=0;i<arr.length;i++) {	
			if(arr[i].getPerId()== id) {
				return i;
			}
		}
		return -1;
	}
	
			
	}

