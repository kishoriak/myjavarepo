package com.demo.test;

import java.util.Scanner;

import com.demo.bean.Account;
import com.demo.exception.AccountNotFoundException;
import com.demo.service.AccountService;
import com.demo.service.AccountServiceImpl;

public class TestAccount {

	public static void main(String[] args) {
		
		int choice=0;
		Scanner sc=new Scanner(System.in);
		AccountService as=new AccountServiceImpl();
		
		do {
			System.out.println("1. Add account \n 2. Withdraw \n 3. Deposit \n 4. Transferfunds \n 5. Change pin \n 6. Check balance \n 7. Display account info by id \n 8. Calculate Simple interest \n 9. Exit");
			choice=sc.nextInt();
			
			//switch case menu
			switch(choice) {
			case 1:
				//add account
				as.addAccount();
				break;
				
			case 2:
				//withdraw
				System.out.println("Enter id :");
				int id=sc.nextInt();
				System.out.println("Enter amount : ");
				double wd=sc.nextDouble();
				try {
					boolean flag=as.withdrawMoney(id,wd);
					if(flag) {
						System.out.println("Transaction Succesful");
					}
					else {
						System.out.println("Transaction not Succesful");
					}
				}catch(AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 3:
				//deposit
				System.out.println("Enter id :");
				id=sc.nextInt();
				System.out.println("Enter amount : ");
				double dep=sc.nextDouble();
				try {
					boolean flag=as.depositMoney(id,dep);
					if(flag) {
						System.out.println("Transaction Succesful");
					}
					else {
						System.out.println("Transaction not Succesful");
					}
				}catch(AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 4:
				//transferfund
				System.out.println("Enter senders id :");
				int id1=sc.nextInt();
				System.out.println("Enter recievers id :");
				int id2=sc.nextInt();
				System.out.println("Enter amount : ");
				double trans=sc.nextDouble();
				try {
					boolean flag=as.transferFunds(id1,id2,trans);
					if(flag) {
						System.out.println("Transaction successful");
					}
					else {
						System.out.println("Transaction not successful");
					}
				}catch(AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 5:
				//change pin
				System.out.println("Enter id :");
				id=sc.nextInt();
				System.out.println("Enter pin :");
				int pin1=sc.nextInt();
				System.out.println("Enter new pin :");
				int pin2=sc.nextInt();
				try {
				boolean flag=as.changePin(id,pin1,pin2);
				if(flag) {
					System.out.println("Pin change successful");
				}
				else {
					System.out.println("Pin change not successful");
				}
				}catch(AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 6: 
				//check balance
				System.out.println("Enter id :");
				int id6=sc.nextInt();
				try {
					System.out.println(as.accCheckBalance(id6));
				}catch(AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 7:
				//display info by id
				System.out.println("Enter id :");
				int id7=sc.nextInt();
				try {
					System.out.println(as.displayAccount(id7));
				}catch(AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 8:
				//Cal simple interest
				System.out.println("Enter id :");
				id=sc.nextInt();
				try {
					double si=as.calculateSimpleInterest(id);
					System.out.println("Simple Interest : "+si);
				}catch(AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 9:
				System.exit(0);
				
			default: 
				System.out.println("Wrong choice");
			}
			
		}while(choice!=9);
		
	}
}
