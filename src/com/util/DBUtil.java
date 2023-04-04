package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	private static String url;
	private static String username;
	private static String password;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			ResourceBundle bundle = ResourceBundle.getBundle("databasedetails"); 
			url = bundle.getString("url");
			username = bundle.getString("username");
			password = bundle.getString("password");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to Load the Driver");
			System.out.println("Window Closed");
			System.exit(1);
		}
	}
	
	public static Connection provideConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}