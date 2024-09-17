package com.collect.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.collect.bean.Account;
import com.collect.bean.CurrentAcc;
import com.collect.bean.SavingsAcc;
import com.collect.dao.AccountDaoImpl;
import com.collect.exception.AccountNotFoundException;
import com.collect.exception.InsufficientBalanceException;


public class AccountServiceImpl implements AccountService{
		
	public static SimpleDateFormat sdf =null;
	public static Scanner sc = null;
	static {
		sc = new Scanner(System.in);
		sdf = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	AccountDaoImpl AccountDao = new AccountDaoImpl();
	Account ob = null;
	//create a new account
	@Override
	public void createAccount(String type) {
			
			System.out.println("Enter ID(Start with S for Savings account and C for Current account)");
			String id = sc.next();
			System.out.println("Enter Name");
			String nm = sc.next();
			System.out.println("Enter PIN");
			int pin = sc.nextInt();
			System.out.println("Enter Balance");
			double bal = sc.nextDouble();
			if(type.equals("Savings")) {
				System.out.println("Enter Cheque Book No.");
				long chequeBkNo = sc.nextLong();
				//id = "S"+id;
				ob = new SavingsAcc(id,nm, new Date(), type, bal,pin,chequeBkNo);
			}
			else {
				//id = "C"+id;
				ob = new CurrentAcc(id,nm, new Date(), type, bal,pin);
			}
			boolean res = AccountDao.createNewAccount(ob);
			if(res==true)
				System.out.println("Account created successfully!");
			else
				System.out.println("Account cannot be created, Sorry!");
	}
	//search an account
	@Override
	public boolean searchAccount(String id) throws AccountNotFoundException {
		try {
			ob = AccountDao.searchById(id);
		} catch (AccountNotFoundException e) {
			throw new AccountNotFoundException("Account not found");
		}catch (Exception e) {
			e.printStackTrace();
		}
//		if(ob == null)
//		else
			return true;
	}
	//withdrawal function
	@Override
	public void withdrawAmt(String id, double amt) throws AccountNotFoundException, InsufficientBalanceException {
		//check if the account exists
		try {
			ob = AccountDao.searchById(id);
		
//		if(ob==null) {
//			System.out.println("Account not found");
//		}
//		else {
			//call withdrawal function of respective class
			boolean res = AccountDao.withdrawal(ob, amt);
			if(res==true)
				System.out.println("Withdrawal Successful!");
		} catch (AccountNotFoundException e) {
			throw new AccountNotFoundException("Account not found");
		}catch (InsufficientBalanceException e) {
			throw new InsufficientBalanceException("Insufficient Balance");
		}catch (Exception e) {
			e.printStackTrace();
		}
//		}
	}
	//deposit function
	@Override
	public void depositAmt(String id, double amt) throws AccountNotFoundException {
		//check if the account exists
		try {
			ob = AccountDao.searchById(id);
		} catch (AccountNotFoundException e) {
			throw new AccountNotFoundException("Account not found");
		}catch(Exception e) {
			e.printStackTrace();
		}
//		if(ob == null) {
//			System.out.println("Account not found");
//		}
//		else {
			//call deposit function of Account class
			AccountDao.deposit(ob, amt);
//		}
	}
	//transfer function
	@Override
	public void transfer(String id1, String id2, double amt) throws AccountNotFoundException, InsufficientBalanceException {
		
		//check if both accounts exist
		boolean res;
		Account ob1=null;
		try {
			ob=AccountDao.searchById(id1);
//		if(ob == null) {
//			System.out.println("Account to transfer from not found");
//			return;
//		}
			ob1=AccountDao.searchById(id2);
		} catch (AccountNotFoundException e) {
			throw new AccountNotFoundException("Account not found");
		}catch(Exception e) {
			e.printStackTrace();
		}
//		if(ob1==null) {
//			System.out.println("Account to be transferred to not found");
//			return;
//		}
		try {
			res = AccountDao.withdrawal(ob,amt);
			if(res==false) {
				System.out.println("Insufficient balance to transfer");
				return;
			}
			else {
				AccountDao.deposit(ob1,amt);
			}
			System.out.println("Transfer Successful!");
		}catch(InsufficientBalanceException e) {
			throw new InsufficientBalanceException("Insufficient Balance");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean checkPin(String id, int pin) throws AccountNotFoundException {
		//check if account exists
		try {
			ob = AccountDao.searchById(id);
		} catch (AccountNotFoundException e) {
			throw new AccountNotFoundException("Account not found");
		}catch(Exception e) {
			e.printStackTrace();
		}
//		if(ob == null) {
//			System.out.println("Account not found");
//			return false;
//		}
//		else{
			boolean valid = AccountDao.validatePin(ob, pin);
			if(valid == false) {
				System.out.println("Incorrect PIN");
				return false;
			}
			else 
				return true;
//		}
	}
	@Override
	public void changePin(String id, int pin) throws AccountNotFoundException {
		
		try {
			ob = AccountDao.searchById(id);
		} catch (AccountNotFoundException e) {
			throw new AccountNotFoundException("Account not found");
		}catch(Exception e) {
			e.printStackTrace();
		}
		AccountDao.changePin(ob, pin);
		System.out.println("PIN updated successfully");
	}
	@Override
	public void checkBalance(String id) throws AccountNotFoundException {
		//check if account exists
		try {
			ob = AccountDao.searchById(id);
		} catch (AccountNotFoundException e) {
			throw new AccountNotFoundException("Account not found");
		}catch(Exception e) {
			e.printStackTrace();
		}
//		if(ob == null) {
//			System.out.println("Account not found");
//			return;
//		}
//		else {
			System.out.println(AccountDao.checkBalance(ob));
//		}
	}
	@Override
	public void display(String id) throws AccountNotFoundException {
		
		try {
			ob = AccountDao.searchById(id);
		} catch (AccountNotFoundException e) {
			throw new AccountNotFoundException("Account not found");
		}catch(Exception e) {
			e.printStackTrace();
		}
		AccountDao.display(ob);
	}
	@Override
	public void displayAll() {
		
		AccountDao.displayAll();
	}
}