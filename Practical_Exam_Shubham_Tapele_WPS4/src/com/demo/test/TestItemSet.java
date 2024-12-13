package com.demo.test;

import java.util.Scanner;
import java.util.Set;
import com.demo.exception.*;
import com.demo.bean.Apparel;
import com.demo.bean.Electronics;
import com.demo.bean.Food;
import com.demo.service.ItemService;


public class TestItemSet {

	public static void main(String[] args) {
		int choice=0;
		Scanner sc=new Scanner(System.in);
		
		
		//Parameter Creation of Food Objects
		Food f1=new Food("20/10/2010", "22/10/2010", "Veg", 10, 1, "Bread", 1);
		Food f2=new Food("20/9/2010", "22/9/2010", "Veg", 20, 2, "Juice", 2);
		Food f3=new Food("20/8/2010", "22/8/2010", "Veg", 30, 3, "Colddrink", 3);
		Food f4=new Food("20/7/2010", "22/7/2010", "Veg", 40, 4, "Bun", 4);

		
		//Parameter Creation of Apparel Objects
		Apparel a1=new Apparel("Medium", "Cotton", 10, 1, "Dress", 10);
		Apparel a2=new Apparel("Medium", "Cotton", 20, 2, "Pant", 20);		
		Apparel a3=new Apparel("Medium", "Cotton", 30, 3, "Shirt", 30);		
		Apparel a4=new Apparel("Medium", "Cotton", 40, 4, "Tshirt", 40);
		
		//Parameter Creation of Electronics Objects
		Electronics e1=new Electronics(10, 10, 1, "Radio", 10);
		Electronics e2=new Electronics(20, 20, 2, "TV", 20);		
		Electronics e3=new Electronics(30, 30, 3, "Ipod", 30);		
		Electronics e4=new Electronics(40, 40, 4, "Mobile", 40);		
		
		//Do while Loop to Carry on till exit is called
			do {
				System.out.println("1. Food Set Report");
				System.out.println("2. Apparel Report");
				System.out.println("3. Electronics Report");
				System.out.println("4. Exit");
				System.out.println("choice: ");
				choice=sc.nextInt();
				//switchcase for all option
				switch(choice) {
				case 1:
					Set<Food> foodSet=ItemService.getAllFood();			
					for(Food food:foodSet) {
						System.out.println(food);
					break;}
				case 2:
					Set<Apparel> appSet=ItemService.getAllApparel();			
					for(Apparel app:appSet) {
						System.out.println(app);
					}
					break;
				case 3:
					Set<Electronics> elecSet=ItemService.getAllElectronics();			
					for(Electronics elec:elecSet) {
						System.out.println(elec);
					}
					break;

				case 4:
					sc.close();
					System.exit(0);
					break;
				}
			}while(choice!=4);

		}
}
