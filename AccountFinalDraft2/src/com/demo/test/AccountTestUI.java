package com.demo.test;

import java.util.Scanner;

import com.demo.bean.*;
import com.demo.service.*;
import com.demo.exception.*;

public class AccountTestUI {
	
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			AccountService accountService=new AccountServiceImpl();
			//Account[] a=new Account[10];
			int choose;
		while(true) {
		System.out.println("------Welcome to xxxx BANK------");
		System.out.println("1.Create New Accountt\n2.Withdraw \n3.Deposit \n4.Display your Account details \n5.Transfer to another Account\n6.Change Pin\n7.EXIT"); // the menu shown to users
		System.out.println("---------------------------------");
		choose=sc.nextInt();
		//sc.close();
		switch(choose) {
		case 1: 
			try {
				accountService.acceptAccountData();
			} catch (LimitExceedException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2: 
			
			System.out.println("Enter account id: ");
			String id=sc.next();
			System.out.println("Enter withdraw amount: ");
			Double amt=sc.nextDouble();
			try {
				accountService.withdraw(id,amt);
			} catch (InsufficientBalanceException e) {
				System.out.println(e.getMessage());
			} catch (UserNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 3: 
			System.out.println("Enter account id: ");
			id=sc.next();
			System.out.println("Enter deposit amount: ");
			amt=sc.nextDouble();
			try {
				accountService.deposit(id,amt);
			} catch (UserNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 4: 
			System.out.println("Enter account id: ");
			id=sc.next();
			try {
				accountService.displayAccount(id);
			} catch (UserNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 5: 
			System.out.println("Enter your account id: ");
			id=sc.next();
			System.out.println("Enter transfer amount: ");
			amt=sc.nextDouble();
			try {
				accountService.transfer(id,amt);
			} catch (InsufficientBalanceException e) {
				System.out.println(e.getMessage());
			} catch (UserNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 6: 
			System.out.println("Enter account id: ");
			id=sc.next();
			try {
				accountService.changePin(id);
			} catch (UserNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (LimitExceedException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 7: 
			System.out.println("THANK YOU FOR CHOOSING xxxx BANK.....");
			System.exit(0);
			break;
		default: System.out.println("PLEASE CHECK YOUR OPTION AND TRY AGAIN.....");
		}
	}
	
}
}