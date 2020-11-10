package com.revature.CustomerDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.log.Logging;
import com.revature.login.DBLogin;

public class CustomerMoneyTransfer {
	
	
	
	public void moneytransfer(Customer cust, int amount) throws SQLException
	{
		Scanner s = new Scanner(System.in);	
		
		Customer cust2 = new Customer();
		
		DBLogin cu = DBLogin.getDBLogin();
		
		Connection conn = cu.getConnection();
				
		System.out.println("money transferring from ");
				
		CustomerWithdraw obj = new CustomerWithdraw();
		obj.withdraw(cust,amount);
		
		
		System.out.println("money transferring to");
		 
		if(cust.getFirstname() == null) {
			System.out.println("enter user_name :"); 
			String firstname = s.nextLine();
			cust2.setFirstname(firstname);
			 }
		
		if(cust.getAccountID() == 0) {
			 System.out.println("enter AccountID :");
			  int accountID = s.nextInt();
			 cust2.setAccountID(accountID);
		}
		
		 CustomerDeposits obj1 = new CustomerDeposits();
		 obj1.deposit(cust2,amount);
		 
		 Logging.loggerInfo(cust.getFirstname()+" transfered money from "+cust2.getFirstname());
    }
}	
