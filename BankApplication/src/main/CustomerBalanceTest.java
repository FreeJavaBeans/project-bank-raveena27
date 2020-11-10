package com.revature.CustomerDetails;

import junit.framework.TestCase;

//purpose is to test customer balance

public class CustomerBalanceTest extends TestCase {
	
	CustomerBalance testBalance;
	
	public void setUp() throws Exception 
	{
		testBalance = new CustomerBalance();
	}
			
	public void testSetBalance()
	{
		Customer cust = new Customer();
		cust.setFirstname("pam");
		cust.setAccountID(1);
		
		assertEquals(testBalance.getCustBalance(cust), 5000);
	}

	
	
}
