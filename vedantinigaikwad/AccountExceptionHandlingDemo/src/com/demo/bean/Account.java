package com.demo.bean;

public class Account {

	private int perId;
	private String perName;
	private double accBal;
	private int pinNumber;
	private String accType;
	private final static int branchCode;
	private static int cnt;
	
	static {
		cnt=0;
		branchCode=123450;
	}
	
	//Default constructor
		public Account() {
			perId=0;
			perName=null;
			accBal=0.0;
			pinNumber=0;
			accType=null;
		}
	
	//Parameterized constructor
	public Account(int id, String name, double bal, int pin, String type) {
		this.perId = id;
		this.perName = name;
		this.accBal = bal;
		this.pinNumber = pin;
		this.accType=type;
	}

	public static int assignId() {
		int id=branchCode+cnt;
		cnt++;
		return id;
	}

	
	
	public int getPerId() {
		return perId;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public double getAccBal() {
		return accBal;
	}

	public void setAccBal(double accBal) {
		this.accBal = accBal;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	
	public String getAccType() {
		return accType;
	}

	public void setAccType(String type) {
		this.accType = type;
	}
	

	@Override
	public String toString() {
		return " perId= " + perId + "\n perName= " + perName + "\n accBal= " + accBal + "\n pinNumber= " + pinNumber + "\n Type: "+accType;
	}

	public boolean transferFunds(Account[] arr, int pos1, int pos2, double trans) {
		return false;
	}

	public boolean changePinNum(Account[] aarr, int pos, int pin1, int pin2) {
		
		if(aarr[pos].getPinNumber()==pin1) {
			aarr[pos].setPinNumber(pin2);
			return true;
		}
		else {
			System.out.println("Incorrect pin");
			return false;
		}
	}

	public boolean accountDeposit(Account[] aarr, int pos, double dep) {
		
		aarr[pos].setAccBal(aarr[pos].getAccBal()+dep);
		return true;
	}
	
	
	
}
