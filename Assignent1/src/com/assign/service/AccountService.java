package com.assign.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.assign.bean.*;

public class AccountService {
		
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static Scanner sc = new Scanner(System.in);
	
	//create a new account
	public static void createAccount(Account[] arr, String type, int i) {
		//for(int i=0;i<arr.length;i++)
		if(i<arr.length) {
			System.out.println("Enter Name");
			String nm = sc.next();
			System.out.println("Enter PIN");
			int pin = sc.nextInt();
			System.out.println("Enter Balance");
			double bal = sc.nextDouble();
			if(type.equals("Savings")) {
				System.out.println("Enter Cheque Book No.");
				long chequeBkNo = sc.nextLong();
				arr[i] = new SavingsAcc(nm, new Date(), type, bal,pin,chequeBkNo);
			}
			else
				arr[i] = new CurrentAcc(nm, new Date(), type, bal,pin);
			System.out.println("Account created successfully!");
		}
		else {
			System.out.println("Account cannot be created, Sorry!");
		}
	}
	//search an account
	public static int searchAccount(Account[] arr, int id) {
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i].getAccId()==id) {
				return i;
			}
		}
		return -1;
	}
	//withdrawal function
	public static void withdrawAmt(Account[] arr, int id, double amt) {
		//check if the account exists
		int check = searchAccount(arr,id);
		if(check==-1) {
			System.out.println("Account not found");
		}
		else {
			//call withdrawal function of respective class
			int res = arr[check].withdrawal(amt);
			if(res==0)
				System.out.println("Withdrawal Successful!");
			else
				System.out.println("Insufficient balance");
		}
	}
	//deposit function
	public static void depositAmt(Account[] arr, int id, double amt) {
		//check if the account exists
		int check = searchAccount(arr,id);
		if(check == -1) {
			System.out.println("Account not found");
		}
		else {
			//call deposit function of Account class
			arr[check].deposit(amt);
		}
	}
	//transfer function
	public static void transfer(Account[] arr, int id1,int id2, double amt) {
		
		//check if both accounts exist
		int a1,a2,res;
		a1=searchAccount(arr, id1);
		if(a1 == -1) {
			System.out.println("Account to transfer from not found");
			return;
		}
		a2=searchAccount(arr,id2);
		if(a2==-1) {
			System.out.println("Account to be transferred to not found");
			return;
		}
		res=arr[a1].withdrawal(amt);
		if(res==-1) {
			System.out.println("Insufficient balance to transfer");
			return;
		}
		else {
			arr[a2].deposit(amt);
		}
		System.out.println("Transfer Successful!");
	}
	public static int checkPin(Account[] arr,int res, int pin) {
		
		if(arr[res].getPin()==pin) {
			return 0;
		}
		else
			return -1;
	}
	public static void changePin(Account[] arr, int pin,int res) {
		
		arr[res].setPin(pin);
		System.out.println("PIN updated successfully");
	}
	public static void checkBalance(Account[] arr, int id) {
		
		int res = searchAccount(arr,id);
		if(res == -1) {
			System.out.println("Account not found");
			return;
		}
		else {
			System.out.println(arr[res].getBalance());
		}
	}
}