package com.revature.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBLogin {
		
	private static DBLogin singleton = new DBLogin();//single instance of BankLogin
	
	private Connection conn;
		
	private DBLogin() {//private constructor no one can call
		super();
		
		String password = System.getenv("DB_PASSWORD");
		String username = System.getenv("DB_USERNAME");
		String url = System.getenv("DB_URL");
		try {
			this.conn = DriverManager.getConnection(url,username,password);
		}catch(SQLException e) {
			System.out.println("Failed to connect to DB");
		}
	}
	
	public static DBLogin getDBLogin() {//public getter for static reference
		
		return singleton;
	
	}
	
	
	
	public Connection getConnection() {
		
		return conn;
	}
	
	
	
	
	}
	
	

