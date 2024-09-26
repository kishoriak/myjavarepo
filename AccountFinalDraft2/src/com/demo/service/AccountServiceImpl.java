package com.demo.service;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import com.demo.bean.*;
import com.demo.dao.*;
import com.demo.exception.*;

import java.text.SimpleDateFormat;

public class AccountServiceImpl implements AccountService{
	static {
		sc=new Scanner(System.in);
		sdf=new SimpleDateFormat("dd/MM/yyyy");
	}
	static Scanner sc;
	public static SimpleDateFormat sdf;
	private AccountDao accountDao;
	public AccountServiceImpl() {
		this.accountDao=new AccountDaoImpl();
	}


	//to create an account based on type---overridden
	@Override
	public void acceptAccountData() throws LimitExceedException {
		Account a=null;
		System.out.println("Enter name");
		String nm=sc.next();
		System.out.println("Enter balance");
		double bal=sc.nextDouble();
		System.out.println("Enter pin");
		int pin=sc.nextInt();
		
		
		//to give 3 chances to enter a/c Type
		int i=0;
		for(;i<3;i++) {
			try {
				System.out.println("Type of account: SAVINGS || CURRENT ?");
				String type=sc.next();
				if((type.toLowerCase()).equals("savings")) {
					a=new SavingsAcc(nm,pin,bal,type);
					accountDao.newAccount(a);
					break;
				}
					
				else if((type.toLowerCase()).equals("current")) {
					a=new CurrentAcc(nm,pin,bal,type);
					accountDao.newAccount(a);
					break;
				}
				else {
					throw new InvalidAccTypeException("Please Enter Valid Acc Type.....");
				}
				//System.out.println(accountDao.searchById(a.getAccId()));
			}	catch(InvalidAccTypeException e1) {
					System.out.println(e1.getMessage());
					if(i==2) {
						throw new LimitExceedException("No.of attempts exceeded. Contact IT Desk.....");
					}
			}	catch (Exception e) {
					e.printStackTrace();
			}
		}
		System.out.println("Account Created Succesfully.....");
	}
	
	//to withdraw from an account based on account id
	@Override
	public void withdraw(String id, Double amt) throws InsufficientBalanceException, UserNotFoundException {
		Account a=accountDao.searchId(id);
		if(a!=null) {
				accountDao.withdraw(a,amt);
			}
		else {
			throw new UserNotFoundException("USER NOT FOUND.....");
		}
		
	}
	
	//to deposit to an account based on account id
	@Override
	public void deposit(String id,Double depositAmt) throws UserNotFoundException {
		Account a=accountDao.searchId(id);
		if(a!=null) {
			a.deposit(depositAmt);		
			if(a instanceof CurrentAcc)
				((CurrentAcc)a).setNoOfTrans(((CurrentAcc)a).getNoOfTrans()+1);
			}
		else
			throw new UserNotFoundException("USER NOT FOUND.....");

	}
	
	//to display data for an account by id
	@Override
	public void displayAccount(String id) throws UserNotFoundException {
			System.out.println(accountDao.searchId(id));
	}
	
	//to transfer amount from sourceId to targetId
	@Override
	public void transfer(String id1,double amt) throws InsufficientBalanceException, UserNotFoundException {
	
		Account a1=accountDao.searchId(id1);
		if(a1!=null) {
			System.out.println("Enter target account id");
			String id2=sc.next();
			Account a2=accountDao.searchId(id2);
			if(a2!=null) {
				accountDao.withdraw(a1,amt);
				a2.deposit(amt);
			}
			else
				throw new UserNotFoundException("USER NOT FOUND.....");
		}
		else {
			throw new UserNotFoundException("USER NOT FOUND.....");
		}
	}
	
	
	//to change pin and verify user using old pin
	@Override
	public void changePin(String id) throws UserNotFoundException, LimitExceedException {
		Account a=accountDao.searchId(id);
		if(a!=null) {
			//to give 3 chances to enter old pin
			for(int i=0;i<3;i++) {
				try {
					System.out.println("Enter Previous PIN.....");
					int pin=sc.nextInt();
					if(a.getPin()==pin) {
						System.out.println("Enter New PIN to be Changed.....");
						int nPin=sc.nextInt();
						a.setPin(nPin);
						System.out.println("PIN Changed Successfully!.....");
						break;
						}
					else {
						throw new PinMismatchException("Enter PIN Again.....");
					}
				} catch (PinMismatchException | InputMismatchException e) {
					System.out.println(e.getMessage());
					if(i==2) {
						throw new LimitExceedException("No.of attempts exceeded. Contact IT Desk.....");
					}
				}
			}
			
		}
		else
			throw new UserNotFoundException("USER NOT FOUND.....");
	}
	
	//to display data for all accounts
	public void displayAllAccounts() {
		
		Set<Account> all=accountDao.displayAll();
		for(Account a:all) {
			System.out.println(a);
		}
		
	}


}
