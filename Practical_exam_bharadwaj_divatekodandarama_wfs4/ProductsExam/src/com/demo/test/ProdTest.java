package com.demo.test;

import java.util.Scanner;

import com.demo.bean.Products;
import com.demo.service.ProdService;
import com.demo.service.ProdServiceImpl;

public class ProdTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ProdService prodService = new ProdServiceImpl();
		String type = sc.next();
		prodService.addProduct(type);
		
		String ptype = sc.next();
		prodService.getProd(ptype);

	}
}
