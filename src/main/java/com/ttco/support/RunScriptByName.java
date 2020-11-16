package com.ttco.support;

import com.ttco.gen.DynamicCall;

public class RunScriptByName 
{
	public static void run(String testName,SupportData td)
	{
		DynamicCall dc = (new DynamicCall(testName)).create();
		dc.invoke("before").invoke("run",td).invoke("after").invoke("finish");
	}
}
