package com.lmsapp.lms.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmsapp.lms.utilities.ConfigReader;

public class DashBoardPageOM {

	WebDriver driver;
	
	public static Logger LOG = LoggerFactory.getLogger(DashBoardPageOM.class);

	public DashBoardPageOM(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
	

	  // Web element locators using @FindBy annotation

	  	@FindBy(xpath = "//header[contains(text(), 'Manage Program')]")
	    private WebElement manageProgramHeader;

	    @FindBy(xpath = "//title")
	    private WebElement pageTitle;

	    @FindBy(css = "nav")
	    private WebElement navigationBar;

	    @FindBy(xpath = "//nav/a[1]")
	    private WebElement firstNavItem;

	    @FindBy(xpath = "//nav/a[2]")
	    private WebElement secondNavItem;

	    @FindBy(xpath = "//nav/a[3]")
	    private WebElement thirdNavItem;

	    @FindBy(xpath = "//nav/a[4]")
	    private WebElement fourthNavItem;

	    @FindBy(id = "logout")
	    private WebElement logoutButton;

	    @FindBy(xpath = "//mat-toolbar/span[1]") // Have problem 
	    private WebElement dashboardPageText;
	    
	    public void navigateTo(String url) {
	        driver.get(url);
	    }

	    public boolean isDashboardVisible() {
	        return dashboardPageText.isDisplayed();
	    }
	    
	    public String getAppName() {
	        return dashboardPageText.getText();
	    }
	    

	    
	    public void login(String username, String password) {
	        WebElement usernameInput = driver.findElement(By.id("username"));
	        WebElement passwordInput = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.id("login"));
	        usernameInput.sendKeys(username);
	        passwordInput.sendKeys(password);
	        loginButton.click();
	    }

	    public boolean isManageProgramVisible() {
	        return manageProgramHeader.isDisplayed();
	    }

	    public String getTitle() {
	        return pageTitle.getText();
	    }

	    public boolean isTitlePositionedTopLeft() {
	        String cssPosition = pageTitle.getCssValue("position");
	        String cssLeft = pageTitle.getCssValue("left");
	        return cssPosition.equals("absolute") && cssLeft.equals("0px");
	    }

	    public boolean isLMSTitleSpelledCorrectly() {
	        String expectedTitle = "LMS - Learning Management System"; 
	        return pageTitle.getText().equals(expectedTitle);
	    }

	    public boolean isNavigationBarOnTopRight() {
	        String cssRight = navigationBar.getCssValue("right");
	        return cssRight.equals("0px");
	    }
	    
	    public boolean checkTextOnNavigationBar(String expectedText) {
	        WebElement navigationBar = driver.findElement(By.cssSelector("nav"));
	        return navigationBar.getText().contains(expectedText);
	    }

	    public void navigateToSomePage() {
	        navigateTo("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/somePage"); 
	    }

	    public void clickLogout() {
	        logoutButton.click();
	    }

	    public boolean isOnLoginPage() {
	        return driver.getCurrentUrl().contains("api-hackathon");
	    }

	    public boolean isItemAtPosition(String item, int position) {
	        WebElement targetItem = null;
	        switch (position) {
	            case 1: targetItem = firstNavItem; break;
	            case 2: targetItem = secondNavItem; break;
	            case 3: targetItem = thirdNavItem; break;
	            case 4: targetItem = fourthNavItem; break;
	        }
	        return targetItem != null && targetItem.getText().equals(item);
	    }
	
}
