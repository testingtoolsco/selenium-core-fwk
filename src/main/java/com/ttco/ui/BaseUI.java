package com.ttco.ui;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUI 
{
	BaseObject obj;
	WebElement currElement;
	Browser browser;
	
	public BaseUI(Browser browser)
	{
		this.browser = browser;
	}
	
	public BaseUI element(BaseObject obj)
	{
		this.obj = obj;
		return this;
	}
	
	public String getAttributeValue(String attr) throws Exception
	{
		obj.setData(attr);
		obj.setActionToPerform(BaseObject.action.GET_ATTRIBUTE);	
		String attrValue = ele().getAttribute(attr);
		
		System.out.println(obj.getExecutionInfo());
		return attrValue;		
	}		
	
	public String getText() throws Exception
	{
		obj.setActionToPerform(BaseObject.action.GET_VALUE);		
		String ret = ele().getText();
		obj.setValue(ret);

		System.out.println(obj.getExecutionInfo());
		return ret;		
	}	
	
	public void setText(String data) throws Exception
	{
		setText(data,true);
	}
	public void setTextWithoutTab(String data) throws Exception
	{
		setText(data,false);
	}	
	public void setText(String data,boolean tab) throws Exception
	{
		obj.setData(data);
		obj.setActionToPerform(BaseObject.action.SET_TEXT);
		
		ele().clear();
		ele().sendKeys(data);		
		if(tab)
			ele().sendKeys(Keys.TAB);
		System.out.println(obj.getExecutionInfo());
			
	}
	
	public void click() throws Exception
	{
		obj.setActionToPerform(BaseObject.action.CLICK);
		waitFor();
		ele().click();	
		System.out.println(obj.getExecutionInfo());
		waitForPage();
	}	
	
	public WebElement ele() throws Exception
	{
		WebElement element = null;
		if(obj.getOcc()>1)
		{
			List<WebElement> eles = browser.dr.findElements(obj.getBy());
			if(eles.size()>1)
			{
				element = eles.get(obj.getOcc()-1);
			}
		}	
		else
			element = browser.dr.findElement(obj.getBy());

		return element;
	}
	
	public boolean waitFor() throws Exception
	{
		boolean ret = true;
		try
		{
			WebDriverWait wait = new WebDriverWait(browser.dr, 15);
			wait.until(ExpectedConditions.elementToBeClickable(ele()));
		}
		catch(Exception e)
		{
			ret = false;		
			throw e;
		}
		return ret;
	}
	
	
	public void waitForPage()
	{
		ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() 
				{
                    public Boolean apply(WebDriver driver) 
                    {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try 
        {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(browser.dr, 30);
            wait.until(expectation);
        } 
        catch (Throwable error) 
        {
            System.err.println("Timeout waiting for Page Load Request to complete.");
        }		
	}
	
	public void launch(String url)
	{
		if(browser.dr!=null)
		{
			browser.dr.manage().window().maximize();
			browser.dr.get(url);		
			waitForPage();
		}
	}
	
	public void quit()
	{
		if(browser.dr!=null)
			browser.dr.quit();
	}
	
	public void close()
	{
		if(browser.dr!=null)
			browser.dr.close();
	}
		
}