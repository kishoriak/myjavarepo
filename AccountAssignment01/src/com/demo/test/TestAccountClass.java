package com.demo.test;
import java.util.Scanner;

import com.demo.bean.Account;
import com.demo.service.AccountService;

public class TestAccountClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account[] acc = new Account[2];
		int choice = 0;
		
		//Menu to be displayed
		do {
			System.out.println("1. Create new accounts");
			System.out.println("2. Withdraw amount");
			System.out.println("3. Make a deposit");
			System.out.println("4. Display accounts");
			System.out.println("5. Exit");
			System.out.println("Enter your choice");
			
			choice = sc.nextInt();
			int id = 0;
			double amount = 0;
			switch(choice) {
				case 1:
					AccountService.acceptAccountData(acc);
					System.out.println("Accounts created");
					break;
				case 2:
					System.out.println("Enter Id:");
					id = sc.nextInt();
					System.out.println("Enter the amount");
					amount = sc.nextDouble();
					int result = AccountService.withdrawAmount(id, amount, acc);
					if(result != -1) {
						System.out.println("Successfully withdrawal");
					}
					else {
						System.out.println("Failed to withdraw");
					}
					break;
				case 3:
					System.out.println("Enter Id");
					id = sc.nextInt();
					System.out.println("Enter the amount");
					amount = sc.nextDouble();
					result = AccountService.depositAmount(id, amount, acc);
					if(result != -1) {
						System.out.println("Deposit Successful");
					}
					else {
						System.out.println("Deposit failed");
					}
					break;
				case 4:
					System.out.println("Enter Id");
					id = sc.nextInt();
					AccountService.displayAccountData(acc, id);
					break;
				case 5:
					System.exit(0);
			}
		}while(choice != 5);
		
	}

}
