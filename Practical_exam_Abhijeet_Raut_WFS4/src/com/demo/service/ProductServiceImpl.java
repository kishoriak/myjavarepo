package com.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.demo.bean.Apparel;
import com.demo.bean.Electronics;
import com.demo.bean.FoodItems;
import com.demo.bean.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	public static Scanner sc = new Scanner(System.in);
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private ProductDao productDao;
	
	public ProductServiceImpl() {
		this.productDao = new ProductDaoImpl();
	}

	//To add product to database/storage
	@Override
	public void addProduct(int choice) {
		System.out.println("Enter item code");
		int itemCode = sc.nextInt();
		System.out.println("Enter item name");
		sc.next();
		String itemName = sc.nextLine();
		System.out.println("Enter unit price");
		double unitPrice = sc.nextDouble();
		System.out.println("Enter quantity");
		int quantity = sc.nextInt();
		
		Product product = null;
		if(choice == 1) {
			System.out.println("Enter manufacturing date. (dd/MM/yyyy)");
			String mDate = sc.next();
			System.out.println("Enter expiring date. (dd/MM/yyyy)");
			String eDate = sc.next();
			System.out.println("Vegetarian? (1: Yes and 2: No)");
			int vegetarianFlag = sc.nextInt();
			boolean vegetarian; 
			if(vegetarianFlag == 1) {
				vegetarian = true;
			}
			else {
				vegetarian = false;
			}
			try {
				Date dateOfManufacture = sdf.parse(mDate);
				Date dateOfExpiry = sdf.parse(eDate);
				product = new FoodItems(itemCode, itemName, unitPrice, quantity, dateOfManufacture, dateOfExpiry, vegetarian);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(choice == 2) {
			System.out.println("Enter size in number");
			int size = sc.nextInt();
			System.out.println("Enter material (cotton/woolen)");
			String material = sc.next();
			
			product = new Apparel(itemCode, itemName, unitPrice, quantity, size, material);
		}
		else {
			System.out.println("Enter warranty in months");
			int warranty = sc.nextInt();
			product = new Electronics(itemCode, itemName, unitPrice, quantity, warranty);
		}
		
		productDao.addProduct(product, choice);
		
	}

	//To get the products from database/storage
	@Override
	public List<Product> getProducts(int choice2) {
		return productDao.getProducts(choice2);
		
	}

}
