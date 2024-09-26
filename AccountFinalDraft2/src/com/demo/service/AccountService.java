package com.demo.service;

import com.demo.bean.Account;
import com.demo.exception.*;
public interface AccountService {

	void acceptAccountData() throws LimitExceedException;

	void withdraw(String id, Double amt) throws InsufficientBalanceException, UserNotFoundException;

	void deposit(String id, Double amt) throws UserNotFoundException;

	void displayAccount(String id) throws UserNotFoundException;

	void transfer(String idSource, double amt) throws InsufficientBalanceException, UserNotFoundException;

	void changePin(String id) throws UserNotFoundException, LimitExceedException;

}
