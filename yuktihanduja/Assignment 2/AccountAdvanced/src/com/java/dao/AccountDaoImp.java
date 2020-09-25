package com.java.dao;

import com.demo.bean.Account;
import com.demo.exception.AccountNotFoundException;

public class AccountDaoImp implements AccountDao{
	
	static
	{
		acc=new Account[20];
		cnt=0;
	}
	static Account[] acc;
	static int cnt;
	@Override
	public void addAccount(Account a) {
		acc[cnt]=a;
		cnt++;
		
		
	}
	@Override
	public Account SearchById(int id) throws AccountNotFoundException {
		for(Account a1:acc)
		{
			if(a1!=null)
			{
				if(a1.getId()==id)
				{
					return a1;
				}
			}
		}
		throw new AccountNotFoundException("Account not found");
	}
	@Override
	public Account[] DisplayAccounts() {
		return acc;
	}
}
