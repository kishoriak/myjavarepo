package com.demo.service;

import com.demo.bean.Employee;


public interface EmployeeService {
	void addNewEmployee();

	Employee searchById(int id);

	boolean updateEmp(int id,String ds);
=======
import com.demo.exception.EmployeeNotFoundException;
import com.demo.exception.InvalidSalaryException;

public interface EmployeeService {
	void addNewEmployee() throws InvalidSalaryException;

	Employee searchById(int id) throws EmployeeNotFoundException ;

	boolean updateEmp(int id,String ds) throws EmployeeNotFoundException;


	Employee[] getAllEmp();
}
