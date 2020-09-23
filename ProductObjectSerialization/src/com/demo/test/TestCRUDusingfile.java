package com.demo.test;

import java.util.List;

import java.util.Scanner;
import java.util.Set;

import com.demo.bean.Product;
import com.demo.exception.*;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestCRUDusingfile {
	public static void main(String[] args) {
		
		boolean del=false,upd=false;//flags to give condition to write the details to file
		ProductService productService=new ProductServiceImpl();
		Scanner sc=new Scanner(System.in);
		//will read data from file if exists
		productService.readData("productData.dat");
		int choice=0;
		do {
		System.out.println("---------Welcome to abc Products-------------------");
		System.out.println("1.add new object\n2.delete product\n3.update price and qty");
		System.out.println("4.display by id\n5.Display all Product\n6.exit");
		System.out.println("---------------------------------------------------");
		System.out.println("choice:");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			//add new product details
			boolean flag;
			try {
				flag = productService.addProduct();
				if(flag) {
					System.out.println("product added");
					upd=true;
				}
			} catch (CheckValueException | SimilarIdException  e2) {
				System.out.println(e2.getMessage());
			}
			break;
		case 2:
			//delete a product you select
			boolean deleted;
			try {
				deleted = productService.deleteProduct();
				if(deleted) {
					System.out.println("Product Deletion Successful.....");
					del=true;
				}
				
			} catch (ProductNotFoundException e1) {
				System.out.println(e1.getMessage());
			}
			break;
		case 3:
			//update price and quantity
			boolean update;
			try {
				update = productService.updateProduct();
				if(update) {
					System.out.println("Product Updated Successful.....");
					
				}
			} catch (ProductNotFoundException e1) {
				System.out.println(e1.getMessage());
			}
			
			break;
		case 4:
			//Displays a single product using id
			try {
			System.out.println("enter Prduct Id: ");
			int id=sc.nextInt();
			Product p=new Product();
			p=productService.searchProdID(id);
			System.out.println(p);
			break;
			}catch(ProductNotFoundException e) {
				System.out.println(e.getMessage());
			}
		case 5:
			//get all products
			List<Product> plist=productService.getProductList();
			for(Product p1:plist) {
				System.out.println(p1);
			}
			break;
		case 6:
			productService.writeData("productData.dat",del,upd);
			System.exit(0);
			break;
		}
		}while(choice!=6);
		
	}

}
