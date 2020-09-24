package com.demo.test;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.demo.bean.Product;
import com.demo.exception.ItemNotFoundException;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

//Author: Adrija Ghansiyal
//Purpose: to test the program, take input from user for product category and generate report for it in console, ui layer

public class ProductTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ProductService prodService=new ProductServiceImpl(); //making Service layer object
		
		System.out.println("Enter Product category");
		String category=sc.nextLine();
		
		List<Product> productReport=null;
		try {
			productReport = prodService.generateReport(category); //product set of the user inputted category received in descending order
		} catch (ItemNotFoundException e) { //customized exception
		System.out.println(e.getMessage());
		}
		for(int i=0;i<3;i++) {
			System.out.print(productReport); //printing top 3 elem of the list
		}
		

	}

}
