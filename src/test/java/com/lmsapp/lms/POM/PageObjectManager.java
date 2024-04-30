package com.lmsapp.lms.POM;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public CommonMethodsObject commonobj;
	public Program01_POM programobj;
	public Program02_POM programobj2;
	
	public PageObjectManager(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public CommonMethodsObject getCommonMethodsObject() {
		commonobj = new CommonMethodsObject(driver);
		return commonobj;
		}
		public Program01_POM getProgramMethodsObject() {
			programobj = new Program01_POM(driver);
		return programobj;
	}
		public Program02_POM getProgramMethodsObject2() {
			programobj2 = new Program02_POM(driver);
		return programobj2;
	}
		}
