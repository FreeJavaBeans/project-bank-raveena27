package com.revature.CustomerDetails;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.log.Logging;
import com.revature.login.DBLogin;

public class CustomerBalance {
DBLogin cu = DBLogin.getDBLogin();
	
	public int getCustBalance(Customer cust) {
		
		Connection conn = cu.getConnection();
		
		Scanner s = new Scanner(System.in);
	
		 if(cust.getFirstname() == null) {
				System.out.println("enter user_name :"); 
				String firstname = s.nextLine();
				cust.setFirstname(firstname);
				 }
				 
		if(cust.getAccountID() == 0) {
			 System.out.println("enter AccountID :");
			  int accountID = s.nextInt();
			 cust.setAccountID(accountID);
		}
		
		
				 
		 int rs = 0;
		
			try {
			
			Statement stmtobj1 = conn.createStatement(); //sql stmt to get all customer details select * from cust_account
			String querystring ="select balance from banking.\"Cust_Account\" where user_name = '"+cust.getFirstname()+"'and accountid ='"+cust.getAccountID()+"'";
			ResultSet results = stmtobj1.executeQuery(querystring);	
			
			while(results.next()== true) {
				Logging.loggerInfo(cust.getFirstname()+" checked current balance");
				rs = results.getInt("balance");
				System.out.println("displaying results..");
				System.out.println("balance:"+rs);
				//System.out.println(results);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("failed to Display balance details ");
			Logging.loggerWarn(cust.getFirstname()+" balance not displayed");
		}
		
		return rs;
	}

	
}
