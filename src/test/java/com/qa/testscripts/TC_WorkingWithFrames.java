package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_WorkingWithFrames {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Software\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://docs.oracle.com/javase/7/docs/api/");	
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void frameByIndex() {
		
		List<WebElement> frames = driver.findElements(By.tagName("frame"));
		
		int size = frames.size();		
		System.out.println("Total no. of frames present on the page are : " + size );
		
		
		for(int i=0;i<size;i++) {
			
			WebDriver frame = driver.switchTo().frame(i); // frame with index 0
			String title = frame.getTitle();
			List<WebElement> links = frame.findElements(By.tagName("a"));
			
			
			System.out.println("Total no. of hyper links present on the " + title + " are : " + links.size());
			
			driver.switchTo().defaultContent(); // from frame to the driver			
			
		}
		
		
	}
	
	@Test(priority=2)
	public void frameByName() {
		
		
		WebDriver frame = driver.switchTo().frame("packageListFrame");
		
		String title = frame.getTitle();
		Reporter.log(title,true);
		List<WebElement> links = frame.findElements(By.tagName("a"));
		for(WebElement link:links) {
			Reporter.log(link.getText(),true);
		}
		
		
	}
	
	@Test(priority=3)
	public void frameByElement() {
		
		WebElement ele = driver.findElement(By.name("classFrame"));
		
		WebDriver frame = driver.switchTo().frame(ele);
		
		String title = frame.getTitle();
		Reporter.log(title,true);
		
		List<WebElement> links = frame.findElements(By.tagName("a"));
		for(WebElement link:links) {
			Reporter.log(link.getText(),true);
		}

		
	}

}
