package com.revature.CustomerDetails;

import java.sql.Connection;
import java.util.Scanner;

import com.revature.login.DBLogin;

public class CustomerPreviousTransactions {
	
	public void getprevioustransaction()
	{
		DBLogin cu = DBLogin.getDBLogin();
		Connection conn = cu.getConnection();
		Scanner s = new Scanner(System.in);
		
		
		int previoustransaction=0;
		
		
		if(previoustransaction > 0) {
			
			
			System.out.println("Deposited :" + previoustransaction);
		}
		else if(previoustransaction <0) {
			System.out.println("withdrawn amount :"+previoustransaction);
		}else {
			System.out.println("no transaction occured");
		}

}
}