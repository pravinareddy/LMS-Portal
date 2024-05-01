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

public class User1_PageObject {
	private WebDriver driver;
	public static Logger LOG = LoggerFactory.getLogger(User1_PageObject.class);
	public User1_PageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//span[@class='mat-button-wrapper' and text()='User']")
	WebElement userLnk;

	@FindBy(xpath = "//div/mat-card/mat-card-title/div[1]")
	WebElement ManageProgram;

	@FindBy(id = "user")
	WebElement User;

	@FindBy(xpath = "//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']")
	WebElement TextPaginationIcon;

	@FindBy(xpath = "//thead[@class='p-datatable-thead']")
	WebElement HeadingColumn;

	
	@FindBy(xpath = "//th[@style='width: 10rem;'][2]")
	WebElement EditDeleteColumn;

	@FindBy(xpath = "//span[@class='p-button-icon pi pi-trash'][1]")
	WebElement TopDeleteButton;

//	@FindBy(xpath = "//div[2]/div[3]/button/span[2]")
//	WebElement AddNewUser;
	
	@FindBy(id="new")
	WebElement AddNewUser;
	
	@FindBy(xpath = "//body/app-root/app-user/div/mat-card/mat-card-title/div[2]/div[5]")
	WebElement AddNewStaff;
	
	@FindBy( xpath="//body/app-root/app-user/div/mat-card/mat-card-title/div[2]/div[4]")
	WebElement AddNewStudent;
	
	@FindBy(id="filterGlobal")
	WebElement SearchIcon;
	
	@FindBy(xpath = "//*/div/div[1]/table/tbody")
	private List<WebElement> RowDataCount;
	
//	@FindBy(css="[class='ng-star-inserted']")
//	private List<WebElement> RowDataCount;
	
	public void ManageProgramValidation() {
		 ManageProgram.isDisplayed();
	   Assert.assertTrue(ManageProgram.isDisplayed(),"Text Pagination Icon Not dispayed");
	}

	public void CheckPaginationIcon() {
		TextPaginationIcon.isDisplayed();
		Assert.assertTrue(TextPaginationIcon.isDisplayed(),"Text Pagination Icon Not dispayed");
		LOG.info("Admin is able to see the pagination Icon");
	}

	public void CheckHeadignColumn() {
		HeadingColumn.isDisplayed();
		Assert.assertTrue(HeadingColumn.isDisplayed(),"Heading Column Icon Not dispayed");
		LOG.info("Admin is able to see the Heading Icon");
	}
	
	public void CheckDeleteButton() {
		TopDeleteButton.isEnabled();
	    Assert.assertFalse(TopDeleteButton.isEnabled(),"Top Delete button is Disabled");
		LOG.info("Top Delete button is Disabled");
	}
	
	public void CheckAddNewUser() {
		AddNewUser.isDisplayed();
		Assert.assertTrue(AddNewUser.isDisplayed(),"Add new user is not dispalyed");
		LOG.info("Add new user is displayed");
	}
	
	public void CheckAddNewStaff() {
		AddNewStaff.isDisplayed();
		Assert.assertTrue(AddNewStaff.isDisplayed(),"Add new staff is not dispalyed");
		LOG.info("Add new staff is displayed");
	}
	
	public void CheckAddNewStudent() {
		AddNewStudent.isDisplayed();
		Assert.assertTrue(AddNewStudent.isDisplayed(),"Add new student is not dispalyed");
		LOG.info("Add new student is  displayed");
	}
	
	public void CheckSearchIcon() {
		SearchIcon.isDisplayed();
		Assert.assertTrue(SearchIcon.isDisplayed(),"Search icon is not dispalyed");
		LOG.info("Search Icon is displayed");
	}
	
	public void RowDataCount() {
		 RowDataCount.size();
		 System.out.println(RowDataCount);
	}
	
	public void navigateToUser() {
		try {
//			userLnk.click();
			Assert.assertTrue(driver.getCurrentUrl().contains("Manage user"));
			LOG.info("Admin has landed on Manage User Page");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void get_rows_in_table() {
		// Find the table element
		WebElement table = driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody"));
		// Find all rows in the table
		java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
		// Check if the table has 5 rows
		if (rows.size() == 5) {
		  System.out.println("-------****Table has 5 rows*****---------");
		} else {
		  System.out.println("Table does not have 5 rows.");
		}
}
	public void get_heading() {
		String msg = driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-title/div[1]")).getText();
		System.out.println("---------**Result getext**--------"+msg);
	}
}