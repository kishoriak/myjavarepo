package com.demo.service;

import com.demo.bean.Account;
import com.demo.exception.AccountNotFoundException;
import com.demo.exception.InvalidAmountException;

public interface AccountService {

	
	 Account searchById(int id) throws AccountNotFoundException;

	  double displayBalance(int id) throws AccountNotFoundException;
	 int changePin(int id, int pin, int pin1) throws AccountNotFoundException;
	 int withdrawAmt(int id, double amount, int pin) throws AccountNotFoundException;

	  int depositeAmt(int id, double amt) throws InvalidAmountException, AccountNotFoundException ;
		

	 Account acceptAccountData(int accountType);

	int transferAmount(int sourceId, int targetId, int pin, double amount) throws AccountNotFoundException;
	 
	
    
	 
}
