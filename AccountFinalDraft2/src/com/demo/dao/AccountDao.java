package com.demo.dao;

import com.demo.exception.*;

import java.util.Set;

import com.demo.bean.Account;

public interface AccountDao {

	void newAccount(Account a);

	Account searchId(String id);

	void deposit(Account arr, double amt);

	Set<Account> displayAll();

	void withdraw(Account a, Double amt) throws InsufficientBalanceException;

}
