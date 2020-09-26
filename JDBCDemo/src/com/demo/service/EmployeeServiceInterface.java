package com.demo.service;

import java.util.List;
import java.util.Set;

import com.demo.bean.Employee;


public interface EmployeeServiceInterface {

	String addEmployee();

	Employee SearchById(int id);

	String deleteEmployee(int id);

	void closeConnection();

	List<Employee> getAllEmployee();

	String updateName(int id, String name);



}
