package com.lmsapp.lms.POM;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;

import com.lmsapp.lms.utilities.ConfigReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User5_PageObject {

	private ConfigReader configReader;
	private WebDriver driver;
	public static Logger LOG = LoggerFactory.getLogger(User5_PageObject.class);

	public User5_PageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.configReader = new ConfigReader();
	}

	@FindBy(xpath = "//*[@class='p-button-icon pi pi-pencil'][1]")
	WebElement EditIcon;

	@FindBy(xpath = "//*/p-table")
	WebElement dataTable;

	@FindBy(id = "user")
	WebElement userModule;

	@FindBy(id = "new")
	WebElement newUser;

	@FindBy(css = "[class=\"ng-trigger ng-trigger-animation ng-tns-c132-6 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted\"]")
	WebElement UserPopup;

	@FindBy(id = "mat-input-107")
	WebElement emailId;

	@FindBy(xpath = "//mat-card-actions/button[2]/span[1]")
	WebElement submit;

	@FindBy(css = "signin-content")
	WebElement update;

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
	
	@FindBy(css="[color='warn']")
	WebElement CancelButton;
	
	@FindBy(xpath="//tbody")
	WebElement dataBody;

	public void ClickCancel() {
		CancelButton.click();
	}
	
	public void DataBoday() {
		assertFalse(dataBody.isDisplayed());
	}
	
	public void ValidDataInput() {
		String Location = configReader.getLocation();
		String LinkedURL = configReader.getURL();

	}

	public void Cancel() {
		CancelButton.click();
	}
	
	public void MandotoryFields() {
		String Location = configReader.getLocation();
		String LinkedURL = configReader.getURL();
		String FirstName = configReader.getFirstName();
		String LastName = configReader.getLastName();
		String PhoneNumber = configReader.getPhoneNumber();
		String Graduate = configReader.getGraduate();
		String PostGraduate = configReader.getPostGraduate();
	}

	public void NumSplChar() {
		Location.sendKeys("1245");
		FirstName.sendKeys("%^^&*");
		LastName.sendKeys("23456789");

	}

	public void OptionalFields() {
		String FirstName = configReader.getFirstName();
	}

	public void updateSuccess() {
		assertNotEquals(update, UserPopup);
	}

	public void updateSuccessWithAlert() {
		String alertMessage = "Invalid Data";
		assertNotEquals(update, UserPopup);
		// Assuming alertMessage is the expected alert message
		String actualAlertMessage = driver.switchTo().alert().getText();
		assertEquals(alertMessage, actualAlertMessage);
	}

	public void ClickSubmit() {
		submit.click();
		
	}

	public void UsetWindow() {
		UserPopup.isDisplayed();
	}

	public void UpdateEmail() {
		emailId.sendKeys("seema@gmail.com");
	}

	public void UpdateInvaliEmail() {
		emailId.sendKeys("seemagmail.com");
	}

	public void NavigatingUser() {
		userModule.click();
	}

	public void CheckingEditIcon() {
		EditIcon.click();
	}

	public void CheckingdataTable() {
		Assert.assertTrue(dataTable.isDisplayed());
	}

}
