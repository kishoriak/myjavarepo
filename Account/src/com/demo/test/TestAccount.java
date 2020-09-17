package com.demo.test;
import java.util.Scanner;

import com.demo.bean.Account;
import com.demo.service.AccountService;
public class TestAccount {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// data for account
		Account[] p=new Account[2];
		AccountService.acceptData(p);
		boolean y=true;
		//satrting screen
		while(y) {
		System.out.println("Choose one option:\n 1 Deposit \n 2 Withdraw \n 3 Display account \n 4 Exit");
		int n=sc.nextInt();
		switch(n) {
		case(1):
			System.out.println("Enter the id:");
			int did=sc.nextInt();
			System.out.println("Enter the amount:");
			double dep=sc.nextDouble();
		    AccountService.depositS(p,did,dep); 
		    break;
		
		
		case(2):
	     System.out.println("Enter the id:");
		int id=sc.nextInt();
		System.out.println("Enter the amount:");
		double draw=sc.nextDouble();
		AccountService.withdrawS(p,id,draw); 
        break;
        
		case(3):
		System.out.println("Enter the id:");
		int nid=sc.nextInt();
		AccountService.Display(p,nid);
		break;
		case(4):
			System.out.println("Exitting ");
		    y=false;
		break;	
			
}
		}
		sc.close();
}
}
