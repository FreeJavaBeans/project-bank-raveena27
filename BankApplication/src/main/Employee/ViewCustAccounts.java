package com.revature.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.log.Logging;
import com.revature.login.DBLogin;

public class ViewCustAccounts {
	
	 public void getCustAccount(){
		 
    	 DBLogin cu = DBLogin.getDBLogin();
		Connection conn = cu.getConnection();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("enter name of customer");
		String user_name = s.nextLine();
		
		System.out.println("enter account id of customer");
		int accountid = s.nextInt();
	
			try {
			
			
			PreparedStatement stmtobj = conn.prepareStatement("select * from banking.\"Cust_Account\" where user_name = '"+user_name+"' and AccountID ='"+accountid+ "'"); //sql stmt to get all customer details select * from cust_account
			ResultSet results = stmtobj.executeQuery();	
			 System.out.println("  ID    |    User_NAME        |   Balance  |   Deposit     | Withdraw     |   Previous Transaction");

             System.out.println("--------------------------------------------------------------------------------------------------");
			while(results.next()== true) {
				Logging.loggerInfo(" Displayed all customer details ");
				System.out.println( results.getString(1) + "\t " + results.getString(2) + "\t " + results.getString(3) + "\t " + results.getString(4) + "\t " + results.getString(5) + "\t " + results.getString(6));
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("failed to Display Customer details ");
			//Logging.loggerWarn(cust.getFirstname()+" Logs not displayed");
		}
		
		
	}


}
