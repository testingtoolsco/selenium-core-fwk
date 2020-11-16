package com.ttco.tests;

import com.ttco.support.BaseScript;
import com.ttco.support.SupportData;

public class DummyTest extends BaseScript
{
	
	public void run(SupportData td) {
		System.out.println("Run is called");
	}

	public void after() {
		// TODO Auto-generated method stub
		System.out.println("After is called");
	}

	public void finish() {
		// TODO Auto-generated method stub
		System.out.println("Finish is called");
	}

	public void before() {
		// TODO Auto-generated method stub
		System.out.println("Before is called");
		
	}
}
