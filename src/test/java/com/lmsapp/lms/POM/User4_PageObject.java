package com.lmsapp.lms.POM;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.lmsapp.lms.utilities.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;



public class User4_PageObject {
	
	private ConfigReader configReader;
		private WebDriver driver;
		public static Logger LOG = LoggerFactory.getLogger(User4_PageObject.class);
		public User4_PageObject(WebDriver driver) {

			this.driver = driver;
			PageFactory.initElements(driver, this);
			this.configReader = new ConfigReader();
		}
		
		@FindBy(id = "mat-input-2")
		WebElement FirstName;

		@FindBy(id = "mat-input-3")
		WebElement MiddleName;

		@FindBy(id = "mat-input-4")
		WebElement LastName;

		@FindBy(id = "mat-input-5")
		WebElement Location;

		@FindBy(id = "mat-input-6")
		WebElement PhoneNumber;

		@FindBy(id = "mat-input-7")
		WebElement LinkedURL;

		@FindBy(id = "mat-input-8")
		WebElement Email;

		@FindBy(id = "mat-input-9")
		WebElement Graduate;

		@FindBy(id = "mat-input-10")
		WebElement PostGraduate;

		@FindBy(id = "mat-input-11")
		WebElement TimeZone;

		@FindBy(id = "mat-input-12")
		WebElement Comments;
		
		@FindBy(id = "user")
		WebElement userModule;
		
		@FindBy(css="p-dropdown-trigger ng-tns-c101-44")
		WebElement UserRole;
		
		@FindBy(css="p-dropdown-trigger ng-tns-c101-45")
		WebElement UserRoleStatus;
		
		@FindBy(css="[class=\"p-dropdown-trigger-icon ng-tns-c101-46 pi pi-chevron-down\"]")
		WebElement VisaStatus;
		
		@FindBy(id="new")
		WebElement newUser;
		
		@FindBy(xpath = "//mat-card-actions/button[2]/span[1]")
		WebElement submit;
		
		@FindBy(css="[color='warn']")
		WebElement CancelButton;
		
		@FindBy(css="[class='ng-trigger ng-trigger-animation ng-tns-c132-6 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted']")
		WebElement dataBody;
		
		public void FindDataBody() {
			Assert.assertTrue(dataBody.isDisplayed());
		}
		
		public void FailedStatus() {
					 String Message =driver.switchTo().alert().getText();
					 String expectedMessage="User not created";
					 assertTrue(Message,expectedMessage);
		}
		
		private void assertTrue(String message, String expectedMessage) {
			// TODO Auto-generated method stub
			
		}

		public void ClickCancel() {
			CancelButton.click();
		}
		public void CheckigAlert() {
			Assert.assertTrue(dataBody.findElement(By.cssSelector("[role='alert']")).isDisplayed());
		}
		
		public void ClickSubmit() {
			submit.click();
		}
		
		public void SelectUserRole(String optionText) {
	        Select dropdown = new Select(UserRole);
	        dropdown.selectByVisibleText("R01");
	    }
		
		public void SelectRoleStatus(String optionText) {
	        Select dropdown = new Select(UserRoleStatus);
	        dropdown.selectByVisibleText("Active");
	    }
		
		public void SelectVisaStatus(String optionText) {
	        Select dropdown = new Select(VisaStatus);
	        dropdown.selectByVisibleText("H4");
	    }
		
		public void NewUser(){
			newUser.click();
		}
		public void NavigatingUser(){
			userModule.click();
		}
		public void HandlingAlert() {
			String actualAlertMessage = driver.switchTo().alert().getText();
			System.out.println(actualAlertMessage);
		}
		
		
		
		public void NumSplChar() {
			Location.sendKeys("1245");
			FirstName.sendKeys("%^^&*");
			LastName.sendKeys("23456789");

		}
		
		public void TextFieldsValid() {
			String Location = configReader.getLocation();
			String LinkedURL = configReader.getURL();
			String FirstName = configReader.getFirstName();
			String MiddleName=configReader.getMiddleName();
			String LastName = configReader.getLastName();
			String PhoneNumber = configReader.getPhoneNumber();
			String Graduate = configReader.getGraduate();
			String PostGraduate = configReader.getPostGraduate();
		}
		
		public void OptionalFields() {
			String Location = configReader.getLocation();
			String LinkedURL = configReader.getURL();
			String FirstName = configReader.getFirstName();
			String LastName = configReader.getLastName();
			String PhoneNumber = configReader.getPhoneNumber();
			String Graduate = configReader.getGraduate();
			String PostGraduate = configReader.getPostGraduate();
		}
}

