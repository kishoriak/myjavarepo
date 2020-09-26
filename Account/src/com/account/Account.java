package com.account;
import java.util.Date;

public class Account {
	
	private int id;
	private String Name;
	private Date dateOfJoining;
	private String accType;
	private long balance;
	private static int cnt = 0;
	
	//Parameterized constructor
	public Account(String name, Date dateOfJoining, String accType, long balance) {
		this.id = cnt++;
		this.Name = name;
		this.dateOfJoining = dateOfJoining;
		this.accType = accType;
		this.balance = balance;
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	//withdraw amount from account
	public String withdrawAmt(long amt) {
		if((this.balance + 1000) >= amt) {
			this.balance -= amt;
			return "Amount withdrawn successfully";
		}
		return "Not Sufficient Account Balance";
	}
	
	//deposit amount to account
	public String depositAmt(long amt) {
		this.balance += amt;
		return "Amount deposited successfully";
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", Name=" + Name + ", dateOfJoining=" + dateOfJoining + ", accType=" + accType
				+ ", balance=" + balance + "]";
	}
}
