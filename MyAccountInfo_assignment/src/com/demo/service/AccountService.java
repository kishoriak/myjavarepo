package com.demo.service;

import java.util.Scanner;
import com.demo.bean.Account;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountService {
	//public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static Scanner sc = new Scanner(System.in);

	// function to accept account data
	public static void acceptAccountData(Account[] acc) {
		for (int i = 0; i < acc.length; i++) {
			/*
			 * System.out.println("Enter account ID"); int id = sc.nextInt();
			 */
			System.out.println("Enter account holder's name: ");
			String name = sc.next();
			System.out.println("Enter type of account: ");
			String acctype = sc.next();
			System.out.println("Enter balance: ");
			double bal = sc.nextDouble();
			//System.out.println("Enter date of opening: ");
			//String dt = sc.next();
			Date dOp = new Date();
			acc[i] = new Account(name, acctype, dOp, bal);
			
		}

	}

	// function to search by ID
	public static int searchById(Account[] acc, int id) {
		for (int i = 0; i < acc.length; i++) {
			if (acc[i].getId() == id) {
				return i;
			}
		}
		return -1;
	}

	// function to deposit amount
	public static int depositAmt(Account[] acc, int id, double amt) {
		int pos = searchById(acc, id);
		if (pos != -1) {
			acc[pos].deposit(amt);
			System.out.println("New balance:" + acc[pos].getBal());
			return pos;
		} else {
			System.out.println("person not found");
			return -1;
		}
	}

	// function to withdraw amount
	public static int withdrawAmt(Account[] acc, int id, double amt) {

		int pos = searchById(acc, id);
		if (pos != -1) {
			acc[pos].withdraw(amt);
			System.out.println("New balance:" + acc[pos].getBal());
			return pos;
		} else {
			System.out.println("person not found");
			return -1;
		}

	}

	// function to display account data
	public static void displayData(Account[] acc) {
		for (int i = 0; i < acc.length; i++) {
			if (acc[i] != null) {
				System.out.println(acc[i]);
			} else {
				break;
			}
		}
	}

	public static int searchByName(Account[] a, String nm) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length; i++) {
			if (a[i].getpName().equals(nm)) {
				return i;
			}
		}
		return -1;
	}

	// display account by ID
	public static void dispById(Account[] a, int id) {
		int pos = searchById(a, id);
		if (pos != -1) {
			System.out.println(a[pos]);
		} else {
			System.out.println("Account not found");
		}
	}
}
