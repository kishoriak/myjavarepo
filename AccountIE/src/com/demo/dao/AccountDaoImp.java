package com.demo.dao;

import com.demo.bean.Account;
import com.demo.exception.AccountNotFoundException;

public class AccountDaoImp implements AccountDao {
	static {
		acc = new Account[10];
		cnt = 0;
	}

	static Account[] acc;
	static int cnt;

	@Override
	public void acceptData(Account a) {
		// TODO Auto-generated method stub
		acc[cnt] = a;
		cnt++;
	}

	@Override
	public Account searchById(int id) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		for (Account a : acc) {
			if(a!=null) {
				if (a.getId() == id) {
					return a;
				}
			}else {
				break;
			}
			
		}
		throw new AccountNotFoundException ("Account not found");
	}

	@Override
	public boolean pinVerify(int pin, int id) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		Account a = searchById(id);
		if (a != null) {
			if (pin == a.getPin()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void depositAmt(int id, double amt, Account ob) {
		// TODO Auto-generated method stub
		ob.deposit(amt);

	}

	@Override
	public void tranAmt(Account src, Account des, double amt) {
		// TODO Auto-generated method stub
		src.setBal(src.getBal() - amt);
		des.setBal(des.getBal() + amt);
	}

	@Override
	public void changePin(int id, int newPin, Account ob) {
		// TODO Auto-generated method stub
		ob.setPin(newPin);

	}

	@Override
	public double checkBal(int id, Account ob) {
		// TODO Auto-generated method stub
		return ob.getBal();
	}

}
