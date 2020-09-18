package com.demo.dao;

import com.demo.bean.Employee;

public interface EmployeeDao {
	void addEmployee(Employee e);

	Employee searchByEmpId(int id);

	boolean updateEmployee(int id,String ds);

	Employee[] getAllEmployees();

}
