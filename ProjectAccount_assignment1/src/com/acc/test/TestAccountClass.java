package com.acc.test;

import java.util.Scanner;
import com.acc.bean.*;
import com.acc.service.*;

public class TestAccountClass {
	
	public static void main(String[] args) {
		
		Account[] a = new Account[10];
		Scanner sc = new Scanner(System.in);
		
		int ch;
		String rep;
		//MENU
		do {
			System.out.println("*****MENU*****");
			System.out.println("1. Create new account");
			System.out.println("2. Withdraw");
			System.out.println("3. Deposit");
			System.out.println("4. Display");
			System.out.println("5. Exit");
			System.out.println("Enter your choice:");
			ch = sc.nextInt();
			int res,id;
			double amt;
			switch(ch) {
			case 1: AccountService.acceptAccountDetails(a);
					break;
			case 2: System.out.println("Enter ID:");
					id = sc.nextInt();
					System.out.println("Enter amount");
					amt = sc.nextDouble();
					AccountService.withdrawAmt(a,id,amt);
					break;
			case 3: System.out.println("Enter ID");
					id = sc.nextInt();
					System.out.println("Enter Amount");
					amt = sc.nextDouble();
					AccountService.depositAmt(a,id,amt);
					break;
			case 4: System.out.println("Enter ID");
					id = sc.nextInt();
					res = AccountService.displayAccount(a, id);
					if(res == -1)
						System.out.println("Account not found");
					break;
			case 5 : System.exit(0);
			}
			System.out.println("Do you wish to continue?(y/n)");
			rep = sc.next();
		}while(rep.equals("y"));
		sc.close();
		//AccountService.displayAllAccounts(a);
	}
}
