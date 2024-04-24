package com.lmsapp.lms.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.lmsapp.lms.POM.PageObjectManager;
import com.lmsapp.lms.webDriverManager.DriverManager;

public class TestSetup {
	public WebDriver driver;
	public DriverManager drivermanager;
	public PageObjectManager pageobjectmanager;

	public TestSetup() throws IOException {
		
		drivermanager = new DriverManager();
		pageobjectmanager = new PageObjectManager(drivermanager.getDriverManager());
	}
	
}
