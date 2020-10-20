package com.collect.bean;

import java.util.Date;

import com.collect.exception.InsufficientBalanceException;

public class SavingsAcc extends Account {
	private long chequeBookNo;
	
	//default constructor
	public SavingsAcc() {
		chequeBookNo = 0;
	}
	//parameterized constructor
	public SavingsAcc(String id, String nm, Date dt, String type, double bal, int pin, long chequeBkNo) {
		super(id,nm,dt,type,bal,pin);
		this.chequeBookNo = chequeBkNo;
		calInterest();
	}
	//additional constructor for searchById
	public SavingsAcc(String id) {
		
		super(id);
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
