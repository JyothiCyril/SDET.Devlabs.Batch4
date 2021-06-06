package com.qa.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotationDemo {
	
	
	
	
	@BeforeClass
	public void Login() {
		System.out.println("Login Action");
	}
	
	@AfterClass
	public void Logout() {
		System.out.println("Logout Action");
	}
	
	
	@Test(priority=1, groups="Payments", invocationCount=3)
	public void FundTransfer() {
		Reporter.log("Fund Transfer",true);
		//Assert.assertTrue(false);
	}
	
	@Test(priority=2, groups="Payments", dependsOnMethods="FundTransfer")
	public void UtilityBillPayment() {
		Reporter.log("Utility Bill Payment",true);
	}
	
	@Test(priority=3, groups="Payments", enabled=false)
	public void CCBillPayment() {
		Reporter.log("Credit card Bill Payment",true);
	}
	
	
	@BeforeTest
	public void LauchBrowser() {
		System.out.println("Invoke the Browser");
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("Close the browser instance");
	}
	
	@BeforeMethod // Runs before @Test method
	public void CheckBalance() {
		System.out.println("Check the balance");
	}
	
	@AfterMethod // Execute upon successful completion of @Test method
	public void Acknowledgement() {
		System.out.println("Print Acknowledgement");
	}
	
	
	@Test(priority=4, groups="Insurance")
	public void VehicleInsurance() {
		Reporter.log("Pay vehicle insurance",true);
	}

	@Test(priority=5, groups="Insurance")
	public void HealthInsurance() {
		Reporter.log("Pay Health Insurance",true);
	}
}
