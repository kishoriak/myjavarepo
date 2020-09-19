package com.except.dao;

import com.except.bean.Account;
import com.except.exception.AccountNotFoundException;
import com.except.exception.InsufficientBalanceException;

public interface AccountDao {
	
	boolean createNewAccount(Account ob);
	
	Account searchById(int id) throws AccountNotFoundException;
	
	boolean withdrawal(Account ob, double amt) throws InsufficientBalanceException;
	
	void deposit(Account ob, double amt);
	
	boolean validatePin(Account ob, int pin);
	
	void changePin(Account ob, int pin);
	
	double checkBalance(Account ob);
	
	void display(Account ob);
}