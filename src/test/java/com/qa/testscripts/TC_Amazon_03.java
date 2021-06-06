package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Amazon_03 extends TestBase{
	
	
	@Test(priority=1)
	public void validateCategoryList() {
		
		
		// total no. of options present in th drop down list.
		List<WebElement> options = AmazonOR.getCategory().getOptions(); // get all the options present in the drop down // each items is an element,
		
		int size = options.size();
		System.out.println("Total no. of options present in the category list box are : " +  size);
		for(WebElement option:options) {
			Reporter.log(option.getText());
			
		}
		
	}

	@Test(priority=2)
	public void getFirstSelectedOption() {
		
		WebElement firstSelectedOption = AmazonOR.getCategory().getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		Reporter.log(text);
		Assert.assertEquals(text, "All Categories");		
	}
	
	
	
	
}
