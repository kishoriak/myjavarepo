package com.demo.test;

//importing packages
import java.util.Date;
import java.util.Scanner;

import com.demo.service.ItemService;
import com.demo.service.ItemServiceImpl;

//Test Class -------> To start the execution
public class TestProduct {
     public static void main(String args[]){
    	 
    	//creating object of service class to call service layer methods
    	 ItemService itemService=new ItemServiceImpl();
    	 int choice=0;
    	 do {
    		//taking user choice to either add or display the data
	    	 System.out.println("1.Enter item data");
	    	 System.out.println("2.Display item Data");
	    	
	    	 Scanner sc=new Scanner(System.in);
	    	 choice=sc.nextInt();
	    	 
	    	 switch(choice) {
	    	 case 1:
	    		 System.out.println("Enter the type of product you want 1.Food Items 2.Apparel 3.Electronics");
	    		 int ch=sc.nextInt();
	    		 itemService.addNewItemInfo(ch);
	    		 break;
	    	 case 2:
	    		 System.out.println("Displaying data");
	    		 itemService.displayAllItems();
	     		 break;
	    	 case 3:
	    		 sc.close();
	    		 System.exit(0);
    	
	    	 }
    	 }while(true);
     }
}
