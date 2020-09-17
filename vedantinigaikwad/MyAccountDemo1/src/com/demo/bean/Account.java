package com.demo.bean;

import java.util.Date;

public class Account {
	
	private int perId;
	private String perName;
	private Date oDate;
	private String aType;
	private double aBalance;
	private static int cnt;
	private static int branchCode;
	
	static {
		cnt=0;
		branchCode=123450;
	}
	
	//Default constructor
	public Account() {
		perId=0;
		perName=null;
		oDate = null;
		aType=null;
		aBalance=0.0;
		
	}

	//Parameterized constructor
	public Account(int perId, String perName, Date oDate, String aType, double aBalance) {
		this.perId = perId;
		this.perName = perName;
		this.oDate = oDate;
		this.aType = aType;
		this.aBalance = aBalance;
	}

	//id Assignment
	
	public static int assignId() {
		int id=0;
		id=branchCode+cnt;
		cnt++;
		return id;
	}
	
	//setter and getter methods
	
	public int getPerId() {
		return perId;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public Date getoDate() {
		return oDate;
	}

	public void setoDate(Date oDate) {
		this.oDate = oDate;
	}

	public String getaType() {
		return aType;
	}

	public void setaType(String aType) {
		this.aType = aType;
	}

	public double getaBalance() {
		return aBalance;
	}

	public void setaBalance(double aBalance) {
		this.aBalance = aBalance;
	}

	@Override
	public String toString() {
		return "Account [perId=" + perId + ", perName=" + perName + ", oDate=" + oDate + ", aType=" + aType
				+ ", aBalance=" + aBalance + "]";
	}

	public static void withdraw(Account[] arr,int pos, double bal, double wd) {
		
		if(arr[pos].getaType().equals("savings")) {
			if(bal-10000>=wd) {
				arr[pos].aBalance = bal - wd;
				System.out.println("Account balance : "+arr[pos].aBalance);
				System.out.println("Transaction Successful");
			}
			else {
				System.out.println("Insufficient balance");
			}
		}
		else {
			if(bal>=wd) {
				arr[pos].aBalance = bal - wd;
				System.out.println("Account balance : "+arr[pos].aBalance);
				System.out.println("Transaction Successful");
			}
			else {
				System.out.println("Insufficient balance");
			}
		}
		
	}

	public static void deposit(Account[] arr, int pos, double bal, double dep) {
		
		arr[pos].aBalance=bal+dep;
		System.out.println("Account balance : "+arr[pos].aBalance);
		System.out.println("Transaction Successful");
		
	}
	
	
	
}
