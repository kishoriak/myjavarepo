package com.demo.dao;

import java.util.ArrayList;

import com.demo.bean.Account;
import com.demo.exception.InsufficientBalanceException;
import com.demo.exception.UserNotFoundException;

public class AccountDaoImpl implements AccountDao{
	static ArrayList<Account> acc;
	static int count;
	static {
		acc=new ArrayList<Account>();
		count=0;
	}
	
	@Override
	public void acceptAccount(Account a) {
		acc.add(a);
		
	}

	@Override
	public Account searchById(String id) throws UserNotFoundException {
		for(Account a:acc) {
			if(a!=null) {
			
				if(a.getAccId().equals(id)) {
		
					return a;
				}
			}
			else {
				throw new UserNotFoundException("user not found");
			}
		}
		return null;
	}

	@Override
	public void withdrawal(Account a,Double amt) throws InsufficientBalanceException {
		a.withdrawal(amt);
		
	}

	@Override
	public ArrayList<Account> displayAll() {
		
		return acc;
	}

}
