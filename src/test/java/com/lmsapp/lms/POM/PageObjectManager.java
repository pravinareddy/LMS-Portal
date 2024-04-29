package com.lmsapp.lms.POM;

import org.openqa.selenium.WebDriver;





public class PageObjectManager {
	public WebDriver driver;
	public CommonMethodsObject commonobj;
	public ManageUserPOM2 manageuser2;
	
	
	
	public PageObjectManager(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public CommonMethodsObject getCommonMethodsObject() {
		commonobj = new CommonMethodsObject(driver);
		return commonobj;
		
	}

	public ManageUserPOM2 getManageUser2Obj() {
		manageuser2 = new ManageUserPOM2(driver);
		return manageuser2;
		
	}
	

}
