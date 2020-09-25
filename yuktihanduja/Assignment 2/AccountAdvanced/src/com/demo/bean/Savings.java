package com.demo.bean;

//parent class Account, child class: Savings
public class Savings extends Account {
	
	private int chequebookno;
	private final static Double interestrate=4.0;
	private Double interestamt;
	//Default Constructor
	public Savings()
	{
		chequebookno=0;
		interestamt=0.0;
	}
	//Parameterized Constructor
	public Savings(int id,Double Balance,String accHolderName,Double pin,int chequebookno)
	{
		super(id,Balance, accHolderName, pin);
		this.chequebookno=chequebookno;
		Interest();
		
	}
	//Formula to calculate interest
	public void Interest()
	{
		if(Balance>5000)
		{
			interestamt=Balance*interestrate+((0.02)*Balance);
		}
		else
		{
			System.out.println("Insufficient balance,minimum amount is 5000");
		}
	}
	//Display function overriden from the parent class
	public String toString()
	{
		return super.toString()+"chequebookno"+chequebookno+"Interest Rate :"+interestamt;
	}


}
