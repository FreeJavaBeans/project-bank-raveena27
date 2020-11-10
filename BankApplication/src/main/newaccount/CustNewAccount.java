package com.revature.newaccount;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.log.Logging;
import com.revature.login.DBLogin;

public class CustNewAccount {
	
	DBLogin cu = DBLogin.getDBLogin();
	
	Connection conn = cu.getConnection();
	public void CustNewAccount()
	{
		
	Scanner s = new Scanner(System.in);
	
	System.out.println("welcome..");
	
	System.out.println("enter First name :");
	String First_Name = s.nextLine();
	
	
	System.out.println("please enter Last name");
	String Last_Name = s.nextLine();
     
     System.out.println("enter Address :");
     String Address = s.nextLine();
     
 	System.out.println("enter City:");
 	String City = s.nextLine();
 		 
    System.out.println("enter State :");
    String State = s.nextLine();
	 
	 System.out.println("enter Country:");
	 String Country = s.nextLine();
	 
	 System.out.println("enter postal code :");
	 int postalcode = s.nextInt();
		 
	 System.out.println("enter phone number :");
	 int phone = s.nextInt();
		 
	//System.out.println("enter email :");
	//String email = s.nextLine();
		 
	System.out.println("enter amount to be deposited :");
	int deposit = s.nextInt();
	 
	//int accountid = nextval('account_id_sequence');
		 
	System.out.println("--------------------");
	int rs = 0;
	while(deposit >= 500) { //minimum of starting balance
	try {
		Connection conn = cu.getConnection();
		Statement stmtobj = conn.createStatement(); 
		String queryst = "insert into banking.\"Cust_Account\" (user_name,balance,deposit,withdraw,previoustransaction) values ('"+First_Name+"'"+",'"+deposit"',"+"'"+deposit+"'"+",'0','0')";
		int rwcount = stmtobj.executeUpdate(queryst);
		if(rwcount>0) {
	    	 System.out.println("Success and "+rwcount+" records are inserted and "+deposit+" Deposited ");
	    	
	     }
		
		//this is for account id
		Statement stmtobj1 = conn.createStatement(); //sql stmt to get all customer details select * from cust_account
		String querystring ="select AccountID from banking.\"Cust_Account\" where user_name = '"+First_Name+"'";
		ResultSet results = stmtobj1.executeQuery(querystring);	
		
		while(results.next()== true) {
			rs = results.getInt("accountID");
			System.out.println("displaying results..");
			System.out.println("AccountID : "+rs);
			 System.out.println(First_Name+" customer accountid is : "+rs);
		}
		
		
		
		
		//then insert into cust_details
		Statement stmtobj2 = conn.createStatement();
   	 String queryst1 = "insert into banking.\"Cust_Details\" (Accountid,First_name,Last_name,address,city,State,Country,PostalCode,Phone) values ('"+rs+"','"+First_Name+"\'"+","+"\'"+Last_Name+"\'"+","+"\'"+Address+"\'"+","+"\'"+City+"\'"+","+"\'"+State+"\'"+","+"\'"+Country+"\'"+","+postalcode+","+phone+")";
      
   	 int  rowcount1= stmtobj2.executeUpdate(queryst1);
          if(rowcount1>0) {
    	 System.out.println("Success and "+ rowcount1+" records are updated");
    	 System.out.println("new row inserted in customer details ");
             }
    		}catch(SQLException e) {
		e.printStackTrace();
		System.out.println("New Account is not created ");
	}break;
	}

}
}
