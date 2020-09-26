package com.demo.test;

import java.util.List;
import java.util.Scanner;
import com.demo.bean.Employee;
import com.demo.service.EmployeeService;

public class TestCRUDJdbc {
	public static void main(String[] args) {
		int choice = 0, id;
		Scanner sc = new Scanner(System.in);
		
		// service class object to call methods of service layer
		EmployeeService employeeService = new EmployeeService();
		
		while (true) {
			System.out.println("1. add new Employee \n2. Delete Employee \n3. update name");
			System.out.println("4. search by by id \n5. Display all \n6. Exit");
			System.out.println("choice: ");
			choice = sc.nextInt();
			// switch case for all option
			switch (choice) {
			case 1:
				System.out.println(employeeService.addEmployee());
				break;
			case 2:
				System.out.println("Enter id");
				id = sc.nextInt();
				System.out.println(employeeService.deleteEmployee(id));
				break;
			case 3:
				System.out.println("Enter id");
				id = sc.nextInt();
				System.out.println("Enter new name");
				String name = sc.next();
				System.out.println(employeeService.updateName(id, name));
				break;
			case 4:
				System.out.println("Enter id");
				id = sc.nextInt();
				Employee e = employeeService.SearchById(id);
				if (e != null) {
					System.out.println(e);
				} else {
					System.out.println("employee not found");
				}

				break;
			case 5:
				List<Employee> plist = employeeService.getAllEmployee();
				for (Employee per : plist) {
					System.out.println(per);
				}
				break;
			case 6:
				sc.close();
				employeeService.closeConnection();
				System.exit(0);
				break;
			}
		}
	}

}
