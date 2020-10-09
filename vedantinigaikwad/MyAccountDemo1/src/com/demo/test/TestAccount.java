package com.demo.test;

import java.util.Scanner;

import com.demo.bean.Account;
import com.demo.services.AccountServices;

public class TestAccount {
	public static void main(String[] args) {
		
		Account[] a=new Account[3];
		Scanner sc=new Scanner(System.in);
		int choice=0;
		
		do {
			System.out.println("1. Add account");
			System.out.println("2. Withdraw");
			System.out.println("3. Deposit");
			System.out.println("4. Display account by id");
			System.out.println("5. Exit");
			System.out.println("Choice?");
			choice=sc.nextInt();
			
			switch(choice){
			case 1:
				AccountServices.acceptData(a);
				break;
			case 2:
				System.out.println("Enter your id : ");
				int id=sc.nextInt();
				System.out.println("Amount to withdraw : ");
				double wd=sc.nextDouble();
				AccountServices.withdrawAmt(a, id, wd);
				break;
			case 3:
				System.out.println("Enter your id : ");
				int id1=sc.nextInt();
				System.out.println("Amount to deposit : ");
				double dep=sc.nextDouble();
				AccountServices.depositAmt(a, id1, dep);
				break;
			case 4:
				System.out.println("Enter your id : ");
				int id2=sc.nextInt();
				int pos=AccountServices.searchById(a, id2);
				AccountServices.displayAccountData(a, pos);
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Wrong choice");
			}
		}while(choice!=5);
		
	}
}
