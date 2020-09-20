package com.demo.service;
import java.util.*;

import com.demo.bean.*;
import com.java.dao.AccountDao;
import com.java.dao.AccountDaoImp;
import com.demo.exception.*;
public class AccountServiceImp implements AccountService{ 
	
	public AccountDao accountDao;
	public AccountServiceImp()
	{
		this.accountDao= new AccountDaoImp();
	}
	Account a=null;
	public void AcceptAccountData(String type) {
		
		{
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter the id");
			int id=sc.nextInt();
			System.out.println("Enter the AccoundHolderName");
			String name=sc.next();
			System.out.println("Enter the balance");
			Double Balance=sc.nextDouble();
			System.out.println("Enter pin");
			Double pin=sc.nextDouble();
			
			switch(type)
			{
			case "C":
				a= new Current(id,Balance,name,pin);
				accountDao.addAccount(a);
				break;
			case "S":
				System.out.println("Enter the Chequebook number");
				int Chequebookno=sc.nextInt();
				a=new Savings(id,Balance,name,pin,Chequebookno);
				accountDao.addAccount(a);
				sc.close();
			default:
				System.out.println("Default");
		}
	}
 }
	@Override
	public Account SerachById(int id) throws AccountNotFoundException {
		return accountDao.SearchById(id);
		
	}
	@Override
	public Account[] DisplayAccounts(){
		return accountDao.DisplayAccounts();
		
	}
	@Override
	public boolean WithdrawAmt(int id, Double amt) throws AccountNotFoundException{
		a = SerachById(id);
		return a.Withdraw(amt);
	}

	@Override
	public boolean DepositAmt(int id, Double amt) throws AccountNotFoundException{
		a=SerachById(id);
		return a.Deposit(amt);
		//return false;
	}
	@Override
	public void TransferFunds(int id1, int id2, Double amt) throws AccountNotFoundException {
		a=SerachById(id1);
		a.Withdraw(amt);
		a=SerachById(id2);
		a.Deposit(amt);
		
		
	}
	

	

}
