package com.demo.service;

import com.demo.bean.Account;
import com.demo.exception.AccountNotFoundException;
import com.demo.exception.InsufficientBalanceException;
import com.demo.exception.InvalidAmountException;

public interface AccountService {
	Account acceptAccountData(int accountType);
	int withdrawAmount(int id, double amount, int pin) throws AccountNotFoundException, InsufficientBalanceException;
	int depositAmount(int id, double amount) throws AccountNotFoundException, InvalidAmountException;
	Account searchAccountById(int id) throws AccountNotFoundException;
	double getBalance(int id, int pin) throws AccountNotFoundException;
	int changePin(int id, int pin, int newPin) throws AccountNotFoundException;
	int transferAmount(int sourceId, int targetId, int pin, double amount) throws AccountNotFoundException, InsufficientBalanceException;

}
