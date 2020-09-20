package com.demo.dao;

import com.demo.bean.Account;
import com.demo.exception.AccountNotFoundException;
import com.demo.exception.InvalidAmountException;

public interface AccountDao {

	void addAccount(Account account);

	Account searchById(int id) throws AccountNotFoundException;

	int depositAmt(Account acc, double amount) throws InvalidAmountException, InvalidAmountException;

	int withdrawAmt(Account acc, double amount, int pin);

	double displayBalance(Account acc);

	int changePin(Account acc, int pin, int pin1);

	void transferAmount(Account targetAcc, double amount);
			
	   
}
