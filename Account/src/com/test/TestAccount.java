package com.test;
import java.util.Scanner;

import com.accountService.AccountService;
import com.account.Account;

public class TestAccount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account[] acc = new Account[10];
		com.accountService.AccountService.addAccData(acc); //create dummy data for 10 accounts
		int choice = 0, id;
		long amt;
		
		while (true) {
			
			System.out.println("1: Withdraw Money");
			System.out.println("2: Deposit Money");
			System.out.println("3: Display account's Info");
			System.out.println("4: Exit");
			System.out.println("Enter your choice : ");
			choice  = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter account Id : ");
				id = sc.nextInt();
				System.out.println("Enter amount : ");
				amt = sc.nextLong();
				System.out.println(AccountService.accDepositWithdraw(acc, id, 'w', amt));
				break;
			
			case 2:
				System.out.println("Enter account Id : ");
				id = sc.nextInt();
				System.out.println("Enter amount : ");
				amt = sc.nextLong();
				System.out.println(AccountService.accDepositWithdraw(acc, id, 'd', amt));
				break;

			case 3:
				System.out.println("Enter account Id : ");
				id = sc.nextInt();
				System.out.println(AccountService.searchById(acc, id).toString());
				break;
				
			case 4:
				System.exit(0);
				
			default:
				System.out.println("Enter valid choice...");
				break;
			}
			
		}
	}

}
//withdraw
//deposit
//display