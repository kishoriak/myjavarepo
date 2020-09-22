package com.demo.dao;

import com.demo.bean.Account;
import com.demo.exception.AccountNotFoundException;
import com.demo.exception.InsufficientBalanceException;
import com.demo.exception.InvalidAmountException;

public interface AccountDao {

	void createAccount(Account acc);
	Account searchAccountById(int id) throws AccountNotFoundException;
	int depositAmount(Account acc, double amount) throws InvalidAmountException;
	int withdrawAmount(Account acc, double amount, int pin) throws InsufficientBalanceException;
	void transferAmount(Account targetAcc, double amount);
	void changePin(Account acc, int pin, int newPin);
	double getBalance(Account acc, int pin);

}
