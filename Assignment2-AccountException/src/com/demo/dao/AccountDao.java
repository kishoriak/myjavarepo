package com.demo.dao;

import com.demo.bean.Account;
import com.demo.exception.InsufficientBalanceException;
import com.demo.exception.UserNotFoundException;

public interface AccountDao {

	void acceptAccount(Account a);

	Account searchById(String id) throws UserNotFoundException;

	void withdrawal(Account a,Double amt) throws InsufficientBalanceException;
	
	Account[] displayAll();

}
