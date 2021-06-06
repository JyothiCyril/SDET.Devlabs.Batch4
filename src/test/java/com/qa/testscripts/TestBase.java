package com.qa.testscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.pages.AmazonPages;
import com.qa.pages.RediffPages;

public class TestBase {

	WebDriver driver;
	AmazonPages AmazonOR;
	RediffPages RediffOR;


	@Parameters({"Browser","Url"})
	@BeforeClass
	public void setUp(String Browser,String Url) {
		// loc for pre-conditions
		if(Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium Software\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		}else if(Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium Software\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}else if(Browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "D:\\Selenium Software\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if(Browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "D:\\Selenium Software\\Drivers\\msedgedriver1.exe");
			driver = new EdgeDriver();

		}

		AmazonOR = new AmazonPages(driver);
		driver.manage().window().maximize();
		driver.get(Url);


	}

	@AfterClass
	public void tearDown() {
		// loc for post conditions
		driver.quit();
	}


	public void captureScreenshot(WebDriver driver, String tname) throws IOException {

		TakesScreenshot tScreenshot = (TakesScreenshot) driver; 
		File Source = tScreenshot.getScreenshotAs(OutputType.FILE);
		String Destination = System.getProperty("user.dir")+"/Screenshots/"+ tname + ".png";
		FileUtils.copyFile(Source, new File(Destination));

	}

}
