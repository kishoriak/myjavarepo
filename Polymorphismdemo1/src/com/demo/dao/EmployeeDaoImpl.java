package com.demo.dao;

import com.demo.bean.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	static {
		emparr=new Employee[20];
		cnt=0;
	}
	static Employee[] emparr;
	static int cnt;

	@Override
	public void addEmployee(Employee e) {
		emparr[cnt]=e;
		cnt++;
		
	}

	@Override
	public Employee searchByEmpId(int id) {
		for(Employee e:emparr) {
			if(e!=null) {
			if(e.getPerId()==id) {
				return e;
			}
			}
			else {
				break;
			}
		}
		return null;
		
	}

	@Override
	public boolean updateEmployee(int id,String ds) {
		Employee e=searchByEmpId(id);
		if(e!=null) {
			e.setDesg(ds);
			return true;
		}
		
		return false;
		
	}

	@Override
	public Employee[] getAllEmployees() {
		return emparr;
	}

}
