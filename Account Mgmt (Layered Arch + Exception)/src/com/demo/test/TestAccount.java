package com.demo.test;

import java.util.Scanner;

import com.demo.exception.AccountNotFound;
import com.demo.exception.AmountIsNotValid;
import com.demo.service.AccountService;

public class TestAccount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AccountService accountService = new AccountService();
		int id, flag = 0;
		double amt;
		while (true) {
			System.out.println("1. Create new Account.");
			System.out.println("2. Withdraw");
			System.out.println("3. Deposit");
			System.out.println("4. Transfer Funds");
			System.out.println("5. Change Pin");
			System.out.println("6. Check balance");
			System.out.println("7. Display Account's information");
			System.out.println("8. Exit");
			System.out.println("Enter your choice:");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println(accountService.addAccount());
				break;

			case 2:
				flag = 0;
				while (flag == 0) {
					try {
						id = AccountService.getIntInput("account id");
						amt = AccountService.getDoubleInput("amount");
						System.out.println(accountService.accWithdraw(id, amt));
						flag = 1;
					} catch (AmountIsNotValid e) {
						e.printStackTrace();
					} catch (AccountNotFound e) {
						e.printStackTrace();
					}
				}
				break;

			case 3:
				flag = 0;
				while (flag == 0) {
					try {
						id = AccountService.getIntInput("account id");
						amt = AccountService.getDoubleInput("amount");
						System.out.println(accountService.accDeposit(id, amt));
						flag = 1;
					} catch (AmountIsNotValid e) {
						e.printStackTrace();
					}catch (AccountNotFound e) {
						e.printStackTrace();
					}
				}
				break;

			case 4:
				flag = 0;
				while (flag == 0) {
					try {
						id = AccountService.getIntInput("sender's account id");
						int id2 = AccountService.getIntInput("recipient's account id");
						amt = AccountService.getDoubleInput("amount");
						System.out.println(accountService.transferFunds(id, id2, amt));
						flag = 1;
					} catch (AmountIsNotValid e) {
						e.printStackTrace();
					}catch (AccountNotFound e) {
						e.printStackTrace();
					}
				}
				break;

			case 5:
				flag = 0;
				while (flag == 0) {
					try {
						id = AccountService.getIntInput("account id");
						int pin = AccountService.getIntInput("current pin");
						int pin1 = AccountService.getIntInput("new pin");
						System.out.println(accountService.changePin(id, pin, pin1));
						flag = 1;
					} catch (AccountNotFound e) {
						e.printStackTrace();
					}
				}
				
				break;

			case 6:
				flag = 0;
				while (flag == 0) {
					try {
						id = AccountService.getIntInput("account id");
						System.out.println(accountService.getAccountBalance(id));
						flag = 1;
					} catch (AccountNotFound e) {
						e.printStackTrace();
					}					
				}
				break;

			case 7:
				flag = 0;
				while(flag == 0) {
					try {
						id = AccountService.getIntInput("account id");
						System.out.println(accountService.displayAccountInfo(id));
						flag = 1;
					} catch (AccountNotFound e) {
						e.printStackTrace();
					}					
				}
				break;

			case 8:
				System.exit(0);

			default:
				System.out.println("Enter valid choice");
				break;
			}
		}
	}
}
