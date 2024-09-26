package com.except.test;

import java.util.Scanner;

import com.except.exception.AccountNotFoundException;
import com.except.exception.InsufficientBalanceException;
import com.except.service.AccountServiceImpl;


public class TestAccount {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//Account[] a = new Account[3];
		AccountServiceImpl AccountService = new AccountServiceImpl();
		
		int ch,id,ch1;
		boolean res;
		String rep,type;
		double amt;
		rep = new String("y");
		
		do {
			//MENU
			System.out.println("*****MENU*****");
			System.out.println("1. Create a new account");
			System.out.println("2. Withdraw");
			System.out.println("3. Deposit");
			System.out.println("4. Transfer fund");
			System.out.println("5. Change PIN");
			System.out.println("6. Check Balance");
			System.out.println("Enter your choice");
			ch = sc.nextInt();
			//switch case
			switch(ch) {
				
				case 1: System.out.println("Enter the type of account you want to create");
						System.out.println("1. Savings Account");
						System.out.println("2. Current Account");
						ch1 = sc.nextInt();
						if(ch1==1)
							type = new String("Savings");
						else if(ch1==2)
							type = new String("Current");
						else {
							System.out.println("Invalid choice");
							break;
						}
						//call create account function in service sending the type as a parameter
						AccountService.createAccount(type);
						break;
				case 2: System.out.println("Enter Account ID");
						id = sc.nextInt();
						System.out.println("Enter amount");
						amt = sc.nextDouble();
						//call withdraw function in service
						try {
							AccountService.withdrawAmt(id, amt);
						} catch (AccountNotFoundException | InsufficientBalanceException e) {
							System.out.println(e.getMessage());
						}
						break;
				case 3: System.out.println("Enter Account ID");
						id = sc.nextInt();
						System.out.println("Enter amount");
						amt = sc.nextDouble();
						//call deposit function in service
						try {
							AccountService.depositAmt(id, amt);
						} catch (AccountNotFoundException e) {
							System.out.println(e.getMessage());
						}
						System.out.println("Deposit Succesful!");
						break;
				case 4: System.out.println("Enter your Account ID");
						int id1;
						id=sc.nextInt();
						System.out.println("Enter Account ID to transfer to");
						id1=sc.nextInt();
						System.out.println("Enter amount to be transferred");
						amt = sc.nextDouble();
						//call transfer method in service
						try {
							AccountService.transfer(id, id1, amt);
						} catch (AccountNotFoundException|InsufficientBalanceException e) {
							System.out.println(e.getMessage());
						}
						break;
				case 5: System.out.println("Enter Account ID");
						id=sc.nextInt();
						System.out.println("Enter current PIN");
						int pin,pin1,pin2;
						pin = sc.nextInt();
						//call to check whether the PIN is correct or not
						try {
							res = AccountService.checkPin(id,pin);
						
						if(res==true) {
							System.out.println("Enter new PIN");
							pin1 = sc.nextInt();
							System.out.println("Confirm new PIN");
							pin2 = sc.nextInt();
							if(pin1==pin2) {
								//call change pin method in service
								AccountService.changePin(id, pin2);
							}
							else
								System.out.println("New PIN and confirmation do not match");
						}
						} catch (AccountNotFoundException e) {
							System.out.println(e.getMessage());
						}
						break;
				case 6: System.out.println("Enter ID");
						id = sc.nextInt();
						//call check balance method in service
						try {
							AccountService.checkBalance(id);
						} catch (AccountNotFoundException e) {
							System.out.println(e.getMessage());
						}
						break;
				default: System.out.println("Invalid choice");
				}
			System.out.println("Do you wish to continue?(y/n)");
			rep = sc.next();
		}while(rep.equals("y"));
		sc.close();
	}
}