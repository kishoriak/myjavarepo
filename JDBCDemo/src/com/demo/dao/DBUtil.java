package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static Connection conn=null;
	public static Connection getMyConnection() {
		if(conn==null) {
			String url = "jdbc:mysql://localhost:3306/testDb";
			String user = "root";
			String password = "Hrushikesh@1";
	        try {
				conn = DriverManager.getConnection(url, user, password);
				if (conn != null) {
		            System.out.println("Connected to database ");
		        }
			} catch (SQLException e) {
				System.out.println("Connection not done ");
				e.printStackTrace();
			}
			
		}
		return conn;
	}
	
	public static void closeMyConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
