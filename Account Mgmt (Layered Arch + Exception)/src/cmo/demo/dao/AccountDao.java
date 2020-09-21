package cmo.demo.dao;

import java.util.HashMap;

import com.demo.bean.Account;
import com.demo.bean.CurrentAccount;
import com.demo.bean.SavingAccount;
import com.demo.exception.AccountNotFound;

public class AccountDao implements AccountDaoInterface {
	static HashMap<Integer, Account> acc;
	
	public AccountDao() {
		acc = new HashMap<>();
	}

	//add new account
	@Override
	public void addAccount(Account account) {
		acc.put(account.getId(), account);
	}

	//search account by id
	@Override
	public Account searchById(int id) throws AccountNotFound {
		Account account =  acc.get(id);
		
		if(account != null) {
			return account;
		}
		throw new AccountNotFound("Account with id : " + id + " not exist!");
	}
	
	//helper function to get minimum balance
	@Override
	public double getMinBalance(Account account) {
		if(account instanceof SavingAccount) {
			return SavingAccount.minBalance;
		}else if(account instanceof CurrentAccount) {
			return CurrentAccount.minBalance;
		}
		return 0.0;
	}

	//deposit amount
	@Override
	public String depositAmt(Account account, double amt) {
		account.setBalance(account.getBalance() + amt);
		return "Amount deposited successfully";
	}

	//withdraw amount
	@Override
	public String withdrawAmt(Account account, double amt) {
		double limit = getMinBalance(account);
		if((account.getBalance() + limit) >= amt) {
			account.setBalance(account.getBalance() - amt);
			return "Amount withdrawn successfully";
		}
		return "Not Sufficient Account Balance";
	}

	//change pin of account
	@Override
	public void changePin(Account account, int newPin) {
		account.setPinNumber(newPin);
	}
}
