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
	
     public boolean BankLogin(Customer cust) 
	 {
    	 Scanner s = new Scanner(System.in);
    	 
    	 Connection conn = cu.getConnection();
    	
	System.out.println("welcome please enter your login details ..");
	System.out.println("--------------------");
	
	
	if(cust.getFirstname() == null) {
		System.out.println("enter user_name :"); 
		String firstname = s.nextLine();
		cust.setFirstname(firstname);
		 }
	System.out.println("--------------------");
	
	if(cust.getPswd() == null) {
		System.out.println("enter password :"); 
		String Pswd = s.nextLine();
		cust.setPswd(Pswd);
		 }

     
	System.out.println("--------------------");
	
	

	try {
		Statement stmtobj = conn.createStatement(); //gets all names in table BankLogin
		
   	 String querystring = "select * from banking.\"BankLogin\" where user_name = '"+cust.getFirstname()+"' and pswd = '"+cust.getPswd()+"'";
   	 ResultSet results = stmtobj.executeQuery(querystring);
   	 
   	 if(results.next()==true)
   	 {
   		 System.out.println("login successful.. "+cust.getFirstname());
   		Logging.loggerInfo(cust.getFirstname()+" logged in succesfully");//for log info
   		 		 
   		 return true;
   	 }else {
   		 System.out.println("login failed!!  Invalid username & password ");
   		 return false;
   	 }
   	 
   	
	}catch(SQLException e) {
		e.printStackTrace();
		System.out.println("Login failed..");
		return false;
	}
	
	}
	
 }	


