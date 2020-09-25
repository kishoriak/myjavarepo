package com.demo.bean;

abstract public class Account {

	private int id;
	private String accHolderName;
	private Double pin;
	protected Double Balance;
	private Double interestRate;
	//Default Constructor
	public Account()
	{
		id=0;
		accHolderName=null;
		Balance=0.0;
		pin=0.0;
		interestRate=0.0;
	
	}
	//Parameterizer constructor
	public Account(int id,Double Balance,String accHolderName,Double pin)
	{
		this.id=id;
		this.Balance=Balance;
		this.accHolderName =accHolderName;
		this.pin=pin;
		
	}
	//Setter Getter methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public Double getPin() {
		return pin;
	}
	public void setPin(Double pin) {
		this.pin = pin;
	}
	public Double getBalance() {
		return Balance;
	}
	public void setBalance(Double balance) {
		Balance = balance;
	}
	public Double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	public String toString()
	{
		return "id: "+id+"\nBalance :"+Balance+"\nAccount Holder Name:"+accHolderName+"\npin:"+pin;
	}
	//abstract method from child classes
	abstract public void Interest();
	//Withdraw money from function
	public boolean Withdraw(Double amt) {
		if(amt<Balance)
		{
			Balance-=amt;
			return true;
		}
		return false;
		
	}
	//Deposit money function
	public boolean Deposit(Double amt)
	{
		
		Balance=Balance+amt;
		return true;
	}
}
