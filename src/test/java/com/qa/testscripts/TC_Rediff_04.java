package com.qa.testscripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.qa.pages.RediffPages;

public class TC_Rediff_04 extends TestBase{
	
	
	@Test
	public void WorkingWithPopUpWindow() throws InterruptedException {
		
		RediffOR = new RediffPages(driver);
		
		RediffOR.getCreateAccountLink().click();
		
		RediffOR.getFullNameTextField().sendKeys("1234657");
		RediffOR.getFullNameTextField().sendKeys(Keys.TAB); // tab key will pressed
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		Reporter.log(alert.getText());
		
		alert.accept();
		Thread.sleep(2000);
		RediffOR.getFullNameTextField().clear();
		Thread.sleep(2000);
		RediffOR.getFullNameTextField().sendKeys("smith");
		Thread.sleep(2000);
		RediffOR.getEmailIDTextField().sendKeys("test@test.com");
		
		
	}

}
