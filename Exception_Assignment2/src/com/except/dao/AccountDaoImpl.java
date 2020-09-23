package com.except.dao;

import com.except.bean.Account;
import com.except.exception.AccountNotFoundException;
import com.except.exception.InsufficientBalanceException;

public class AccountDaoImpl implements AccountDao{

	static Account[] a = null;
	static int cnt;
	
	static {
		a = new Account[3];
		cnt=0;
	}
	
	@Override
	public boolean createNewAccount(Account ob) {
		
		if(cnt<a.length) {
			a[cnt] = ob;
			cnt++;
			return true;
		}
		else
			return false;
	}
	@Override
	public Account searchById(int id) throws AccountNotFoundException{

		for(Account a1 : a) {
			if(a1!=null) {
				if(a1.getAccId()==id)
					return a1;
			}
			else 
				throw new AccountNotFoundException("Account not found");
		}
		return null;
	}
	@Override
	public boolean withdrawal(Account ob, double amt) throws InsufficientBalanceException {
		
		boolean res = ob.withdrawal(amt);
		if(res == true)
			return true;
		else
			throw new InsufficientBalanceException("Insufficient Balance");
	}
	@Override
	public void deposit(Account ob, double amt) {
		
		ob.deposit(amt);
	}
	@Override
	public boolean validatePin(Account ob, int pin) {
		
		if(ob.getPin()==pin)
			return true;
		return false;
	}
	@Override
	public void changePin(Account ob, int pin) {
		
		ob.setPin(pin);
	}
	@Override
	public double checkBalance(Account ob) {
		
		return ob.getBalance();
	}
	@Override
	public void display(Account ob) {
		
		ob.toString();
	}
}
