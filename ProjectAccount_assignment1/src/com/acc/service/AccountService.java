package com.acc.service;

//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.acc.bean.*;

public class AccountService {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static Scanner sc = new Scanner(System.in);
	
	//accept n account details
	public static void acceptAccountDetails(Account[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.println("Enter Name");
			String nm = sc.next();
//			System.out.println("Enter Date(dd/MM/yyyy)");
//			String date = sc.next();
			System.out.println("Enter Account Type");
			String type = sc.next();
			System.out.println("Enter Balance");
			double bal = sc.nextDouble();
//			try {
//				Date dt = sdf.parse(date);
			arr[i] = new Account(nm,new Date(),type,bal);
//			}catch (ParseException e) {
//				e.printStackTrace();
//			}
		}
	}
	//display all accounts' details
	/*public static void displayAllAccounts(Account[] arr) {
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=null)
				System.out.println(arr[i]);
			else
				break;
		}
	}*/
	//searching for a specific account
	public static int searchAccount(Account[] arr,int id) {
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i].getAccId()==id)
				return i;
		}
		return -1;
	}
	//withdrawal function
	public static void withdrawAmt(Account[] arr, int id, double amt) {
		int pos = AccountService.searchAccount(arr, id);
		if(pos == -1)
			System.out.println("Account not found");
		else
			arr[pos].withdrawal(amt);
	}
	//deposit function
	public static void depositAmt(Account[] arr, int id, double amt) {
		int pos = AccountService.searchAccount(arr, id);
		if(pos == -1)
			System.out.println("Account not found");
		else
			arr[pos].deposit(amt);
	}
	//displaying a specific account
	public static int displayAccount(Account[] arr,int id) {
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i].getAccId()==id) {
				System.out.println(arr[i]);
				return 0;
			}
		}
		return -1;
	}
	//for each loop
	//for(Account a:arr) {
	//	if(a.getAccId()==id) {
	//		return i;
	//	}
	//}
}