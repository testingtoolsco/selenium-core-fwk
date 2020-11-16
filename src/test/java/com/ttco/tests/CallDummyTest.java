package com.ttco.tests;

import com.ttco.support.ScriptWrapper;

public class CallDummyTest 
{
	public static void main(String rs[])
	{
		ScriptWrapper sw = new ScriptWrapper.Builder()
										.name("dummy test case")
										.tags("sanity")
										.module("HR")
										.testDataXLFile("")
										.build();
		
		sw.run("com.ttco.tests.DummyTest");
	}
	
}
