package com.demo.bean;

public class Saving extends Account {

	private final static float irSaving;
	private int chkBookNum;
	private static final int code;
	
	static {
		irSaving=4.4f;
		code =12300000;
	}
	
	public Saving() {
		super();
	}
	
	public Saving(int id,String name,double bal, int pin, String type )
	{
		super(id,name,bal,pin, type);
	}
	
	
	
	public static int assignChkBookNum() {
		return code+12345;
	}
	
	@Override
	public boolean transferFunds(Account[] arr, int pos1, int pos2, double trans) {
		
		if(arr[pos1].getAccBal()-10000>=trans) {
			arr[pos1].setAccBal(arr[pos1].getAccBal()-trans);
			arr[pos2].setAccBal(arr[pos2].getAccBal()+trans);
			return true;
		}
		System.out.println("Insufficient balance");
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + "\n Interest rate: "+irSaving+ "\n chkBookNum=" + Saving.assignChkBookNum();
	}

	public boolean savingsWithdraw(Account[] aarr,int pos, double wd) {
		
		if (aarr[pos].getAccBal() - 10000 >= wd) {
			aarr[pos].setAccBal(aarr[pos].getAccBal() - wd);
			return true;
		} else {
			System.out.println("Insufficient balance");
			return false;
		}
		
	}

	public double savingsSimpleInterest(Account[] aarr, int pos) {
		
		if(aarr[pos].getAccBal()>=50000) {
		return aarr[pos].getAccBal()*irSaving*(0.02*aarr[pos].getAccBal());
		}
		else {
			return aarr[pos].getAccBal()*irSaving;
		}
	}
	
	
	
}
