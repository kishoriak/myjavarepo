package com.demo.test;
import com.demo.bean.Account;
import com.demo.service.*;
import java.util.Date;
import java.util.Scanner;

public class TestAccountClass {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Account[] a=new Account[1];
		System.out.println("Please enter all 10 account details:");
		AccountService.acceptAccountData(a);
		
		// the menu shown to users
		
		while(true) {
		System.out.println("------Welcome to xxxx BANK------");
		System.out.println("1.Withdraw \n2.Deposit \n3.Display your Account details \n4.Exit"); 
		int i=sc.nextInt();
		
		
		
		//switch case for the menu
		switch(i) {
		case 1:
			System.out.println("Please enter your Account Id:");
			int id1=sc.nextInt();
			System.out.println("Enter amount to be withdrawn:");
			double amt=sc.nextInt();
			AccountService.withdrawAmt(a,amt,id1);
			break;
		case 2:
			System.out.println("Please enter your Account Id:");
			int id2=sc.nextInt();
			System.out.println("Enter amount to be deposited:");
			double amt1=sc.nextInt();
			AccountService.depositAmt(a,amt1,id2);
			break;
		case 3:
			System.out.println("Please enter your Account Id:");
			int id3=sc.nextInt();
			int s;
			s=AccountService.searchById(a, id3);
			if(s!=1) {
				System.out.println(a[s]);
			}
			
			break;
		case 4:
			System.exit(0);
			}
		
		
		}

}
}