package com.demo.dao;

import com.demo.bean.Account;
import com.demo.exception.AccountNotFoundException;

public interface AccountDao {
	
	void acceptData(Account a);

	Account searchById(int id) throws AccountNotFoundException;
	
	boolean pinVerify(int pin, int id) throws AccountNotFoundException;
	
	void depositAmt(int id, double amt, Account ob);
	
	void tranAmt(Account src,Account des, double amt);
	
	void changePin(int id, int newPin, Account ob);
	
	double checkBal(int id, Account ob);

	
}
