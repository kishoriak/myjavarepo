package com.demo.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import com.demo.bean.Product;
import com.demo.service.ProductService;

public class TestCRUDProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductService productService = new ProductService();
		String fileName = "products.txt";
		File f = new File(fileName);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

//		System.out.println(f.length());
		if (f.length() != 0) {
			productService.readDataFromFile(fileName);
		}

		int choice = 0, id = 0;
		while (true) {
			System.out.println("1.add new object\n2.delete product\n3.update qty");
			System.out.println("4.display by id\n5.Display all Product\n6.exit");
			System.out.println("choice:");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				if (productService.addProduct(fileName)) {
					System.out.println("product added");
				} else {
					System.out.println("error occured");
				}
				break;
			case 2:
				System.out.println("Enter id : ");
				id = sc.nextInt();

				System.out.println(productService.deleteProduct(id, fileName));
				break;
			case 3:
				System.out.println("Enter id : ");
				id = sc.nextInt();
				System.out.println("Enter new qty : ");
				int qty = sc.nextInt();
				Product p = productService.updateProduct(id, qty, fileName);
				if (p != null) {
					System.out.println("Product updated successfully");
					System.out.println(p);
				} else {
					System.out.println("Product not found");
				}
				break;
			case 4:
				System.out.println("Enter id : ");
				id = sc.nextInt();
				System.out.println(productService.getProductById(id));
				break;
			case 5:
				HashMap<Integer, Product> map = productService.getProductList();
				for (Entry<Integer, Product> m : map.entrySet()) {
					System.out.println(m.getValue().toString());
				}
				break;
			case 6:
				System.exit(0);
				break;
			}
		}
	}

}
