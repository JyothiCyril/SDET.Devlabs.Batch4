package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {


	ExtentHtmlReporter htmlReporter;
	ExtentReports xReport;
	ExtentTest xTest;




	public void onStart(ITestContext testContext) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-execution-report" + timeStamp + ".html";

		String dest = System.getProperty("user.dir")+ "/Reports/"+ repName;


		htmlReporter = new ExtentHtmlReporter(dest);

		htmlReporter.config().setDocumentTitle("Automation Testing");
		htmlReporter.config().setReportName("Functional Testing");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setAutoCreateRelativePathMedia(true);

		xReport= new ExtentReports();
		xReport.attachReporter(htmlReporter);
		xReport.setSystemInfo("Hostname", "localhost");
		xReport.setSystemInfo("OS", "Windows");
		xReport.setSystemInfo("QA Name", "Jyothi");

	}


	public void onFinish(ITestContext testContext) {	  
		xReport.flush();

	}



	public void onTestSuccess(ITestResult tr) {
		xTest = xReport.createTest(tr.getName());
		xTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		xTest.log(Status.PASS, "Test is Passed");
		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + tr.getName()+ ".png";

		File file = new File(screenshotPath);
		if(file.exists()) {
			try {
				xTest.pass("Screenshot for the test passed is :"  +  xTest.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}


	}


	public void onTestFailure(ITestResult tr) {
		xTest = xReport.createTest(tr.getName());
		xTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		xTest.log(Status.FAIL, "Test is Failed");
		xTest.log(Status.FAIL, tr.getThrowable());

		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + tr.getName()+ ".png";

		File file = new File(screenshotPath);
		if(file.exists()) {
			try {
				xTest.fail("Screenshot for the test failed is :"  +  xTest.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}



	}


	public void onTestSkipped(ITestResult tr) {
		xTest = xReport.createTest(tr.getName());
		xTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
		xTest.log(Status.SKIP, "Test is Skipped");

	}


}
