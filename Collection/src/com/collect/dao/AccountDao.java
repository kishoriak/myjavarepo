package com.collect.dao;

import com.collect.bean.Account;
import com.collect.exception.AccountNotFoundException;
import com.collect.exception.InsufficientBalanceException;

public interface AccountDao {
	
	boolean createNewAccount(Account ob);	//for new account creation
	
	Account searchById(String id) throws AccountNotFoundException;	//for searching an account using id
	
	boolean withdrawal(Account ob, double amt) throws InsufficientBalanceException;	//for withdrawal
	
	void deposit(Account ob, double amt);	//for depositing
	
	boolean validatePin(Account ob, int pin);	//for validating PIN
	
	void changePin(Account ob, int pin);	//for changing PIN
	
	double checkBalance(Account ob);	//for checking balance
	
	void display(Account ob);	//display a specific account using id
	
	void displayAll();	//display all accounts
}