package com.demo.test;

import java.util.Date;
import java.util.Scanner;

import com.demo.bean.Account;
import com.demo.bean.SavingAccount;
import com.demo.exception.AccountNotFoundException;
import com.demo.exception.InsufficientBalanceException;
import com.demo.exception.InvalidAmountException;
import com.demo.service.AccountService;
import com.demo.service.AccountServiceImpl;

public class TestAccountInheritance {
	
	public static void main(String[] args) {
		AccountService accountService = new AccountServiceImpl();
		
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		//Menu to be displayed
		do {
			System.out.println("1. Create new account");
			System.out.println("2. Withdraw amount");
			System.out.println("3. Make a deposit");
			System.out.println("4. Transfer fund");
			System.out.println("5. Change pin");
			System.out.println("6. Check balance");
			System.out.println("7. Display account by Id");
			System.out.println("8. Exit");
			
			choice = sc.nextInt();
			int id = 0;
			double amount = 0;
			int accountType = 0;
			
			switch(choice) {
				case 1:
					System.out.println("1. Saving Account");
					System.out.println("2. Current Account");
					System.out.println("Enter type of account");
					accountType = sc.nextInt();
					Account acc = accountService.acceptAccountData(accountType);
					System.out.println("Account created");
					System.out.println(acc);
					break;
				case 2:
					System.out.println("Enter Id:");
					id = sc.nextInt();
					System.out.println("Enter the amount");
					amount = sc.nextDouble();
					System.out.println("Enter the pin");
					int pin = sc.nextInt();
					int result;
					try {
						result = accountService.withdrawAmount(id, amount, pin);
						if(result != -1) {
							System.out.println("Successful withdrawal");
						}
					} catch (AccountNotFoundException e5) {
						System.out.println(e5.getMessage());
					} catch (InsufficientBalanceException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					System.out.println("Enter Id");
					id = sc.nextInt();
					System.out.println("Enter the amount");
					amount = sc.nextDouble();
					try {
						result = accountService.depositAmount(id, amount);
						System.out.println("Deposit Successful");
					} catch (AccountNotFoundException e4) {
						System.out.println(e4.getMessage());
					} catch (InvalidAmountException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 4:
					System.out.println("Enter Id of source account:");
					int sourceId = sc.nextInt();
					System.out.println("Enter Id of target account");
					int targetId = sc.nextInt();
					System.out.println("Enter the pin of source account");
					pin = sc.nextInt();
					System.out.println("Enter the amount");
					amount = sc.nextDouble();
					try {
						result = accountService.transferAmount(sourceId, targetId, pin, amount);
						if(result != -1) {
							System.out.println("Transfer Successful");
						}
						else {
							System.out.println("Transfer failed");
						}
					} catch (AccountNotFoundException e3) {
						System.out.println(e3.getMessage());
					} catch (InsufficientBalanceException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 5:
					System.out.println("Enter Id:");
					id = sc.nextInt();
					System.out.println("Enter the current pin");
					pin = sc.nextInt();
					System.out.println("Enter the new pin");
					int newPin = sc.nextInt();
					try {
						result = accountService.changePin(id, pin, newPin);
						if(result != -1) {
							System.out.println("Pin changed");
						}
						else {
							System.out.println("Cannot change pin");
						}
					} catch (AccountNotFoundException e2) {
						System.out.println(e2.getMessage());
					}
					
					
					break;
				case 6:
					System.out.println("Enter Id:");
					id = sc.nextInt();
					System.out.println("Enter the pin");
					pin = sc.nextInt();
					try {
						System.out.println("Account balance is :" + accountService.getBalance(id, pin));
					} catch (AccountNotFoundException e1) {
						System.out.println(e1.getMessage());
					}
					break;
				case 7:
					System.out.println("Enter Id :");
					id = sc.nextInt();
					try {
						System.out.println(accountService.searchAccountById(id));
					} catch (AccountNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 8:
					System.exit(0);
			}
		}while(choice != 8);
		
	}
}
