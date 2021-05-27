package com.CRM.Utilities;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String Capturescreenshot(WebDriver ldriver)
	{  
		String ScreenshotPath=System.getProperty("user.dir")+"/Screenshots/Framework_screenshot_"+getCurrentDateTime()+".png";
		File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
		
	try {
		FileHandler.copy(src,new File(ScreenshotPath));
		System.out.println("Screenshot Captured");
	} catch (IOException e) {
		System.out.println("Unable to load screenshot"+e.getMessage());
	}
	return ScreenshotPath;
	}
	
	public static String getCurrentDateTime() {
		DateFormat currentformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return currentformat.format(currentDate);
	}
}
