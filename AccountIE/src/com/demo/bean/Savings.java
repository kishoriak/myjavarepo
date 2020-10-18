package com.demo.bean;

import java.util.Date;

public class Savings extends Account {

	private int cheqBn;
	private float intRate = 3.5f;

	// default constructor
	public Savings() {
		cheqBn = 0;
	}

	// Parameterized constructor
	public Savings(String pName, int pin, Date dOp, double bal, String aType, int cheqBn) {
		super(pName, pin, dOp, bal, aType);
		this.cheqBn = cheqBn;
	}

	// calculate interest
	public double interest(double bal) {
		if (bal > 50000) {
			return bal * intRate + 0.02 * bal;
		} else {
			return bal * intRate;
		}
	}

	// function for withdraw operation
	public void withdraw(double amt) {
		if (balance - 10000 >= amt) {
			balance = balance - amt;
		} else {
			System.out.println("Less balance");
		}
	}

	public String toString() {
		return super.toString() + "\ncheque book number: " + cheqBn;
	}
}
