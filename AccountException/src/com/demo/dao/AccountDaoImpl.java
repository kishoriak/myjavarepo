package com.demo.dao;

import com.demo.bean.Account;
import com.demo.exception.InsufficientBalanceException;
import com.demo.exception.UserNotFoundException;

public class AccountDaoImpl implements AccountDao{
	static Account[] acarr;
	static int cnt;
	static {
		acarr=new Account[20];
		cnt=0;
	}
	
	@Override
	public void acceptAccount(Account a) {
		acarr[cnt]=a;
		cnt++;
		
	}

	@Override
	public Account searchById(String id) throws UserNotFoundException {
		for(Account a:acarr) {
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
		
		return acarr;
	}

}
