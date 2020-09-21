package com.demo.service;

import com.demo.bean.Account;
import com.demo.exception.AccountNotFoundException;

public interface AccountService {

	void addAccount();
	Account displayAccount(int id) throws AccountNotFoundException;
	boolean withdrawMoney(int id, double wd) throws AccountNotFoundException;
	boolean depositMoney(int id, double dep) throws AccountNotFoundException;
	boolean transferFunds(int id2, int id4, double trans) throws AccountNotFoundException;
	double accCheckBalance(int id) throws AccountNotFoundException;
	boolean changePin(int id, int pin1, int pin2) throws AccountNotFoundException;
	double calculateSimpleInterest(int id) throws AccountNotFoundException;

}
