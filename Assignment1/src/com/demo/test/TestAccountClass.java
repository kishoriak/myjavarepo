package com.demo.test;

import com.demo.bean.Account;
import com.demo.service.AccountService;
import java.util.Scanner;

public class TestAccountClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account[] a = new Account[3];
		int choice = 0;
		
		//Main Menu with options
		do {
			System.out.println("1. New Account : \n2. Search Account by ID : \n3. Deposit : \n4. Withdraw : \n5. Search Account by Name : \n6. Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				AccountService.acceptAccountData(a);
				break;
			case 2:
				System.out.println("Enter ID name ");
				int id = sc.nextInt();
				int pos = AccountService.searchById(a, id);
				if (pos != -1) {
					System.out.println(a[pos]);
				} else {
					System.out.println("No such ID found");
				}
				break;
			case 3:
				System.out.println("Deposit Amount : ");
				double damt = sc.nextDouble();
				System.out.println("Enter the Account ID: ");
				int dId = sc.nextInt();
				AccountService.depositAmt(a, dId, damt);
				break;
			case 4:
				System.out.println("Withdraw Amount: ");
				double wAmt = sc.nextDouble();
				System.out.println("Enter the Account ID: ");
				int wId = sc.nextInt();
				AccountService.withdrawAmt(a, wId, wAmt);
				break;
			case 5:
				System.out.println("Enter Name");
				String nm = sc.next();
				int posn = AccountService.searchByName(a, nm);
				if (posn != -1) {
					System.out.println(a[posn]);
				} else {
					System.out.println("Person Not Found");
				}
				break;
			case 6:
				System.exit(0);
			}
		} while (choice != 6);
		sc.close();
	}

}
