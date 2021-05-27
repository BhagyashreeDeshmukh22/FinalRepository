package com.CRM.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.CRM.Pages.BaseClass;
import com.CRM.Pages.LoginPage;
import com.CRM.Utilities.BrowserFactory;
import com.CRM.Utilities.Helper;

public class LoginTestCRM extends BaseClass{
	 
	 @Test
	 public void loginApp()
	 {
		logger=report.createTest("Login to CRM");
		LoginPage login=PageFactory.initElements(ldriver,LoginPage.class);
		logger.info("Starting application");
		login.loginToCRM(excel.getStringData("LoginDetails", 0, 0),excel.getStringData("LoginDetails",0,1));
		logger.pass("Login Successful");

		Helper.Capturescreenshot(ldriver);//now this will capture screenshot when our test get pass but we want to take screenshot on fail test case as well
		 Reporter.log("TestCase completed", true);
	 }
}
