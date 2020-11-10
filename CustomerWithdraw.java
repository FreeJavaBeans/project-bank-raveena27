package com.revature.CustomerDetails;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.log.Logging;
import com.revature.login.DBLogin;

public class CustomerWithdraw {
	
	public void withdraw(Customer cust,int amount) throws SQLException
	{
		DBLogin cu = DBLogin.getDBLogin();
		Scanner s = new Scanner(System.in);
		Connection conn = cu.getConnection();
		
		
		long currentTimeMills = System.currentTimeMillis();
		Date date = new Date(currentTimeMills);//doubt not taking current format
		
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
		
		
		 CustomerBalance existBal = new CustomerBalance();
		 
		 			 
		int balance=0;
		int prevbal = 0;
		int previoustransaction=0;
		
		if(amount > 0) {
			prevbal=existBal.getCustBalance(cust);
			//System.out.println("prevbal:"+prevbal);
			if(amount<prevbal) {
			 balance = prevbal - amount;
			 previoustransaction = previoustransaction - amount;
			        }
			        else {
				System.out.println("Amount is not sufficient for withdrawl");
				System.exit(1);
			            }
		}
		else {
			System.out.println("transaction rejected");
			System.exit(1);
		}
		try 
		{
			int rs = existBal.getCustBalance(cust);
			Statement stmtobj1 = conn.createStatement();
			String querystm = "insert into banking.\"Cust_Account_Hist\" (accountID,user_name,balance,deposit,withdraw,previoustransaction,rec_update) values ('"+cust.getAccountID()+"','"+cust.getFirstname()+"','"+balance+"','"+rs+"' ,'"+amount+"', '"+prevbal+"','"+date+"') " ;
			//System.out.println(querystm);
			int rc = stmtobj1.executeUpdate(querystm);
			if(rc>0) {
				System.out.println(+rc+ " rows updated in Cust_Account_Hist");
			         }
		Statement stmtobj = conn.createStatement();
		String queryst = "update banking.\"Cust_Account\" set balance = '"+balance+"',withdraw = '"+amount+"',previoustransaction= '"+prevbal+"' where accountID ='" +cust.getAccountID()+"'" ;
		int rwcount = stmtobj.executeUpdate(queryst);
		if(rwcount>0) {
			Logging.loggerInfo(cust.getFirstname()+" withdrawn "+amount);
		System.out.println("withdrawn amount :"+amount);
		System.out.println("total balance :"+balance);
		System.out.println("previous transaction :"+prevbal);
		}
	}catch(SQLException e){
		e.printStackTrace();
		Logging.loggerWarn(cust.getFirstname()+" withdrawn details not displayed");
		System.out.println("failed to Display withdrawal details ");
	}
	
	}

	

}
