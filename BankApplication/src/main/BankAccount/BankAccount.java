package com.revature.BankAccount;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.CustomerDetails.Customer;
import com.revature.CustomerDetails.CustomerBalance;
import com.revature.CustomerDetails.CustomerDeposits;
import com.revature.CustomerDetails.CustomerMoneyTransfer;
import com.revature.CustomerDetails.CustomerWithdraw;
import com.revature.login.DBLogin;

public class BankAccount {
	
	
	public DBLogin cu = DBLogin.getDBLogin();
	
	Scanner s = new Scanner(System.in);
	
	public void menu(Customer cust) throws SQLException {
		
		char option;
			
		Scanner s = new Scanner(System.in);
		
		
		Connection conn = cu.getConnection();
		
		
			System.out.println("please enter an option");
			System.out.println("A.Check Balance");
			System.out.println("B.Deposit");
			System.out.println("C.withdraw");
			System.out.println("D.Transfer money");
			System.out.println("E.EXIT");
			
			do
			{
				System.out.println("please enter an option :");
				
				option = s.next().toUpperCase().charAt(0);
				System.out.println("\n");
				switch(option) 
				{
				case 'A':
					CustomerBalance obj1 = new CustomerBalance();
					obj1.getCustBalance(cust);
					System.out.println("\n");
					break;
					
				case 'B':
					System.out.println("enter amount to deposit :");
					int amount = s.nextInt();
					CustomerDeposits obj2 = new CustomerDeposits();				
					obj2.deposit(cust,amount);
					System.out.println("\n");	
					break;
					
				case 'C':
					System.out.println("enter amount to withdraw :");
					int amount2 = s.nextInt();
					CustomerWithdraw obj3 = new CustomerWithdraw();
					obj3.withdraw(cust,amount2);
					System.out.println("\n");	
					break;
				case 'D':
					System.out.println("enter money to transfer:");
					int amount3 = s.nextInt();
					CustomerMoneyTransfer obj4 = new CustomerMoneyTransfer();
					obj4.moneytransfer(cust,amount3);
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
			
			
		
		
	
	
	


