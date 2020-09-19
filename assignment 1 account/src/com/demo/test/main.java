package com.demo.test;
import java.util.*;

import com.demo.bean.account;
import com.demo.service.service;
public class main {
	
	
	static account[] acc=new account[3];
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		service.enteraccdetails(acc);
		//temp vcalue to store the choice entered by user
	int temp=20;
	while(temp!=0) {
		System.out.println("Select one of the options");
		
		System.out.println("1 View account details by id");
		System.out.println("2 Withdraw");
		System.out.println("3 Deposit");
		System.out.println("0 exit");
		
		
		int op=s.nextInt();
		
		if(op==1) {
			service.viewdetails(acc);
		}
		if(op==2) {
			service.withdraw(acc);
		}
		if(op==3) {
			service.deposit(acc);
		}
		if(op==0) {
			break;
		}
	}
	
	
	
	
	
	
	
	
	}
}
