package com.demo.dao;

import java.util.List;

import com.demo.bean.Employee;

public interface EmployeeDaoInterface {

	int addEmployee(Employee e);

	void closeConnection();

	List<Employee> getAllEmployee();

	Employee searchEmployeeById(int id);

	int deleteEmployee(int id);

	int updateName(int id, String name);

}
