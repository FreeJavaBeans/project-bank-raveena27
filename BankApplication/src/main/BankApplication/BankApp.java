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

		// Logger logger = LogManager.getLogger("com.revature.BankApplication");
		// logger.debug("this is a test");
		//Logging.loggerInfo("transaction is started");
		// Thread.currentThread().getStackTrace();

		Connection conn = cu.getConnection();

		if (conn != null && !conn.isClosed()) {
			System.out.println("DB connected !!");
                       Customer cust = new Customer();
			BankLogin obj1 = new BankLogin();

			boolean loginSu = obj1.BankLogin(cust);

			if (loginSu == true) {

				System.out.println("welcome.. ");

				BankAccount obj2 = new BankAccount();
				obj2.menu(cust);

			} else {

				System.out.println("no such account available.");
				System.out.println("please create a new Account ");
				CustNewAccount obj3 = new CustNewAccount();
				obj3.CustNewAccount();

			}

		}
	}

}
