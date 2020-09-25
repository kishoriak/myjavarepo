package com.demo.dao;

import java.util.HashSet;
import java.util.Set;

import com.demo.bean.Account;
import com.demo.exception.InsufficientBalanceException;
import com.demo.exception.UserNotFoundException;

public class AccountDaoImpl implements AccountDao{

	static Set<Account> accset;

	static {
		accset=new HashSet<>();
	}
	
	//to add an account
	@Override
	public void acceptAccount(Account acc) {
		accset.add(acc); //calls hashcode()-->equals(), to check if new acc id already exists
	}
	
	//to search for an account by id
	@Override
	public Account searchById(String id) throws UserNotFoundException {
		for(Account acc:accset) {
			if(acc!=null) {
				//System.out.println("OBJ found");
				if(acc.getAccId().equals(id)) {
					//System.out.println("id found");
					return acc;
				}
			}
			else {
				throw new UserNotFoundException("user not found");
			}
		}
		return null;
	}
	
	//to withdraw from an account
	@Override
	public void withdrawal(Account acc,Double amt) throws InsufficientBalanceException {
		acc.withdrawal(amt);
		
	}

	//fetches all accounts
	@Override
	public Set<Account> getAllAccounts() {
		return accset;
	}

}
