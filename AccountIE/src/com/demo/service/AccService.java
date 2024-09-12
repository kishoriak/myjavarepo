package com.demo.service;

import com.demo.bean.Account;
import com.demo.exception.AccountNotFoundException;

public interface AccService {

	 void acceptAccData(String schoice);
	 
	 Account searchById(int id) throws AccountNotFoundException;

	 boolean pinVerify(int pin, int id);
	
	 void withdrawAmt(int id, double amt) throws AccountNotFoundException;

	 void depositAmt(int id, double amt) throws AccountNotFoundException;

	 void tranAmt(int id, int id2, double amt) throws AccountNotFoundException;

	 void changePin(int id, int newPin) throws AccountNotFoundException;

	 double checkBal(int id) throws AccountNotFoundException;

	Account dispById(int id) throws AccountNotFoundException;

}
