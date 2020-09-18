package com.demo.service;

import java.util.Scanner;

import com.demo.bean.Account;
import com.demo.bean.CurrentAccount;
import com.demo.bean.SavingAccount;
import com.demo.exception.AccountNotFound;
import com.demo.exception.AmountIsNotValid;
import cmo.demo.dao.AccountDao;

public class AccountService implements AccountServiceInterface{
	
	private AccountDao accountDao;

	public AccountService() {
		this.accountDao = new AccountDao();
	}

	@Override
	public String addAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name : ");
		String name = sc.next();
		System.out.println("Enter balance : ");
		double balance = sc.nextDouble();
		System.out.println("Enter pin number : ");
		int pin = sc.nextInt();
		System.out.println();
		while (true) {
			System.out.println("1. Saving Account");
			System.out.println("2. Current Account");
			System.out.println("Select account type");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				accountDao.addAccount(new SavingAccount(name, balance, pin));
				return "Saving Account created successfully!";
				
			case 2:
				accountDao.addAccount(new CurrentAccount(name, balance, pin));
				return "Current Account created successfully!";
				
			default:
				System.out.println("Enter valid choice.");
				break;
			}
		}
	}
			
	//deposit to account / withdraw from account
	@Override
	public String accDepositWithdraw(int id, char idf, double amt) throws AmountIsNotValid, AccountNotFound{
		if(amt <= 0) {
			throw new AmountIsNotValid("Please enter the valid amount");
		}
		Account account = accountDao.searchById(id);
		if(account != null) {
			if(idf == 'd') {
				return accountDao.depositAmt(account, amt);
			}else if(idf == 'w') {
				return accountDao.withdrawAmt(account, amt);
			}
		}else {
			return "Account not found";
		}
		return "";
	}
	
	public static int getIntInput(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter " + msg +" : ");
		int id = sc.nextInt();
		return id;
	}
	
	public static double getDoubleInput(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter " + msg + " : ");
		double amount = sc.nextDouble();
		return amount;
	}
	
	@Override
	public String transferFunds(int id1, int id2, double amt) throws AmountIsNotValid, AccountNotFound {
		if(amt <= 0) {
			throw new AmountIsNotValid("Please enter the valid amount");
		}
		Account acc1 = accountDao.searchById(id1);
		Account acc2 = accountDao.searchById(id2);
		String msg = accountDao.withdrawAmt(acc1, amt);
		if(!msg.contains("successful")) {
			return "Error Occured. Check if you have sufficient balance";
		}
		accountDao.depositAmt(acc2, amt);
		return "Fund transfer successfully";
	}
	
	@Override
	public String changePin(int id, int currentPin, int newPin) throws AccountNotFound {
		Account account = accountDao.searchById(id);
		if(account.getPinNumber() == currentPin) {
			account.setPinNumber(newPin);
			return "Pin change successfully";
		}else {
			return "Incorrect Pin";
		}
	}
	
	@Override
	public String getAccountBalance(int id) throws AccountNotFound {
		Account account = accountDao.searchById(id);
		if(account != null) {
			return "Account Balance : " + account.getBalance();
		}else {
			return "Account not found!";
		}
	}
	
	@Override
	public String displayAccountInfo(int id) throws AccountNotFound {
		Account account = accountDao.searchById(id);
		if(account != null) {
			double interest = 0;
			if(account instanceof SavingAccount) {
				interest = account.calculateInterest();
			}else if(account instanceof CurrentAccount) {
				interest = account.calculateInterest();
			}
			return account.toString() + " [Interest = " + interest + "]";
		}else {
			return "Account not found!";
		}
	}
}
