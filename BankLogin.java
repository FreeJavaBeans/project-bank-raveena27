package com.revature.login;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.BankApplication.BankApp;
import com.revature.log.Logging;


public class BankLogin{
	
	public DBLogin cu = DBLogin.getDBLogin();
	//String customerName;
	//String password ;
     public boolean BankLogin() 
	 {
    	 Scanner s = new Scanner(System.in);
    	 
    	 //int AccountID;
    	 
    	 Connection conn = cu.getConnection();
    	 //System.out.println(conn);
    	 
      	
	System.out.println("welcome please enter your login details ..");
	System.out.println("--------------------");
	
	
	System.out.println("enter customer Username :");
	
	String user_name = s.nextLine();
	
	System.out.println("--------------------");

	System.out.println("welcome "+ user_name);
	
	System.out.println("please enter customer password :");
	String pswd = s.nextLine();
     
    // System.out.println("please enter Account ID :");
     //AccountID = s.nextInt();
     
	System.out.println("--------------------");
	
	

	try {
		Statement stmtobj = conn.createStatement(); //gets all names in table BankLogin
		
   	 String querystring = "select * from banking.\"BankLogin\" where user_name = '"+user_name+"' and pswd = '"+pswd+"'";
   	
   	 //String querystring = "select name from bankapp.\"BankLogin\"";
   	// System.out.println("Getting result");
   	 
   	 ResultSet results = stmtobj.executeQuery(querystring);
   	 
   	 
   	 
   	 //System.out.println("Displaying the results");
   	 
   	/*/while(results.next()) {
   		System.out.println(results.getString(1));
  		 results.getString(1);//displays 1st index of column
  	 }*/
   	
   	 if(results.next()==true)
   	 {
   		 System.out.println("login successful.. "+user_name);
   		Logging.loggerInfo(user_name+" logged in succesfully");//for log info
   		 		 
   		 return true;
   	 }else {
   		 System.out.println("login failed ");
   		 return false;
   	 }
   	 
   	
	}catch(SQLException e) {
		e.printStackTrace();
		System.out.println("Login failed..");
		return false;
	}
	
	}
	
 }	


