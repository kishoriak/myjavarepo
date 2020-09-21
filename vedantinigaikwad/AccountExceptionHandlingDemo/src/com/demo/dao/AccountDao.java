package com.demo.dao;

import com.demo.bean.Account;
import com.demo.exception.AccountNotFoundException;

public interface AccountDao {

	void acceptData(Account a);

	Account displayData(int id) throws AccountNotFoundException;

	int searchById(int id) throws AccountNotFoundException;

	boolean withdraw(int pos, double wd);

	boolean deposit(int pos, double dep);

	boolean transFunds(int pos1, int pos2, double trans);

	double checkBalance(int pos);

	boolean changePinNumber(int pos, int pin1, int pin2);

	double calSimpInterest(int pos);

}
