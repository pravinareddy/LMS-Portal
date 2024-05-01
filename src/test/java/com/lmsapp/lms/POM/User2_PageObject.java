package com.lmsapp.lms.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import com.lmsapp.lms.stepDefinition.E1_UserStepDefinition;

public class User2_PageObject {
	private WebDriver driver;
	public static Logger LOG = LoggerFactory.getLogger(User2_PageObject.class);
	public User2_PageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//mat-toolbar/button[3]/span[1]")
	WebElement userModule;

	@FindBy(xpath = "//div[@role='checkbox']")
	List<WebElement> checkbox;
	
	@FindBy(xpath = "//span[@class='p-button-icon pi pi-pencil']")
	List<WebElement> EditButton;

	
	@FindBy(css="[class='p-button-icon pi pi-trash']")
	List<WebElement> DeleteButton;
	
	public void NavigatingUser(){
		userModule.click();
	}
	
	public void CheckBoxCount () throws InterruptedException {	
	Thread.sleep(1000);
	int count =0;
	  for (WebElement element : checkbox) {
		  if (element.isDisplayed()) {
              count++;
          }
		}
		Assert.assertTrue(count==6);
		System.out.println("Checkbox is present " + count + "times");	  
	}
	
	public void EditEnabledButton() {
		int count =0;
		  for (WebElement element : EditButton) {
			  if (element.isEnabled()) {
	              count++;
	          }
			}
			Assert.assertTrue(count==5);
			System.out.println(count + " Edit Button is enabled ");	  
		}
	
	
	public void DeleteButtonEnabled() throws InterruptedException {
		Thread.sleep(2000);
		int count =0;
		  for (WebElement element : DeleteButton) {
			  if (element.isEnabled()) {
	              count++;
	          }
			}
			Assert.assertTrue(count==6);
			System.out.println(count + " Delete Buttons are enabled ");	  
		}
	
	}
	
	
	
	

	