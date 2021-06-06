package com.qa.testscripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_AmazonActionDemo_04 extends TestBase{
	
	
	@Test
	public void AmazonRegistration() throws InterruptedException {
		
		
		WebElement accountandLists = AmazonOR.getAccountandLists();
		
		Actions act = new Actions(driver);
		act.moveToElement(accountandLists).build().perform();
		
		Thread.sleep(5000);
		AmazonOR.getRegistrationLink().click();
		
		Thread.sleep(5000);
		
		String title = driver.getTitle();
		if(title.contains("Registration")) {
			Reporter.log("The user is on Registration page",true);
		}else {
			Reporter.log("The user is not on Registration page",true);
		}
		
	}

}
