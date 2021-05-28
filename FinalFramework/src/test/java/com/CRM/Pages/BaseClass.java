package com.CRM.Pages;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.CRM.Utilities.BrowserFactory;
import com.CRM.Utilities.ConfigDataProvider;
import com.CRM.Utilities.ExcelDataProvider;
import com.CRM.Utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BaseClass {
	public WebDriver ldriver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	/*@BeforeClass             (without using parameters)
	public void setup()
	{
		 Reporter.log("Setting up Browsers and app url", true);
		ldriver=BrowserFactory.startApp(config.getBrowser(),config.getURL(), ldriver);
		 
		
		Reporter.log("Setting done and Browser has launched and Application is strat", true);
	}*/
	
	@Parameters({"browser","TestingUrl"})
	@BeforeClass             
	public void setup(String browser,String url)
	{
		 Reporter.log("Setting up Browsers and app url", true);
		ldriver=BrowserFactory.startApp(browser,url, ldriver);
		 
		
		Reporter.log("Setting done and Browser has launched and Application is strat", true);
	}
	@AfterClass
	public void teardown()
	{
		BrowserFactory.quitBrowser(ldriver);
		 Reporter.log("Browser has closed", true);
	}
	@BeforeSuite
	public void setupSuite()
	{

		 Reporter.log("Setting up reports and Test is getting started", true);
		excel=new ExcelDataProvider();
		config =new ConfigDataProvider();
		 ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Report1_"+Helper.getCurrentDateTime()+".html"));
		// ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Report1.html"));
		 report=new ExtentReports();
		 report.attachReporter(extent);
		 Reporter.log("Setting  done and Test get Started", true);
	}
	
	@AfterMethod
	public void teardownmethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to end and creating report internally", true);
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Fails",MediaEntityBuilder.createScreenCaptureFromPath(Helper.Capturescreenshot(ldriver)).build());
			//Helper.Capturescreenshot(ldriver);
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Pass",MediaEntityBuilder.createScreenCaptureFromPath(Helper.Capturescreenshot(ldriver)).build());
		}
	report.flush();
	 Reporter.log(" Test Completed >>>Reports Generated", true);
	}
	
}
