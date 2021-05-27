package com.CRM.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	
	public  ConfigDataProvider()
	{
		File src=new File("./Configuration/config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
		} catch (IOException e) {
		System.out.println("File not Exist"+e.getMessage());
		}
	}
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	public String getURL()
	{
		return pro.getProperty("Openurl");
	}
	public String getDataFromConfig(String key)
	{
		return pro.getProperty(key);
	}

}
