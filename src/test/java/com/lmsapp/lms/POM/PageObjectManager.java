package com.lmsapp.lms.POM;

import org.openqa.selenium.WebDriver;





public class PageObjectManager {
	public WebDriver driver;
	public CommonMethodsObject commonobj;
	
	
	public PageObjectManager(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public CommonMethodsObject getCommonMethodsObject() {
		commonobj = new CommonMethodsObject(driver);
		return commonobj;
		
	}

	

}
