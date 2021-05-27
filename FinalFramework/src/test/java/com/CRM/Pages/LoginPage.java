package com.CRM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	@FindBy(css="a[class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")WebElement loginorange;
	@FindBy(name="email") WebElement emailid;
	@FindBy(name="password") WebElement password;
	@FindBy(css="div[class='ui fluid large blue submit button']") WebElement loginblue;
	
	public void loginToCRM(String emailidapp,String passwordapp)
	{
		loginorange.click();
		emailid.sendKeys(emailidapp);
		password.sendKeys(passwordapp);
		loginblue.click();
	}
}


