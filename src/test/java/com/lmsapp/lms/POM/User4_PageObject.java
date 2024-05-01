package com.lmsapp.lms.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User4_PageObject {
	
	
		private WebDriver driver;
		public static Logger LOG = LoggerFactory.getLogger(User4_PageObject.class);
		public User4_PageObject(WebDriver driver) {

			this.driver = driver;
			PageFactory.initElements(driver, this);

		}
		
		@FindBy(id = "user")
		WebElement userModule;
		
		@FindBy(id="new")
		WebElement newUser;
		
		public void NewUser(){
			newUser.click();
		}
		public void NavigatingUser(){
			userModule.click();
		}
		
		
		public void NewUserDataInput() {
			
			
		}
}

