package com.revature.CustomerDetails;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.revature.login.DBLogin;

public class CustomerDetails {
	DBLogin cu = DBLogin.getDBLogin();
 
    
	public  int getallCustDetails() {
		
		
		Connection conn = cu.getConnection();
		
		Scanner s = new Scanner(System.in);
		
		//System.out.println("enter customername :");
		 //String First_name = s.nextLine();
		 
		 System.out.println("enter account id :");
		 int AccountID = s.nextInt();
		 
		
		try {
			PreparedStatement stmtobj1 = conn.prepareStatement("select * from banking.\"Cust_Account\""); //sql stmt to get all customer details select * from cust_details
			
			//String querystring ="select * from banking.\"Cust_Account\"";
			ResultSet results = stmtobj1.executeQuery();	
			//results.setInt(1,AccountID);
			while(results.next()== true) {
				// c = new 
				
				System.out.println("displaying results..");
				System.out.println(results.getInt(1)+" "+results.getString(2)+ "" +results.getInt(3)+" "+results.getInt(4)+" "+results.getInt(5)+" "+results.getInt(6)); 
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("failed to Display ");
		}
		return AccountID;
		
		
		
	}
	public static void main(String[] args) throws SQLException {
		
		DBLogin cu = DBLogin.getDBLogin();

		Connection conn = cu.getConnection();
		if (conn != null && !conn.isClosed()) {
			System.out.println("DB connected !!");
		}
		
		CustomerDetails obj = new CustomerDetails();
		obj.getallCustDetails();
		
	}

}