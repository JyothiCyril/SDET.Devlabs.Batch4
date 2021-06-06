package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.qa.pages.RediffPages;

public class TC_Rediff_01 extends TestBase{

	
	@Test
	public void registration() {
		RediffOR = new RediffPages(driver);
			
		RediffOR.getCreateAccountLink().click();
		
		
		boolean contains = driver.getCurrentUrl().contains("register");
		
		if(contains) {
			System.out.println("The user is landed on registration page");
			
			RediffOR.getFullNameTextField().sendKeys("Kim Smith");			
			RediffOR.getEmailIDTextField().sendKeys("smith@test.com");			
			RediffOR.getCheckAvailablityButton().click();
			
		}else {
			System.out.println("The user is not landed on registration page");
		}
			
		
		

	}

}
