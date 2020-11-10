package com.revature.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.CustomerDetails.Customer;
import com.revature.CustomerDetails.CustomerBalance;
import com.revature.CustomerDetails.CustomerDeposits;
import com.revature.CustomerDetails.CustomerMoneyTransfer;
import com.revature.CustomerDetails.CustomerWithdraw;
import com.revature.login.DBLogin;

public class EmpOptions {
	

	public DBLogin cu = DBLogin.getDBLogin();
	
	Scanner s = new Scanner(System.in);
	
	public void menu() throws SQLException {
		
		char option;
			
		Scanner s = new Scanner(System.in);
		
		Customer cust = new Customer();
		Connection conn = cu.getConnection();
		
		
			System.out.println("please enter an option");
			System.out.println("A.To View all log transactions of Customer");
			System.out.println("B.To View Customer Accounts");
			System.out.println("C.To Register for new customer Account");
			System.out.println("E.EXIT");
			
			do
			{
				System.out.println("please enter an option :");
				
				option = s.next().toUpperCase().charAt(0);
				System.out.println("\n");
				switch(option) 
				{
				case 'A':
					CustomerLogTransactions obj1 = new CustomerLogTransactions();
					obj1.getCustLogTransactions();
					System.out.println("\n");
					break;
					
				case 'B':
					
					ViewCustAccounts obj2 = new ViewCustAccounts();				
					obj2.getCustAccount();
					System.out.println("\n");	
					break;
					
				case 'C':
					
					EmpNewAccount obj3 = new EmpNewAccount();
					obj3.EmpNewAccount();
					System.out.println("\n");	
					break;
				
					
				case 'E':
					System.out.println("good bye !!");
					break;
					
				default :
					System.out.println("invalid option ");
					break;
				}
	
			}
			while(option != 'E');
				System.out.println("Thank you..!! \n visit again");
				
				
					
				
			}


}
