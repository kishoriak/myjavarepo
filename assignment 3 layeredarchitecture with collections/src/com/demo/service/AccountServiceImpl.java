package com.demo.service;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.demo.bean.Account;
import com.demo.bean.current;
import com.demo.bean.savings;
import com.demo.dao.AccountDao;
import com.demo.dao.AccountDaoImpl;
import com.demo.exception.InsufficientBalanceException;
import com.demo.exception.InvalidAccTypeException;
import com.demo.exception.LimitExceedException;
import com.demo.exception.PinMismatchException;
import com.demo.exception.UserNotFoundException;

//import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AccountServiceImpl implements AccountService{
	static {
		s=new Scanner(System.in);
	}
	static Scanner s;
	private AccountDao accountDao;
	public AccountServiceImpl() {
		this.accountDao=new AccountDaoImpl();
	}


	//to create an account based on type---overridden
	@Override
	public void acceptAccountData() throws LimitExceedException {
		Account a=null;
		System.out.println("Enter name");
		String name=s.next();
		System.out.println("Enter balance");
		double bal=s.nextDouble();
		System.out.println("Enter pin");
		int pin=s.nextInt();
		
		//3 chances
		int i=0;
		for(;i<3;i++) {
			try {
				System.out.println("Enter type of account: \n 1: savings \n 2: current?");
				int n=s.nextInt();
				if(n==1) {
					a=new savings(name,bal,"Savings",pin);
					accountDao.acceptAccount(a);
					break;
				}
					
				else if(n==2) {
					a=new current(name,bal,"Current",pin);
					accountDao.acceptAccount(a);
					break;
				}
				else {
					throw new InvalidAccTypeException("Please enter valid account type");
				}
	
			}	catch(InvalidAccTypeException e1) {
					System.out.println(e1.getMessage());
					if(i==2) {
						throw new LimitExceedException("no. of attempts exceeded. Contact admin");
					}
			}	catch (Exception e) {
					e.printStackTrace();
			}
		}
		System.out.println("Successfully created");
	}
	
	//withdraw function
	@Override
	public void withdraw(String id, Double amt) throws InsufficientBalanceException, UserNotFoundException {
		Account a=accountDao.searchById(id);
		if(a!=null) {
				accountDao.withdrawal(a,amt);
			}
		else {
			throw new UserNotFoundException("user not found");
		}
		
	}
	
	//deposit function
	@Override
	public void deposit(String id,Double depositAmt) throws UserNotFoundException {
		Account a=accountDao.searchById(id);
		if(a!=null) {
			a.deposition(depositAmt);		
			if(a instanceof current)
				((current)a).setTrans(((current)a).getTrans()+1);
			}
		else
			throw new UserNotFoundException("user not found");

	}
	
	//display data
	@Override
	public void displayAccount(String id) throws UserNotFoundException {
			System.out.println(accountDao.searchById(id));
	}
	
	//amount transfer form one account to other
	@Override
	public void transfer(String idSource,double amt) throws InsufficientBalanceException, UserNotFoundException {
	
		Account a1=accountDao.searchById(idSource);
		if(a1!=null) {
			System.out.println("Enter target account id");
			String idTarget=s.next();
			Account a2=accountDao.searchById(idTarget);
			if(a2!=null) {
				accountDao.withdrawal(a1,amt);
				a2.deposition(amt);
			}
			else
				throw new UserNotFoundException("target user not found");
		}
		else {
			throw new UserNotFoundException("source user not found");
		}
	}
	
	//pin change 
	@Override
	public void changePin(String id) throws UserNotFoundException, LimitExceedException {
		Account a=accountDao.searchById(id);
		if(a!=null) {
			//to give 3 chances to enter old pin
			for(int i=0;i<3;i++) {
				try {
					System.out.println("Enter old pin");
					int pin=s.nextInt();
					if(a.getPin()==pin) {
						System.out.println("Enter new pin");
						int nPin=s.nextInt();
						a.setPin(nPin);
						System.out.println("Pin successfully changed");
						break;
						}
					else {
						throw new PinMismatchException("Enter pin again");
					}
				} catch (PinMismatchException | InputMismatchException e) {
					System.out.println(e.getMessage());
					if(i==2) {
						throw new LimitExceedException("no. of attempts exceeded. Contact admin");
					}
				}
			}
			
		}
		else
			throw new UserNotFoundException("user not found");
	}
	
	//to display data for all accounts
	public void displayAllAccounts() {
		
		Account[] acc=accountDao.displayAll();
		for(Account a:acc) {
			System.out.println(a);
		}
		
	}


}
