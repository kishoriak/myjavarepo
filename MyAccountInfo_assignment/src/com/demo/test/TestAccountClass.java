package com.demo.test;

import com.demo.bean.Account;
import com.demo.service.AccountService;
import java.util.Scanner;

public class TestAccountClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Account[] a = new Account[3];
		int choice = 0;
		do {
			System.out.println("1.add new person");
			System.out.println("2.search person by name");
			System.out.println("3.deposit amount");
			System.out.println("4.withdraw amount");
			System.out.println("5.display account by id");
			System.out.println("6.exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				AccountService.acceptAccountData(a);
				break;
			case 2:
				System.out.println("enter the name to be searched");
				String nm = sc.next();
				int posn = AccountService.searchByName(a, nm);
				if (posn != -1) {
					System.out.println(a[posn]);
				} else {
					System.out.println("person not found");
				}
				break;
			case 3:
				System.out.println("Enter the amount to be deposited: ");
				double damt = sc.nextDouble();
				System.out.println("Enter the person ID: ");
				int dId = sc.nextInt();
				AccountService.depositAmt(a, dId, damt);
				break;
			case 4:
				System.out.println("Enter the amount to be withdrawn: ");
				double wAmt = sc.nextDouble();
				System.out.println("Enter the person ID: ");
				int wId = sc.nextInt();
				AccountService.withdrawAmt(a, wId, wAmt);
				break;
			case 5:
				System.out.println("enter id to display data");
				int id = sc.nextInt();
				int pos = AccountService.searchById(a, id);
				if (pos != -1) {
					System.out.println(a[pos]);
				} else {
					System.out.println("person not found");
				}
				break;
			case 6:
				System.exit(0);
			}
		} while (choice != 6);
		sc.close();
	}

}
