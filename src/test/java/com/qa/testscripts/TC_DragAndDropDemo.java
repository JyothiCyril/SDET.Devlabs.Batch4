package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_DragAndDropDemo {
	
WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Software\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");	
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void DemoDragDrop() throws InterruptedException {
		
		driver.switchTo().frame(0);
		
		WebElement DragEle = driver.findElement(By.xpath("//p[contains(text(),'Drag me to my target')]"));
		
		WebElement DropEle = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(DragEle, DropEle).build().perform();
		
		Thread.sleep(5000);
		
	}
	
	

}
