package com.demo.test;

import java.util.Scanner;

import com.demo.bean.Person;
import com.demo.service.PersonService;

public class TestPerson {
	static {
		System.out.println("in static block");
	}
	public  static void main(String[] args) {
		Person[] parr=new Person[3];
		int choice=0;
		Scanner sc=new Scanner(System.in);
		do {
		System.out.println("1. Add new person");
		System.out.println("2. search a person by id");
		System.out.println("3. search a person by name");
		System.out.println("4. display All");
		System.out.println("6. withdraw");
		System.out.println("5. exit");
		System.out.println("choice:");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			PersonService.acceptPersonData(parr);
			break;
		case 2:
			System.out.println("enter id for search");
			int id=sc.nextInt();
			int pos=PersonService.searchById(parr,id);
			if (pos!=-1) {
				System.out.println(parr[pos]);
			}
			else {
				System.out.println("Person not found");
			}
			break;
		case 3:
			System.out.println("enter name to be searched");
			String nm=sc.next();
			pos=PersonService.searchByName(parr,nm);
			if (pos!=-1) {
				System.out.println(parr[pos]);
			}
			else {
				System.out.println("Person not found");
			}
			break;
		case 4:
			PersonService.displayPerson(parr);
			break;
		case 5:
			System.exit(0);
			break;
		default:
			System.out.println("wrong choice");
		
		}
		}while(choice!=5);
		
	}

}
