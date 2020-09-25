package com.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.demo.bean.Employee;
import com.demo.dao.EmployeeDao;

public class EmployeeService implements EmployeeServiceInterface {
	private EmployeeDao employeeDao;
	static Scanner sc;
	static SimpleDateFormat sdf;
	static {
		sc = new Scanner(System.in);
		sdf = new SimpleDateFormat("dd/MM/yyyy");

	}

	public EmployeeService() {
		this.employeeDao = new EmployeeDao();
	}

	@Override
	public String addEmployee() {
		System.out.println("enter Id");
		int id = sc.nextInt();
		System.out.println("enter Name");
		sc.nextLine();
		String nm = sc.nextLine();
		System.out.println("enter sal");
		double sal = sc.nextDouble();
		System.out.println("enter deptId");
		int did = sc.nextInt();
		System.out.println("enter Date of Joinig(dd/MM/yyyy)");
		String bdate = sc.next();
		try {
			Date bdt = sdf.parse(bdate);
			Employee e = new Employee(id, nm, sal, bdt, did);

			if (employeeDao.addEmployee(e) != 0) {
				return "Employee added successfully";
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "error accoured";

	}

	@Override
	public Employee SearchById(int id) {
		return employeeDao.searchEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	@Override
	public String deleteEmployee(int id) {
		int val = employeeDao.deleteEmployee(id);
		if (val != 0) {
			return "Employee with id " + id + " deleted successfully";
		}else if(val == 0) {
			return "Employee with id " + id + " not found";
		}else {
			return "err occured";
		}
	}

	@Override
	public void closeConnection() {
		employeeDao.closeConnection();
	}
	
	@Override
	public String updateName(int id, String name) {
		int val = employeeDao.updateName(id, name);
		if (val != 0) {
			return "Name updated successfully";
		}else if(val == 0) {
			return "Employee with id " + id + " not found";
		}else {
			return "err occured";
		}
	}
}
