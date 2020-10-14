package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.bean.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestProduct {

	public static void main(String[] args) {
		ProductService productService = new ProductServiceImpl();
		Scanner sc=new Scanner(System.in);
		int choice1 = 0; //to decide to add or fetch products
		int choice2 = 0; // to decide the category of products
		do {
			System.out.println("1. Add product\n2. Get the info");
			choice1 = sc.nextInt();
			System.out.println("Enter the category");
			System.out.println("1. Food Item\n2. Apparel\n3. Electronics\n4. Exit");
			System.out.println("Enter Choice:");
			choice2 = sc.nextInt();
			if(choice1 == 1) {
				productService.addProduct(choice2);
			}
			else {
				List<Product> productList = productService.getProducts(choice2);
				for(Product product : productList) {
					System.out.println(product);
				}
			}
		}while(choice2 != 4);
	}

}
