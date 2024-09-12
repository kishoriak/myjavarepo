package com.demo.test;

import java.util.Scanner;
import java.util.Set;

import com.demo.bean.Account;
import com.demo.bean.CurrentAcc;
import com.demo.bean.SavingsAcc;
import com.demo.exception.InsufficientBalanceException;
import com.demo.exception.LimitExceedException;
import com.demo.exception.UserNotFoundException;
import com.demo.service.AccountService;
import com.demo.service.AccountServiceImpl;

public class AccountTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		AccountService accountService=new AccountServiceImpl();
		Account[] a=new Account[10];

		//menu for the customer
		int choice;
		do{			
			System.out.println("\nEnter the number: (1) create a/c (2) withdraw (3) deposit "
					+ "(4) display a/c by id (5) transfer (6) change pin (7) exit (8)"); 
			choice=sc.nextInt();
			switch(choice) {
			case 1: 
				//to create new acc
				try {
					accountService.acceptAccountData();
				} catch (LimitExceedException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2: 
				//to withdraw from acc
				System.out.println("Enter account id");
				String id=sc.next();
				System.out.println("Enter withdraw amount");
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
				//to deposit into acc
				System.out.println("Enter account id");
				id=sc.next();
				System.out.println("Enter deposit amount");
				amt=sc.nextDouble();
				try {
					accountService.deposit(id,amt);
				} catch (UserNotFoundException e1) {
					System.out.println(e1.getMessage());
				}
				break;
			case 4: 
				//to display acc
				System.out.println("Enter account id");
				id=sc.next();
				try {
					accountService.displayAccount(id);
				} catch (UserNotFoundException e1) {
					System.out.println(e1.getMessage());
				}
				break;
			case 5: 
				//to transfer money from source to target
				System.out.println("Enter your account id");
				id=sc.next();
				System.out.println("Enter transfer amount");
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
				//to change pin
				System.out.println("Enter account id");
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
				//to exit
				System.out.println("exited");
				System.exit(0);
				break;
			/*case 8:
			 	//to display all accounts
				Set<Account> accSet=accountService.getAllAccounts();
				for(Account acc:accSet) {	
					System.out.println(acc);
				}
				break;*/
			default: System.out.println("wrong option");
			}
		}while(choice!=7);
		sc.close();

	}

}
