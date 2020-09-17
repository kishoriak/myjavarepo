package com.demo.test;
import java.util.Scanner;

import com.demo.bean.Account;
import com.demo.service.AccountService;

public class TestAccountClass {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		Account[] a=new Account[3];

		//menu for the customer
		int choice;
		do{			
			System.out.println("\nEnter the number: (1) create a/c (2) withdraw (3) deposit "
					+ "(4) display a/c by id (5) exit"); 
			choice=sc.nextInt();
			switch(choice) {
			case 1: 
				AccountService.acceptAccountData(a);
				break;
			case 2: 
				System.out.println("Enter account id");
				int id=sc.nextInt();
				System.out.println("Enter withdraw amount");
				Double amt=sc.nextDouble();
				AccountService.withdraw(a,id,amt);
				break;
			case 3: 
				System.out.println("Enter account id");
				id=sc.nextInt();
				System.out.println("Enter deposit amount");
				amt=sc.nextDouble();
				AccountService.deposit(a,id,amt);
				break;
			case 4: 
				System.out.println("Enter account id");
				id=sc.nextInt();
				AccountService.displayAccount(a,id);
				break;
			case 5: 
				System.out.println("exited");
				System.exit(0);
				break;
			default: System.out.println("wrong option");
			}
		}while(choice!=5);
		//System.out.print(Account.count); //finally showing total number of accounts
	}

}
