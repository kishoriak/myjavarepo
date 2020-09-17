package com.demo.test;
import com.demo.bean.Account;
import com.demo.service.*;
import java.util.Scanner;
public class AccountDemo {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		Account[] a=new Account[3];
		int ch=0,id=0;
		Double amt=0.0;
		do
		{
			System.out.println("1.Create account 2. Withdraw 3. Deposit 4.Display 5.Exit");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				AccountService.acceptAccountData(a);
				break;
				
			case 2:
				System.out.println("Enter your id");
				id=sc.nextInt();
				System.out.println("Enter the amount you want to withdraw");
				amt=sc.nextDouble();
				AccountService.withdrawAmt(a, id, amt);
				break;
				
			case 3:
				System.out.println("Enter your id");
				id=sc.nextInt();
				System.out.println("Enter the amount you want to deposit");
				amt=sc.nextDouble();
				AccountService.depositAmt(a, id, amt);
			case 4:
				AccountService.displayAccountData(a);
				
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong Choice");
				
			}
		}while(ch!=5);
		
	}
	
}
