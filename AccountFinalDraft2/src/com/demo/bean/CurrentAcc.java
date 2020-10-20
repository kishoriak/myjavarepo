package com.demo.bean;
import com.demo.exception.*;
import java.util.Date;
import java.util.Scanner;
import com.demo.service.AccountService;

public class CurrentAcc extends Account {
	

	public static Scanner sc=new Scanner(System.in);
	static {
		iR=0.2;
	}

	public static double iR;
	private int noOfTrans;
	private final int maxTrans=3;
	
	//default Constructor
	public CurrentAcc() {
		noOfTrans=0;
	}

	public CurrentAcc(String aName,int pin, double bal, String accType) {
		super(aName,pin,bal,accType);
		noOfTrans=0;
	}
//setter getter to get number of transactions over
	public int getNoOfTrans() {
		return noOfTrans;
	}

	public void setNoOfTrans(int noOfTrans) {
		this.noOfTrans = noOfTrans;
	}

	public int withdraw(double amt) throws InsufficientBalanceException{
		if((getBalance())>=amt) {
			setBalance(getBalance()-amt);
			System.out.println("Successfully withdrawn from current a/c");
			++noOfTrans;
			return 1;
		}
		else 
			throw new InsufficientBalanceException("Insufficient Balance");
		
	}

	public double interestCal() {
		return getBalance()*iR;
	}
	
	public String toString() {
		return super.toString()+"\nInterest Rate: "+iR+"\nNo of Transactions.: "+this.noOfTrans+"\nTotal interest Calculated: "+interestCal();
	}

}

	
