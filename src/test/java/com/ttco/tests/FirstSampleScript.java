package com.ttco.tests;

import com.ttco.ui.BaseObject;
import com.ttco.ui.BaseUI;
import com.ttco.ui.Browser;

public class FirstSampleScript 
{

	public static void main(String rs[]) throws Exception
	{
		Browser b = new Browser();
		BaseUI web = new BaseUI(b);
		
		BaseObject query = new BaseObject.Builder().name("q").label("Search").build();
		BaseObject searchBtn = new BaseObject.Builder().name("btnK").occ(2).label("Google Search").build();
		
		web.launch("https://google.com");
		web.element(query).setTextAndTab("TestingTools.co");
		web.element(searchBtn).click();
		web.waitForPage();
		web.close();
	}
}
