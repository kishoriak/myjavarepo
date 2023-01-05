package com.demo.dao;

import com.demo.bean.Employee;


public interface EmployeeDao {
	void addEmployee(Employee e);

	Employee searchByEmpId(int id);

	boolean updateEmployee(int id,String ds);

import com.demo.exception.EmployeeNotFoundException;

public interface EmployeeDao{
	void addEmployee(Employee e);

	Employee searchByEmpId(int id) throws EmployeeNotFoundException;

	boolean updateEmployee(String ds,Employee ob);


	Employee[] getAllEmployees();

}
