package com.ttco.tests;

import com.ttco.ui.Browser;

public class TestBrowserObject 
{
	public static void main(String rs[])
	{
		
		Browser b = new Browser();
		b.launch("https://testingtools.co");
		b.close();
		
		Browser b1 = new Browser(Browser.type.FIREFOX,null);
		b1.launch("https://testingtools.co");
		b1.close();
	}
}
