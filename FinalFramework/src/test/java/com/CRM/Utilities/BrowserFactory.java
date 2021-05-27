package com.CRM.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	public static WebDriver startApp(String browser,String app_url,WebDriver ldriver)
	{
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver" , "./Drivers/chromedriver1.exe");
			ldriver=new ChromeDriver();
			ldriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		else if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver" , "./Drivers/geckodriver.exe");
			ldriver=new FirefoxDriver();
			ldriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.gecko.driver" , "./Drivers/msedgedriver.exe");
			ldriver=new EdgeDriver();
			ldriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		else
		{
			System.out.println("Didnot support this browser");
		}
		ldriver.manage().window().maximize();
		ldriver.get(app_url);
		ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return ldriver;	
		
	}
	public static void quitBrowser(WebDriver ldriver)
	{
		ldriver.quit();
	}


}
 