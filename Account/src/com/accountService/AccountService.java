package com.accountService;
import java.util.Date;
import java.util.Scanner;

import com.account.Account;

public class AccountService {
	//add accounts data
	public static void addAccData(Account[] acc) {
		for (int i = 0; i < acc.length; i++) {
			acc[i] = new Account("Cust" + i, new Date(), i%2 == 0 ? "S" : "C", (long)(Math.random() * 10000));
		}
	}
	
	//search account by id
	public static Account searchById(Account[] acc, int id) {
		for (int i = 0; i < acc.length; i++) {
			if(acc[i].getId() == id) {
				return acc[i];
			}
		}
		return null;
	}
	
	//deposit to account / withdraw from account
	public static String accDepositWithdraw(Account[] acc, int id, char idf, long amt) {
		Account account = searchById(acc, id);
		if(account != null) {
			if(idf == 'd') {
				return account.depositAmt(amt);
			}else if(idf == 'w') {
				return account.withdrawAmt(amt);
			}
		}else {
			return "Account not found";
		}
		return "";
	}
}
