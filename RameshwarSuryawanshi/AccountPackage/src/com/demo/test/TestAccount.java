package com.demo.test;
import java.util.Date;
import java.util.Scanner;

import com.demo.bean.Person;
import com.demo.bin.Account;
import com.demo.service.AccountService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class TestAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner sc =new Scanner(System.in);
		 Account[] a=new Account[2];
		 //System.out.println("Count : "+Account.cnt);
	     
	    int choice;
		 
	  do
	  {  System.out.println("1 :Create Acc ");
	     System.out.println("2 :Deposit Money ");
	     System.out.println("3 :Withdraw Money ");
	     System.out.println("4 :Display Acc by Id ");
	     System.out.println("5 :Exit ");
	  	 System.out.println("Enter Choice");
	      choice=sc.nextInt();
	     switch(choice)
	     {
	     case 1:
	    	 AccountService.acceptAccountdata(a);
	    	 break;
	    	 
	     case 2:
	    	 System.out.println("Enter Id");
	    	 int ide=sc.nextInt();
	    	
	    	 System.out.println("Enter Amount to be Deposit");
	    	 double am=sc.nextDouble();
	    	  AccountService.depositeAmt(a, ide, am);
	    	   break;
	     case 3:
	    	 System.out.println("Enter Id");
	    	 int ide1=sc.nextInt();
	    	  System.out.println("Enter amt to be Withdraw");
	    	  double am1=sc.nextInt();
	    	
	    	  AccountService.withdrawAmt(a, ide1, am1);
	    	  break;
	     case 4:
	    	
	    	 System.out.println("Enter Id");
	    	 int ide2=sc.nextInt();
	    	 AccountService.displayAccount(a, ide2);
	    	 break;
	    	 
	    	
	     case 5:
	        System.exit(0);
	        break;
	     
	    	 
	    	 
	     }
	    
	   }while(choice!=5);
		
	}

}
