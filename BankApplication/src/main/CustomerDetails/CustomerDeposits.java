package com.revature.CustomerDetails;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Set;

import com.revature.BankAccount.BankAccount;
import com.revature.log.Logging;
import com.revature.login.DBLogin;

public class CustomerDeposits {
DBLogin cu = DBLogin.getDBLogin();

      public void deposit(Customer cust, int amount) throws SQLException
       {
	Scanner s = new Scanner(System.in);
	
	Connection conn = cu.getConnection();
	
	
	CustomerBalance exisBal = new CustomerBalance();
	
	

	
	int balance=0;
	int prevBal = 0;
	int accountID =0;
	//int previoustransaction = 0;
	
	if(cust.getFirstname() == null) {
		System.out.println("enter user_name :"); 
		String firstname = s.nextLine();
		cust.setFirstname(firstname);
		 }
	
	if(cust.getAccountID() == 0) {
		 System.out.println("enter AccountID :");
		  accountID = s.nextInt();
		 cust.setAccountID(accountID);
	}
	
	 
	 
	if(amount >0) {
		prevBal = exisBal.getCustBalance(cust);
		balance = prevBal + amount;	
		
		
		try {
			Statement stmtobj = conn.createStatement();
		
			String queryst = "update banking.\"Cust_Account\" set balance = '"+balance+"',deposit = '"+amount+"',previoustransaction= '"+prevBal+"' where accountID ='" +cust.getAccountID()+"' and user_name = '"+cust.getFirstname()+"'" ;
			int rwcount = stmtobj.executeUpdate(queryst);
			if(rwcount>0)
			{
			Logging.loggerInfo(cust.getFirstname()+" deposited money");	
			System.out.println("Deposited amount :"+amount);
			System.out.println("total balance :"+balance);
			}
			/*while(results.next()== true) {
				System.out.println("displaying results..");
				System.out.println(results);
				
			}*/
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("failed to  deposit ");
		}
				}else {
					System.out.println("entered negative amount, invalid transaction");
					System.exit(1);
				}
		
		
	
		
	}	
	}
	/*
	public   getCustDeposits() {
		
		Connection conn = cu.getConnection();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("enter customername :");
		 String First_name = s.nextLine();
		
		
		try {
			Statement stmtobj1 = conn.createStatement(); //sql stmt to get all customer details select * from cust_details
			String querystring ="select balance from banking.\"Cust_Account\" where user_name = '"+First_name+"'";
			ResultSet results = stmtobj1.executeQuery(querystring);	
			
			while(results.next()== true) {
				System.out.println("displaying results..");
				System.out.println(results);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("failed to Display balance details ");
		}
		
		return null;
	
	}
*/

