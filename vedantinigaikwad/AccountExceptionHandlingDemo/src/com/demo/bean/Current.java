package com.demo.bean;

public class Current extends Account{

	private final static float irCurrent;
	private final static int numTrans;
	
	static {
		irCurrent=1.1f;
		numTrans=3;
	}

	public Current() {
		super();
	}
	
	public Current(int id, String name, double bal, int pin, String type) {
		super(id,name,bal,pin,type);
	}
	
	@Override
	public boolean transferFunds(Account arr[], int pos1, int pos2, double trans) {
		
		if(arr[pos1].getAccBal()>=trans) {
			arr[pos1].setAccBal(arr[pos1].getAccBal()-trans);
			arr[pos2].setAccBal(arr[pos2].getAccBal()+trans);
			return true;
		}
		System.out.println("Insufficient balance");
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n Interest rate: "+irCurrent+"\n No. of  Transactions : "+numTrans;
	}

	public boolean currentWithdraw(Account[] aarr,int pos, double wd) {
		
		if (aarr[pos].getAccBal() >= wd) {
			aarr[pos].setAccBal(aarr[pos].getAccBal() - wd);
			return true;
		} else {
			System.out.println("Insufficient balance");
			return false;
		}
		
	}

	public double currentSimpleInterest(Account[] aarr, int pos) {
		
		return aarr[pos].getAccBal()*irCurrent;
	}
	
	
	
}
