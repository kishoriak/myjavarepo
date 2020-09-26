package com.demo.test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import com.demo.bean.Person;
import com.demo.bean.Product;
import com.demo.exception.ProductNotFoundException;
import com.demo.exception.QuantityNotFoundException;
import com.demo.exception.QuantityNotValidException;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestCRUDusingfile {
	public static void main(String[] args) {
		ProductService productService=new ProductServiceImpl();
		Scanner sc=new Scanner(System.in);
		//will read data from file if exists
		productService.readData("productData.dat");
		int choice=0;
		int f=0;
		
		do {
		System.out.println("1.add new object\n2.delete product\n3.update price and qty\n");
		System.out.println("4.display by id\n5.Display all Product\n6.exit");
		System.out.println("choice:");
		choice=sc.nextInt();
		boolean flag=false;
		switch(choice) {
		case 1:
		     try {
				flag=productService.addProduct();
				if(flag) {
					System.out.println("product added");
					f =1;
					
				}
				else {
					System.out.println("error occured");
				}
			} catch (QuantityNotValidException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				System.out.println(e1.getMessage());
			}
			
			break;
		case 2:
			System.out.println("Enter id");
			int id=sc.nextInt();
		    flag=productService.deletePerson(id);
			if (flag) {
				System.out.println("deletion done");
				f =2;
			}
			else {
				System.out.println("person not found");
			}
			break;
		case 3:
			System.out.println("Enter id");
			id=sc.nextInt();
			System.out.println("enter price");
			double price=sc.nextDouble();
			System.out.println("enter qty");
			int qty=sc.nextInt();
			
			try {
				if(qty>0)
				{
				flag = productService.updateEmp(id,price,qty);
				if(flag) {
					System.out.println("updation done");
					f =2;
				}
				}
				else
				{
					throw new QuantityNotValidException("Enter Valid Quantity ");
				}
				
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}catch(QuantityNotValidException e1)
			{    
				System.out.println(e1.getMessage());
			}
				
			break;
		case 4:
			   System.out.println("Enter id");
			   id=sc.nextInt();
			   Product p;
			try {
				p = productService.SearchById(id);
				System.out.println(p);
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}
			   
			break;
		case 5:
			//get all products
			ArrayList<Product> pset=productService.getProductList();
			for(Product ps:pset) {
				System.out.println(ps);
			}
			break;
		case 6:
			
            if(f==1){
				
				productService.writeData("productData.dat",f);
			}
				
			else if(f==2){
					productService.writeData("productData.dat",f);
				}
			System.exit(0);
			break;
		}
		}while(choice!=6);
		
	}

}
