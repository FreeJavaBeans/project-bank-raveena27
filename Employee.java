package com.revature.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import com.revature.login.DBLogin;

public class Employee {
	
	public static void main(String[] args) throws SQLException {

		DBLogin cu = DBLogin.getDBLogin();
	   
		Connection conn = cu.getConnection();

		if (conn != null && !conn.isClosed()) {
			System.out.println("DB connected !!");

			EmpLogin obj = new EmpLogin();

			boolean loginSu = obj.EmpLogin();

			if (loginSu == true) {

				System.out.println(" welcome ");
				
				EmpOptions obj1 = new EmpOptions();
				obj1.menu();

 			} else {

				System.out.println("no such employee available.");

			}

		}
	}

}
