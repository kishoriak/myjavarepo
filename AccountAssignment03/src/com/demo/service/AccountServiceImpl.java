package com.demo.service;
import java.text.ParseException;
import java.math.*;
import java.lang.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.demo.bean.Account;
import com.demo.bean.CurrentAccount;
import com.demo.bean.SavingAccount;
import com.demo.dao.AccountDao;
import com.demo.dao.AccountDaoImpl;
import com.demo.exception.AccountNotFoundException;
import com.demo.exception.InsufficientBalanceException;
import com.demo.exception.InvalidAmountException;

public class AccountServiceImpl implements AccountService{
	public static Scanner sc = new Scanner(System.in);
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private AccountDao accountDao;
	
	//Default constructor
	public AccountServiceImpl(){
		this.accountDao = new AccountDaoImpl();
	}
	
	//Accept user data and create accounts
	@Override
	public Account acceptAccountData(int accountType) {
			Account acc = null;
			System.out.println("Enter Name :");
			String name = sc.next();
			System.out.println("Enter Balance :");
			double balance = sc.nextDouble();
			System.out.println("Enter Pin :");
			int pin = sc.nextInt();
			System.out.println("Enter Date :");
			String doj= sc.next();
			try {
				Date dateOfJoining = sdf.parse(doj);
				if(accountType == 1) {
					acc = new SavingAccount(name, pin, balance, dateOfJoining, "Saving");
				}
				else if(accountType == 2) {
					acc = new CurrentAccount(name, pin, balance, dateOfJoining, "Current");
				}
				accountDao.createAccount(acc);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return acc;
	}
	
	//Display account data to user
	@Override
	public Account searchAccountById(int id) throws AccountNotFoundException{
		return accountDao.searchAccountById(id);
	}
	
	//Withdraw amount
	@Override
	public int withdrawAmount(int id, double amount, int pin) throws AccountNotFoundException, InsufficientBalanceException {
		Account acc = accountDao.searchAccountById(id);
		if(acc != null && acc.getPin() == pin) {
			return accountDao.withdrawAmount(acc, amount, pin);
		}
		return -1;
	}
	
	//Deposit amount
	@Override
	public int depositAmount(int id, double amount) throws AccountNotFoundException, InvalidAmountException {
		Account acc = searchAccountById(id);
		if(acc != null) {
			accountDao.depositAmount(acc, amount);
		}
		return 1;
		
	}

	//Get the balance of an account
	@Override
	public double getBalance(int id, int pin) throws AccountNotFoundException {
		Account acc = searchAccountById(id);
		if(acc != null) {
			return accountDao.getBalance(acc, pin);
		}
		return -1;
	}

	//Change pin of a account
	@Override
	public int changePin(int id, int pin, int newPin) throws AccountNotFoundException {
		Account acc = searchAccountById(id);
		if(acc != null && acc.getPin() == pin) {
			accountDao.changePin(acc, pin, newPin);
			return 1;
		}
		return -1;
	}

	//Transfer amount to other account
	@Override
	public int transferAmount(int sourceId, int targetId, int pin, double amount) throws AccountNotFoundException, InsufficientBalanceException {
		Account sourceAcc =searchAccountById(sourceId);
		if(sourceAcc != null) {
			int result = accountDao.withdrawAmount(sourceAcc, amount, pin);
			if(result != -1) {
				Account targetAcc = searchAccountById(targetId);
				if(targetAcc != null) {
					accountDao.transferAmount(targetAcc, amount);
					return 1;
				}
			}
		}
		return -1;
	}


	

}
