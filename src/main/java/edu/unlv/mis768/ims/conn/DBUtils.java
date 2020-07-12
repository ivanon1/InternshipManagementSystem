package edu.unlv.mis768.ims.conn;

import java.sql.*;

public class DBUtils {
	
	//Declare constants for DB Connection URL, Username and Password
	static private final String DB_BASE_URL = "jdbc:mysql://localhost:3306/";
	static private final String DB_IMS_URL = "jdbc:mysql://localhost:3306/InternshipManagementSystem";
	static private final String USERNAME = "root";
	static private final String PASSWORD = "";
	
	/**
	 * This method establishes the DB Connection
	 * @return conn
	 */
	public static Connection getDBConnection(){

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_IMS_URL, USERNAME, PASSWORD);
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		
		return conn;
		
	}
	
	
	/**
	 * This method establishes the base DB Connection
	 * @return conn
	 */
	 public static Connection getBaseDBConnection(){

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_BASE_URL, USERNAME, PASSWORD);
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		
		return conn;
		
	}

	/**
	 * This method closes the DB connection
	 * @param the connection to be closed
	 */
	public static void closeDBConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
			}
		}
	}

}