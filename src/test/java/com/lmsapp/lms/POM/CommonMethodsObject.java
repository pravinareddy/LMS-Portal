package com.lmsapp.lms.POM;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


import com.lmsapp.lms.utilities.ConfigReader;

public class CommonMethodsObject {
	
	WebDriver driver;
	
	public static Logger LOG = LoggerFactory.getLogger(CommonMethodsObject.class);

	public CommonMethodsObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}

	@FindBy(xpath="//input[@id='username']")
	WebElement usernameTxtBox;
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordTxtBox;
	@FindBy(xpath="//button[@id='login']")
	WebElement loginBtn;
	
	
	public void loginUser() {
		try
		{
			String username=ConfigReader.getProperty("username");
			String password=ConfigReader.getProperty("password");
			usernameTxtBox.sendKeys(username);
			passwordTxtBox.sendKeys(password);
			loginBtn.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			
	}
	

}
