package com.demo.test;

import java.util.Scanner;

import com.demo.service.ProductService;

import ccom.demo.bean.Apparel;
import ccom.demo.bean.Electronics;
import ccom.demo.bean.FoodItems;
import ccom.demo.bean.Product;

public class TestProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductService productService = new ProductService();
		productService.addDummyData(); //generate dummy data of products
		int choice;
		
		while(true) {
			System.out.println("Get Top Products");
			System.out.println("1. Food Items");
			System.out.println("2. Apparel");
			System.out.println("3. Electronice");
			System.out.println("Enter your choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					System.out.println("Food Items");
					for(Product p : productService.getTopProducts("foodItems")) {
						System.out.println(((FoodItems)p).toString());
					}
					break;
				case 2:
					System.out.println("Apparel");
					for(Product p : productService.getTopProducts("apparel")) {
						System.out.println(((Apparel)p).toString());
					}
					break;
				case 3:
					System.out.println("Electronics");
					for(Product p : productService.getTopProducts("electronics")) {
						System.out.println(((Electronics)p).toString());
					}
					break;
				default:
					System.out.println("Enter valid choice.");
			}
			
			
		}

	}

}
