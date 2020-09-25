package com.demo.service;

import java.util.HashMap;
import java.util.Scanner;

import com.demo.bean.Product;
import com.demo.dao.ProductDao;

public class ProductService implements ProductServiceInterface {
	private ProductDao productDao = null;
	static Scanner sc = new Scanner(System.in);

	public ProductService() {
		this.productDao = new ProductDao();
	}

	@Override
	public void readDataFromFile(String fileName) {
		productDao.readDatafromFile(fileName);
	}

	public boolean addProduct(String fileName) {
		System.out.println("enter Prduct Id");
		int id = sc.nextInt();
		System.out.println("enter Prduct Name");
		sc.nextLine();
		String pname = sc.nextLine();
		System.out.println("enter Prduct price");
		double price = sc.nextDouble();
		System.out.println("enter Prduct quantity");
		int qty = sc.nextInt();
		Product p = new Product(id, pname, price, qty);

		return productDao.addProduct(p, fileName) ? true : false;
	}

	// get product list
	@Override
	public HashMap<Integer, Product> getProductList() {
		return productDao.getAllProduct();
	}

	@Override
	public void readData(String fname) {
		productDao.readDatafromFile(fname);
	}

	@Override
	public String deleteProduct(int id, String fileName) {
		return productDao.deleteProduct(id, fileName);
	}

	@Override
	public Product updateProduct(int id, int qty, String fileName) {
		return productDao.updateProduct(id, qty, fileName);
	}

	@Override
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

}
