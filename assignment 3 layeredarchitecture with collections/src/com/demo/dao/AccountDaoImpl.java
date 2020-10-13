package com.demo.dao;

import com.demo.bean.Account;
import com.demo.exception.InsufficientBalanceException;
import com.demo.exception.UserNotFoundException;

public class AccountDaoImpl implements AccountDao{
	static Account[] acc;
	static int count;
	static {
		acc=new Account[10];
		count=0;
	}
	
	@Override
	public void acceptAccount(Account a) {
		acc[count]=a;
		count++;
		
	}

	@Override
	public Account searchById(String id) throws UserNotFoundException {
		for(Account a:acc) {
			if(a!=null) {
				//System.out.println("OBJ found");
				if(a.getAccId().equals(id)) {
					//System.out.println("id found");
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
	public Account[] displayAll() {
		
		return acc;
	}

}
