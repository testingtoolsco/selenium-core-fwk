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
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLinkText() {
		return linkText;
	}

	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	public String getPartialLinkText() {
		return partialLinkText;
	}

	public void setPartialLinkText(String partialLinkText) {
		this.partialLinkText = partialLinkText;
	}

	public type getUiType() {
		return uiType;
	}

	public void setUiType(type uiType) {
		this.uiType = uiType;
	}

	public action getActionToPerform() {
		return actionToPerform;
	}

	public void setActionToPerform(action actionToPerform) {
		this.actionToPerform = actionToPerform;
	}

	public int getOcc() {
		return occ;
	}

	public void setOcc(int occ) {
		this.occ = occ;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
	public BaseObject(Builder builder)
	{
		this.label = builder.label;
		this.xpath = builder.xpath;
		this.id    = builder.id;
		this.name  = builder.name;
		this.linkText 			= builder.linkText;
		this.partialLinkText 	= builder.partialLinkText;
		this.uiType 			= builder.uiType;
		this.actionToPerform 	= builder.actionToPerform;
		this.occ	 			= builder.occ;
		this.data 				= builder.data;
		this.value 				= builder.value;
	}
	
	public static enum type {
								TEXT_BOX, 
								CHECK_BOX, 
								LINK, 
								IMAGE, 
								TEXT_AREA, 
								DROP_DOWN, 
								RADIO_BUTTON,
								BUTTON,
								INPUT_BUTTON,
								MENU,
								MENU_ITEM,
								ELEMENT
							};
							
	public static enum action {
								CLICK,
								CLICK_OPTIONAL,
								SET_TEXT,
								GET_TEXT,
								SELECT_OPTION,
								SELECT_OPTION_BY_INDEX,
								SELECT_OPTION_BY_VALUE,
								GET_OPTION_BY_VALUE,
								GET_OPTION_BY_INDEX,
								GET_SELECTED_OPTION,
								GET_VALUE,
								GET_ATTRIBUTE
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
		
		else 
			by = getCustomBy();
		
		return by;
	}
	
	public By getCustomBy()
	{
		By by = null;
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
			case BUTTON:
				ret = "Button";
				break;
			case INPUT_BUTTON:
				ret = "Button";
				break;				
			case ELEMENT:
				ret = "Element";
				break;		
			case MENU:
				ret = "Menu";
			case MENU_ITEM:
				ret = "Menu Item";				
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
			case CLICK_OPTIONAL:	
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
			case GET_ATTRIBUTE:				
			case GET_VALUE:
				ret = "Captured \""+value+"\" from  \"" + label + "\" " + getType();
				break;		
				
			default:
				break;
		}
				
		return ret;
	}
	
	
	public static class Builder
	{
		String label;
		String xpath;
		String id, name;
		String linkText,partialLinkText;
		type uiType;
		action actionToPerform;
		int occ; 
		String data,value;		
		
		public Builder()
		{
			occ = 1;
		}
		
		public Builder label(String label)
		{
			this.label = label;
			return this;
		}
		
		public Builder xpath(String xpath)
		{
			this.xpath = xpath;
			return this;
		}
		
		public Builder id(String id)
		{
			this.id = id;
			return this;
		}
		public Builder name(String name)
		{
			this.name = name;
			return this;
		}
				
		public Builder linkText(String linkText)
		{
			this.linkText = linkText;
			return this;
		}
		
		public Builder paritalLinkText(String partialLinkText)
		{
			this.partialLinkText = partialLinkText;
			return this;
		}
		
		public Builder uiType(type uiType)
		{
			this.uiType = uiType;
			return this;
		}
		
		public Builder actionToPerform(action actionToPerform)
		{
			this.actionToPerform = actionToPerform;
			return this;
		}
		
		public Builder occ(int occ)
		{
			this.occ = occ;
			return this;
		}
		
		public Builder data(String data)
		{
			this.data = data;
			return this;
		}
		public Builder value(String value)
		{
			this.value = value;
			return this;
		}
		
		public BaseObject build()
		{
			return new BaseObject(this);
		}
	}


	
}
