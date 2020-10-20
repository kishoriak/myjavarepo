package com.collect.dao;

import java.util.ArrayList;

import com.collect.bean.Account;
import com.collect.bean.CurrentAcc;
import com.collect.bean.SavingsAcc;
import com.collect.exception.AccountNotFoundException;
import com.collect.exception.InsufficientBalanceException;

public class AccountDaoImpl implements AccountDao{

	ArrayList<Account> Accounts = new ArrayList<>();

	@Override
	public boolean createNewAccount(Account ob) {
		
		Accounts.add(ob);
		return true;
	}
	@Override
	public Account searchById(String id) throws AccountNotFoundException{

//		for(Account a1 : Accounts) {
//			if(a1!=null) {
//				if(a1.getAccId()==id)
//					return a1;
//			}
//			else 
//				throw new AccountNotFoundException("Account not found");
//		}
//		return null;
		Account acc = null;
		if(id.startsWith("S")) {
			acc = new SavingsAcc(id);
		}
		else if(id.startsWith("C"))
			acc = new CurrentAcc(id);
		int pos = Accounts.indexOf(acc);
		if(pos == -1)
			throw new AccountNotFoundException("Account not found");
		else
			return Accounts.get(pos);
		
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
		
//		if(ob.getAccType().equals("Savings"))
//			((SavingsAcc)ob).toString();
//		else if(ob.getAccType().equals("Current"))
//			((CurrentAcc)ob).toString();
		System.out.println(Accounts.get(Accounts.indexOf(ob)));
	}
	@Override
	public void displayAll() {
		
		System.out.println(Accounts);
	}
}