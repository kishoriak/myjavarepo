package com.except.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.except.bean.Account;
import com.except.bean.CurrentAcc;
import com.except.bean.SavingsAcc;
import com.except.dao.AccountDaoImpl;
import com.except.exception.AccountNotFoundException;
import com.except.exception.InsufficientBalanceException;


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
	public void createAccount(String type) {

			System.out.println("Enter Name");
			String nm = sc.next();
			System.out.println("Enter PIN");
			int pin = sc.nextInt();
			System.out.println("Enter Balance");
			double bal = sc.nextDouble();
			if(type.equals("Savings")) {
				System.out.println("Enter Cheque Book No.");
				long chequeBkNo = sc.nextLong();
				ob = new SavingsAcc(nm, new Date(), type, bal,pin,chequeBkNo);
			}
			else {
				ob = new CurrentAcc(nm, new Date(), type, bal,pin);
			}
			boolean res = AccountDao.createNewAccount(ob);
			if(res==true)
				System.out.println("Account created successfully!");
			else
				System.out.println("Account cannot be created, Sorry!");
	}
	//search an account
	public boolean searchAccount(int id) throws AccountNotFoundException {
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
	public void withdrawAmt(int id, double amt) throws AccountNotFoundException, InsufficientBalanceException {
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
	public void depositAmt(int id, double amt) throws AccountNotFoundException {
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
	public void transfer(int id1,int id2, double amt) throws AccountNotFoundException, InsufficientBalanceException {
		
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
	public boolean checkPin(int id, int pin) throws AccountNotFoundException {
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
	public void changePin(int id, int pin) throws AccountNotFoundException {
		
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
	public void checkBalance(int id) throws AccountNotFoundException {
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
	public void display(int id) throws AccountNotFoundException {
		
		try {
			ob = AccountDao.searchById(id);
		} catch (AccountNotFoundException e) {
			throw new AccountNotFoundException("Account not found");
		}catch(Exception e) {
			e.printStackTrace();
		}
		AccountDao.display(ob);
	}
}