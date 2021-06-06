package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

public class TC_Amazon_01 extends TestBase {
	

	@Test(dataProvider="getData")
	public void SearchItem(String Category, String ItemName) throws IOException {
		
		
		AmazonOR.getCategory().selectByVisibleText(Category); // 1st field
		AmazonOR.getSearchTextField().clear();
		AmazonOR.getSearchTextField().sendKeys(ItemName); // 2nd field
		AmazonOR.getSearchButton().click();
		
		String title = driver.getTitle();
		if(title.contains(ItemName)) {
		//	captureScreenshot(driver,"SearchItem");
			Reporter.log("Title has the search term",true);
			Assert.assertTrue(true);
			
		}else {
			captureScreenshot(driver,"SearchItem");
			Reporter.log("Title do not have the search term",true);
			Assert.assertTrue(false);
		}			

	}
	
	
	@DataProvider
	public String[][] getData() throws IOException{
		
		String xFile="D:\\Devlabs\\Batch 3\\SeleniumTraining\\SDET.Devlabs.Batch4\\src\\test\\java\\com\\qa\\testdata\\InputData.xlsx";
		String xSheet="Sheet1";
		
		int rowCount = ExcelUtility.getRowCount(xFile, xSheet);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheet, rowCount);
		
		String data[][] = new String[rowCount][cellCount];
		
		for(int i=1; i<=rowCount; i++) {
			
			for(int j=0; j<cellCount; j++) {
				data[i-1][j]=ExcelUtility.getCellData(xFile, xSheet, i, j);
			}
			
		}
				
		return data;
		
	}
	
	
	/*
	 * @DataProvider public Object[][] getData() {
	 * 
	 * Object[][] data = new Object[3][2];
	 * 
	 * // 1 st field
	 * 
	 * data[0][0] = "Books"; data[1][0] = "Electronics"; data[2][0] = "Furniture";
	 * 
	 * // 2nd field data[0][1] = "Da vinci code"; data[1][1] = "Washing machines";
	 * data[2][1] = "Wooden tables";
	 * 
	 * return data;
	 * 
	 * 
	 * 
	 * }
	 */

}
