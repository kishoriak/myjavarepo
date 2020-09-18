package cmo.demo.dao;

import com.demo.bean.Account;
import com.demo.bean.CurrentAccount;
import com.demo.bean.SavingAccount;
import com.demo.exception.AccountNotFound;

public class AccountDao implements AccountDaoInterface {
	static Account[] acc;
	static int cnt;
	
	static {
		acc = new Account[10];
		cnt = 0;
	}

	@Override
	public void addAccount(Account account) {
		acc[cnt] = account;
		cnt++;
	}

	@Override
	public Account searchById(int id) throws AccountNotFound {
		for (int i = 0; i < cnt; i++) {
			if(acc[i].getId() == id) {
				return acc[i];
			}
		}
		throw new AccountNotFound("Account with id : " + id + " not exist!");
	}
	
	@Override
	public double getMinBalance(Account account) {
		if(account instanceof SavingAccount) {
			return SavingAccount.minBalance;
		}else if(account instanceof CurrentAccount) {
			return CurrentAccount.minBalance;
		}
		return 0.0;
	}

	@Override
	public String depositAmt(Account account, double amt) {
		account.setBalance(account.getBalance() + amt);
		return "Amount deposited successfully";
	}

	@Override
	public String withdrawAmt(Account account, double amt) {
		double limit = getMinBalance(account);
		if((account.getBalance() + limit) >= amt) {
			account.setBalance(account.getBalance() - amt);
			return "Amount withdrawn successfully";
		}
		return "Not Sufficient Account Balance";
	}

	@Override
	public void changePin(Account account, int newPin) {
		account.setPinNumber(newPin);
	}
}