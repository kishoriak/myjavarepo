package com.demo.service;
import java.text.ParseException;
import com.demo.bean.Person;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
//import static java.lang.math.*;

public class PersonService {
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	public static Scanner sc=new Scanner(System.in);
	//accept data for n person
	public static void acceptPersonData(Person[] parr) {
		for(int i=0;i<parr.length;i++) {
				/*System.out.println("enter Id");
				int id=sc.nextInt();*/
				System.out.println("Enter name");
				String nm=sc.next();
				System.out.println("Enter mobile");
				String mob=sc.next();
				System.out.println("Enter email");
				String em=sc.next();
				System.out.println("Enetr Date:(dd/MM/yyyy)");
				String dt=sc.next();
				try {
					Date bdate=sdf.parse(dt);
					parr[i]=new Person(nm,bdate,mob,em);
					//System.out.println(p);
					//System.out.println("mobile : "+p.getMobile());
					//p.setMobile("22222");
					
					
				}catch(ParseException e) {
					e.printStackTrace();
				}
				}
	}
	//display data for n person
	public static void displayPerson(Person[] parr) {
		for(int i=0;i<parr.length;i++) {
			if(parr[i]!=null)
			   System.out.println(parr[i]);
			else {
				break;
			}
			
		}
	}
	
	//search a person by id
	public static int searchById(Person[] parr, int id) {
		for(int i=0;i<parr.length;i++)
		{
			if(parr[i].getPerId()==id) {
				return i;
			}
		}
		
		/*for(Person p:parr) {
			if(p.getPerId()==id) {
				return p;
			}*/
			
		return -1;
	}
	
	////search a person by name
	public static int searchByName(Person[] parr, String nm) {
		for(int i=0;i<parr.length;i++) {
			if(parr[i].getPerName().equals(nm)) {
				return i;
			}
		}
		return -1;
	}

}
