package com.demo.test;
import  java.util.Scanner;
import com.demo.bean.Bank;
import com.demo.service.BankService;




public class TestBanking {

	private static Scanner sc;

	public static void main (String[] args) {
		
			sc = new Scanner(System.in);
			int id=0,amt=0,key=0;
			Bank[ ] p=new Bank[2];
			
			while(key!=6)
			{
					System.out.println("enter the Choice for operation \n1.Create account  \n2.Display\n3.deposit \n 4.Withdraw5. Search By Id \n6. Exit ");
					 key=sc.nextInt();
					switch(key) {
				
					case 1:
							BankService.acceptAccountData(p);     //get account data method
							break;
					
					case 2: 
							BankService.displayAccount(p);          //display data method
							break;
					  
					case 3:
						System.out.println("enter the id and amt ")	;
						id=sc.nextInt();
						amt=sc.nextInt();
						int pos=BankService.SearchById(p,id);    //Search by ID method
						if(pos!=-1) {
								BankService.deposit(p, id, amt);       //deposit if Id found
								System.out.println("updated account balance is :"+p[pos].getBalance());
						}
					 else {
						 		System.out.println("account not found");
					 	}
						break;
					
				   case 4:	
					   System.out.println("enter the id and amt ")	;
					   id=sc.nextInt();
					   amt=sc.nextInt();
					   pos=BankService.SearchById(p,id);        //search by Id method
					   if(pos!=-1) {
						       
								BankService.withdraw(p,id,amt);     //withdraw if id found and conditions satisfies;
								System.out.println("updated account balance is :"+p[pos].getBalance());}
					 else {
								 System.out.println("account not found");
							 	}
					   break;
					        
				
				   case  5:
						System.out.println("enter the id to search");
					  	 id=sc.nextInt();
						pos=BankService.SearchById(p,id);
						if(pos!=-1) {
								System.out.println(p[pos]);
						}
					 else {
						 		System.out.println("account not found");
					 	}
							 break;
					 
				  case 6:
					  System.out.println("See you again");
					  System.exit(0);          //exit code;
				
				
					  
				  default:
					  System.out.println("enter valid input");
				    break;
					}
		
	
	}	
	}
}
				
				
			
				
			
	           
	
	
	
	
	
	
	     
	


