[1mdiff --git a/src/test/java/com/lmsapp/lms/POM/PageObjectManager.java b/src/test/java/com/lmsapp/lms/POM/PageObjectManager.java[m
[1mindex a7b6314..d72ce79 100644[m
[1m--- a/src/test/java/com/lmsapp/lms/POM/PageObjectManager.java[m
[1m+++ b/src/test/java/com/lmsapp/lms/POM/PageObjectManager.java[m
[36m@@ -9,50 +9,18 @@[m [mimport org.openqa.selenium.WebDriver;[m
 public class PageObjectManager {[m
 	public WebDriver driver;[m
 	public CommonMethodsObject commonobj;[m
[31m-	public User1_PageObject user1obj;[m
[31m-	public User2_PageObject user2obj;[m
[31m-	public User3_PageObject user3obj;[m
[31m-	public User4_PageObject user4obj;[m
[31m-	public User5_PageObject user5obj;[m
[32m+[m[41m	[m
 	[m
 	public PageObjectManager(WebDriver driver) {[m
 		super();[m
 		this.driver = driver;[m
 	}[m
[31m-	[m
 	public CommonMethodsObject getCommonMethodsObject() {[m
 		commonobj = new CommonMethodsObject(driver);[m
 		return commonobj;[m
 		[m
 	}[m
 [m
[31m-	public User1_PageObject getUser1MethodsObject() {[m
[31m-		user1obj = new User1_PageObject(driver);[m
[31m-		return user1obj;[m
[31m-		[m
[31m-	}[m
[31m-[m
[31m-	public User2_PageObject getUser2MethodsObject() {[m
[31m-		user2obj = new User2_PageObject(driver);[m
[31m-		return user2obj;[m
[31m-		[m
[31m-	}[m
 	[m
[31m-	public User3_PageObject getUser3MethodsObject() {[m
[31m-		user3obj = new User3_PageObject(driver);[m
[31m-		return user3obj;[m
[31m-		[m
[31m-	}[m
 [m
[31m-	public User4_PageObject getUser4MethodsObject() {[m
[31m-		user4obj = new User4_PageObject(driver);[m
[31m-		return user4obj;[m
[31m-		[m
[31m-	}[m
[31m-[m
[31m-	public User5_PageObject getUser5MethodsObject() {[m
[31m-		user5obj = new User5_PageObject(driver);[m
[31m-		return user5obj;[m
[31m-		[m
[31m-	}[m
 }[m
[1mdiff --git a/src/test/java/com/lmsapp/lms/POM/User1_PageObject.java b/src/test/java/com/lmsapp/lms/POM/User1_PageObject.java[m
[1mdeleted file mode 100644[m
[1mindex b4c2b66..0000000[m
[1m--- a/src/test/java/com/lmsapp/lms/POM/User1_PageObject.java[m
[1m+++ /dev/null[m
[36m@@ -1,146 +0,0 @@[m
[31m-package com.lmsapp.lms.POM;[m
[31m-[m
[31m-import java.util.List;[m
[31m-[m
[31m-import org.openqa.selenium.By;[m
[31m-import org.openqa.selenium.WebDriver;[m
[31m-import org.openqa.selenium.WebElement;[m
[31m-import org.openqa.selenium.support.FindBy;[m
[31m-import org.openqa.selenium.support.PageFactory;[m
[31m-import org.slf4j.Logger;[m
[31m-import org.slf4j.LoggerFactory;[m
[31m-import org.testng.Assert;[m
[31m-import com.lmsapp.lms.stepDefinition.E1_UserStepDefinition;[m
[31m-[m
[31m-public class User1_PageObject {[m
[31m-	private WebDriver driver;[m
[31m-	public static Logger LOG = LoggerFactory.getLogger(User1_PageObject.class);[m
[31m-	public User1_PageObject(WebDriver driver) {[m
[31m-[m
[31m-		this.driver = driver;[m
[31m-		PageFactory.initElements(driver, this);[m
[31m-[m
[31m-	}[m
[31m-	[m
[31m-	@FindBy(xpath = "//span[@class='mat-button-wrapper' and text()='User']")[m
[31m-	WebElement userLnk;[m
[31m-[m
[31m-	@FindBy(xpath = "//div/mat-card/mat-card-title/div[1]")[m
[31m-	WebElement ManageProgram;[m
[31m-[m
[31m-	@FindBy(id = "user")[m
[31m-	WebElement User;[m
[31m-[m
[31m-	@FindBy(xpath = "//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']")[m
[31m-	WebElement TextPaginationIcon;[m
[31m-[m
[31m-	@FindBy(xpath = "//thead[@class='p-datatable-thead']")[m
[31m-	WebElement HeadingColumn;[m
[31m-[m
[31m-	[m
[31m-	@FindBy(xpath = "//th[@style='width: 10rem;'][2]")[m
[31m-	WebElement EditDeleteColumn;[m
[31m-[m
[31m-	@FindBy(xpath = "//span[@class='p-button-icon pi pi-trash'][1]")[m
[31m-	WebElement TopDeleteButton;[m
[31m-[m
[31m-//	@FindBy(xpath = "//div[2]/div[3]/button/span[2]")[m
[31m-//	WebElement AddNewUser;[m
[31m-	[m
[31m-	@FindBy(id="new")[m
[31m-	WebElement AddNewUser;[m
[31m-	[m
[31m-	@FindBy(xpath = "//body/app-root/app-user/div/mat-card/mat-card-title/div[2]/div[5]")[m
[31m-	WebElement AddNewStaff;[m
[31m-	[m
[31m-	@FindBy( xpath="//body/app-root/app-user/div/mat-card/mat-card-title/div[2]/div[4]")[m
[31m-	WebElement AddNewStudent;[m
[31m-	[m
[31m-	@FindBy(id="filterGlobal")[m
[31m-	WebElement SearchIcon;[m
[31m-	[m
[31m-	@FindBy(xpath = "//*/div/div[1]/table/tbody")[m
[31m-	private List<WebElement> RowDataCount;[m
[31m-	[m
[31m-//	@FindBy(css="[class='ng-star-inserted']")[m
[31m-//	private List<WebElement> RowDataCount;[m
[31m-	[m
[31m-	public void ManageProgramValidation() {[m
[31m-		 ManageProgram.isDisplayed();[m
[31m-	   Assert.assertTrue(ManageProgram.isDisplayed(),"Text Pagination Icon Not dispayed");[m
[31m-	}[m
[31m-[m
[31m-	public void CheckPaginationIcon() {[m
[31m-		TextPaginationIcon.isDisplayed();[m
[31m-		Assert.assertTrue(TextPaginationIcon.isDisplayed(),"Text Pagination Icon Not dispayed");[m
[31m-		LOG.info("Admin is able to see the pagination Icon");[m
[31m-	}[m
[31m-[m
[31m-	public void CheckHeadignColumn() {[m
[31m-		HeadingColumn.isDisplayed();[m
[31m-		Assert.assertTrue(HeadingColumn.isDisplayed(),"Heading Column Icon Not dispayed");[m
[31m-		LOG.info("Admin is able to see the Heading Icon");[m
[31m-	}[m
[31m-	[m
[31m-	public void CheckDeleteButton() {[m
[31m-		TopDeleteButton.isEnabled();[m
[31m-	    Assert.assertFalse(TopDeleteButton.isEnabled(),"Top Delete button is Disabled");[m
[31m-		LOG.info("Top Delete button is Disabled");[m
[31m-	}[m
[31m-	[m
[31m-	public void CheckAddNewUser() {[m
[31m-		AddNewUser.isDisplayed();[m
[31m-		Assert.assertTrue(AddNewUser.isDisplayed(),"Add new user is not dispalyed");[m
[31m-		LOG.info("Add new user is displayed");[m
[31m-	}[m
[31m-	[m
[31m-	public void CheckAddNewStaff() {[m
[31m-		AddNewStaff.isDisplayed();[m
[31m-		Assert.assertTrue(AddNewStaff.isDisplayed(),"Add new staff is not dispalyed");[m
[31m-		LOG.info("Add new staff is displayed");[m
[31m-	}[m
[31m-	[m
[31m-	public void CheckAddNewStudent() {[m
[31m-		AddNewStudent.isDisplayed();[m
[31m-		Assert.assertTrue(AddNewStudent.isDisplayed(),"Add new student is not dispalyed");[m
[31m-		LOG.info("Add new student is  displayed");[m
[31m-	}[m
[31m-	[m
[31m-	public void CheckSearchIcon() {[m
[31m-		SearchIcon.isDisplayed();[m
[31m-		Assert.assertTrue(SearchIcon.isDisplayed(),"Search icon is not dispalyed");[m
[31m-		LOG.info("Search Icon is displayed");[m
[31m-	}[m
[31m-	[m
[31m-	public void RowDataCount() {[m
[31m-		 RowDataCount.size();[m
[31m-		 System.out.println(RowDataCount);[m
[31m-	}[m
[31m-	[m
[31m-	public void navigateToUser() {[m
[31m-		try {[m
[31m-//			userLnk.click();[m
[31m-			Assert.assertTrue(driver.getCurrentUrl().contains("Manage user"));[m
[31m-			LOG.info("Admin has landed on Manage User Page");[m
[31m-		} catch (Exception e) {[m
[31m-			e.printStackTrace();[m
[31m-		}[m
[31m-	}[m
[31m-	[m
[31m-	public void get_rows_in_table() {[m
[31m-		// Find the table element[m
[31m-		WebElement table = driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody"));[m
[31m-		// Find all rows in the table[m
[31m-		java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));[m
[31m-		// Check if the table has 5 rows[m
[31m-		if (rows.size() == 5) {[m
[31m-		  System.out.println("-------****Table has 5 rows*****---------");[m
[31m-		} else {[m
[31m-		  System.out.println("Table does not have 5 rows.");[m
[31m-		}[m
[31m-}[m
[31m-	public void get_heading() {[m
[31m-		String msg = driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-title/div[1]")).getText();[m
[31m-		System.out.println("---------**Result getext**--------"+msg);[m
[31m-	}[m
[31m-}[m
\ No newline at end of file[m
[1mdiff --git a/src/test/java/com/lmsapp/lms/POM/User2_PageObject.java b/src/test/java/com/lmsapp/lms/POM/User2_PageObject.java[m
[1mdeleted file mode 100644[m
[1mindex 925e90c..0000000[m
[1m--- a/src/test/java/com/lmsapp/lms/POM/User2_PageObject.java[m
[1m+++ /dev/null[m
[36m@@ -1,84 +0,0 @@[m
[31m-package com.lmsapp.lms.POM;[m
[31m-[m
[31m-import java.util.List;[m
[31m-[m
[31m-import org.openqa.selenium.By;[m
[31m-import org.openqa.selenium.WebDriver;[m
[31m-import org.openqa.selenium.WebElement;[m
[31m-import org.openqa.selenium.support.FindBy;[m
[31m-import org.openqa.selenium.support.PageFactory;[m
[31m-import org.slf4j.Logger;[m
[31m-import org.slf4j.LoggerFactory;[m
[31m-import org.testng.Assert;[m
[31m-import com.lmsapp.lms.stepDefinition.E1_UserStepDefinition;[m
[31m-[m
[31m-public class User2_PageObject {[m
[31m-	private WebDriver driver;[m
[31m-	public static Logger LOG = LoggerFactory.getLogger(User2_PageObject.class);[m
[31m-	public User2_PageObject(WebDriver driver) {[m
[31m-[m
[31m-		this.driver = driver;[m
[31m-		PageFactory.initElements(driver, this);[m
[31m-[m
[31m-	}[m
[31m-	[m
[31m-	@FindBy(xpath = "//mat-toolbar/button[3]/span[1]")[m
[31m-	WebElement userModule;[m
[31m-[m
[31m-	@FindBy(xpath = "//div[@role='checkbox']")[m
[31m-	List<WebElement> checkbox;[m
[31m-	[m
[31m-	@FindBy(xpath = "//span[@class='p-button-icon pi pi-pencil']")[m
[31m-	List<WebElement> EditButton;[m
[31m-[m
[31m-	[m
[31m-	@FindBy(css="[class='p-button-icon pi pi-trash']")[m
[31m-	List<WebElement> DeleteButton;[m
[31m-	[m
[31m-	public void NavigatingUser(){[m
[31m-		userModule.click();[m
[31m-	}[m
[31m-	[m
[31m-	public void CheckBoxCount () throws InterruptedException {	[m
[31m-	Thread.sleep(1000);[m
[31m-	int count =0;[m
[31m-	  for (WebElement element : checkbox) {[m
[31m-		  if (element.isDisplayed()) {[m
[31m-              count++;[m
[31m-          }[m
[31m-		}[m
[31m-		Assert.assertTrue(count==6);[m
[31m-		System.out.println("Checkbox is present " + count + "times");	  [m
[31m-	}[m
[31m-	[m
[31m-	public void EditEnabledButton() {[m
[31m-		int count =0;[m
[31m-		  for (WebElement element : EditButton) {[m
[31m-			  if (element.isEnabled()) {[m
[31m-	              count++;[m
[31m-	          }[m
[31m-			}[m
[31m-			Assert.assertTrue(count==5);[m
[31m-			System.out.println(count + " Edit Button is enabled ");	  [m
[31m-		}[m
[31m-	[m
[31m-	[m
[31m-	public void DeleteButtonEnabled() throws InterruptedException {[m
[31m-		Thread.sleep(2000);[m
[31m-		int count =0;[m
[31m-		  for (WebElement element : DeleteButton) {[m
[31m-			  if (element.isEnabled()) {[m
[31m-	              count++;[m
[31m-	          }[m
[31m-			}[m
[31m-			Assert.assertTrue(count==6);[m
[31m-			System.out.println(count + " Delete Buttons are enabled ");	  [m
[31m-		}[m
[31m-	[m
[31m-	}[m
[31m-	[m
[31m-	[m
[31m-	[m
[31m-	[m
[31m-[m
[31m-	[m
\ No newline at end of file[m
[1mdiff --git a/src/test/java/com/lmsapp/lms/POM/User3_PageObject.java b/src/test/java/com/lmsapp/lms/POM/User3_PageObject.java[m
[1mdeleted file mode 100644[m
[1mindex c25f7a7..0000000[m
[1m--- a/src/test/java/com/lmsapp/lms/POM/User3_PageObject.java[m
[1m+++ /dev/null[m
[36m@@ -1,100 +0,0 @@[m
[31m-package com.lmsapp.lms.POM;[m
[31m-[m
[31m-import static org.testng.Assert.assertTrue;[m
[31m-[m
[31m-import java.util.List;[m
[31m-[m
[31m-import org.openqa.selenium.By;[m
[31m-import org.openqa.selenium.WebDriver;[m
[31m-import org.openqa.selenium.WebElement;[m
[31m-import org.openqa.selenium.support.FindBy;[m
[31m-import org.openqa.selenium.support.PageFactory;[m
[31m-import org.slf4j.Logger;[m
[31m-import org.slf4j.LoggerFactory;[m
[31m-import org.testng.Assert;[m
[31m-import com.lmsapp.lms.stepDefinition.E3_UserStepDefinition;[m
[31m-[m
[31m-public class User3_PageObject {[m
[31m-	private WebDriver driver;[m
[31m-	public static Logger LOG = LoggerFactory.getLogger(User3_PageObject.class);[m
[31m-	public User3_PageObject(WebDriver driver) {[m
[31m-[m
[31m-		this.driver = driver;[m
[31m-		PageFactory.initElements(driver, this);[m
[31m-[m
[31m-	}[m
[31m-	@FindBy(id = "user")[m
[31m-	WebElement userModule;[m
[31m-	[m
[31m-	@FindBy(id="filterGlobal")[m
[31m-	WebElement SearchIcon;[m
[31m-	[m
[31m-    @FindBy(xpath="//p-table/div/div[1]/table/tbody")[m
[31m-    WebElement table;[m
[31m-    [m
[31m-	@FindBy(id="new")[m
[31m-	WebElement newUser;[m
[31m-    [m
[31m-	@FindBy(xpath="//div/p-dialog[1]/div/div")[m
[31m-	WebElement UserPopup;[m
[31m-	[m
[31m-//	@FindBy(tagName="//input")[m
[31m-//    List<WebElement> TextBox;[m
[31m-	[m
[31m-	@FindBy(xpath="//tbody[@class='p-datatable-tbody']")[m
[31m-	WebElement DataBody;[m
[31m-	[m
[31m-	@FindBy(css="div[aria-haspopup='listbox']")[m
[31m-	List<WebElement> Dropdown;[m
[31m-	[m
[31m-	@FindBy(css="div[class='col']")[m
[31m-	List<WebElement> TextBox;[m
[31m-	[m
[31m-	public void Countdropdown() {[m
[31m-		int count =Dropdown.size();[m
[31m-		assertTrue(count==3);[m
[31m-	}[m
[31m-	[m
[31m-	public void UsetWindow() {[m
[31m-		UserPopup.isDisplayed();[m
[31m-	}[m
[31m-	[m
[31m-	public void TextBoxes() {[m
[31m-		int Count=TextBox.size();[m
[31m-		assertTrue(Count==14);[m
[31m-	}[m
[31m-	[m
[31m-	public void DisplayEnterName() {[m
[31m-		SearchIcon.sendKeys("sdetorganizers@gmail.com");[m
[31m-	}[m
[31m-	[m
[31m-	[m
[31m-	public void Invalidata() {[m
[31m-		SearchIcon.sendKeys("12345");[m
[31m-		[m
[31m-	}[m
[31m-	[m
[31m-	public void NodataDisplayed(){[m
[31m-		Assert.assertFalse(DataBody.isDisplayed(),"Valid Data");[m
[31m-	}[m
[31m-	[m
[31m-	public void NavigatingUser(){[m
[31m-		userModule.click();[m
[31m-	}[m
[31m-	[m
[31m-	public void NewUser(){[m
[31m-		newUser.click();[m
[31m-	}[m
[31m-	[m
[31m-	public void UserDisplayed() {[m
[31m-		// Find the user name rows in the table[m
[31m-		Boolean IsDispayed=table.findElement(By.id("username")).isDisplayed();[m
[31m-		assertTrue(IsDispayed , "Username element is not displayed ");[m
[31m-}[m
[31m-	[m
[31m-	[m
[31m-	public void get_heading() {[m
[31m-		String msg = driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-title/div[1]")).getText();[m
[31m-		System.out.println("---------**Result getext**--------"+msg);[m
[31m-	}[m
[31m-}[m
\ No newline at end of file[m
[1mdiff --git a/src/test/java/com/lmsapp/lms/POM/User4_PageObject.java b/src/test/java/com/lmsapp/lms/POM/User4_PageObject.java[m
[1mdeleted file mode 100644[m
[1mindex 6f35dfd..0000000[m
[1m--- a/src/test/java/com/lmsapp/lms/POM/User4_PageObject.java[m
[1m+++ /dev/null[m
[36m@@ -1,169 +0,0 @@[m
[31m-package com.lmsapp.lms.POM;[m
[31m-[m
[31m-import static org.testng.Assert.assertTrue;[m
[31m-[m
[31m-import org.openqa.selenium.By;[m
[31m-import org.openqa.selenium.WebDriver;[m
[31m-import com.lmsapp.lms.utilities.ConfigReader;[m
[31m-import org.openqa.selenium.WebElement;[m
[31m-import org.openqa.selenium.support.FindBy;[m
[31m-import org.openqa.selenium.support.PageFactory;[m
[31m-import org.openqa.selenium.support.ui.Select;[m
[31m-import org.slf4j.Logger;[m
[31m-import org.slf4j.LoggerFactory;[m
[31m-import org.testng.Assert;[m
[31m-[m
[31m-[m
[31m-[m
[31m-public class User4_PageObject {[m
[31m-	[m
[31m-	private ConfigReader configReader;[m
[31m-		private WebDriver driver;[m
[31m-		public static Logger LOG = LoggerFactory.getLogger(User4_PageObject.class);[m
[31m-		public User4_PageObject(WebDriver driver) {[m
[31m-[m
[31m-			this.driver = driver;[m
[31m-			PageFactory.initElements(driver, this);[m
[31m-			this.configReader = new ConfigReader();[m
[31m-		}[m
[31m-		[m
[31m-		@FindBy(id = "mat-input-2")[m
[31m-		WebElement FirstName;[m
[31m-[m
[31m-		@FindBy(id = "mat-input-3")[m
[31m-		WebElement MiddleName;[m
[31m-[m
[31m-		@FindBy(id = "mat-input-4")[m
[31m-		WebElement LastName;[m
[31m-[m
[31m-		@FindBy(id = "mat-input-5")[m
[31m-		WebElement Location;[m
[31m-[m
[31m-		@FindBy(id = "mat-input-6")[m
[31m-		WebElement PhoneNumber;[m
[31m-[m
[31m-		@FindBy(id = "mat-input-7")[m
[31m-		WebElement LinkedURL;[m
[31m-[m
[31m-		@FindBy(id = "mat-input-8")[m
[31m-		WebElement Email;[m
[31m-[m
[31m-		@FindBy(id = "mat-input-9")[m
[31m-		WebElement Graduate;[m
[31m-[m
[31m-		@FindBy(id = "mat-input-10")[m
[31m-		WebElement PostGraduate;[m
[31m-[m
[31m-		@FindBy(id = "mat-input-11")[m
[31m-		WebElement TimeZone;[m
[31m-[m
[31m-		@FindBy(id = "mat-input-12")[m
[31m-		WebElement Comments;[m
[31m-		[m
[31m-		@FindBy(id = "user")[m
[31m-		WebElement userModule;[m
[31m-		[m
[31m-		@FindBy(css="p-dropdown-trigger ng-tns-c101-44")[m
[31m-		WebElement UserRole;[m
[31m-		[m
[31m-		@FindBy(css="p-dropdown-trigger ng-tns-c101-45")[m
[31m-		WebElement UserRoleStatus;[m
[31m-		[m
[31m-		@FindBy(css="[class=\"p-dropdown-trigger-icon ng-tns-c101-46 pi pi-chevron-down\"]")[m
[31m-		WebElement VisaStatus;[m
[31m-		[m
[31m-		@FindBy(id="new")[m
[31m-		WebElement newUser;[m
[31m-		[m
[31m-		@FindBy(xpath = "//mat-card-actions/button[2]/span[1]")[m
[31m-		WebElement submit;[m
[31m-		[m
[31m-		@FindBy(css="[color='warn']")[m
[31m-		WebElement CancelButton;[m
[31m-		[m
[31m-		@FindBy(css="[class='ng-trigger ng-trigger-animation ng-tns-c132-6 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted']")[m
[31m-		WebElement dataBody;[m
[31m-		[m
[31m-		public void FindDataBody() {[m
[31m-			Assert.assertTrue(dataBody.isDisplayed());[m
[31m-		}[m
[31m-		[m
[31m-		public void FailedStatus() {[m
[31m-					 String Message =driver.switchTo().alert().getText();[m
[31m-					 String expectedMessage="User not created";[m
[31m-					 assertTrue(Message,expectedMessage);[m
[31m-		}[m
[31m-		[m
[31m-		private void assertTrue(String message, String expectedMessage) {[m
[31m-			// TODO Auto-generated method stub[m
[31m-			[m
[31m-		}[m
[31m-[m
[31m-		public void ClickCancel() {[m
[31m-			CancelButton.click();[m
[31m-		}[m
[31m-		public void CheckigAlert() {[m
[31m-			Assert.assertTrue(dataBody.findElement(By.cssSelector("[role='alert']")).isDisplayed());[m
[31m-		}[m
[31m-		[m
[31m-		public void ClickSubmit() {[m
[31m-			submit.click();[m
[31m-		}[m
[31m-		[m
[31m-		public void SelectUserRole(String optionText) {[m
[31m-	        Select dropdown = new Select(UserRole);[m
[31m-	        dropdown.selectByVisibleText("R01");[m
[31m-	    }[m
[31m-		[m
[31m-		public void SelectRoleStatus(String optionText) {[m
[31m-	        Select dropdown = new Select(UserRoleStatus);[m
[31m-	        dropdown.selectByVisibleText("Active");[m
[31m-	    }[m
[31m-		[m
[31m-		public void SelectVisaStatus(String optionText) {[m
[31m-	        Select dropdown = new Select(VisaStatus);[m
[31m-	        dropdown.selectByVisibleText("H4");[m
[31m-	    }[m
[31m-		[m
[31m-		public void NewUser(){[m
[31m-			newUser.click();[m
[31m-		}[m
[31m-		public void NavigatingUser(){[m
[31m-			userModule.click();[m
[31m-		}[m
[31m-		public void HandlingAlert() {[m
[31m-			String actualAlertMessage = driver.switchTo().alert().getText();[m
[31m-			System.out.println(actualAlertMessage);[m
[31m-		}[m
[31m-		[m
[31m-		[m
[31m-		[m
[31m-		public void NumSplChar() {[m
[31m-			Location.sendKeys("1245");[m
[31m-			FirstName.sendKeys("%^^&*");[m
[31m-			LastName.sendKeys("23456789");[m
[31m-[m
[31m-		}[m
[31m-		[m
[31m-		public void TextFieldsValid() {[m
[31m-			String Location = configReader.getLocation();[m
[31m-			String LinkedURL = configReader.getURL();[m
[31m-			String FirstName = configReader.getFirstName();[m
[31m-			String MiddleName=configReader.getMiddleName();[m
[31m-			String LastName = configReader.getLastName();[m
[31m-			String PhoneNumber = configReader.getPhoneNumber();[m
[31m-			String Graduate = configReader.getGraduate();[m
[31m-			String PostGraduate = configReader.getPostGraduate();[m
[31m-		}[m
[31m-		[m
[31m-		public void OptionalFields() {[m
[31m-			String Location = configReader.getLocation();[m
[31m-			String LinkedURL = configReader.getURL();[m
[31m-			String FirstName = configReader.getFirstName();[m
[31m-			String LastName = configReader.getLastName();[m
[31m-			String PhoneNumber = configReader.getPhoneNumber();[m
[31m-			String Graduate = configReader.getGraduate();[m
[31m-			String PostGraduate = configReader.getPostGraduate();[m
[31m-		}[m
[31m-}[m
[31m-[m
[1mdiff --git a/src/test/java/com/lmsapp/lms/POM/User5_PageObject.java b/src/test/java/com/lmsapp/lms/POM/User5_PageObject.java[m
[1mdeleted file mode 100644[m
[1mindex b5fd491..0000000[m
[1m--- a/src/test/java/com/lmsapp/lms/POM/User5_PageObject.java[m
[1m+++ /dev/null[m
[36m@@ -1,174 +0,0 @@[m
[31m-package com.lmsapp.lms.POM;[m
[31m-[m
[31m-import static org.testng.Assert.assertEquals;[m
[31m-import static org.testng.Assert.assertFalse;[m
[31m-import static org.testng.Assert.assertNotEquals;[m
[31m-import static org.testng.Assert.assertTrue;[m
[31m-import org.testng.Assert;[m
[31m-[m
[31m-import com.lmsapp.lms.utilities.ConfigReader;[m
[31m-[m
[31m-import org.openqa.selenium.WebDriver;[m
[31m-import org.openqa.selenium.WebElement;[m
[31m-import org.openqa.selenium.support.FindBy;[m
[31m-import org.openqa.selenium.support.PageFactory;[m
[31m-import org.slf4j.Logger;[m
[31m-import org.slf4j.LoggerFactory;[m
[31m-[m
[31m-public class User5_PageObject {[m
[31m-[m
[31m-	private ConfigReader configReader;[m
[31m-	private WebDriver driver;[m
[31m-	public static Logger LOG = LoggerFactory.getLogger(User5_PageObject.class);[m
[31m-[m
[31m-	public User5_PageObject(WebDriver driver) {[m
[31m-[m
[31m-		this.driver = driver;[m
[31m-		PageFactory.initElements(driver, this);[m
[31m-		this.configReader = new ConfigReader();[m
[31m-	}[m
[31m-[m
[31m-	@FindBy(xpath = "//*[@class='p-button-icon pi pi-pencil'][1]")[m
[31m-	WebElement EditIcon;[m
[31m-[m
[31m-	@FindBy(xpath = "//*/p-table")[m
[31m-	WebElement dataTable;[m
[31m-[m
[31m-	@FindBy(id = "user")[m
[31m-	WebElement userModule;[m
[31m-[m
[31m-	@FindBy(id = "new")[m
[31m-	WebElement newUser;[m
[31m-[m
[31m-	@FindBy(css = "[class=\"ng-trigger ng-trigger-animation ng-tns-c132-6 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted\"]")[m
[31m-	WebElement UserPopup;[m
[31m-[m
[31m-	@FindBy(id = "mat-input-107")[m
[31m-	WebElement emailId;[m
[31m-[m
[31m-	@FindBy(xpath = "//mat-card-actions/button[2]/span[1]")[m
[31m-	WebElement submit;[m
[31m-[m
[31m-	@FindBy(css = "signin-content")[m
[31m-	WebElement update;[m
[31m-[m
[31m-	@FindBy(id = "mat-input-2")[m
[31m-	WebElement FirstName;[m
[31m-[m
[31m-	@FindBy(id = "mat-input-3")[m
[31m-	WebElement MiddleName;[m
[31m-[m
[31m-	@FindBy(id = "mat-input-4")[m
[31m-	WebElement LastName;[m
[31m-[m
[31m-	@FindBy(id = "mat-input-5")[m
[31m-	WebElement Location;[m
[31m-[m
[31m-	@FindBy(id = "mat-input-6")[m
[31m-	WebElement PhoneNumber;[m
[31m-[m
[31m-	@FindBy(id = "mat-input-7")[m
[31m-	WebElement LinkedURL;[m
[31m-[m
[31m-	@FindBy(id = "mat-input-8")[m
[31m-	WebElement Email;[m
[31m-[m
[31m-	@FindBy(id = "mat-input-9")[m
[31m-	WebElement Graduate;[m
[31m-[m
[31m-	@FindBy(id = "mat-input-10")[m
[31m-	WebElement PostGraduate;[m
[31m-[m
[31m-	@FindBy(id = "mat-input-11")[m
[31m-	WebElement TimeZone;[m
[31m-[m
[31m-	@FindBy(id = "mat-input-12")[m
[31m-	WebElement Comments;[m
[31m-	[m
[31m-	@FindBy(css="[color='warn']")[m
[31m-	WebElement CancelButton;[m
[31m-	[m
[31m-	@FindBy(xpath="//tbody")[m
[31m-	WebElement dataBody;[m
[31m-[m
[31m-	public void ClickCancel() {[m
[31m-		CancelButton.click();[m
[31m-	}[m
[31m-	[m
[31m-	public void DataBoday() {[m
[31m-		assertFalse(dataBody.isDisplayed());[m
[31m-	}[m
[31m-	[m
[31m-	public void ValidDataInput() {[m
[31m-		String Location = configReader.getLocation();[m
[31m-		String LinkedURL = configReader.getURL();[m
[31m-[m
[31m-	}[m
[31m-[m
[31m-	public void Cancel() {[m
[31m-		CancelButton.click();[m
[31m-	}[m
[31m-	[m
[31m-	public void MandotoryFields() {[m
[31m-		String Location = configReader.getLocation();[m
[31m-		String LinkedURL = configReader.getURL();[m
[31m-		String FirstName = configReader.getFirstName();[m
[31m-		String LastName = configReader.getLastName();[m
[31m-		String PhoneNumber = configReader.getPhoneNumber();[m
[31m-		String Graduate = configReader.getGraduate();[m
[31m-		String PostGraduate = configReader.getPostGraduate();[m
[31m-	}[m
[31m-[m
[31m-	public void NumSplChar() {[m
[31m-		Location.sendKeys("1245");[m
[31m-		FirstName.sendKeys("%^^&*");[m
[31m-		LastName.sendKeys("23456789");[m
[31m-[m
[31m-	}[m
[31m-[m
[31m-	public void OptionalFields() {[m
[31m-		String FirstName = configReader.getFirstName();[m
[31m-	}[m
[31m-[m
[31m-	public void updateSuccess() {[m
[31m-		assertNotEquals(update, UserPopup);[m
[31m-	}[m
[31m-[m
[31m-	public void updateSuccessWithAlert() {[m
[31m-		String alertMessage = "Invalid Data";[m
[31m-		assertNotEquals(update, UserPopup);[m
[31m-		// Assuming alertMessage is the expected alert message[m
[31m-		String actualAlertMessage = driver.switchTo().alert().getText();[m
[31m-		assertEquals(alertMessage, actualAlertMessage);[m
[31m-	}[m
[31m-[m
[31m-	public void ClickSubmit() {[m
[31m-		submit.click();[m
[31m-		[m
[31m-	}[m
[31m-[m
[31m-	public void UsetWindow() {[m
[31m-		UserPopup.isDisplayed();[m
[31m-	}[m
[31m-[m
[31m-	public void UpdateEmail() {[m
[31m-		emailId.sendKeys("seema@gmail.com");[m
[31m-	}[m
[31m-[m
[31m-	public void UpdateInvaliEmail() {[m
[31m-		emailId.sendKeys("seemagmail.com");[m
[31m-	}[m
[31m-[m
[31m-	public void NavigatingUser() {[m
[31m-		userModule.click();[m
[31m-	}[m
[31m-[m
[31m-	public void CheckingEditIcon() {[m
[31m-		EditIcon.click();[m
[31m-	}[m
[31m-[m
[31m-	public void CheckingdataTable() {[m
[31m-		Assert.assertTrue(dataTable.isDisplayed());[m
[31m-	}[m
[31m-[m
[31m-}[m
[1mdiff --git a/src/test/java/com/lmsapp/lms/hooks/Hooks.java b/src/test/java/com/lmsapp/lms/hooks/Hooks.java[m
[1mindex 61eb01a..f8929dd 100644[m
[1m--- a/src/test/java/com/lmsapp/lms/hooks/Hooks.java[m
[1m+++ b/src/test/java/com/lmsapp/lms/hooks/Hooks.java[m
[36m@@ -31,33 +31,33 @@[m [mpublic class Hooks {[m
 		this.testup = testup;[m
 		this.driver=testup.drivermanager.getDriverManager();[m
 	}[m
[31m-[m
[31m-//	@Before(order = 0)[m
[31m-//	public void getProperty() {[m
[31m-//		configFileReader = new ConfigReader();[m
[31m-//		prop = configFileReader.init_prop();[m
[31m-//	}[m
[31m-//	[m
[31m-//	@Before(order = 1)[m
[31m-//	public void launchBrowser() {[m
[31m-//	[m
[31m-//		//String browserName = prop.getProperty("browser");[m
[31m-//		driverManager = new DriverManager();[m
[31m-//		try {[m
[31m-//			driver = driverManager.getDriverManager();[m
[31m-//		} catch (IOException e) {[m
[31m-//			[m
[31m-//			e.printStackTrace();[m
[31m-//		}[m
[32m+[m[32m/*[m[41m	[m
[32m+[m	[32m@Before(order = 0)[m
[32m+[m	[32mpublic void getProperty() {[m
[32m+[m		[32mconfigFileReader = new ConfigReader();[m
[32m+[m		[32mprop = configFileReader.init_prop();[m
[32m+[m	[32m}[m
[32m+[m[41m	[m
[32m+[m	[32m@Before(order = 1)[m
[32m+[m	[32mpublic void launchBrowser() {[m
[32m+[m[41m	[m
[32m+[m		[32m//String browserName = prop.getProperty("browser");[m
[32m+[m		[32mdriverManager = new DriverManager();[m
[32m+[m		[32mtry {[m
[32m+[m			[32mdriver = driverManager.getDriverManager();[m
[32m+[m		[32m} catch (IOException e) {[m
[32m+[m[41m			[m
[32m+[m			[32me.printStackTrace();[m
[32m+[m		[32m}[m
 		[m
[31m-//	}[m
[32m+[m	[32m}[m
 	[m
 	[m
 	[m
 	@After(order = 0)[m
 	public void quitBrowser() {[m
 		driver.quit();[m
[31m-	}[m
[32m+[m	[32m}*/[m
 	[m
 	@After(order = 1)[m
 	public void takeScreenshotOnFailure(Scenario scenario)[m
[1mdiff --git a/src/test/java/com/lmsapp/lms/stepDefinition/CommonMethodsStepDefinition.java b/src/test/java/com/lmsapp/lms/stepDefinition/CommonMethodsStepDefinition.java[m
[1mindex 8278a61..33a77ef 100644[m
[1m--- a/src/test/java/com/lmsapp/lms/stepDefinition/CommonMethodsStepDefinition.java[m
[1m+++ b/src/test/java/com/lmsapp/lms/stepDefinition/CommonMethodsStepDefinition.java[m
[36m@@ -1,5 +1,6 @@[m
 package com.lmsapp.lms.stepDefinition;[m
 [m
[32m+[m
 import java.io.IOException;[m
 import java.net.URISyntaxException;[m
 import java.util.concurrent.TimeoutException;[m
[36m@@ -16,32 +17,35 @@[m [mimport io.cucumber.java.en.Then;[m
 import io.cucumber.java.en.When;[m
 [m
 public class CommonMethodsStepDefinition {[m
[31m-[m
[32m+[m[41m	[m
 	WebDriver driver;[m
 	TestSetup testsetup;[m
 	CommonMethodsObject commonobj;[m
[31m-[m
[32m+[m[41m	[m
 	public CommonMethodsStepDefinition(TestSetup testsetup) throws IOException {[m
 		super();[m
 		this.testsetup = testsetup;[m
 		this.driver = testsetup.drivermanager.getDriverManager();[m
 		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();[m
[31m-[m
[32m+[m[41m		[m
 	}[m
[31m-[m
[32m+[m[41m	[m
[32m+[m[41m	[m
 	@Given("User is on dashboard page after Login and clicks User on the navigation bar")[m
 	public void user_is_on_dashboard_page_after_login_and_clicks_user_on_the_navigation_bar() {[m
 		commonobj.loginUser();[m
 	}[m
[32m+[m[41m	[m
[32m+[m[41m	[m
 [m
[31m-	@When("The user select Get Started button in user panel")[m
[31m-	public void the_user_select_get_started_button_in_user_panel() {[m
[31m-[m
[31m-	}[m
[31m-[m
[31m-	@Then("The user should be redirected to user page")[m
[31m-	public void the_user_should_be_redirected_to_user_page() {[m
[32m+[m[32m@When("The user select Get Started button in user panel")[m
[32m+[m[32mpublic void the_user_select_get_started_button_in_user_panel() {[m
[32m+[m[41m  [m
[32m+[m[32m}[m
 [m
[31m-	}[m
[32m+[m[32m@Then("The user should be redirected to user page")[m
[32m+[m[32mpublic void the_user_should_be_redirected_to_user_page() {[m
[32m+[m[41m   [m
[32m+[m[32m}[m
 [m
 }[m
[1mdiff --git a/src/test/java/com/lmsapp/lms/stepDefinition/E1_UserStepDefinition.java b/src/test/java/com/lmsapp/lms/stepDefinition/E1_UserStepDefinition.java[m
[1mdeleted file mode 100644[m
[1mindex dc00cc1..0000000[m
[1m--- a/src/test/java/com/lmsapp/lms/stepDefinition/E1_UserStepDefinition.java[m
[1m+++ /dev/null[m
[36m@@ -1,110 +0,0 @@[m
[31m-package com.lmsapp.lms.stepDefinition;[m
[31m-[m
[31m-import static org.testng.Assert.assertTrue;[m
[31m-[m
[31m-import java.io.BufferedReader;[m
[31m-import java.io.IOException;[m
[31m-import java.io.InputStreamReader;[m
[31m-import java.net.URL;[m
[31m-import java.net.URLConnection;[m
[31m-[m
[31m-import org.openqa.selenium.By;[m
[31m-import org.openqa.selenium.WebDriver;[m
[31m-import org.openqa.selenium.WebElement;[m
[31m-import org.testng.Assert;[m
[31m-import java.util.stream.*;[m
[31m-import com.lmsapp.lms.POM.CommonMethodsObject;[m
[31m-import com.lmsapp.lms.POM.User1_PageObject;[m
[31m-import com.lmsapp.lms.utilities.TestSetup;[m
[31m-import org.slf4j.Logger;[m
[31m-import org.slf4j.LoggerFactory;[m
[31m-[m
[31m-[m
[31m-import io.cucumber.java.en.*;[m
[31m-[m
[31m-public class E1_UserStepDefinition {[m
[31m-	[m
[31m-	[m
[31m-	WebDriver driver;[m
[31m-	TestSetup testsetup;[m
[31m-	CommonMethodsObject commonobj;[m
[31m-	public User1_PageObject user1obj;[m
[31m-	public static Logger LOG = LoggerFactory.getLogger(E1_UserStepDefinition.class);[m
[31m-	[m
[31m-	public E1_UserStepDefinition(TestSetup testsetup) throws IOException {[m
[31m-		super();[m
[31m-		this.testsetup = testsetup;[m
[31m-		this.driver = testsetup.drivermanager.getDriverManager();[m
[31m-		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();[m
[31m-		user1obj=testsetup.pageobjectmanager.getUser1MethodsObject();[m
[31m-	}[m
[31m-[m
[31m-	[m
[31m-	@Given("Admin is on dashboard page after Login")[m
[31m-	public void admin_is_on_dashboard_page_after_login() {[m
[31m-		commonobj.loginUser();[m
[31m-[m
[31m-	}[m
[31m-[m
[31m-	@When("Admin clicks {string} from navigation bar")[m
[31m-	public void admin_clicks_from_navigation_bar(String string) {[m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin should see the {string} in the URL")[m
[31m-	public void admin_should_see_the_in_the_url(String string)  {[m
[31m-		user1obj.navigateToUser();[m
[31m-	   }[m
[31m-[m
[31m-	[m
[31m-	@Then("Admin should see a heading with text {string} on the page")[m
[31m-	public void admin_should_see_a_heading_with_text_on_the_page(String string) {[m
[31m-		user1obj.ManageProgramValidation();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin should see the text as {string} along with Pagination icon below the table.")[m
[31m-	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String string) {[m
[31m-	    user1obj.CheckPaginationIcon();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin Should see the data table with column names Id, Name, location, Phone Number, Edit\\/Delete")[m
[31m-	public void admin_should_see_the_data_table_with_column_names_id_name_location_phone_number_edit_delete() {[m
[31m-		user1obj.CheckHeadignColumn();[m
[31m-	   [m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin should see a Delete button on the top left hand side as Disabled")[m
[31m-	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {[m
[31m-		user1obj.CheckDeleteButton();[m
[31m-	}[m
[31m-[m
[31m-	[m
[31m-	@Then("Admin should be able to see the {string} button above the data table-NewUser")[m
[31m-	public void admin_should_be_able_to_see_the_button_above_the_data_table_new_user(String string) {[m
[31m-		 user1obj.CheckAddNewUser();[m
[31m-	}[m
[31m-	[m
[31m-	@Then("Admin should be able to see the {string} button above the data table-Assign Staff")[m
[31m-	public void admin_should_be_able_to_see_the_button_above_the_data_table_assign_staff(String string) throws InterruptedException {[m
[31m-		Thread.sleep(1000);[m
[31m-		user1obj.CheckAddNewStaff();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin should be able to see the {string} button above the data table-Assign Student")[m
[31m-	public void admin_should_be_able_to_see_the_button_above_the_data_table_assign_student(String string) throws InterruptedException {[m
[31m-		Thread.sleep(1000);[m
[31m-		user1obj.CheckAddNewStudent();[m
[31m-	}[m
[31m-[m
[31m-[m
[31m-	@Then("Admin should be able to see the search text box above the data table")[m
[31m-	public void admin_should_be_able_to_see_the_search_text_box_above_the_data_table() {[m
[31m-	   user1obj.CheckSearchIcon();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin should see two  records displayed on the data table")[m
[31m-	public void admin_should_see_two_records_displayed_on_the_data_table() {[m
[31m-		 user1obj.RowDataCount();[m
[31m-	}[m
[31m-	[m
[31m-[m
[31m-}[m
[1mdiff --git a/src/test/java/com/lmsapp/lms/stepDefinition/E2_UserStepDefinition.java b/src/test/java/com/lmsapp/lms/stepDefinition/E2_UserStepDefinition.java[m
[1mdeleted file mode 100644[m
[1mindex 8b7728b..0000000[m
[1m--- a/src/test/java/com/lmsapp/lms/stepDefinition/E2_UserStepDefinition.java[m
[1m+++ /dev/null[m
[36m@@ -1,59 +0,0 @@[m
[31m-package com.lmsapp.lms.stepDefinition;[m
[31m-[m
[31m-import java.io.IOException;[m
[31m-[m
[31m-import org.openqa.selenium.WebDriver;[m
[31m-import org.slf4j.Logger;[m
[31m-import org.slf4j.LoggerFactory;[m
[31m-[m
[31m-import com.lmsapp.lms.POM.CommonMethodsObject;[m
[31m-import com.lmsapp.lms.POM.User1_PageObject;[m
[31m-import com.lmsapp.lms.POM.User2_PageObject;[m
[31m-import com.lmsapp.lms.utilities.TestSetup;[m
[31m-import io.cucumber.java.en.*;[m
[31m-[m
[31m-public class E2_UserStepDefinition {[m
[31m-[m
[31m-	WebDriver driver;[m
[31m-	TestSetup testsetup;[m
[31m-	CommonMethodsObject commonobj;[m
[31m-	public User2_PageObject user2obj;[m
[31m-	public static Logger LOG = LoggerFactory.getLogger(E1_UserStepDefinition.class);[m
[31m-	[m
[31m-	public E2_UserStepDefinition(TestSetup testsetup) throws IOException {[m
[31m-		super();[m
[31m-		this.testsetup = testsetup;[m
[31m-		this.driver = testsetup.drivermanager.getDriverManager();[m
[31m-		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();[m
[31m-		user2obj=testsetup.pageobjectmanager.getUser2MethodsObject();[m
[31m-	}[m
[31m-	[m
[31m-	[m
[31m-	@Given("Admin is on dashboard page after Login-User2")[m
[31m-	public void admin_is_on_dashboard_page_after_login_user2() {[m
[31m-		commonobj.loginUser();[m
[31m-	}[m
[31m-[m
[31m-	@When("Admin clicks {string} from navigation bar-User2")[m
[31m-	public void admin_clicks_from_navigation_bar_user2(String string) {[m
[31m-		user2obj.NavigatingUser();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Each row in the data table should have a checkbox")[m
[31m-	public void each_row_in_the_data_table_should_have_a_checkbox() throws InterruptedException {[m
[31m-		user2obj.CheckBoxCount();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Each row in the data table should have a edit icon that is enabled")[m
[31m-	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {[m
[31m-		user2obj.EditEnabledButton();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Each row in the data table should have a delete icon that is enabled")[m
[31m-	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() throws InterruptedException {[m
[31m-	  Thread.sleep(2000); [m
[31m-	  user2obj.DeleteButtonEnabled();[m
[31m-	}[m
[31m-[m
[31m-	[m
[31m-}[m
[1mdiff --git a/src/test/java/com/lmsapp/lms/stepDefinition/E3_UserStepDefinition.java b/src/test/java/com/lmsapp/lms/stepDefinition/E3_UserStepDefinition.java[m
[1mdeleted file mode 100644[m
[1mindex 48e1d81..0000000[m
[1m--- a/src/test/java/com/lmsapp/lms/stepDefinition/E3_UserStepDefinition.java[m
[1m+++ /dev/null[m
[36m@@ -1,82 +0,0 @@[m
[31m-package com.lmsapp.lms.stepDefinition;[m
[31m-[m
[31m-import java.io.IOException;[m
[31m-[m
[31m-import org.openqa.selenium.WebDriver;[m
[31m-import org.slf4j.Logger;[m
[31m-import org.slf4j.LoggerFactory;[m
[31m-[m
[31m-import com.lmsapp.lms.POM.CommonMethodsObject;[m
[31m-import com.lmsapp.lms.POM.User1_PageObject;[m
[31m-import com.lmsapp.lms.POM.User2_PageObject;[m
[31m-import com.lmsapp.lms.POM.User3_PageObject;[m
[31m-import com.lmsapp.lms.utilities.TestSetup;[m
[31m-import io.cucumber.java.en.*;[m
[31m-[m
[31m-public class E3_UserStepDefinition {[m
[31m-[m
[31m-	WebDriver driver;[m
[31m-	TestSetup testsetup;[m
[31m-	CommonMethodsObject commonobj;[m
[31m-	public User3_PageObject user3obj;[m
[31m-	public static Logger LOG = LoggerFactory.getLogger(E1_UserStepDefinition.class);[m
[31m-	[m
[31m-	public E3_UserStepDefinition(TestSetup testsetup) throws IOException {[m
[31m-		super();[m
[31m-		this.testsetup = testsetup;[m
[31m-		this.driver = testsetup.drivermanager.getDriverManager();[m
[31m-		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();[m
[31m-		user3obj=testsetup.pageobjectmanager.getUser3MethodsObject();[m
[31m-	}[m
[31m-	[m
[31m-	@Given("Admin is on Manage User Page-User3")[m
[31m-	public void admin_is_on_manage_user_page_user3() {[m
[31m-	  commonobj.loginUser();[m
[31m-	  user3obj.NavigatingUser();[m
[31m-	}[m
[31m-[m
[31m-	@When("Admin enters user name into search box-User3.")[m
[31m-	public void admin_enters_user_name_into_search_box_user3() {[m
[31m-		user3obj.NavigatingUser();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin should see user displayed with the entered name-User3")[m
[31m-	public void admin_should_see_user_displayed_with_the_entered_name_user3() {[m
[31m-	   user3obj.DisplayEnterName();[m
[31m-	   user3obj.UserDisplayed();[m
[31m-	}[m
[31m-[m
[31m-	@When("Admin enters the keywords not present in the data table on the Search box-User3")[m
[31m-	public void admin_enters_the_keywords_not_present_in_the_data_table_on_the_search_box_user3() {[m
[31m-		[m
[31m-		user3obj.Invalidata();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin should see zero entries on the data table-User3")[m
[31m-	public void admin_should_see_zero_entries_on_the_data_table_user3() {[m
[31m-	    user3obj.NodataDisplayed();[m
[31m-	}[m
[31m-	[m
[31m-	@When("Admin clicks {string} button")[m
[31m-	public void admin_clicks_button(String string) {[m
[31m-	 user3obj.NewUser();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin should see pop up open for user details")[m
[31m-	public void admin_should_see_pop_up_open_for_user_details() {[m
[31m-		user3obj.UsetWindow();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin should see all text boxes for the fields")[m
[31m-	public void admin_should_see_all_text_boxes_for_the_fields() {[m
[31m-		user3obj.TextBoxes();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin should see drop downs for the fields")[m
[31m-	public void admin_should_see_drop_downs_for_the_fields() {[m
[31m-	   user3obj.Countdropdown();[m
[31m-	}[m
[31m-[m
[31m-	[m
[31m-	[m
[31m-}[m
[1mdiff --git a/src/test/java/com/lmsapp/lms/stepDefinition/E4_UserStepDefinition.java b/src/test/java/com/lmsapp/lms/stepDefinition/E4_UserStepDefinition.java[m
[1mdeleted file mode 100644[m
[1mindex 54974d5..0000000[m
[1m--- a/src/test/java/com/lmsapp/lms/stepDefinition/E4_UserStepDefinition.java[m
[1m+++ /dev/null[m
[36m@@ -1,117 +0,0 @@[m
[31m-package com.lmsapp.lms.stepDefinition;[m
[31m-[m
[31m-import java.io.IOException;[m
[31m-[m
[31m-import org.openqa.selenium.WebDriver;[m
[31m-import org.slf4j.Logger;[m
[31m-import org.slf4j.LoggerFactory;[m
[31m-import com.lmsapp.lms.POM.CommonMethodsObject;[m
[31m-import com.lmsapp.lms.POM.User4_PageObject;[m
[31m-import com.lmsapp.lms.utilities.TestSetup;[m
[31m-[m
[31m-import io.cucumber.java.en.*;[m
[31m-[m
[31m-public class E4_UserStepDefinition {[m
[31m-	WebDriver driver;[m
[31m-	TestSetup testsetup;[m
[31m-	CommonMethodsObject commonobj;[m
[31m-	public User4_PageObject user4obj;[m
[31m-	public static Logger LOG = LoggerFactory.getLogger(E4_UserStepDefinition.class);[m
[31m-	[m
[31m-	public E4_UserStepDefinition(TestSetup testsetup) throws IOException {[m
[31m-		super();[m
[31m-		this.testsetup = testsetup;[m
[31m-		this.driver = testsetup.drivermanager.getDriverManager();[m
[31m-		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();[m
[31m-		user4obj=testsetup.pageobjectmanager.getUser4MethodsObject();[m
[31m-	}[m
[31m-	[m
[31m-	@Given("Admin is on  User details pop up-User4")[m
[31m-	public void admin_is_on_user_details_pop_up_user4() {[m
[31m-		commonobj.loginUser();[m
[31m-		user4obj.NavigatingUser();[m
[31m-		user4obj.NewUser();[m
[31m-	}[m
[31m-[m
[31m-	@When("Admin enters mandatory fields in the form and clicks on submit button.")[m
[31m-	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_submit_button() throws InterruptedException {[m
[31m-	Thread.sleep(2000);   [m
[31m-	   user4obj.TextFieldsValid();[m
[31m-[m
[31m-	   user4obj.ClickSubmit();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin gets message User added Successfully.")[m
[31m-	public void admin_gets_message_user_added_successfully() {[m
[31m-	  user4obj.HandlingAlert();[m
[31m-	}[m
[31m-[m
[31m-	@When("Admin skips to add value in mandatory field")[m
[31m-	public void admin_skips_to_add_value_in_mandatory_field() {[m
[31m-		 user4obj.OptionalFields();[m
[31m-		 [m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin should see error message below the test field and the field will be highlighed in red color")[m
[31m-	public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighed_in_red_color() {[m
[31m-		user4obj.ClickSubmit();[m
[31m-		user4obj.CheckigAlert();[m
[31m-	}[m
[31m-[m
[31m-	@When("Admin enters invalid data in all of the  fields in the form and clicks on submit button")[m
[31m-	public void admin_enters_invalid_data_in_all_of_the_fields_in_the_form_and_clicks_on_submit_button() {[m
[31m-	    user4obj.NumSplChar();[m
[31m-	    user4obj.ClickSubmit();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin gets error message and user is not created")[m
[31m-	public void admin_gets_error_message_and_user_is_not_created() {[m
[31m-	 user4obj.HandlingAlert();[m
[31m-	}[m
[31m-[m
[31m-	@When("Admin clicks on submit button without entering data")[m
[31m-	public void admin_clicks_on_submit_button_without_entering_data() {[m
[31m-	   user4obj.ClickSubmit();[m
[31m-	}[m
[31m-[m
[31m-	@Then("user won't be created and Admin gets error message")[m
[31m-	public void user_won_t_be_created_and_admin_gets_error_message() {[m
[31m-		user4obj.CheckigAlert();[m
[31m-	}[m
[31m-[m
[31m-	@When("Admin clicks Cancel or Close Icon on User Details form")[m
[31m-	public void admin_clicks_cancel_close_x_icon_on_user_details_form() {[m
[31m-	   user4obj.ClickCancel();[m
[31m-	}[m
[31m-[m
[31m-	@Then("User Details popup window should be closed without saving")[m
[31m-	public void user_details_popup_window_should_be_closed_without_saving() {[m
[31m-	    user4obj.FailedStatus();[m
[31m-	}[m
[31m-[m
[31m-	@When("Admin clicks Cancel button")[m
[31m-	public void admin_clicks_cancel_button() {[m
[31m-	user4obj.ClickCancel();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin can see the User details popup disappears without adding any user")[m
[31m-	public void admin_can_see_the_user_details_popup_disappears_without_adding_any_user() {[m
[31m-	   user4obj.FindDataBody();[m
[31m-	}[m
[31m-[m
[31m-	@When("Fill in all the fields with valid values and click submit")[m
[31m-	public void fill_in_all_the_fields_with_valid_values_and_click_submit() {[m
[31m-	   user4obj.TextFieldsValid();[m
[31m-	   user4obj.SelectRoleStatus("R02");[m
[31m-	   user4obj.SelectUserRole("Active");[m
[31m-	   user4obj.SelectVisaStatus("GC-EAD");[m
[31m-	   user4obj.ClickSubmit();[m
[31m-	}[m
[31m-[m
[31m-	@Then("The newly added user should be present in the data table in Manage User page")[m
[31m-	public void the_newly_added_user_should_be_present_in_the_data_table_in_manage_user_page() {[m
[31m-	    user4obj.FindDataBody();[m
[31m-	}[m
[31m-[m
[31m-[m
[31m-}[m
[1mdiff --git a/src/test/java/com/lmsapp/lms/stepDefinition/E5_UserStepDefination.java b/src/test/java/com/lmsapp/lms/stepDefinition/E5_UserStepDefination.java[m
[1mdeleted file mode 100644[m
[1mindex 1ec2142..0000000[m
[1m--- a/src/test/java/com/lmsapp/lms/stepDefinition/E5_UserStepDefination.java[m
[1m+++ /dev/null[m
[36m@@ -1,100 +0,0 @@[m
[31m-package com.lmsapp.lms.stepDefinition;[m
[31m-[m
[31m-import java.io.IOException;[m
[31m-[m
[31m-import org.openqa.selenium.WebDriver;[m
[31m-import org.slf4j.Logger;[m
[31m-import org.slf4j.LoggerFactory;[m
[31m-[m
[31m-import com.lmsapp.lms.POM.CommonMethodsObject;[m
[31m-import com.lmsapp.lms.POM.User5_PageObject;[m
[31m-import com.lmsapp.lms.utilities.TestSetup;[m
[31m-import io.cucumber.java.en.*;[m
[31m-[m
[31m-public class E5_UserStepDefination {[m
[31m-	WebDriver driver;[m
[31m-	TestSetup testsetup;[m
[31m-	CommonMethodsObject commonobj;[m
[31m-	public User5_PageObject user5obj;[m
[31m-	public static Logger LOG = LoggerFactory.getLogger(E1_UserStepDefinition.class);[m
[31m-	[m
[31m-	public E5_UserStepDefination(TestSetup testsetup) throws IOException {[m
[31m-		super();[m
[31m-		this.testsetup = testsetup;[m
[31m-		this.driver = testsetup.drivermanager.getDriverManager();[m
[31m-		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();[m
[31m-		user5obj=testsetup.pageobjectmanager.getUser5MethodsObject();[m
[31m-	}[m
[31m-	[m
[31m-	@Given("Admin is on Manage User Page")[m
[31m-	public void admin_is_on_manage_user_page() {[m
[31m-	   commonobj.loginUser();[m
[31m-	}[m
[31m-[m
[31m-	@When("Admin clicks on the edit icon")[m
[31m-	public void admin_clicks_on_the_edit_icon() {[m
[31m-	  user5obj.CheckingEditIcon();[m
[31m-	}[m
[31m-[m
[31m-	@Then("A new pop up with User details appears")[m
[31m-	public void a_new_pop_up_with_user_details_appears() {[m
[31m-	    user5obj.CheckingdataTable();[m
[31m-	}[m
[31m-[m
[31m-	@Given("Admin is on User details pop up")[m
[31m-	public void admin_is_on_user_details_pop_up() {[m
[31m-		commonobj.loginUser();[m
[31m-		user5obj.NavigatingUser();[m
[31m-		 user5obj.CheckingEditIcon();[m
[31m-	}[m
[31m-[m
[31m-	@When("Update the fields with valid data and click submit")[m
[31m-	public void update_the_fields_with_valid_data_and_click_submit() {[m
[31m-		  user5obj.UpdateEmail();[m
[31m-		user5obj.ClickSubmit();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin gets message {string} and see the updated values in data table")[m
[31m-	public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) {[m
[31m-		user5obj.updateSuccess();[m
[31m-	}[m
[31m-[m
[31m-	@When("Update the fields with invalid values and click submit")[m
[31m-	public void update_the_fields_with_invalid_values_and_click_submit() {[m
[31m-		user5obj.UpdateInvaliEmail();[m
[31m-		user5obj.ClickSubmit();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin should get Error message")[m
[31m-	public void admin_should_get_error_message() {[m
[31m-		user5obj.updateSuccessWithAlert();[m
[31m-	}[m
[31m-[m
[31m-	@When("Update the mandatory fields with valid values and click submit")[m
[31m-	public void update_the_mandatory_fields_with_valid_values_and_click_submit() {[m
[31m-		user5obj.MandotoryFields();[m
[31m-		user5obj.ClickSubmit();[m
[31m-	}[m
[31m-[m
[31m-	@When("Update the optional fields with valid values and click submit")[m
[31m-	public void update_the_optional_fields_with_valid_values_and_click_submit() {[m
[31m-		user5obj.OptionalFields();[m
[31m-		user5obj.ClickSubmit();[m
[31m-	}[m
[31m-[m
[31m-	@When("Admin enters only numbers or special char in the text fields")[m
[31m-	public void admin_enters_only_numbers_or_special_char_in_the_text_fields() {[m
[31m-		user5obj.NumSplChar();[m
[31m-	}[m
[31m-[m
[31m-	@When("Admin clicks Cancel button on edit popup")[m
[31m-	public void admin_clicks_cancel_button_on_edit_popup() {[m
[31m-		user5obj.Cancel();[m
[31m-	}[m
[31m-[m
[31m-	@Then("Admin can see the User details popup disappears and can see nothing changed for particular User")[m
[31m-	public void admin_can_see_the_user_details_popup_disappears_and_can_see_nothing_changed_for_particular_user() {[m
[31m-		user5obj.DataBoday();[m
[31m-	}[m
[31m-[m
[31m-}[m
[1mdiff --git a/src/test/java/com/lmsapp/lms/testRunner/TestRunnerTestNG.java b/src/test/java/com/lmsapp/lms/testRunner/TestRunnerTestNG.java[m
[1mindex 6955552..0bfa07a 100644[m
[1m--- a/src/test/java/com/lmsapp/lms/testRunner/TestRunnerTestNG.java[m
[1m+++ b/src/test/java/com/lmsapp/lms/testRunner/TestRunnerTestNG.java[m
[36m@@ -28,9 +28,9 @@[m [mimport io.cucumber.testng.CucumberOptions;[m
 public class TestRunnerTestNG extends AbstractTestNGCucumberTests{[m
 		[m
 //		 this is for pararell execution	, scenarios() present in AbstractTestNGCucumberTests() class.[m
[31m-//		@Override       [m
[31m-//		@DataProvider(parallel = true)[m
[31m-//		public Object[][] scenarios() {[m
[31m-//			return super.scenarios();[m
[31m-//		}[m
[32m+[m		[32m@Override[m[41m       [m
[32m+[m		[32m@DataProvider(parallel = true)[m
[32m+[m		[32mpublic Object[][] scenarios() {[m
[32m+[m			[32mreturn super.scenarios();[m
[32m+[m		[32m}[m
 }[m
\ No newline at end of file[m
[1mdiff --git a/src/test/java/com/lmsapp/lms/utilities/ConfigReader.java b/src/test/java/com/lmsapp/lms/utilities/ConfigReader.java[m
[1mindex 88d39d4..56d99a1 100644[m
[1m--- a/src/test/java/com/lmsapp/lms/utilities/ConfigReader.java[m
[1m+++ b/src/test/java/com/lmsapp/lms/utilities/ConfigReader.java[m
[36m@@ -35,77 +35,5 @@[m [mpublic class ConfigReader {[m
 		}[m
 		prop.get().setProperty(key,value);[m
 	}[m
[31m-	[m
[31m-	public String getLocation() {[m
[31m-	    if (prop.get() == null) {[m
[31m-	        init_prop();[m
[31m-	    }[m
[31m-	    return prop.get().getProperty("Location");[m
[31m-	}[m
[31m-[m
[31m-	public String getEmail() {[m
[31m-	    if (prop.get() == null) {[m
[31m-	        init_prop();[m
[31m-	    }[m
[31m-	    return prop.get().getProperty("Email");[m
[31m-	}[m
[31m-	    [m
[31m-		public String getURL() {[m
[31m-		    if (prop.get() == null) {[m
[31m-		        init_prop();[m
[31m-		    }[m
[31m-		    return prop.get().getProperty("URL");[m
[31m-		}[m
[31m-	    [m
[31m-	    public String getFirstName() {[m
[31m-		    if (prop.get() == null) {[m
[31m-		        init_prop();[m
[31m-		    }[m
[31m-		    return prop.get().getProperty("FirstName");[m
[31m-	    }[m
[31m-	    [m
[31m-	    public  String getLastName(){[m
[31m-	        if (prop.get() == null) {[m
[31m-	            init_prop();[m
[31m-	        }[m
[31m-	        return prop.get().getProperty("LastName");[m
[31m-	    }[m
[31m-	    [m
[31m-	    public  String getMiddleName(){[m
[31m-	        if (prop.get() == null) {[m
[31m-	            init_prop();[m
[31m-	        }[m
[31m-	        return prop.get().getProperty("MiddleName");[m
[31m-	    }[m
[31m-[m
[31m-	    public  String getPhoneNumber(){[m
[31m-	        if (prop.get() == null) {[m
[31m-	            init_prop();[m
[31m-	        }[m
[31m-	        return prop.get().getProperty("PhoneNumber");[m
[31m-	    }[m
[31m-	    [m
[31m-	    public  String getPostGraduate(){[m
[31m-	        if (prop.get() == null) {[m
[31m-	            init_prop();[m
[31m-	        }[m
[31m-	        return prop.get().getProperty("PostGraduate");[m
[31m-	    }[m
[31m-	    [m
[31m-	    public  String getGraduate(){[m
[31m-	        if (prop.get() == null) {[m
[31m-	            init_prop();[m
[31m-	        }[m
[31m-	        return prop.get().getProperty("Graduate");[m
[31m-	    }[m
[31m-	    [m
[31m-	    public  String getComments(){[m
[31m-	        if (prop.get() == null) {[m
[31m-	            init_prop();[m
[31m-	        }[m
[31m-	        return prop.get().getProperty("Comments");[m
[31m-	    }[m
[31m-	}[m
[31m-[m
[31m-[m
 [m
[32m+[m[32m}[m
[1mdiff --git a/src/test/java/com/lmsapp/lms/utilities/ExcelReader.java b/src/test/java/com/lmsapp/lms/utilities/ExcelReader.java[m
[1mindex 79e9840..9cf4f5c 100644[m
[1m--- a/src/test/java/com/lmsapp/lms/utilities/ExcelReader.java[m
[1m+++ b/src/test/java/com/lmsapp/lms/utilities/ExcelReader.java[m
[36m@@ -56,7 +56,7 @@[m [mpublic class ExcelReader {[m
 	public ExcelReader(String xlFilePath) {[m
 		try {[m
 			this.xlFilePath = xlFilePath;[m
[31m-			fis = new FileInputStream("C://Users//shilp//git//LMS-Portal//src//test//java//com//lmsapp//lms//utilities//ExcelReader.java");[m
[32m+[m			[32mfis = new FileInputStream(xlFilePath);[m
 			workbook = new XSSFWorkbook(fis);[m
 			[m
 		} catch (Exception e) {[m
[36m@@ -82,7 +82,7 @@[m [mpublic class ExcelReader {[m
 			if (r != null)// This whole row is empty[m
 			{[m
 				if (!(r.getCell(0) == null)) {[m
[31m-					 System.out.println("Row <>>>>>>>>>>>>"+r.getCell(0).getStringCellValue());[m
[32m+[m					[32m// System.out.println("Row <>>>>>>>>>>>>"+r.getCell(0).getStringCellValue());[m
 					rowCount = rowNum;[m
 				}[m
 				continue;[m
[36m@@ -106,7 +106,7 @@[m [mpublic class ExcelReader {[m
 		sheet = workbook.getSheet(sheet_name);[m
 		int colCount = getColumnCount();[m
 		int rowCount = getRowCount() + 1;[m
[31m-		System.out.println("Row Count & Col Count>>>>>>>"+rowCount +colCount);[m
[32m+[m		[32m//System.out.println("Row Count & Col Count>>>>>>>"+rowCount +colCount);[m
 		String[][] dataTable = null;[m
 		dataTable = new String[rowCount][colCount];[m
 		Iterator<Row> iterator = sheet.iterator();[m
[36m@@ -121,7 +121,7 @@[m [mpublic class ExcelReader {[m
 				while (cellIterator.hasNext()) {[m
 [m
 					Cell currentCell = cellIterator.next();[m
[31m-					System.out.println("Cell Type  :"+ currentCell.getCellType());[m
[32m+[m					[32m//System.out.println("Cell Type  :"+ currentCell.getCellType());[m
 					String ct=currentCell.getCellType().toString();[m
 			        [m
 					if (ct.equals("STRING")&& currentCell.getStringCellValue().length() == 0) {[m
[1mdiff --git a/src/test/java/com/lmsapp/lms/utilities/dataDriven.java b/src/test/java/com/lmsapp/lms/utilities/dataDriven.java[m
[1mdeleted file mode 100644[m
[1mindex d22a41b..0000000[m
[1m--- a/src/test/java/com/lmsapp/lms/utilities/dataDriven.java[m
[1m+++ /dev/null[m
[36m@@ -1,51 +0,0 @@[m
[31m-package com.lmsapp.lms.utilities;[m
[31m-[m
[31m-import java.io.IOException;[m
[31m-import java.util.ArrayList;[m
[31m-import java.io.FileInputStream;[m
[31m-import org.apache.poi.ss.usermodel.Cell;[m
[31m-import org.apache.poi.ss.usermodel.CellType;[m
[31m-import org.apache.poi.ss.usermodel.Row;[m
[31m-import org.apache.poi.xssf.usermodel.XSSFSheet;[m
[31m-import org.apache.poi.xssf.usermodel.XSSFWorkbook;[m
[31m-import java.util.Iterator;[m
[31m-[m
[31m-public class dataDriven {[m
[31m-[m
[31m-	public void getData(String testcaseName) throws IOException[m
[31m-	{[m
[31m-	//fileInputStream argument[m
[31m-	ArrayList<String> a=new ArrayList<String>();[m
[31m-[m
[31m-	FileInputStream fis=new FileInputStream("C://Users//shilp//git//LMS-Portal//src//test//java//com//lmsapp//lms//utilities//ExcelReader.java");[m
[31m-	XSSFWorkbook workbook=new XSSFWorkbook(fis);[m
[31m-[m
[31m-	XSSFSheet sheet=workbook.getSheet("sheet1");[m
[31m-	[m
[31m-//	XSSFSheet sheet=workbook.getSheetAt(i);[m
[31m-[m
[31m-[m
[31m-	Iterator<Row>  rows= sheet.iterator();// sheet is collection of rows[m
[31m-	Row firstrow= rows.next();[m
[31m-	Row secondrow=rows.next();[m
[31m-	Iterator<Cell> ce=secondrow.cellIterator();//row is collection of cells[m
[31m-	int k=0;[m
[31m-	int coloumn = 0;[m
[31m-	while(ce.hasNext())[m
[31m-	{[m
[31m-		 Row row = rows.next();[m
[31m-		    Iterator<Cell> cells = row.cellIterator(); // row is a collection of cells[m
[31m-		    while (cells.hasNext()) {[m
[31m-		        Cell cell = cells.next();[m
[31m-		        // Process the cell data here[m
[31m-		        System.out.print(cell.getStringCellValue() + "\t");[m
[31m-		        [m
[31m-		    }[m
[31m-[m
[31m-	System.out.println(coloumn);[m
[31m-[m
[31m-[m
[31m-}[m
[31m-}[m
[31m-	}[m
[31m-	[m
\ No newline at end of file[m
[1mdiff --git a/src/test/java/com/lmsapp/lms/webDriverManager/DriverManager.java b/src/test/java/com/lmsapp/lms/webDriverManager/DriverManager.java[m
[1mindex 155abbb..3054558 100644[m
[1m--- a/src/test/java/com/lmsapp/lms/webDriverManager/DriverManager.java[m
[1m+++ b/src/test/java/com/lmsapp/lms/webDriverManager/DriverManager.java[m
[36m@@ -34,8 +34,8 @@[m [mpublic class DriverManager {[m
                switch (browserType.toLowerCase()) {[m
                 case "chrome":[m
                     WebDriverManager.chromedriver().setup();[m
[31m-                    ChromeOptions chromeoption = new ChromeOptions();[m
[31m-                    chromeoption.addArguments("--headless");[m
[32m+[m[32m                   // ChromeOptions chromeoption = new ChromeOptions();[m
[32m+[m[32m                   // chromeoption.addArguments("--headless");[m
                     driver = new ChromeDriver();[m
                     break;[m
                 case "edge":[m
[1mdiff --git a/src/test/resources/extent.properties b/src/test/resources/extent.properties[m
[1mindex 3372a72..280e3de 100644[m
[1m--- a/src/test/resources/extent.properties[m
[1m+++ b/src/test/resources/extent.properties[m
[36m@@ -12,15 +12,4 @@[m [mextent.reporter.html.screenshot.embed=true[m
 [m
 #screenshot path[m
 screenshot.dir=screenshot/[m
[31m-screenshot.rel.path=../../screenshot/[m
[31m-[m
[31m-Location=America[m
[31m-URL=www.linkedin.com/in/Ram-Janaki[m
[31m-FirstName= Ram[m
[31m-MiddleName=Lakshman[m
[31m-LastName=Janaki[m
[31m-PhoneNumber=1234567890[m
[31m-email= janaki@gmail.com[m
[31m-Graduate=BE[m
[31m-PostGraduate=MS[m
[31m-Comments=success[m
\ No newline at end of file[m
[32m+[m[32mscreenshot.rel.path=../../screenshot/[m
\ No newline at end of file[m
[1mdiff --git a/src/test/resources/features/E1_User.feature b/src/test/resources/features/E1_User.feature[m
[1mdeleted file mode 100644[m
[1mindex b696e96..0000000[m
[1m--- a/src/test/resources/features/E1_User.feature[m
[1m+++ /dev/null[m
[36m@@ -1,59 +0,0 @@[m
[31m-[m
[31m-[m
[31m-@tag[m
[31m-Feature: User page validation[m
[31m-  I want to use this template for my feature file[m
[31m-[m
[31m-[m
[31m- Background: Logged on the LMS portal as admin[m
[31m-    Given Admin is on dashboard page after Login[m
[31m-[m
[31m-  #@tag1[m
[31m-  Scenario: Validate landing in User page[m
[31m-    When Admin clicks "User" from navigation bar[m
[31m-    Then Admin should see the "Manage User" in the URL[m
[31m-[m
[31m-  #@tag2[m
[31m-  Scenario: Validate the heading[m
[31m-    When Admin clicks "User" from navigation bar[m
[31m-    Then Admin should see a heading with text "Manage user" on the page[m
[31m-[m
[31m-  @tag3[m
[31m-  Scenario: Validate the text and pagination icon below the data table[m
[31m-    When Admin clicks "User" from navigation bar[m
[31m-    Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table.[m
[31m-    [m
[31m-   @tag4[m
[31m-  Scenario: Validate data table headers in the User Page[m
[31m-    When Admin clicks "User" from navigation bar[m
[31m-    Then Admin Should see the data table with column names Id, Name, location, Phone Number, Edit/Delete[m
[31m-    [m
[31m-    @tag5[m
[31m-  Scenario: Validating the default state of Delete button[m
[31m-    When Admin clicks "User" from navigation bar[m
[31m-    Then Admin should see a Delete button on the top left hand side as Disabled[m
[31m-    [m
[31m-     @tag6[m
[31m-  Scenario: Validate "+ A New user" button in User Page[m
[31m-    When Admin clicks "User" from navigation bar[m
[31m-    Then Admin should be able to see the "+ A New User" button above the data table-NewUser[m
[31m-    [m
[31m-     @tag7[m
[31m-    Scenario: Validate "+ Assign staff"  button in User page[m
[31m-    When Admin clicks "User" from navigation bar[m
[31m-    Then Admin should be able to see the "+ Assign staff" button above the data table-Assign Staff[m
[31m-    [m
[31m-     @tag8[m
[31m-    Scenario: Validate "+ Assign Student"  button in User page[m
[31m-    When Admin clicks "User" from navigation bar[m
[31m-    Then Admin should be able to see the "+ Assign Student" button above the data table-Assign Student[m
[31m-    [m
[31m-     @tag9[m
[31m-    Scenario: Validate search box in User page[m
[31m-    When Admin clicks "User" from navigation bar[m
[31m-    Then Admin should be able to see the search text box above the data table[m
[31m-    [m
[31m-     @tag10[m
[31m-  Scenario: Validate number of data rows in the data [m
[31m-    When Admin clicks "User" from navigation bar[m
[31m-    Then Admin should see two  records displayed on the data table[m
[1mdiff --git a/src/test/resources/features/E2_User.feature b/src/test/resources/features/E2_User.feature[m
[1mdeleted file mode 100644[m
[1mindex 0ee1745..0000000[m
[1m--- a/src/test/resources/features/E2_User.feature[m
[1m+++ /dev/null[m
[36m@@ -1,27 +0,0 @@[m
[31m-[m
[31m-@tag[m
[31m-Feature: User page validation[m
[31m-  I want to use this template for my feature file[m
[31m-  [m
[31m- Background: Logged on the LMS portal as admin[m
[31m- Given Admin is on dashboard page after Login-User2[m
[31m- [m
[31m-  @tag1[m
[31m-  Scenario: Verify Check box on the data table[m
[31m-    When Admin clicks "User" from navigation bar-User2[m
[31m-    Then Each row in the data table should have a checkbox[m
[31m-[m
[31m-[m
[31m-  @tag2[m
[31m-  Scenario: Verify edit icon on the data table[m
[31m-[m
[31m-    When Admin clicks "User" from navigation bar-User2[m
[31m-    Then Each row in the data table should have a edit icon that is enabled[m
[31m-[m
[31m-    @tag3[m
[31m-    Scenario: Verify  delete icon on the data table[m
[31m-    [m
[31m-    When Admin clicks "User" from navigation bar-User2[m
[31m-    Then Each row in the data table should have a delete icon that is enabled[m
[31m-    [m
[31m-    [m
\ No newline at end of file[m
[1mdiff --git a/src/test/resources/features/E3_User.feature b/src/test/resources/features/E3_User.feature[m
[1mdeleted file mode 100644[m
[1mindex 68d9449..0000000[m
[1m--- a/src/test/resources/features/E3_User.feature[m
[1m+++ /dev/null[m
[36m@@ -1,37 +0,0 @@[m
[31m-@tag[m
[31m- Feature: User page validation[m
[31m-  I want to use this template for my feature file[m
[31m-[m
[31m-[m
[31m- Background: Admin is on dashboard page after Login[m
[31m- and clicks User on the navigation bar[m
[31m- Given Admin is on Manage User Page-User3[m
[31m-[m
[31m-[m
[31m-    @tag1[m
[31m-    Scenario: Search user by name[m
[31m-    When Admin enters user name into search box-User3.[m
[31m-    Then Admin should see user displayed with the entered name-User3[m
[31m-[m
[31m-[m
[31m-    @tag2[m
[31m-    Scenario: Validating the Search with unrelated keyword [m
[31m-    When Admin enters the keywords not present in the data table on the Search box-User3[m
[31m-    Then Admin should see zero entries on the data table-User3[m
[31m-    [m
[31m-    @tag3 [m
[31m-    Scenario: Validate User Details Popup window[m
[31m-    When Admin clicks "+ A New User" button[m
[31m-    Then Admin should see pop up open for user details [m
[31m-    [m
[31m-    @tag4 [m
[31m-    Scenario: Validate input fields and text boxes in user details form[m
[31m-    When Admin clicks "+ A New User" button[m
[31m-    Then Admin should see all text boxes for the fields[m
[31m-    [m
[31m-    @tag5[m
[31m-    Scenario: Validate drop downs in new user form[m
[31m-    When Admin clicks "+ A New User" button[m
[31m-    Then Admin should see drop downs for the fields[m
[31m-    [m
[31m- [m
\ No newline at end of file[m
[1mdiff --git a/src/test/resources/features/E4_User.feature b/src/test/resources/features/E4_User.feature[m
[1mdeleted file mode 100644[m
[1mindex 9b38dc3..0000000[m
[1m--- a/src/test/resources/features/E4_User.feature[m
[1m+++ /dev/null[m
[36m@@ -1,45 +0,0 @@[m
[31m-@tag[m
[31m-Feature: Add new user[m
[31m-  I want to use this template for my feature file[m
[31m-[m
[31m-[m
[31m-Background: Admin is on the Manage User Page after clicking on User on the navigation bar[m
[31m-    Given Admin is on  User details pop up-User4[m
[31m-[m
[31m-[m
[31m-    @tag1[m
[31m-    Scenario: Check if user is created when only mandatory fields are entered with valid data[m
[31m-    When Admin enters mandatory fields in the form and clicks on submit button.[m
[31m-    Then Admin gets message User added Successfully.[m
[31m-[m
[31m-[m
[31m-    @tag2[m
[31m-    Scenario: Check if user is created when only optional fields are entered with valid data[m
[31m-    When Admin skips to add value in mandatory field[m
[31m-    Then Admin should see error message below the test field and the field will be highlighed in red color[m
[31m-    [m
[31m-    @tag3 [m
[31m-    Scenario: check if user is created when invalid data is entered in all of the fields[m
[31m-    When Admin enters invalid data in all of the  fields in the form and clicks on submit button[m
[31m-    Then Admin gets error message and user is not created [m
[31m-    [m
[31m-    @tag4 [m
[31m-    Scenario: Empty form submission[m
[31m-    When Admin clicks on submit button without entering data [m
[31m-    Then user won't be created and Admin gets error message[m
[31m-    [m
[31m-    @tag5[m
[31m-    Scenario: Validate Cancel/Close(X) icon on User Details form[m
[31m-    When Admin clicks Cancel or Close Icon on User Details form[m
[31m-    Then User Details popup window should be closed without saving[m
[31m-    [m
[31m-    [m
[31m-    @tag6[m
[31m-    Scenario:Validate Cancel button on User Details form[m
[31m-    When Admin clicks Cancel button [m
[31m-    Then Admin can see the User details popup disappears without adding any user[m
[31m-    [m
[31m-     @tag7[m
[31m-    Scenario: Check if the user details are added in data table[m
[31m-    When Fill in all the fields with valid values and click submit[m
[31m-    Then The newly added user should be present in the data table in Manage User page[m
\ No newline at end of file[m
[1mdiff --git a/src/test/resources/features/E5_User.feature b/src/test/resources/features/E5_User.feature[m
[1mdeleted file mode 100644[m
[1mindex 1bb79c9..0000000[m
[1m--- a/src/test/resources/features/E5_User.feature[m
[1m+++ /dev/null[m
[36m@@ -1,48 +0,0 @@[m
[31m-[m
[31m-Feature: Edit new user[m
[31m-  I want to use this template for my feature file[m
[31m-[m
[31m-  #@tag1[m
[31m-  #Scenario: Validate row level edit icon[m
[31m-    #Given Admin is on Manage User Page[m
[31m-    #When Admin clicks on the edit icon [m
[31m-    #Then A new pop up with User details appears[m
[31m-[m
[31m-[m
[31m-  @tag2[m
[31m-  Scenario: Check if the fields are updated with valid data[m
[31m-    Given Admin is on User details pop up[m
[31m-    When Update the fields with valid data and click submit[m
[31m-    Then Admin gets message "User updated Successfully " and see the updated values in data table[m
[31m-[m
[31m-  @tag3[m
[31m-  Scenario: Check if the fields are updated with invalid values[m
[31m-  Given Admin is on User details pop up[m
[31m-  When Update the fields with invalid values and click submit[m
[31m-  Then Admin should get Error message [m
[31m-  [m
[31m-  @tag4[m
[31m-  Scenario: Check if the mandatory fields are updated with valid data[m
[31m-  Given Admin is on User details pop up[m
[31m-  When Update the mandatory fields with valid values and click submit[m
[31m-  Then Admin gets message "User updated Successfully " and see the updated values in data table[m
[31m-  [m
[31m-  @tag5[m
[31m-  Scenario: Check if the optional fields are updated with valid data[m
[31m-  Given Admin is on User details pop up[m
[31m-  When Update the optional fields with valid values and click submit[m
[31m-  Then Admin gets message "User updated Successfully " and see the updated values in data table[m
[31m-  [m
[31m-  @tag6[m
[31m-  Scenario: Validate invalid values in the text fields[m
[31m-  Given Admin is on User details pop up[m
[31m-  When Admin enters only numbers or special char in the text fields[m
[31m-  Then Admin should get Error message [m
[31m-  [m
[31m-  @tag7[m
[31m-  Scenario: Validate Cancel button on Edit popup[m
[31m-  Given Admin is on User details pop up[m
[31m-  When Admin clicks Cancel button on edit popup[m
[31m-  Then Admin can see the User details popup disappears and can see nothing changed for particular User[m
[31m-  [m
[31m- [m
\ No newline at end of file[m
[1mdiff --git a/src/test/resources/testData/TestData.xlsx b/src/test/resources/testData/TestData.xlsx[m
[1mindex c2448d2..25d6294 100644[m
Binary files a/src/test/resources/testData/TestData.xlsx and b/src/test/resources/testData/TestData.xlsx differ
[1mdiff --git a/testng1.xml b/testng1.xml[m
[1mdeleted file mode 100644[m
[1mindex bbb67a1..0000000[m
[1m--- a/testng1.xml[m
[1m+++ /dev/null[m
[36m@@ -1,9 +0,0 @@[m
[31m-<?xml version="1.0" encoding="UTF-8"?>[m
[31m-<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">[m
[31m-<suite parallel="classes" name="Suite">[m
[31m-  <test thread-count="5" parallel="classes" name="Test">[m
[31m-    <classes>[m
[31m-      <class name="com.lmsapp.lms.hooks.Hooks"/>[m
[31m-    </classes>[m
[31m-  </test> <!-- Test -->[m
[31m-</suite> <!-- Suite -->[m
