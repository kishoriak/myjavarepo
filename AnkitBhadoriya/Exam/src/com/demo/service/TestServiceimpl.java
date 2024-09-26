//ankit bhadoriya
//TestService implementation layer 
//implents the methods for the Bussiness logic and works as middle layer between dao and ui layer

//import packages
package com.demo.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.demo.bean.Products;
import com.demo.dao.TestDao;
import com.demo.dao.TestDaoImpl;

public class TestServiceImpl implements TestService {
	
	//static block scanner object
	//static block SimpleDateFormat object
	static {
		sc=new Scanner(System.in);
		sdf=new SimpleDateFormat("dd/MM/yyyy");
	}
	
	
	//Creating a EmployeeDao object in the Default constructor of service class
	
	private TestDao testDao;
	public TestServiceImpl() {
		this.testDao = new TestDaoImpl();
	}
	static Scanner sc;
   
	
     
    //method to add employees
	@Override
	public void viewNewProduct() throws InvalidTypeException{
		System.out.println("enter Type");
		int type=sc.nextInt();
		System.out.println("enter Itemcode");
		int itemcode=sc.nextInt();
		System.out.println("enter Itemname");
		String itemname=sc.next();
		
		switch(type) {
		case 1: //ask for addition parameters and call fooditems constructor;'
			break;
			
		case 2: //ask for addition parameters and call apparel constructor;'
			break
			
		case 3: //ask for addition parameters and call Electronics constructor;'
			break;
		
		default:
			System.out.println("enter valid type");
		
		
		
		}
		
		
		
		@Override
		//TODO method call to dao layer Serach by qunatity and return top three products	
		@Override
		public List<Products> getProducts(int type) {
			List<Product> elist=List<Product> sortData();
			for(int i=0 ; i<=3 ;i++ ) {
				System.out.println(elist[i]);
			}
			
		}
		}
		
		
		
		
		
	
	

	
 
}
