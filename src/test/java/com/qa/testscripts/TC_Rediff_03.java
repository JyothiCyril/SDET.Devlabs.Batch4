package com.qa.testscripts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.qa.pages.RediffPages;

public class TC_Rediff_03 extends TestBase{
	
	@Test
	public void workingWithMultipleWindows() {
		
		RediffOR = new RediffPages(driver);
		
		RediffOR.getCreateAccountLink().click();
		
		RediffOR.getTandCLink().click(); // 2nd window
		RediffOR.getPrivacyLink().click(); // 3rd window
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		Iterator<String> iter = windowHandles.iterator();
		
		while(iter.hasNext()) {
			String windId = iter.next();
			WebDriver window = driver.switchTo().window(windId);
			Reporter.log(window.getTitle());
			Reporter.log("*************************");
			List<WebElement> elements = window.findElements(By.tagName("a"));
			for(WebElement ele: elements) {
				
				Reporter.log(ele.getText());
			}
		}
		
	}

}
