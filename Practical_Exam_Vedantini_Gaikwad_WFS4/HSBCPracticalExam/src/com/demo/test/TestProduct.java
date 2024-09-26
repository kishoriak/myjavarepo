package com.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

import com.demo.bean.FoodItems;
import com.demo.bean.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestProduct {

	public static void main(String[] args) {
		ProductService productService =new ProductServiceImpl();
		productService.addItems();
		Map<Integer,Product> map=productService.displayItems();
		for(Product product: map.values()) {
			System.out.println(product);
		}
		int category=0;
		System.out.println("1.food items\n2.apparel\n3.electronics ");
		System.out.println("Enter category : ");
		Scanner sc=new Scanner(System.in);
		category=sc.nextInt();
		switch(category) {
		case 1: 
			productService.displayFoodItems();
			Map<Integer,Product> map1=productService.displayFoodItems();;
			for(Product product: map1.values()) {
				System.out.println(product);
			}
			break;
		case 2:
			productService.displayFoodItems();
			Map<Integer,Product> map2=productService.displayApparel();;
			for(Product product: map2.values()) {
				System.out.println(product);
			}
			break;
		case 3:
			productService.displayFoodItems();
			Map<Integer,Product> map3=productService.displayElectronic();;
			for(Product product: map3.values()) {
				System.out.println(product);
			}
			break;
		}

	}

}
