package com.demo.dao;



import com.demo.bean.*;
import com.demo.exception.AccountNotFoundException;
import com.demo.exception.InvalidAmountException;

public  class AccountDaoImpl implements AccountDao {
	
	static Account[] acc;
	static int cnt; 
	static {
		      acc=new Account[20];
		      cnt=0;
		
	       }
	//add account
	@Override
	public void addAccount(Account account) {
		acc[cnt] = account;
		cnt=cnt+1;
		//System.out.println(cnt);
	}
	
	//Search account by id
	@Override
	public Account searchById(int id) throws AccountNotFoundException  {
		
		for ( int i = 0; i < cnt; i++) 
		{
			if(acc[i].getAccId() == id) 
			{
				return acc[i];
			}
		}
		throw new AccountNotFoundException("Account with id : " + id + " not Found!");
	}

	//Deposite Amount 
	@Override
	public int depositAmt(Account acc, double amount) throws InvalidAmountException {
			acc.deposite(amount);
			return 1;
			
	}
	
	//Withdraw Amount
	@Override
	public int withdrawAmt(Account acc, double amount, int pin) {
		 acc.withdraw(amount);
		return 1;
		
	}
	
	
	//Display balance
	@Override
	public double displayBalance(Account acc) {
		
			return acc.getAccbalance();
		
	}

	//change pin
	@Override
	public int changePin(Account acc, int pin, int pin1) {
		// TODO Auto-generated method stub
		 acc.setPin(pin1);
		return 1;
		
		
	}

	//Transfer Account
	@Override
	public void transferAmount(Account targetAcc, double amount) {
		targetAcc.setAccBalance(targetAcc.getAccbalance() + amount);
	}
	
    
		

	
	}
