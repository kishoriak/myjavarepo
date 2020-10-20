package com.demo.bean;
import java.util.Scanner;
import com.demo.exception.*;

public class SavingsAcc extends Account {
	
	public static Scanner sc=new Scanner(System.in);
	static {
		iR=4;
	}
	public static double iR;
	private String cheqbNo;
	
	public SavingsAcc() {
		super();
	}

	public SavingsAcc(String aName,int pin, double bal ,String accType) {
		super(aName,pin,bal,accType);
			this.cheqbNo = acNo;
	}

	//withdraw from account
		public int withdraw(double amt) throws InsufficientBalanceException {
			if((getBalance()-10000)>=amt) {
				setBalance(getBalance()-amt);
				System.out.println("Withdrawn Successful(savings a/c).....");
				return 1;
			}
			else 
				throw new InsufficientBalanceException("Insufficient Balance.....");
			
	
		}
		
	//calculate interest
	public double interestCal() {
		if(getBalance()>50000) {
			return (getBalance()*iR)+(getBalance()*0.02);
			}
		else {
				return getBalance()*iR;
			}
	}
	
	public String toString() {
		return super.toString()+"\nInterest Rate: "+iR+"\nCheque No.: "
				+cheqbNo+"\nTotal Interest Calculated: "+interestCal();
}
}

