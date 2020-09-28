package com.demo.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Scanner;

import com.demo.bean.Product;
import com.demo.exception.InvalidPriceException;
import com.demo.exception.ProductAlreadyExistsException;
import com.demo.exception.ProductNotFoundException;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestProductClass {

	public static void main(String[] args) {
		
		ProductService productService=new ProductServiceImpl();
		Scanner sc=new Scanner(System.in);
		productService.readData("myproductdata.dat");
		int choice;
		
		do {
			System.out.println("1.add new object\n2.delete product\n3.update price and qty\n");
			System.out.println("4.display by id\n5.Display all Product\n6.exit");
			System.out.println("Enter Choice : ");
			choice=sc.nextInt();
			
			switch(choice) {
			
			case 1:
				//add a product
				try {
					boolean flag=productService.addProduct();
					if(flag) {
						System.out.println("Add successful");
					}
				}catch(ProductAlreadyExistsException e) {
					System.out.println("Product Already Exists");
				} catch (InvalidPriceException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				//delete a product
				System.out.println("Enter id : ");
				int id=sc.nextInt();
				try {
					boolean flag=productService.deleteProduct(id);
					if(flag) {
						System.out.println("Delete successful");
					}
				} catch (ProductNotFoundException e1) {
					System.out.println(e1.getMessage());
				}
				break;
			case 3:
				//update price and quantity
				System.out.println("Enter id : ");
				id=sc.nextInt();
				System.out.println("Enter new price : ");
				double price=sc.nextInt();
				System.out.println("Enter new quantity : ");
				int qty=sc.nextInt();
				try {
					boolean flag=productService.updateProduct(id,price,qty);
					if(flag) {
						System.out.println("Update successful");
					}
				}catch(ProductNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				//display by id
				System.out.println("Enter id : ");
				id=sc.nextInt();
				try {
					Product p=productService.displayById(id);
					System.out.println(p);
				}catch(ProductNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				//display all products
				List<Product> pList;
				pList=productService.displayAll();
				for(Product p1:pList) {
					System.out.println(p1);
				}
				break;
			case 6:
				productService.writedata("myproductdata.dat");
				System.exit(0);
			}
			
		}while(choice!=6);

	}

}
