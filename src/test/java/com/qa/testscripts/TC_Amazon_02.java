package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.AmazonPages;

public class TC_Amazon_02 extends TestBase{

	@Test
	public void CalculateFooterLinks() throws IOException {


		List<WebElement> footerLinks = AmazonOR.getFooterLinks();
		int size = footerLinks.size();
		System.out.println("Total no. of links present on the footer section of the page is : " + size);

		boolean condition = size>50;

		if(condition) {
			Assert.assertTrue(true); // execution stops if the condition is mismatched


			for(WebElement link: footerLinks) {
				System.out.println(link.getText());
			}

		}else
		{
			captureScreenshot(driver,"CalculateFooterLinks");
			Assert.assertTrue(false); // execution stops if the condition is mismatched

		}



	}

}
