package com.lmsapp.lms.POM;

import org.openqa.selenium.WebDriver;
//import com.lmsapp.lms.stepDefinition.Program1_StepDefinition;


public class PageObjectManager {
	public WebDriver driver;
	public CommonMethodsObject commonobj;
	public ManageUserPOM2 manageuser2;
	public LoginPageOM loginPageOM;
	public DashBoardPageOM dashboardPageOM;
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

	public ManageUserPOM2 getManageUser2Obj() {
		manageuser2 = new ManageUserPOM2(driver);
		return manageuser2;
		
	}
	
	public LoginPageOM getLoginPageObject() {
		loginPageOM = new LoginPageOM(driver);
		return loginPageOM;
		
	}
	
	public DashBoardPageOM getDashBoardPageObject() {
		dashboardPageOM = new DashBoardPageOM(driver);
		return dashboardPageOM;
		
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
