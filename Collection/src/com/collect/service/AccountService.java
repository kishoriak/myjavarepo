package com.collect.service;

import com.collect.exception.AccountNotFoundException;
import com.collect.exception.InsufficientBalanceException;

public interface AccountService {

	void createAccount(String type);	//create new account
	
	boolean searchAccount(String id) throws AccountNotFoundException;	//search by id
	
	void withdrawAmt(String id, double amt) throws AccountNotFoundException, InsufficientBalanceException;	//withdraw
	
	void depositAmt(String id, double amt) throws AccountNotFoundException;	//deposit
	
	void transfer(String id1,String id2, double amt) throws AccountNotFoundException, InsufficientBalanceException;	//transfer
	
	boolean checkPin(String id, int pin) throws AccountNotFoundException;	//validate PIN
	
	void changePin(String id, int pin) throws AccountNotFoundException;	//change PIN
	
	void checkBalance(String id) throws AccountNotFoundException;	//check balance
	
	void display(String id) throws AccountNotFoundException;	//display one account
	
	void displayAll();	//display all accounts
}