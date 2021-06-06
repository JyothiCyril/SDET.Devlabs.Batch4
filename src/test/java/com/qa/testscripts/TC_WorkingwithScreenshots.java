package com.qa.testscripts;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TC_WorkingwithScreenshots {

	
WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Software\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");	
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void WebElementScreenshot() throws IOException {
		
		File Source = driver.findElement(By.id("nav-logo-sprites")).getScreenshotAs(OutputType.FILE);
		
		String Destination = System.getProperty("user.dir")+"/Screenshots/"+ "Amazonlogo.png";
		
		FileUtils.copyFile(Source, new File(Destination));
		
	}
	
	@Test(priority=2)
	public void DriverScreenShot() throws IOException {
		
		TakesScreenshot tScreenshot = (TakesScreenshot) driver; 
		
		File Source = tScreenshot.getScreenshotAs(OutputType.FILE);
		
		String Destination = System.getProperty("user.dir")+"/Screenshots/"+ "AmazonDriverPage.png";
		
		FileUtils.copyFile(Source, new File(Destination));
		
		
		
	}
	
	@Test(priority=3)
	public void PageScreenShot() throws IOException {
		String Screenshotname = "AmazonFullPage";
		
		AShot SShot = new AShot(); 
		Screenshot takeScreenshot = SShot.shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(driver);
		
		String Destination = System.getProperty("user.dir")+"/Screenshots/"+ Screenshotname+".jpg";		
		
		 
		ImageIO.write(takeScreenshot.getImage(), "jpg" , new File(Destination));
	}
	
}
