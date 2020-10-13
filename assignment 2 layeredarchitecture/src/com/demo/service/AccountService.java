package com.demo.service;

import com.demo.exception.InsufficientBalanceException;
import com.demo.exception.LimitExceedException;
import com.demo.exception.UserNotFoundException;

public interface AccountService {

	void acceptAccountData() throws LimitExceedException;

	void withdraw(String id, Double amt) throws InsufficientBalanceException, UserNotFoundException;

	void deposit(String id, Double amt) throws UserNotFoundException;

	void displayAccount(String id) throws UserNotFoundException;

	void transfer(String idSource, double amt) throws InsufficientBalanceException, UserNotFoundException;

	void changePin(String id) throws UserNotFoundException, LimitExceedException;

}
