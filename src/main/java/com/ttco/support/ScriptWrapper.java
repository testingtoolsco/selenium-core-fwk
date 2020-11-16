package com.ttco.support;

import java.util.Date;

public class ScriptWrapper 
{
	
	String name, description, browser,module;
	Date startTime, endTime;
	String assignedTo, priority; 
	String testDataXLFile;


	String status;
	String tags;
	
	public String getTestDataXLFile() {
		return testDataXLFile;
	}

	public void setTestDataXLFile(String testDataXLFile) {
		this.testDataXLFile = testDataXLFile;
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public SupportData loadSupportDataFrom()
	{
		SupportData sd = new SupportData();
		return sd;
	}
	public void run(String testName)
	{
		RunScriptByName.run(testName,loadSupportDataFrom());
	}
	
	public ScriptWrapper(Builder builder)
	{
		this.name = builder.name;
		this.description = builder.description;
		this.browser = builder.browser;
		this.module = builder.module;
		this.assignedTo = builder.assingedTo;
		this.priority = builder.priority;
		this.tags = builder.tags;
		this.testDataXLFile = builder.testDataXLFile;						
	}
	
	public static class Builder
	{
		String name, description, browser,module;
		String assingedTo, priority,tags;
		String testDataXLFile;
		
		public Builder()
		{
			this.browser = "chrome";
		}
		
		public ScriptWrapper build()
		{
			return new ScriptWrapper(this);
		}
		public Builder testDataXLFile(String testDataXLFile)
		{
			this.testDataXLFile = testDataXLFile;
			return this;
		}		
		public Builder name(String name)
		{
			this.name = name;
			return this;
		}
		
		public Builder description(String description)
		{
			this.description = description;
			return this;
		}
		
		public Builder browser(String browser)
		{
			this.browser = browser;
			return this;
		}
		
		public Builder module(String module)
		{
			this.module = module;
			return this;
		}
		
		
		public Builder assignedTo(String assignedTo)
		{
			this.assingedTo = assignedTo;
			return this;
		}
		
		public Builder priority(String priority)
		{
			this.priority = priority;
			return this;
		}
		
		public Builder tags(String tags)
		{
			this.tags = tags;
			return this;
		}
	}
	
}
