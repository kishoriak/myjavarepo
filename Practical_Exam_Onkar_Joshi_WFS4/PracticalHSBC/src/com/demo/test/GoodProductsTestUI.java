package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.bean.*;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class GoodProductsTestUI {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		ProductService productservice= new ProductServiceImpl();
		
		System.out.println("1. add products\n 2. show reports");
		int i=sc.nextInt();
		
		switch(i) {
		case 1:
			System.out.println("1. Fooditems\n 2. Apparals\n 3.Electronics");
			int n=sc.nextInt();
			productservice.newProduct(n);
		case 2:
			System.out.println("Reports you need...");
			System.out.println("1. Fooditems\n 2. Apparals\n 3.Electronics");
			int c=sc.nextInt();
			if(c==1) {
			List<FoodItems> prod=productservice.sortOnQuantity();
			for(FoodItems f:prod) {
				System.out.println(f);
			}
			
		}
		
		
	}
	
