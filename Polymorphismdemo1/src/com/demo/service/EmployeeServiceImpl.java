package com.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.demo.bean.Employee;
import com.demo.bean.SalariedEmp;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {
	static {
		sc=new Scanner(System.in);
		sdf=new SimpleDateFormat("dd/MM/yyyy");
	}
	private EmployeeDao employeeDao;
	public EmployeeServiceImpl() {
		this.employeeDao = new EmployeeDaoImpl();
	}
	static Scanner sc;
    static SimpleDateFormat sdf;
	
     
	@Override
	public void addNewEmployee() {
		System.out.println("enter Id");
		int id=sc.nextInt();
		System.out.println("enter Name");
		sc.nextLine();
		String nm=sc.nextLine();
		System.out.println("enter mobile");
		String mob=sc.next();
		System.out.println("enter dept");
		String dt=sc.next();
		System.out.println("enter desg");
		String ds=sc.next();
		System.out.println("enter Salary");
		double sal=sc.nextDouble();
		System.out.println("enter bonus");
		float bonus=sc.nextFloat();
		System.out.println("enter bdate");
		String bdate=sc.next();
		try {
			Date bdt=sdf.parse(bdate);
			Employee e=new SalariedEmp(id,nm,bdt,mob,dt,ds,sal,bonus);
			employeeDao.addEmployee(e);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	@Override
	public Employee searchById(int id) {
		return employeeDao.searchByEmpId(id);
		
	}
	@Override
	public boolean updateEmp(int id,String ds) {
		return employeeDao.updateEmployee(id,ds);
		
	}
	@Override
	public Employee[] getAllEmp() {
		return employeeDao.getAllEmployees();
	}
	

}
