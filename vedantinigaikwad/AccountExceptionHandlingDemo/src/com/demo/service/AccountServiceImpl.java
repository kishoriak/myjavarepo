package com.demo.service;

import java.util.Scanner;

import com.demo.bean.Account;
import com.demo.bean.Current;
import com.demo.bean.Saving;
import com.demo.dao.AccountDao;
import com.demo.dao.AccountDaoImpl;
import com.demo.exception.AccountNotFoundException;

public class AccountServiceImpl implements AccountService{

	AccountDao accountDao=new AccountDaoImpl();
	
	@Override
	public void addAccount() {
		Scanner sc=new Scanner(System.in);
		String type;
		Account a;
		
		int id=Account.assignId();
		System.out.println("Your id is: "+id);
		System.out.println("Enter name : ");
		String nm=sc.nextLine();
		System.out.println("Enter balance : ");
		double bal=sc.nextDouble();
		System.out.println("Enter pin : ");
		int pin=sc.nextInt();
		System.out.println("Enter type : (1.Savings/2.Current)");
		int typ=sc.nextInt();
		switch(typ) {
		case 1: 
			//savings account
			type=new String("Saving");
			a=new Saving(id,nm,bal,pin,type);
			accountDao.acceptData(a);
			break;
		case 2: 
			//Current account
			type=new String("Current");
			a=new Current(id,nm,bal,pin,type);
			accountDao.acceptData(a);
		}
		
	}

	@Override
	public Account displayAccount(int id) throws AccountNotFoundException {
		
		
		return accountDao.displayData(id);
		
	}

	@Override
	public boolean withdrawMoney(int id, double wd) throws AccountNotFoundException {
		
		int pos=accountDao.searchById(id);
		if(pos!=-1) {
			return accountDao.withdraw(pos,wd);
		}
		throw new AccountNotFoundException("Invalid Id");
	}

	@Override
	public boolean depositMoney(int id, double dep) throws AccountNotFoundException {
		
		int pos=accountDao.searchById(id);
		if(pos!=-1) {
			return accountDao.deposit(pos,dep);
		}
		throw new AccountNotFoundException("Invalid Id");
		
	}

	@Override
	public boolean transferFunds(int id2, int id4, double trans) throws AccountNotFoundException {
		
		int pos1=accountDao.searchById(id2);
		int pos2=accountDao.searchById(id4);
		if(pos1!=-1 && pos2!=-1) {
			return accountDao.transFunds(pos1, pos2, trans);
		}
		throw new AccountNotFoundException("Invalid Id");
		
		
	}

	@Override
	public double accCheckBalance(int id) throws AccountNotFoundException {
		
		int pos=accountDao.searchById(id);
		if(pos!=-1) {
			return accountDao.checkBalance(pos);
		}
		throw new AccountNotFoundException("Invalid Id");
		
	}

	@Override
	public boolean changePin(int id, int pin1, int pin2) throws AccountNotFoundException {
		
		int pos=accountDao.searchById(id);
		if(pos!=-1) {
			return accountDao.changePinNumber(pos,pin1,pin2);
		}
		throw new AccountNotFoundException("Invalid Id");
	}

	@Override
	public double calculateSimpleInterest(int id) throws AccountNotFoundException {
		
		int pos=accountDao.searchById(id);
		
		if(pos!=-1) {
			return accountDao.calSimpInterest(pos);
		}
		throw new AccountNotFoundException("Invalid Id");
		
		
	}

}
