package com.lmsapp.lms.POM;

import org.openqa.selenium.WebDriver;





public class PageObjectManager {
	public WebDriver driver;
	public CommonMethodsObject commonobj;
	public User1_PageObject user1obj;
	public User2_PageObject user2obj;
	public User3_PageObject user3obj;
	public User4_PageObject user4obj;
	public User5_PageObject user5obj;
	
	public PageObjectManager(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public CommonMethodsObject getCommonMethodsObject() {
		commonobj = new CommonMethodsObject(driver);
		return commonobj;
		
	}

	public User1_PageObject getUser1MethodsObject() {
		user1obj = new User1_PageObject(driver);
		return user1obj;
		
	}

	public User2_PageObject getUser2MethodsObject() {
		user2obj = new User2_PageObject(driver);
		return user2obj;
		
	}
	
	public User3_PageObject getUser3MethodsObject() {
		user3obj = new User3_PageObject(driver);
		return user3obj;
		
	}

	public User4_PageObject getUser4MethodsObject() {
		user4obj = new User4_PageObject(driver);
		return user4obj;
		
	}

	public User5_PageObject getUser5MethodsObject() {
		user5obj = new User5_PageObject(driver);
		return user5obj;
		
	}
}
