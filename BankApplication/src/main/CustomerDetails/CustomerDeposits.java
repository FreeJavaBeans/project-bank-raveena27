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
	      
	long currentTimeMills = System.currentTimeMillis();
	Date date = new Date(currentTimeMills);
	

	
	int balance=0;
	int prevBal = 0;
	int accountID =0;
	
	
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
			int rs = exisBal.getCustBalance(cust);
			Statement stmtobj1 = conn.createStatement();
			String querystm = "insert into banking.\"Cust_Account_Hist\" (accountID,user_name,balance,deposit,withdraw,previoustransaction,rec_update) values ('"+cust.getAccountID()+"','"+cust.getFirstname()+"','"+balance+"','"+rs+"' ,'"+amount+"', '"+prevBal+"','"+date+"') " ;
			
			int rc = stmtobj1.executeUpdate(querystm);
			if(rc>0) {
				System.out.println(+rc+ " rows updated in Cust_Account_Hist");
			         }
			
			Statement stmtobj = conn.createStatement();
		
			String queryst = "update banking.\"Cust_Account\" set balance = '"+balance+"',deposit = '"+amount+"',previoustransaction= '"+prevBal+"' where accountID ='" +cust.getAccountID()+"' and user_name = '"+cust.getFirstname()+"'" ;
			int rwcount = stmtobj.executeUpdate(queryst);
			if(rwcount>0)
			{
			Logging.loggerInfo(cust.getFirstname()+" deposited money");	
			System.out.println("Deposited amount :"+amount);
			System.out.println("total balance :"+balance);
			}
			
			
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
	

