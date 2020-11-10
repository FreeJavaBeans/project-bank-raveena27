package com.revature.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.log.Logging;
import com.revature.login.DBLogin;

public class EmpLogin {
	
	public DBLogin cu = DBLogin.getDBLogin();
	
     public boolean EmpLogin() 
	 {
    	 Scanner s = new Scanner(System.in);
    	 	 
    	 Connection conn = cu.getConnection();
    	     	 
      	
	System.out.println("welcome please enter your login details ..");
	System.out.println("--------------------");
	
	
	System.out.println("enter employee Username :");
	
	String user_name = s.nextLine();
	
	System.out.println("--------------------");

	System.out.println("welcome "+ user_name);
	
	System.out.println("please enter employee password :");
	String pswd = s.nextLine();
         
	System.out.println("--------------------");
	
	

	try {
		Statement stmtobj = conn.createStatement(); //gets all names in table BankLogin
		
   	 String querystring = "select * from banking.\"Employee_credentials\" where user_name = '"+user_name+"' and pswd = '"+pswd+"'";
   	   	  	 
   	 ResultSet results = stmtobj.executeQuery(querystring);
   	 
   	 if(results.next()==true)
   	 {
   		 System.out.println("login successful.. "+user_name);
   		Logging.loggerInfo("Employee "+user_name+" logged in succesfully");//for log info
   		 		 
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
