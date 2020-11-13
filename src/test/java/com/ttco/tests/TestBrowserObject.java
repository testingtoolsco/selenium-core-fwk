package com.ttco.tests;

import com.ttco.ui.BaseUI;
import com.ttco.ui.Browser;

public class TestBrowserObject 
{
	public static void main(String rs[])
	{
		
		//Earlier methods where availalbe directly in the Browser Class, now they are moved to BaseUI
		/*
		Browser b = new Browser();
		b.launch("https://testingtools.co");
		b.close();
		
		Browser b1 = new Browser(Browser.type.FIREFOX,null);
		b1.launch("https://testingtools.co");
		b1.close();
		*/
		
		//Calling methods and testing with methos moved to BaseUI
		//Working fine
		Browser b = new Browser();
		BaseUI web = new BaseUI(b);
		web.launch("https://testingtools.co");
		web.close();
		
		b = new Browser(Browser.type.FIREFOX,null);
		web = new BaseUI(b);
		web.launch("https://testingtools.co");
		web.close();
	}
}
