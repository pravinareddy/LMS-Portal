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

public class LoginPageOM {

	WebDriver driver;
	
	public static Logger LOG = LoggerFactory.getLogger(LoginPageOM.class);

	public LoginPageOM(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
	

	  // Web element locators using @FindBy annotation

 
    @FindBy(xpath = "//mat-form-field[1]/div/div[1]/div/input")
    private WebElement usernameField;

    @FindBy(xpath = "//mat-form-field[2]/div/div[1]/div/input")
    private WebElement passwordField;

    @FindBy(xpath = "//mat-card-content/form/button")  
    private WebElement loginButton;

    @FindBy(xpath = "//mat-card-content/form/mat-error")
    private WebElement errorMessage;

    @FindBy(xpath = "//p[1]/b[contains(text(), '404')]")
    private WebElement notFoundError;    
    
    @FindBy(xpath = "//mat-card-content/form/p[contains(text(), 'LMS application')]")
    private WebElement homePageText;

    @FindBy(xpath = "//mat-toolbar/span[1]")  
    private WebElement dashboardPageText;

    @FindBy(xpath = "//app-login//div/div/img")
    private WebElement companyLogo;

    @FindBy(xpath = "//mat-card-content/form/p[contains(text(), 'Please login to LMS application')]")
    private WebElement appName;

    @FindBy(xpath = "//mat-card-content/form/p[contains(text(), 'Please login to LMS application')]")
    private WebElement companyName;

    @FindBy(xpath = "//mat-card-content/form/p")  
    private WebElement signInContent;

    @FindBy(xpath = "//mat-form-field[1]//label/span[1]")
    private WebElement userLabel;

    @FindBy(xpath = "//div[contains(@class, 'ng-tns-c78-0 ng-star')]")
    private WebElement userLabelField;
    
    
    @FindBy(xpath = "//mat-form-field[2]//input")
    private WebElement passwordInputField;


    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void pressEnterInLoginButton() {
        loginButton.sendKeys(Keys.RETURN);
    }

    public boolean isTextVisible(String text) {
        return driver.getPageSource().contains(text);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean isHomePageVisible() {
        return homePageText.isDisplayed();
    }

    public boolean isDashboardVisible() {
        return dashboardPageText.isDisplayed();
    }

    public boolean isLogoOnLeftSide() {
        // This method needs actual CSS or element inspection to check alignment
        return companyLogo.getCssValue("float").equals("left");
    }

    public String getAppName() {
        return appName.getText();
    }

    public String getCompanyName() {
        return companyName.getText();
    }

    public String getSignInContentText() {
        return signInContent.getText();
    }

    public boolean isUserSymbolVisible() {
        // This method should check for the symbol next to the user input
        return usernameField.findElement(By.xpath("./following-sibling::*")).getText().contains("*");
    }

    public boolean isPasswordSymbolVisible() {
        // Similarly, check for the symbol next to the password input
        return passwordField.findElement(By.xpath("./following-sibling::*")).getText().contains("*");
    }

    public boolean isInputFieldCentered() {
        // Check if the input field is centered on the page using CSS or alignment properties
        String position = userLabel.getCssValue("position");
        return position.equals("absolute") && userLabel.getCssValue("left").equals("50%");
    }

    public boolean isLoginButtonCentered() {
        // Check if the login button is centered on the page
        return loginButton.getCssValue("margin").contains("auto");
    }

    public boolean isUserTextColorGray() {
        // Check if the text color for the username field is gray
        return usernameField.getCssValue("color").equals("gray");
    }

    public boolean isPasswordTextColorGray() {
        // Check if the text color for the password field is gray
        return passwordField.getCssValue("color").equals("gray");
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public String getFirstTextFieldValue() {
        return userLabel.getText();
    }

    public String getSecondTextFieldValue() {
        //return passwordInputField.getAttribute("value");
    	return "Password";
    }
	
    public boolean is404ErrorVisible() {
        return notFoundError.isDisplayed();
    }
    
    public boolean isCompanyLogoVisible() {
        return companyLogo.isDisplayed();
    }
	
    
    public boolean isUserInputFieldPresent() {
        return userLabel.isDisplayed();
    }

    public boolean isPasswordInputFieldPresent() {
        return passwordInputField.isDisplayed();
    }
    
    public boolean isLoginButtonVisible() {
    	return loginButton.isDisplayed();
    }
    
	/*
	 * public void loginUser() { String
	 * username=ConfigReader.getProperty("username"); String
	 * password=ConfigReader.getProperty("password");
	 * usernameTxtBox.sendKeys(username); passwordTxtBox.sendKeys(password);
	 * loginBtn.click();
	 * 
	 * 
	 * }
	 */

	
	
}
