package com.demo.service;

import com.demo.bean.Account;
import com.demo.exception.AccountNotFoundException;

public interface AccountService {

	void AcceptAccountData(String type);
	Account SerachById(int id) throws AccountNotFoundException;
    Account[] DisplayAccounts();
	boolean WithdrawAmt(int id, Double amt)throws AccountNotFoundException;
	boolean DepositAmt(int id, Double amt)throws AccountNotFoundException;
	void TransferFunds(int id1, int id2, Double amt) throws AccountNotFoundException;
}
