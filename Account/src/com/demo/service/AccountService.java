package com.demo.service;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import com.demo.bean.Account;
public class AccountService {
	
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	public static Scanner sc=new Scanner(System.in);
	//accept data from the user for n accounts
	public static void acceptData(Account[] arr){
	for(int i=0;i<arr.length;i++){
	System.out.println("Enter name:");
	String name=sc.next();
	System.out.println("Enter balance:");
	double bal=sc.nextDouble();
	arr[i]=new Account(name,bal);
	}
	}
	//to display
public static void Display(Account[] parr,int id) {
	for(int i=0;i<parr.length;i++) {
		if(parr[i].getid()==id)
			System.out.println(parr[i]);
		else {
			break;
		}
	}
}
//to deposit
public static void deposit(Account[] parr,int id,double dep) {
	for(int j=0;j<parr.length;j++) 
	{
		if(parr[j].getid()==id) {
			parr[j].setBalanceDep(dep);
		}
	
	}
}
//to withdraw
public static void withdrawS(Account[] parr,int index,double amt) {
	int pos= AccountService.searchById(parr, index);
	if(pos!=-1) {
		parr[pos].withdraw(amt);
	     }
}
	
//to deposit
public static void depositS(Account[] parr,int index,double amt) {
	int pos= AccountService.searchById(parr, index);
	if(pos!=-1) {
		parr[pos].deposit(amt);
	}
	
		}
	

public static int searchById(Account[] parr,int id) {
for(int i=0;i<parr.length;i++) {
	if(parr[i].getid()==id) {
		return i;
	}
	
}
return -1;
}
}
