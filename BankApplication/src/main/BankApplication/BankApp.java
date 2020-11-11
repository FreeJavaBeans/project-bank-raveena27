package com.revature.BankApplication;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.BankAccount.BankAccount;
import com.revature.log.Logging;
import com.revature.login.BankLogin;
import com.revature.login.DBLogin;
import com.revature.newaccount.CustNewAccount;

public class BankApp {

	public static void main(String[] args) throws SQLException {

		DBLogin cu = DBLogin.getDBLogin();

		Connection conn = cu.getConnection();

		if (conn != null && !conn.isClosed()) {
			System.out.println("DB connected !!");
			
			System.out.println("WELCOME TO BANK");
			
                       	String input;
			    
				System.out.println("please enter an option for ");
				System.out.println("   1. login as existing Customer ");
				System.out.println("   2. Create new account  ");
				
				Scanner s = new Scanner(System.in);
				System.out.println("enter option : ");
				 input = s.nextLine();
				
				
			    	switch (Integer.parseInt(input)) {
			    	
					case 1: login(); 
						break;
							
					case 2: System.out.println("please create a new Account ");
							CustNewAccount obj3 = new CustNewAccount();
							obj3.CustNewAccount();
							break;
					 
					default:
						System.out.println("Exiting the Menu .. ");
						System.exit(0);
						}
						
			    	}

		}
		
		
	}
	static void login() throws SQLException {

							Customer cust = new Customer();
							BankLogin obj1 = new BankLogin();
		
							boolean loginSu = obj1.BankLogin(cust);
		
							if (loginSu == true) {

								System.out.println("welcome.. ");

								BankAccount obj2 = new BankAccount();
								obj2.menu(cust);

							} else {

								//System.out.println("no such account available.");
								System.out.println("invalid details ");
								
							}
						}

}
