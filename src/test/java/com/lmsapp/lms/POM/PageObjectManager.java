package com.lmsapp.lms.POM;

import org.openqa.selenium.WebDriver;

import com.lmsapp.lms.stepDefinition.Program1_StepDefinition;

public class PageObjectManager {
	public WebDriver driver;
	public CommonMethodsObject commonobj;
	public Program1_POM programobj;
	public Program2_POM programobj2;

	public PageObjectManager(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public CommonMethodsObject getCommonMethodsObject() {
		commonobj = new CommonMethodsObject(driver);
		return commonobj;
	}

	public Program1_POM getProgramMethodsObject() {
		programobj = new Program1_POM(driver);
		return programobj;
	}
	
	public Program2_POM getProgramMethodsObject2() {
		programobj2 = new Program2_POM(driver);
	return programobj2;
}

		
	}
