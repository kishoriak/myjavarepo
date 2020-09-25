package com.demo.service;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import com.demo.bean.Account;
import com.demo.bean.CurrentAcc;
import com.demo.bean.SavingsAcc;
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
		sc=new Scanner(System.in);
	}
	static Scanner sc; //static because it is being shared by all
	private AccountDao accountDao; // not static because Spring will use it like this...can be static but not used in Spring
	public AccountServiceImpl() {
		this.accountDao=new AccountDaoImpl();
	}


	//to create an account based on type---overridden
	@Override
	public void acceptAccountData() throws LimitExceedException {
		Account a=null;
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter balance");
		double bal=sc.nextDouble();
		System.out.println("Enter pin");
		int pin=sc.nextInt();
		
		//to give 3 chances to enter a/c Type
		int i=0;
		for(;i<3;i++) {
			try {
				System.out.println("Enter type of account: savings or current?");
				String type=sc.next();
				if((type.toLowerCase()).equals("savings")) {
					a=new SavingsAcc(name,bal,type,pin);
					accountDao.acceptAccount(a);
					break;
				}
					
				else if((type.toLowerCase()).equals("current")) {
					a=new CurrentAcc(name,bal,type,pin);
					accountDao.acceptAccount(a);
					break;
				}
				else {
					throw new InvalidAccTypeException("Please enter valid a/c type");
				}
				//System.out.println(accountDao.searchById(a.getAccId()));
			}	catch(InvalidAccTypeException e1) {
					System.out.println(e1.getMessage());
					if(i==2) {
						throw new LimitExceedException("no. of attempts exceeded. Contact admin");
					}
			}	catch (Exception e) {
					e.printStackTrace();
			}
		}
		System.out.println("Successfully a/c created with a/c id: "+a.getAccId());
	}
	
	//to withdraw from an account based on account id
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
	
	//to deposit to an account based on account id
	@Override
	public void deposit(String id,Double depositAmt) throws UserNotFoundException {
		Account a=accountDao.searchById(id);
		if(a!=null) {
			a.deposition(depositAmt);		//not calling Dao class-->directly calling Account method
			if(a instanceof CurrentAcc)
				((CurrentAcc)a).setTrans(((CurrentAcc)a).getTrans()+1); //if it is current account, count it in noOfTransactions
			}
		else
			throw new UserNotFoundException("user not found");

	}
	
	//to display data for an account by id
	@Override
	public void displayAccount(String id) throws UserNotFoundException {
			System.out.println(accountDao.searchById(id));
	}
	
	//to transfer amount from sourceId to targetId
	@Override
	public void transfer(String idSource,double amt) throws InsufficientBalanceException, UserNotFoundException {
	
		Account a1=accountDao.searchById(idSource);
		if(a1!=null) {
			System.out.println("Enter target account id");
			String idTarget=sc.next();
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
	
	//to change pin for an account based on old pin
	@Override
	public void changePin(String id) throws UserNotFoundException, LimitExceedException {
		Account a=accountDao.searchById(id);
		if(a!=null) {
			//to give 3 chances to enter old pin
			for(int i=0;i<3;i++) {
				try {
					System.out.println("Enter old pin");
					int pin=sc.nextInt();
					if(a.getPin()==pin) {
						System.out.println("Enter new pin");
						int nPin=sc.nextInt();
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
	
	//to get data for all accounts
	public Set<Account> getAllAccounts() {
		return accountDao.getAllAccounts();
		
	}


}
