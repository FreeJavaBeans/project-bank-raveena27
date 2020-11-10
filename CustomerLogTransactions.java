package com.revature.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.log.Logging;
import com.revature.login.DBLogin;

public class CustomerLogTransactions{
	
     public void getCustLogTransactions(){
    	 DBLogin cu = DBLogin.getDBLogin();
		Connection conn = cu.getConnection();
		
		Scanner s = new Scanner(System.in);
	
			try {
			
			PreparedStatement stmtobj = conn.prepareStatement("select * from banking.\"Cust_Account_Hist\""); //sql stmt to get all customer details select * from cust_account
			ResultSet results = stmtobj.executeQuery();	
			 System.out.println("  ID    |    User_NAME        |   Balance  |   Deposit     | Withdraw     |   Previous Transaction   |    Date");

             System.out.println("---------------------------------------------------------------------------------------------------------------");
			while(results.next()== true) {
				Logging.loggerInfo(" Displayed all Log details ");
				System.out.println( results.getString(1) + "\t " + results.getString(2) + "\t " + results.getString(3) + "\t " + results.getString(4) + "\t " + results.getString(5) + "\t " + results.getString(6) + "\t " + results.getString(7));
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("failed to Display balance details ");
			//Logging.loggerWarn(cust.getFirstname()+" Logs not displayed");
		}
		
		
	}

	
}
