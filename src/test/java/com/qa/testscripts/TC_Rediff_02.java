package com.qa.testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.RediffPages;

public class TC_Rediff_02 extends TestBase{
	
	@Test
	public void Login() throws IOException, InterruptedException {
		RediffOR = new RediffPages(driver);
		SoftAssert SAssert = new SoftAssert();
		FileInputStream fileLoc = new FileInputStream("D:\\Devlabs\\Batch 3\\SeleniumTraining\\SDET.Devlabs.Batch4\\src\\test\\java\\com\\qa\\testdata\\TestData.properties");
		Properties prop = new Properties();
		prop.load(fileLoc);
		
		RediffOR.getSigninLink().click();
		
		boolean currentUrl = driver.getCurrentUrl().contains("login");
		SAssert.assertEquals(currentUrl, true);
		Reporter.log("The user is on login page",true);
		
		boolean UName = RediffOR.getUserNameTextField().isDisplayed();
		SAssert.assertEquals(UName, true);
		RediffOR.getUserNameTextField().sendKeys(prop.getProperty("Uname"));
		Thread.sleep(2000);
		
		boolean Pwd = RediffOR.getPasswordTextField().isDisplayed();
		SAssert.assertEquals(Pwd, true);
		RediffOR.getPasswordTextField().sendKeys(prop.getProperty("Pwd"));
		Thread.sleep(2000);
		
		Reporter.log("The username and password field are present on the Login page",true);	
		
		boolean selected = RediffOR.getStaySignInChkbox().isSelected();
		SAssert.assertEquals(selected, false); // Keep me signed in should be deselected by default
		Reporter.log("The check box is selected by default",true);		
		RediffOR.getStaySignInChkbox().click();
		
		boolean selected1 = RediffOR.getStaySignInChkbox().isSelected(); // Upon click the check box should get selected.
		SAssert.assertEquals(selected1, false);
		
		boolean enabled = RediffOR.getSignInBtn().isEnabled();
		SAssert.assertEquals(enabled, true);
		RediffOR.getSignInBtn().click();
		Reporter.log("The SignIn button is enable by default",true);	
		
		SAssert.assertAll();
	}

}
