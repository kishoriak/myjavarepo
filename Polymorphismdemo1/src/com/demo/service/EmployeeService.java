package com.demo.service;

import com.demo.bean.Employee;

public interface EmployeeService {
	void addNewEmployee();

	Employee searchById(int id);

	boolean updateEmp(int id,String ds);

	Employee[] getAllEmp();
}
