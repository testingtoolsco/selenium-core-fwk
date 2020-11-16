package com.ttco.support;

public abstract class  BaseScript 
{
	SupportData td = null;
	
	public abstract void before();
	public abstract void run(SupportData td);
	public abstract void after();
	public abstract void finish();
	
}
