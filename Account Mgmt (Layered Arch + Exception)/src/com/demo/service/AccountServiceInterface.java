package com.demo.service;

import com.demo.exception.AccountNotFound;
import com.demo.exception.AmountIsNotValid;

public interface AccountServiceInterface {
	String addAccount();
	String accDeposit(int id, double amt) throws AmountIsNotValid, AccountNotFound;
	String accWithdraw(int id, double amt) throws AmountIsNotValid, AccountNotFound;
	String transferFunds(int id1, int id2, double amt) throws AmountIsNotValid, AccountNotFound;
	String changePin(int id, int pin, int pin1) throws AccountNotFound;
	String getAccountBalance(int id) throws AccountNotFound;
	String displayAccountInfo(int id) throws AccountNotFound;
}
