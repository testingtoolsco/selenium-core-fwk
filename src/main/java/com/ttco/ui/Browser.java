package com.ttco.ui;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser 
{
	
	public static enum type {CHROME,FIREFOX,IE,EDGE};
	
	type browserType = type.CHROME;
	WebDriver dr;	
	
	// default constructor, which means browserName is chrome 
	// also default browser settings are intialized and web driver object is created
	public Browser()
	{
		init(null);
	}
	
	//constructor to set the default 
	// if empty string or null is passed by default the browser will be chrome
	public Browser(type browserType,HashMap properties)
	{
		if(browserType != null && !browserType.equals("") )		
			this.browserType = browserType;		
		
		init(properties);
	}
	
	// initializes the web driver with any specific capabilities or other settings for web driver
	// if null is passed then a default set of properties and capabilities will be set as per this framework
	public void init(HashMap properties)
	{		
		switch(browserType)
		{
			case CHROME:
				WebDriverManager.chromedriver().setup();
				dr = new ChromeDriver();
				break;
			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				dr = new FirefoxDriver();
				break;
			case EDGE:
				WebDriverManager.edgedriver().setup();
				dr = new EdgeDriver();
				break;
			case IE:
				WebDriverManager.iedriver().setup();
				dr = new InternetExplorerDriver();
				break;

			default:
				WebDriverManager.chromedriver().setup();
				dr = new ChromeDriver();				
				break;
			
		}

		if(properties!=null && properties.size()>0)
		{
			// we will write code here for handling properties
		}
		else
		{
			// default settings will come here if there are no properties passed
		}
	}
	
	public void launch(String url)
	{
		if(dr!=null)
			dr.get(url);
	}
	
	public void quit()
	{
		if(dr!=null)
			dr.quit();
	}
	
	public void close()
	{
		if(dr!=null)
			dr.close();
	}
}
