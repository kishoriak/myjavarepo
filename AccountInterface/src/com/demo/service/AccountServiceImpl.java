package com.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.demo.bean.Account;
import com.demo.bean.CurrentAcc;
import com.demo.bean.SavingAcc;
import com.demo.dao.AccountDao;
import com.demo.dao.AccountDaoImpl;
import com.demo.exception.AccountNotFoundException;
import com.demo.exception.InvalidAmountException;

public class AccountServiceImpl implements AccountService {
	
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
	public static Scanner sc =new Scanner(System.in);
	private  AccountDao accountDao;
	
	//Default constructor
	public AccountServiceImpl(){
			this.accountDao = new AccountDaoImpl();
		}
	//accept data for person
	public Account acceptAccountData( int accountType) {
		Account acc=null;
		System.out.println("Enter Name :");
		String name = sc.next();
		System.out.println("Enter Balance :");
		double balance = sc.nextDouble();
		System.out.println("Enter Pin :");
		int pin = sc.nextInt();
		System.out.println("Enter Date :");
		String doj= sc.next();
		try {
			Date dateOfJoining = sdf.parse(doj);
			if(accountType == 1) {
				acc = new SavingAcc(name, dateOfJoining, balance, pin, "Saving");
			}
			else if(accountType == 2) {
				acc = new CurrentAcc(name, dateOfJoining, balance, pin, "Current");
			}
			accountDao.addAccount(acc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
}
	
		
	//Deposit Amount
	@Override
	public  int depositeAmt(int id,double amt) throws InvalidAmountException, AccountNotFoundException 
	{
		Account acc = searchById(id);
		if(acc != null) {
			return accountDao.depositAmt(acc, amt);
		}
		return 1;

		
	}
	//withdraw amount
	
	
	@Override
	public  int withdrawAmt(int id, double amount, int pin) throws AccountNotFoundException {
		Account acc = accountDao.searchById(id);
		if(acc != null && acc.getPin() == pin) {
			return accountDao.withdrawAmt(acc, amount, pin);
		}
		return -1;
	}

	//Change Pin
	@Override
	public  int changePin(int id,int pin,int pin1) throws AccountNotFoundException 
	{
		Account acc = searchById(id);
		if(acc != null && acc.getPin() == pin) {
			return accountDao.changePin(acc, pin, pin1);
			
		}
		return -1;		
	}
	
	
	//Display Balance
	@Override
	public  double displayBalance(int id) throws AccountNotFoundException 
	{     
		Account acc = searchById(id);
		 if(acc != null) {
			 return accountDao.displayBalance(acc);
			}
		 return -1;
	}
	
    
	//Search By Name
	
	@Override
	public  Account searchById(int id) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		return accountDao.searchById(id);
		
	}
	
	//Transfer Amount
	@Override
	public int transferAmount(int sourceId, int targetId, int pin, double amount) throws AccountNotFoundException {
		Account sourceAcc =searchById(sourceId);
		if(sourceAcc != null) {
			int result = accountDao.withdrawAmt(sourceAcc, amount, pin);
			if(result != -1) {
				Account targetAcc = searchById(targetId);
				if(targetAcc != null) {
					accountDao.transferAmount(targetAcc, amount);
					return 1;
				}
			}
		}
		return -1;
	}

	
	
	
	}
