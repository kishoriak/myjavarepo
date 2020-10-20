package com.assign.test;

import java.util.Scanner;

import com.assign.bean.*;
import com.assign.service.*;

public class TestAccount {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Account[] a = new Account[3];
		
		int ch,id,ch1,res,i=0;
		String rep,type;
		double amt;
		
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
					AccountService.createAccount(a, type,i);
					i++;
					break;
			case 2: System.out.println("Enter Account ID");
					id = sc.nextInt();
					System.out.println("Enter amount");
					amt = sc.nextDouble();
					//call withdraw function in service
					AccountService.withdrawAmt(a, id, amt);
					break;
			case 3: System.out.println("Enter Account ID");
					id = sc.nextInt();
					System.out.println("Enter amount");
					amt = sc.nextDouble();
					//call deposit function in service
					AccountService.depositAmt(a, id, amt);
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
					AccountService.transfer(a, id, id1, amt);
					break;
			case 5: System.out.println("Enter Account ID");
					id=sc.nextInt();
					//check whether it exists or not
					res=AccountService.searchAccount(a, id);
					if(res==-1) {
						System.out.println("Account not found");
						break;
					}
					System.out.println("Enter current PIN");
					int pin,pin1,pin2,res1;
					pin = sc.nextInt();
					//call to check whether the PIN is correct or not
					res1=AccountService.checkPin(a, res, pin);
					if(res1==-1) {
						System.out.println("Incorrect PIN");
						break;
					}
					System.out.println("Enter new PIN");
					pin1 = sc.nextInt();
					System.out.println("Confirm new PIN");
					pin2 = sc.nextInt();
					if(pin1==pin2) {
						//call change pin method in service
						AccountService.changePin(a, pin2, res);
					}
					else
						System.out.println("New PIN and confirmation do not match");
					break;
			case 6: System.out.println("Enter ID");
					id = sc.nextInt();
					//call check balance method in service
					AccountService.checkBalance(a, id);
					break;
			default: System.out.println("Invalid choice");
			}
			System.out.println("Do you wish to continue?(y/n)");
			rep = sc.next();
		}while(rep.equals("y"));
		sc.close();
	}
}