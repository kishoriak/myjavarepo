package com.except.service;

import com.except.exception.AccountNotFoundException;
import com.except.exception.InsufficientBalanceException;

public interface AccountService {

	void createAccount(String type);
	
	boolean searchAccount(int id) throws AccountNotFoundException;
	
	void withdrawAmt(int id, double amt) throws AccountNotFoundException, InsufficientBalanceException;
	
	void depositAmt(int id, double amt) throws AccountNotFoundException;
	
	void transfer(int id1,int id2, double amt) throws AccountNotFoundException, InsufficientBalanceException;
	
	boolean checkPin(int id, int pin) throws AccountNotFoundException;
	
	void changePin(int id, int pin) throws AccountNotFoundException;
	
	void checkBalance(int id) throws AccountNotFoundException;
	
	void display(int id) throws AccountNotFoundException;
}