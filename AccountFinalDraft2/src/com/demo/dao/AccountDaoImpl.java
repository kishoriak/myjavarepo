package com.demo.dao;
import com.demo.exception.*;

import java.util.HashSet;
import java.util.Set;

import com.demo.bean.Account;
import com.demo.exception.*;

public class AccountDaoImpl implements AccountDao {
	static Set<Account> aset;
	static {
		aset=new HashSet<>();
	}
	
	//Create new account
	@Override 
	public void newAccount(Account a) {
		aset.add(a);
	}


	//searches for the id
	@Override 
	public Account searchId(String id) {
		for(Account a:aset) {
			if(a.getAcNo().equals(id) ){
				return a;
			}
	}
		return null;
	}
	// calls withdraw from either savings or current account
	@Override 
	public void withdraw(Account a,Double amt) throws InsufficientBalanceException {
		a.withdraw(amt);
	}
	
	// calls deposit from account
	@Override 
	public void deposit(Account a,double amt) {
		a.deposit(amt);
	}
	
	//Displays all the Account Details
	@Override
	public Set<Account> displayAll() {
		return aset;
	}

		
}
