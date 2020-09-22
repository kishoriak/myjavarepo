package com.demo.service;

import java.util.Date;
import java.util.Scanner;

import com.demo.bean.Account;
import com.demo.bean.Current;
import com.demo.bean.Savings;
import com.demo.dao.AccountDao;
import com.demo.dao.AccountDaoImp;
import com.demo.exception.AccountNotFoundException;

public class AccServiceImp implements AccService {
	static {
		sc = new Scanner(System.in);
	}
	static Scanner sc;
	private AccountDao accDao;
	
	public AccServiceImp() {
		this.accDao = new AccountDaoImp();
	}
	
	@Override
	public void acceptAccData(String type) {
		Account acc = null;
		System.out.println("Enter account holder's name: ");
		String name = sc.next();
		System.out.println("enter the pin");
		int pin = sc.nextInt();
		System.out.println("enter the cheque book number");
		int chqBn = sc.nextInt();
		System.out.println("Enter balance: ");
		double bal = sc.nextDouble();
		Date dOp = new Date();
		if (type.equals("sav")) {
			acc = new Savings(name, pin, dOp, bal, type, chqBn);
			accDao.acceptData(acc);
		} else {
			acc = new Current(name, pin, dOp, bal, type);
			accDao.acceptData(acc);
		}
	}

	@Override
	public boolean pinVerify(int pin, int id) {
		// TODO Auto-generated method stub
		try {
			return accDao.pinVerify(pin, id);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	@Override
	public Account searchById(int id) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		return accDao.searchById(id);
	}
	
	@Override
	public void withdrawAmt(int id, double amt) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		Account a = accDao.searchById(id);
		if(a!=null) {
			a.withdraw(amt);
		}
		
	}

	@Override
	public void depositAmt(int id, double amt) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		Account a = accDao.searchById(id);
		if(a!=null) {
			accDao.depositAmt(id, amt, a);
		}
		
	}

	@Override
	public void tranAmt(int id, int id2, double amt) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		Account a1 = accDao.searchById(id);
		Account a2 = accDao.searchById(id2);
		if(a1!=null && a2 != null) {
			accDao.tranAmt(a1, a2, amt);
		}
	}

	@Override
	public void changePin(int id, int newPin) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		Account a = accDao.searchById(id);
		if(a!=null) {
			accDao.changePin(id, newPin, a);
		}
	}

	@Override
	public double checkBal(int id) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		Account a = accDao.searchById(id);
		if(a!=null) {
			return accDao.checkBal(id, a);
		}else {
			return 0.0;
		}
		
	}

	@Override
	public Account dispById(int id) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		Account a = accDao.searchById(id);
		return a;
	}

	

}
