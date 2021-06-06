package com.qa.testscripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverIntroduction {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;
		String Browser = "chrome";

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
			System.setProperty("webdriver.edge.driver", "D:\\Selenium Software\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();

		}

		driver.get("https://www.amazon.in/"); // Load the URL on the browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		// elements present on the page
		// searchcontext interface
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("da vinci code");
		Thread.sleep(2000);
		
		
		
		driver.navigate().to("https://www.google.com/");
		
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int size = allLinks.size();
		System.out.println("Total no. of links present on the page are : " + size);
		
		driver.navigate().back(); //amazon
		
		driver.navigate().forward(); // google
		
		String title = driver.getTitle();  // fetch and return the title of the page in the string.
		System.out.println(title);
		
		
		String currentUrl = driver.getCurrentUrl(); // URL of the page at run session --> String
		System.out.println(currentUrl);
		
		
		String windowHandle = driver.getWindowHandle(); // return the window id of the current browser instance
		System.out.println(windowHandle);
		//driver.getWindowHandles(); // return the window id's of all/multiple  browser instances that were opened
		
//		String pageSource = driver.getPageSource(); // Return HTML design of the page into a String.
//		System.out.println(pageSource);
	//	driver.switchTo().window(windowHandle); // tab / window
		
	//	driver.switchTo().alert(); // Javascript alert
		
	//	driver.switchTo().frame(0); // frame id / name /webelements
		
		
		driver.close(); // closes only the current window
		
		//driver.quit(); // closes the current browser along with other tabs / window / pop up will be closed

		







	}

}
