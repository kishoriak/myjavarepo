package com.java.dao;

import com.demo.bean.Account;
import com.demo.exception.AccountNotFoundException;

public interface AccountDao {

	void addAccount(Account a);

	Account SearchById(int id) throws AccountNotFoundException;

	Account[] DisplayAccounts();



}
