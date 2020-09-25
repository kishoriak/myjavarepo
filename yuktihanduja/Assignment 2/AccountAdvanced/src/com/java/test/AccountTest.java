package com.java.test;
import java.util.*;
import com.demo.bean.Account;
import com.demo.service.*;
import com.demo.exception.*;
public class AccountTest {
	
	public static void main(String[] args)
	{
		//Account[] a=new Account[3];
		
		Scanner sc= new Scanner(System.in);
		
		int id=0;
		Double amt=0.0;
		AccountService acc=new AccountServiceImp();
		do {
			System.out.println("Enter your choice 1. create account 2.withdraw 3.Deposit 4.Transfer fund 5.Display 6.Exit");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the type of account you want to create 'C'-Current 'S'-Savings");
				String type=sc.next();
				acc.AcceptAccountData(type);
				break;
			
			case 2:
				try
				{
					System.out.println("Enter your id to withdraw amount");
					id=sc.nextInt();
					System.out.println("Enter the amount you want to withdraw");
					amt= sc.nextDouble();
					acc.WithdrawAmt(id,amt);
				}
				catch(AccountNotFoundException e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try
				{
					System.out.println("Enter your id to deposit amount");
					id=sc.nextInt();
					System.out.println("Enter the amount you want to deposit");
					amt= sc.nextDouble();
					acc.DepositAmt(id,amt);
				}
				catch(AccountNotFoundException e)
				{
					System.out.println(e.getMessage());
				}
				
				break;
			case 4:
				try
				{
					System.out.println("Sender's account id");
					int id1 = sc.nextInt();
					System.out.println("Reciever's account id");
					int id2=sc.nextInt();
					System.out.println("Enter the amount to be transferred");
					amt=sc.nextDouble();
					acc.TransferFunds(id1,id2,amt);
				}
				catch(AccountNotFoundException e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				try {
					System.out.println("Enter your Id to display the account data");
					id=sc.nextInt();
					Account a=acc.SerachById(id);
					if(a!=null)
					{	
						System.out.println(a);
						
					}
				}
				catch(AccountNotFoundException e){
					System.out.println(e.getMessage());
					
				}
				break;
			case 6:
				sc.close();
				System.exit(0);
				break;
			/*case 7:
				Account[] ac=acc.DisplayAccounts();
				for(Account a11:ac)
					System.out.println(a11);
			*/
			}
		}while(true);
	}
}
