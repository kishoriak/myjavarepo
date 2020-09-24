package com.demo.service;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//classes and interfaces imported
import com.demo.bean.Apparel;
import com.demo.bean.Electronics;
import com.demo.bean.Item;
import com.demo.dao.ItemDao;
import com.demo.dao.ItemDaoImpl;

public class ItemServiceImpl implements ItemService {
	public ItemDao itemDao;
	//Defaltu constructor
	public ItemServiceImpl() {
		super();
		itemDao = new ItemDaoImpl();
	}
	
	//static method
	static
	{
		sc=new Scanner(System.in);
	}
	static Scanner sc;
	@Override
	
	//Function to add data
	public void addNewItemInfo(int ch) {
		Item item=null;
		int Quantity=0;
		System.out.println("Enter the itemCode");
		int itemCode=sc.nextInt();
		System.out.println("Enter the item name");
		String itemName=sc.next();
		System.out.println("Enter the itemPrice");
		Double itemPrice=sc.nextDouble();
		System.out.println("Enter the quantity of Product");
		int quantity=sc.nextInt();
		
		switch(ch)
		{
		case 1:
			//NOT COMPLETED YET
			System.out.println("Enter the date of manifacturing");
			System.out.println("Enter the date of Expiry");
			System.out.println("Enter if yes for vegetarian and no for non-vegetarian");
			System.out.println("Enter the quantity");
			Quantity=sc.nextInt();
			break;
		case 2:
			System.out.println("Enter the size");
			int size= sc.nextInt();
			System.out.println("Enter the material");
			String material=sc.next();
			System.out.println("Enter the Quantity");
			Quantity=sc.nextInt();
			item= new Apparel(itemCode, itemName, itemPrice, quantity,size, material);
			itemDao.addItems(item);
			break;
		case 3:
			System.out.println("Enter the Warranty period in months");
			int warranty=sc.nextInt();
			System.out.println("Enter the Quantity");
			Quantity = sc.nextInt();
			item=new Electronics(itemCode, itemName, itemPrice, warranty, quantity);
			itemDao.addItems(item);
			
		}
		
		
		
	}
	
	//Function to call display the data
	@Override
	public Set<Item> displayAllItems() {
		
		return itemDao.displayAllStudents();
	}

}
