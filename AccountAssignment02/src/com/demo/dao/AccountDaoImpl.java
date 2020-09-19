package com.demo.dao;

import com.demo.bean.Account;
import com.demo.exception.AccountNotFoundException;
import com.demo.exception.InsufficientBalanceException;
import com.demo.exception.InvalidAmountException;
import com.demo.service.AccountServiceImpl;

public class AccountDaoImpl implements AccountDao {
	static Account[] accounts;
	static int count;
	
	static {
		accounts = new Account[3];
		count = 0;
	}

	//Create an account
	@Override
	public void createAccount(Account acc) {
		accounts[count] = acc;
		count = count + 1;
	}
	
	//Search an account by Id
	@Override
	public Account searchAccountById(int id) throws AccountNotFoundException{
		int iterator = 0;
		for(Account acc : accounts) {
			if(iterator < count) {
				if(acc.getId() == id) {
					return acc;
				}
				iterator++;
			}
		}
		throw new AccountNotFoundException("Cannot find account");
	}

	//Deposit amount into an account
	@Override
	public int depositAmount(Account acc, double amount) throws InvalidAmountException {
			acc.deposit(amount);
			return 1;
	}

	//Withdraw amount from an account
	@Override
	public int withdrawAmount(Account acc, double amount, int pin) throws InsufficientBalanceException {
		int result = acc.withdraw(amount);
		if(result != -1) {
			return 1;
		}
		return -1;
	}

	//Transfer amount to other account
	@Override
	public void transferAmount(Account targetAcc, double amount) {
		targetAcc.setBalance(targetAcc.getBalance() + amount);
	}

	//Change the pin of an account
	@Override
	public void changePin(Account acc, int pin, int newPin) {
		acc.setPin(newPin);
	}

	//Get the balance of an account
	@Override
	public double getBalance(Account acc, int pin) {
			return acc.getBalance();
	}
	
	
}
