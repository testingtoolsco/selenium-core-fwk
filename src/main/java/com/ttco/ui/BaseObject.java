package com.ttco.ui;

import org.openqa.selenium.By;

public class BaseObject 
{
	String label;
	String xpath;
	String id, name;
	String linkText,partialLinkText;
	type uiType;
	action actionToPerform;
	int occ; 
	String data,value;
	
	public static enum type {
								TEXT_BOX, 
								CHECK_BOX, 
								LINK, 
								IMAGE, 
								TEXT_AREA, 
								DROP_DOWN, 
								RADIO_BUTTON
							};
							
	public static enum action {
								CLICK,
								SET_TEXT,
								GET_TEXT,
								SELECT_OPTION,
								SELECT_OPTION_BY_INDEX,
								SELECT_OPTION_BY_VALUE,
								GET_OPTION_BY_VALUE,
								GET_OPTION_BY_INDEX,
								GET_SELECTED_OPTION,
								GET_VALUE
								};
	
	public By getBy()
	{
		By by = null;
		
		if(xpath!=null && !xpath.equals(""))
			by = By.xpath(xpath);
		
		else if(name!=null && !name.equals(""))
			by = By.name(name);
		
		else if(id!=null && !id.equals(""))
			by = By.id(id);
		
		else if(linkText!=null && !linkText.equals(""))
			by = By.linkText(linkText);
		
		else if(partialLinkText!=null && !partialLinkText.equals(""))
			by = By.partialLinkText(partialLinkText);
		
		return by;
	}
	
	public String getType()
	{
		String ret = "";
		switch(uiType)
		{
			case TEXT_BOX:
				ret = "Text Box";
				break;
				
			case CHECK_BOX:
				ret = "Check Box";
				break;
			case LINK:
				ret = "Link";
				break;
			case IMAGE:
				ret = "Image";
				break;
			case TEXT_AREA:
				ret = "Text Area";
				break;
			case DROP_DOWN:
				ret = "Drop Down";
				break;
			case RADIO_BUTTON:
				ret = "Radio Button";
				break;
			default:
				break;
		}
		return ret;
	}
	
	public String getExecutionInfo()
	{
		String ret = "";
		
		switch(actionToPerform)
		{
			case CLICK:
				ret = "Clicked \"" + label  + "\" " + getType(); 
				break;
			case SET_TEXT:
				ret = "Entered text \"" + data  + "\" in " + "\"" +label+ "\" " + getType();
				break;
			case GET_TEXT:
				ret = "Captured text \"" + value  + "\" from  \"" + label + "\" " + getType();
				break;
			case SELECT_OPTION:
				ret = "Selected option \"" + data  + "\" from  \"" + label + "\" " + getType();
				break;
			case SELECT_OPTION_BY_INDEX:
				ret = "Selected option  \" from  \"" + label + "\" " + getType() + " using index \"" + data + "\"";
				break;				
			case SELECT_OPTION_BY_VALUE:
				ret = "Selected option \" from  \"" + label + "\" " + getType() + " using value \"" + data + "\"" ;
				break;				
			case GET_OPTION_BY_VALUE:
				ret = "Captured option\'s text \""+value+"\" from  \"" + label + "\" " + getType() + " using value \"" + data + "\"";
				break;
			case GET_OPTION_BY_INDEX:
				ret = "Captured option\'s text \""+value+"\" from  \"" + label + "\" " + getType() + " using index \"" + data + "\"";
				break;
			case GET_SELECTED_OPTION:
				ret = "Captured selected option \""+value+"\" from  \"" + label + "\" " + getType();				
				break;
			case GET_VALUE:
				ret = "Captured \""+value+"\" from  \"" + label + "\" " + getType();
				break;				
			default:
				break;
		}
				
		return ret;
	}
}
