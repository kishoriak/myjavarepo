package com.demo.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.bean.Employee;

public class EmployeeDao implements EmployeeDaoInterface {
	static Connection conn;
	static PreparedStatement st;
	static {
		conn = DBUtil.getMyConnection();
	}

	@Override
	public int addEmployee(Employee e) {
		String query = "insert into employee values(?,?,?,?,?)";
		try {
			st = conn.prepareStatement(query);

			st.setInt(1, e.getEmpid());
			st.setString(2, e.getEname());
			st.setDouble(3, e.getSal());
			java.sql.Date dt = new java.sql.Date(e.getDoj().getTime());
			st.setDate(4, dt);
			st.setInt(5, e.getDeptid());

			return st.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		String query = "select * from employee";
		List<Employee> elist = new ArrayList<Employee>();

		try {
			st = conn.prepareStatement(query);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4), rs.getInt(5));
				elist.add(e);
			}
			return elist;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee searchEmployeeById(int id) {
		String query = "select * from employee where id=?";
		try {
			st = conn.prepareStatement(query);
			
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4), rs.getInt(5));
				return e;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return null;
	}

	@Override
	public int deleteEmployee(int id) {
		String query = "delete from employee where empid=?";

		try {
			st = conn.prepareStatement(query);

			st.setInt(1, id);
			int n = st.executeUpdate();

			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int updateName(int id, String name) {
		String query = "update employee set name=? where id=?";

		try {
			st = conn.prepareStatement(query);
			
			st.setString(1, name);
			st.setInt(2, id);
			int n = st.executeUpdate();
			
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public void closeConnection() {
		DBUtil.closeMyConnection();

	}

}
