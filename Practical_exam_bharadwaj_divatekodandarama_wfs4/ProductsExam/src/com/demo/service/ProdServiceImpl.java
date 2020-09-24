package com.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

import com.demo.bean.Apparel;
import com.demo.bean.Electronics;
import com.demo.bean.Food;
import com.demo.bean.Products;
import com.demo.dao.ProdDao;
import com.demo.dao.ProdDaoImpl;

//service layer class that implements ProdService interface
public class ProdServiceImpl implements ProdService {
	static {
		sc = new Scanner(System.in);
	}
	static Scanner sc;
	private ProdDao pDao;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYY");

	public ProdServiceImpl() {

		this.pDao = new ProdDaoImpl();
	}

	// method to add products based on choice
	@Override
	public void addProduct(String type) {
		//accepting the details of the product
		Products prod = null;
		System.out.println("enter itm code");
		int itmNum = sc.nextInt();
		System.out.println("enter the itm name");
		String name = sc.next();
		System.out.println("enter the price");
		double price = sc.nextDouble();
		System.out.println("enter quantity");
		int qty = sc.nextInt();
		switch (type) {
		case "food":
			Date dtm=null,dte=null;
			try {
				System.out.println("enter the manufacture date");
				String dateM = sc.next();
				dtm = sdf.parse(dateM);
				System.out.println("enter the expiry date");
				String dateE = sc.next();
				dte = sdf.parse(dateE);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("veg or not");
			boolean veg = sc.nextBoolean();
			prod = new Food(itmNum, name, price, qty, type, dtm, dte, veg);
			pDao.addProduct(prod,type);
			break;
		case "apparel":
			System.out.println("enter itm size");
			int size = sc.nextInt();
			System.out.println("enter the itm material");
			String material = sc.next();
			prod = new Apparel(itmNum, name, price, qty, type, size, material);
			pDao.addProduct(prod,type);
			break;
		case "electronics":
			System.out.println("enter warranty in months");
			int warranty = sc.nextInt();
			prod = new Electronics(itmNum, name, price, qty, type, warranty);
			pDao.addProduct(prod,type);
			break;
		}

	}
	
	public Set<Products> getProds(String type){
		return pDao.getProds(type);
	}
	
	
}
