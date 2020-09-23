package com.except.bean;

import java.util.Date;

import com.except.exception.InsufficientBalanceException;

public class SavingsAcc extends Account {
	private long chequeBookNo;
	
	//default constructor
	public SavingsAcc() {
		chequeBookNo = 0;
	}
	//parameterized constructor
	public SavingsAcc(String nm, Date dt, String type, double bal, int pin, long chequeBkNo) {
		super(nm,dt,type,bal,pin);
		this.chequeBookNo = chequeBkNo;
		calInterest();
	}
	//setter and getter methods
	public void setChequeBookNo(long chequeBkNo) {
		this.chequeBookNo = chequeBkNo;
	}
	public long getChequeBookNo() {
		return this.chequeBookNo;
	}
	@Override
	public String toString() {
		return super.toString()+"\nCheque Book No. : "+chequeBookNo+"\nInterest : "+interest; 
	}
	@Override
	public boolean withdrawal(double amt) throws InsufficientBalanceException {
	
		if(amt <= balance-10000) {
			balance-=amt;
			return true;
			//System.out.println("Withdrawal Successful!");
			//System.out.println("Balance : "+balance);
		}
		else 
			throw new InsufficientBalanceException("Insufficient Balance");
	}
	@Override
	public void calInterest() {
		
		if(balance > 5000)
		{
			interest = (balance*rate) + (0.02*balance);
		}
		else
			interest = balance*rate;
	}
	
}
