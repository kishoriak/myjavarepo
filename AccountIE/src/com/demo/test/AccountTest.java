package com.demo.test;

import java.util.Date;
import java.util.Scanner;

import com.demo.bean.Account;
import com.demo.bean.Current;
import com.demo.bean.Savings;
import com.demo.exception.AccountNotFoundException;
import com.demo.service.AccService;
import com.demo.service.AccServiceImp;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		AccService a = new AccServiceImp();
		int choice = 0;
		String schoice = null;
		do {
			System.out.println("1.Add new account");
			System.out.println("2.withdraw");
			System.out.println("3.deposit");
			System.out.println("4.transfer fund");
			System.out.println("5.change pin");
			System.out.println("6.check balance");
			System.out.println("7.display by id");
			System.out.println("8.exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("type of account, sav/cur?");
				schoice = sc.next();
				a.acceptAccData(schoice);
				
				break;
			case 2:
				System.out.println("enter the per id");
				int id = sc.nextInt();
				System.out.println("enter the amount to be withdrawn");
				double amt = sc.nextDouble();
				System.out.println("enter the account pin");
				int pin = sc.nextInt();
				try {
					if (a.pinVerify(pin, id)) {
						a.withdrawAmt(id, amt);
					} else {
						System.out.println("incorrect pin entered");
					}
				} catch (AccountNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					// e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("enter the per id");
				id = sc.nextInt();
				System.out.println("enter the amount to be deposited");
				amt = sc.nextDouble();
				System.out.println("enter the account pin");
				pin = sc.nextInt();
				try {
					if (a.pinVerify(pin, id)) {
						a.depositAmt(id, amt);
					} else {
						System.out.println("incorrect pin entered");
					}
				}catch(AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 4:
				System.out.println("enter the id of the debit account");
				id = sc.nextInt();
				System.out.println("enter the account pin");
				pin = sc.nextInt();
				try {
					if (a.pinVerify(pin, id)) {
						System.out.println("enter the id of the credit account");
						int id2 = sc.nextInt();
						System.out.println("enter the amount to be transferred");
						amt = sc.nextDouble();
						a.tranAmt(id, id2, amt);
					} else {
						System.out.println("incorrect pin entered");
					}
				}catch(AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 5:
				System.out.println("enter the id of the debit account");
				id = sc.nextInt();
				System.out.println("enter the account pin");
				pin = sc.nextInt();
				try {
					if (a.pinVerify(pin, id)) {
						System.out.println("enter the new pin");
						int newPin = sc.nextInt();
						a.changePin(id, newPin);
					} else {
						System.out.println("incorrect pin entered");
					}
				}catch(AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
			case 6:
				System.out.println("enter the id of the account");
				id = sc.nextInt();
				System.out.println("enter the account pin");
				pin = sc.nextInt();
				try {
					double bal = 0.0;
					if (a.pinVerify(pin, id)) {
						bal = a.checkBal(id);
						System.out.println("The balance is :" + bal);
					}
				}catch(AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 7:
				System.out.println("enter the id of the account");
				id = sc.nextInt();
				try {
					Account q = a.dispById(id);
					System.out.println(q);
				}catch(AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 8:
				System.exit(0);
			}

		} while (choice != 8);
		sc.close();
	}

}
