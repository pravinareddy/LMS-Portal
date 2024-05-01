package com.lmsapp.lms.POM;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import com.lmsapp.lms.stepDefinition.E3_UserStepDefinition;

public class User3_PageObject {
	private WebDriver driver;
	public static Logger LOG = LoggerFactory.getLogger(User3_PageObject.class);
	public User3_PageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(id = "user")
	WebElement userModule;
	
	@FindBy(id="filterGlobal")
	WebElement SearchIcon;
	
    @FindBy(xpath="//p-table/div/div[1]/table/tbody")
    WebElement table;
    
	@FindBy(id="new")
	WebElement newUser;
    
	@FindBy(xpath="//div/p-dialog[1]/div/div")
	WebElement UserPopup;
	
//	@FindBy(tagName="//input")
//    List<WebElement> TextBox;
	
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']")
	WebElement DataBody;
	
	@FindBy(css="div[aria-haspopup='listbox']")
	List<WebElement> Dropdown;
	
	@FindBy(css="div[class='col']")
	List<WebElement> TextBox;
	
	public void Countdropdown() {
		int count =Dropdown.size();
		assertTrue(count==3);
	}
	
	public void UsetWindow() {
		UserPopup.isDisplayed();
	}
	
	public void TextBoxes() {
		int Count=TextBox.size();
		assertTrue(Count==14);
	}
	
	public void DisplayEnterName() {
		SearchIcon.sendKeys("sdetorganizers@gmail.com");
	}
	
	
	public void Invalidata() {
		SearchIcon.sendKeys("12345");
		
	}
	
	public void NodataDisplayed(){
		Assert.assertFalse(DataBody.isDisplayed(),"Valid Data");
	}
	
	public void NavigatingUser(){
		userModule.click();
	}
	
	public void NewUser(){
		newUser.click();
	}
	
	public void UserDisplayed() {
		// Find the user name rows in the table
		Boolean IsDispayed=table.findElement(By.id("username")).isDisplayed();
		assertTrue(IsDispayed , "Username element is not displayed ");
}
	
	
	public void get_heading() {
		String msg = driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-title/div[1]")).getText();
		System.out.println("---------**Result getext**--------"+msg);
	}
}