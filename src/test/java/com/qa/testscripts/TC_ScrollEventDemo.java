package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_ScrollEventDemo {


	WebDriver driver;
	JavascriptExecutor Js;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Software\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");	
		Js = (JavascriptExecutor) driver;

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
	
	
	@Test(priority = 1, enabled=false)
	public void workingwithScorllbar() throws InterruptedException {
		
		
		
		for(int i=0;i<=5;i++) {
			Js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(2000);
		}
		
		Thread.sleep(5000);
		
		for(int i=5;i>=1;i--) {
			Js.executeScript("window.scrollBy(0,-500)");
			Thread.sleep(2000);
		}
		

	}
	
	@Test(priority = 2)
	public void scrollinElementview() throws InterruptedException {
		
		WebElement ele = driver.findElement(By.linkText("Careers"));
		Js.executeScript("arguments[0].scrollIntoView()",ele);
		
		Thread.sleep(5000);
		ele.click();
		
		
		
	}



}
