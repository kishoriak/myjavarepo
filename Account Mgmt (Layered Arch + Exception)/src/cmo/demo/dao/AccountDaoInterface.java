package cmo.demo.dao;

import com.demo.bean.Account;
import com.demo.exception.AccountNotFound;

public interface AccountDaoInterface {
	void addAccount(Account account);
	Account searchById(int id) throws AccountNotFound;
	double getMinBalance(Account account);
	String depositAmt(Account account, double amt);
	String withdrawAmt(Account account, double amt);
	void changePin(Account account, int newPin);
}
