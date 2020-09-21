package com.demo.dao;

import com.demo.bean.Account;
import com.demo.bean.Current;
import com.demo.bean.Saving;
import com.demo.exception.AccountNotFoundException;

public class AccountDaoImpl implements AccountDao {

	static Account[] aarr;
	Account a = new Account();
	static int index;

	static {
		aarr = new Account[20];
		index = 0;
	}

	@Override
	public void acceptData(Account a) {

		aarr[index] = a;
		index++;

	}

	@Override
	public Account displayData(int id) throws AccountNotFoundException {
		
		int pos = searchById(id);
		if(pos!=-1) {
		return aarr[pos];
		}
		throw new AccountNotFoundException("Invalid Id");
	}

	@Override
	public int searchById(int id) throws AccountNotFoundException{

		try {
		for (int i = 0; i < aarr.length; i++) {
			if (aarr[i].getPerName() != null) {
				if (id == aarr[i].getPerId()) {
					return i;
				}
			}
			else {
				break;
			}
		}
		}catch(NullPointerException e1) {
			
		}
		throw new AccountNotFoundException("Invalid Id");
	}

	@Override
	public boolean withdraw(int pos, double wd) {

		if (aarr[pos].getAccType().equals("Saving")) {
			Saving sav=new Saving();
			return sav.savingsWithdraw(aarr,pos,wd);
		} else {
			Current curr=new Current();
			return curr.currentWithdraw(aarr,pos,wd);
		}

	}

	@Override
	public boolean deposit(int pos, double dep) {

		return a.accountDeposit(aarr,pos,dep);

	}

	@Override
	public boolean transFunds(int pos1, int pos2, double trans) {

		if (aarr[pos1].getAccType().equals("Saving")) {
			Saving saving = new Saving();
			return saving.transferFunds(aarr, pos1, pos2, trans);
		} else {
			Current current = new Current();
			return current.transferFunds(aarr, pos1, pos2, trans);
		}

	}

	@Override
	public double checkBalance(int pos) {

		double bal = aarr[pos].getAccBal();
		return bal;

	}

	@Override
	public boolean changePinNumber(int pos, int pin1, int pin2) {

		return a.changePinNum(aarr, pos, pin1, pin2);
	}

	@Override
	public double calSimpInterest(int pos) {
		
		if (aarr[pos].getAccType().equals("Saving")) {
			Saving sav=new Saving();
			return sav.savingsSimpleInterest(aarr,pos);
		} 
		else {
			Current curr=new Current();
			return curr.currentSimpleInterest(aarr,pos);
		}
	}

}
