package com.lmsapp.lms.POM;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ManageUserPOM2 {

	WebDriver driver;

	public static Logger LOG = LoggerFactory.getLogger(CommonMethodsObject.class);

	public ManageUserPOM2(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[@class='mat-button-wrapper' and text()='User']")
	WebElement userLnk;
	@FindBy(xpath = "//th[@psortablecolumn='userId']")
	WebElement idIcon;
	@FindBy(xpath = "//th[@psortablecolumn='userFirstName']")
	WebElement nameIcon;
	@FindBy(xpath = "//th[@psortablecolumn='userLocation']")
	WebElement locationIcon;
	@FindBy(xpath = "//th[@psortablecolumn='userPhoneNumber']")
	WebElement phnumberIcon;
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']/..")
	WebElement nextBtn;
	@FindBy(xpath = "//button[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only']")
	WebElement deleteIcon;
	@FindBy(xpath = "//span[normalize-space()='No']")
	WebElement alertNoBtn;
	@FindBy(xpath = "//span[normalize-space()='Yes']")
	WebElement alertYesBtn;
	@FindBy(xpath = "//span[@class='pi pi-times ng-tns-c133-9']/..")
	WebElement alertCloseBtn;
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-left']/..")
	WebElement goBackBtn;
	@FindBy(xpath = "//button[@id='Assign'  and @label='Assign Student']")
	WebElement assignStudentBtn;
	@FindBy(xpath = "//button[@label='Save']")
	WebElement assignStdSaveBtn;
	@FindBy(xpath = "//button[@label='Cancel']")
	WebElement assignStdCancelBtn;
	@FindBy(xpath = "//span[contains(text(),'Assign Student')]//following-sibling::div//button")
	WebElement assignStdCloseBtn;
	@FindBy(xpath = "//span[contains(text(),'Assign User')]//following-sibling::div//button")
	WebElement assignSaffCloseBtn;
	@FindBy(xpath="//button[@id='Assign' and @label='Assign Staff']")
	WebElement assignStaffBtn;
	@FindBy(xpath="//input[@id='skillName']")
	WebElement skillTxtBox;

	public void navigateToUser() {
		try {
			userLnk.click();
			Assert.assertTrue(driver.getCurrentUrl().contains("user"));
			LOG.info("Admin has landded on Manage User Page");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<String> sortFnc(int columnIndex) {
		List<WebElement> originalList;
		ArrayList<String> originalListItems = new ArrayList<>();
		boolean endOfpage = true;
		String classAttributeValue = nextBtn.getAttribute("class");
		try {

			while (endOfpage) {

				originalList = driver.findElements(By.xpath("//tr/td[" + columnIndex + "]"));
				// System.out.println(originalList.size());

				for (WebElement element : originalList) {
					// System.out.println(element.getText());
					originalListItems.add(element.getText().toLowerCase());
				}

				PageFactory.initElements(driver, this);
				classAttributeValue = nextBtn.getAttribute("class");

				if (classAttributeValue != null && classAttributeValue.contains("p-disabled")) {
					endOfpage = false;
					break;
				} else {
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", nextBtn);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return originalListItems;
	}

	public void sortUsers(String headerElement) {

		ArrayList<String> sortedList = new ArrayList<>();
		ArrayList<String> aftersortedlList = new ArrayList<>();
		int columnIndex = 0;
		WebElement sortElement = null;
		try {

			switch (headerElement.toLowerCase()) {
			case "id":
				sortElement = idIcon;
				columnIndex = 2;
				break;
			case "name":
				sortElement = nameIcon;
				columnIndex = 3;
				break;
			case "location":
				sortElement = locationIcon;
				columnIndex = 4;
				break;
			case "phonenumber":
				sortElement = phnumberIcon;
				columnIndex = 5;
				break;

			}
			// ascending order sorting
			sortedList = sortFnc(columnIndex);
			Collections.sort(sortedList);
			sortElement.click();
			aftersortedlList = sortFnc(columnIndex);
			SoftAssert softassert= new SoftAssert();
				
			softassert.assertEquals(sortedList, aftersortedlList);

			// Descending order sorting
			Collections.sort(sortedList, Collections.reverseOrder());
			sortElement.click();
			aftersortedlList = sortFnc(columnIndex);
			softassert.assertEquals(sortedList, aftersortedlList);
			softassert.assertAll();

			LOG.info("Sorting validated successfully ");
		} catch (Exception e) {
		
			e.printStackTrace();
		}

	}

	/*
	 * public void deleteUser(List<String> UserID) { try { ArrayList<String>
	 * userIDList = new ArrayList<>(); userIDList=sortFnc(2);
	 * 
	 * for(int i=0;i<UserID.size();i++) { String deletionUserID=UserID.get(i);
	 * for(int j=0;j<userIDList.size();j++) {
	 * if(deletionUserID.equalsIgnoreCase(userIDList.get(j))) {
	 * System.out.println(UserID.get(i)); String uid=UserID.get(i); boolean
	 * elementnotfound=true; List <String>originalListItems=new ArrayList<>();
	 * idIcon.click(); goBackBtn.click(); while(elementnotfound) {
	 * 
	 * List <WebElement>originalList = driver.findElements(By.xpath("//tr/td[2]"));
	 * 
	 * for (WebElement element : originalList) {
	 * //System.out.println(element.getText());
	 * originalListItems.add(element.getText().toLowerCase()); } for (String element
	 * : originalListItems) { if(deletionUserID.equalsIgnoreCase(element)) {
	 * WebElement chkbox=driver.findElement(By.xpath("//tr/td[contains(text(),'" +
	 * uid + "')]//preceding-sibling::td[1]")); chkbox.click(); WebElement
	 * deleteBtn=driver.findElement(By.xpath("//tr/td[contains(text(),'" + uid +
	 * "')]//following-sibling::td[4]//button[2]")); deleteBtn.click();
	 * alertCloseBtn.click(); elementnotfound=false; break; } else if
	 * (nextBtn.isEnabled()) { JavascriptExecutor executor = (JavascriptExecutor)
	 * driver; executor.executeScript("arguments[0].click();", nextBtn); } else {
	 * break; }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * } //String uppercaseUserID = userIDList.get(i).toUpperCase();
	 * 
	 * }
	 * 
	 * }catch (Exception e) { e.printStackTrace(); }
	 * 
	 * 
	 * }
	 */

	public void delete1(List<String> UserID) throws InterruptedException {
		List<String> ids = new ArrayList<>(UserID);
		Collections.sort(ids);
		idIcon.click();
		int index = 0;
		boolean gotoNextPage = false;

		do {
			for (int i = index; i < ids.size(); i++) {
				String id = ids.get(i);
				try {
					System.out.println(id);
					WebElement chkbox = driver
							.findElement(By.xpath("//tr/td[contains(text(),'" + id + "')]//preceding-sibling::td[1]"));
					chkbox.click();
					WebElement deleteBtn = driver.findElement(
							By.xpath("//tr/td[contains(text(),'" + id + "')]//following-sibling::td[4]//button[2]"));
					deleteBtn.click();
					alertCloseBtn.click();

				} catch (NoSuchElementException ex) {
					gotoNextPage = true;
					break;
				}
				index++;
			}

			if (gotoNextPage && index < ids.size()) {
				if (nextBtn.isEnabled()) {
					nextBtn.click();
				} else {
					break;
				}
			}
			if (index == ids.size())
				break;
		} while (gotoNextPage || !ids.isEmpty());

	}

	public void clickassignStudentBtn() {
		try {
			assignStudentBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void clickassignStaffBtn() {
		try {
			assignStaffBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void assignStdtPopupvalidation1() {

		try {
			Assert.assertTrue(assignStdSaveBtn.isEnabled(), "Save button is disabled for assign student popup");
			Assert.assertTrue(assignStdCancelBtn.isEnabled(), "Cancel button is disabled for assign student popup");
			Assert.assertTrue(assignStdCloseBtn.isEnabled(), "Close button is disabled for assign student popup");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void assignStaffPopupvalidation1() {

		try {
			Assert.assertTrue(assignStdSaveBtn.isEnabled(), "Save button is disabled for assign student popup");
			Assert.assertTrue(assignStdCancelBtn.isEnabled(), "Cancel button is disabled for assign student popup");
			Assert.assertTrue(assignSaffCloseBtn.isEnabled(), "Close button is disabled for assign student popup");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FindBy(xpath = "//input[@id='roleId']")
	WebElement userRoleTxtBox;
	@FindBy(xpath = "//span[@class='ng-tns-c101-10 p-dropdown-label p-inputtext p-placeholder ng-star-inserted']/../..")
	WebElement stdtEmailIdDD;
	@FindBy(xpath = "//*[@id='programName']")
	WebElement prgNameTxtBox;
	@FindBy(xpath = "//*[@id='batchName']")
	WebElement batchNameTxtBox;
	@FindBy(xpath = "//input[@id='Active']")
	WebElement activeRadioBtn;
	@FindBy(xpath = "//input[@id='Inactive']")
	WebElement inactiveRadioBtn;
	@FindBy(xpath="//span[text()='Select Email ID']/..")
	private WebElement stdtEmailDropDown;

	public void assignStdtPopupvalidation2() {
		try
		{
	
			Assert.assertTrue(userRoleTxtBox.getAttribute("value").equals("R03") , "Default value of UserRole is not valid");
			Assert.assertTrue(stdtEmailDropDown.getText().equals("Select Email ID") , "Default value of Email Id feild is not valid");
			Assert.assertTrue(prgNameTxtBox.getText().equals("") , "Default value of Proogram Name feild is not valid");
			Assert.assertTrue(batchNameTxtBox.getText().equals("") , "Default value of Batch Name feild is not valid");
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@FindBy(xpath="//span[text()='Select Email Id']/..")
	WebElement staffEmailDropDown;
	
	public void assignStaffPopupvalidation2() {
		try
		{
	
			Assert.assertTrue(userRoleTxtBox.getAttribute("value").equals("R02") , "Default value of UserRole is not valid");
			Assert.assertTrue(staffEmailDropDown.getText().equals("Select Email Id") , "Default value of Email Id feild is not valid");
			Assert.assertTrue(skillTxtBox.getText().equals("") , "Default value of Skill feild is not valid");
			Assert.assertTrue(prgNameTxtBox.getText().equals("Select a Program name") , "Default value of Proogram Name feild is not valid");
			Assert.assertTrue(batchNameTxtBox.getText().equals("Select Batch Name") , "Default value of Batch Name feild is not valid");
			LOG.info("Empty form validation for AssignStaff done sucessfully");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void assignStdtPopupvalidation3() {
		
		try {
		
			Assert.assertTrue(activeRadioBtn.isEnabled(), "Active Radio Button is not Enbled");
			Assert.assertTrue(inactiveRadioBtn.isEnabled(), "Inactive Radio Button is not Enbled");
			LOG.info("Radio buttons on Assign staff are active and enabled");
			}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
		
	@FindBy(xpath = "//div[contains(text(),' User Email Id is required. ')]")
	WebElement assignstdEmailErrmsg;
	@FindBy(xpath = "//div[contains(text(),'Program Name is required. ')]")
	WebElement assignstdProgErrmsg;
	@FindBy(xpath = "//div[contains(text(),' Batch Name is required. ')]")
	WebElement assignstdBatchErrmsg;
	@FindBy(xpath = "//div[contains(text(),'Status is required. ')]")
	WebElement assignstdStatusErrmsg;
	
	
	public void clickSaveBtn() {
		
		assignStdSaveBtn.click();
		
	}
	
	public void validateEmptyFormErrMsg()
	{
			
		Assert.assertTrue(assignstdEmailErrmsg.getText().equals("User Email Id is required.") , "Invalid Error msg for emaild id");
		Assert.assertTrue(assignstdProgErrmsg.getText().equals("Program Name is required.") , "Invalid Error msg for Program Name");
		Assert.assertTrue(assignstdBatchErrmsg.getText().equals("Batch Name is required.") , "Invalid Error msg for Batch name");
		Assert.assertTrue(assignstdStatusErrmsg.getText().equals("Status is required.") , "Invalid Error msg for status");
	
	}
	
	@FindBy(xpath="//div[contains(text(),' Email Id is required. ')]")
	WebElement assignstaffEmailErrmsg;
	
	public void validateEmptyFormErrMsgForAssignStaff()
	{
			
		Assert.assertTrue(assignstaffEmailErrmsg.getText().equals("Email Id is required.") , "Invalid Error msg for emaild id");
		Assert.assertTrue(assignstdProgErrmsg.getText().equals("Program Name is required.") , "Invalid Error msg for Program Name");
		Assert.assertTrue(assignstdBatchErrmsg.getText().equals("Batch Name is required.") , "Invalid Error msg for Batch name");
		Assert.assertTrue(assignstdStatusErrmsg.getText().equals("Status is required.") , "Invalid Error msg for status");
	
	}
	
	
	@FindBy(xpath="//li")
	WebElement emailIds;
	@FindBy(xpath="//div[@role='button']")
	WebElement emailDD;
	@FindBy(xpath="(//div[@role='button'])[2]")
	WebElement prognameDD;
	@FindBy(xpath="//*[@id='batchName']")
	WebElement batchDD;
	
	
	public void validateAssignStdtWithOutStatus(String emailid)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		emailDD.click();
		List<WebElement>emailidList= driver.findElements(By.xpath("//li"));
		ArrayList<String> StudtEmailids = new ArrayList<>();
		for(WebElement element : emailidList)
		{
			StudtEmailids.add(element.getText());
			
		}
		for(int i=0;i<StudtEmailids.size();i++)
		{
			if(StudtEmailids.get(i).equals(emailid))
			{
				 
			     executor.executeScript("arguments[0].click();", emailidList.get(i));
			}
		}
		
		prognameDD.click();
		List<WebElement>progList= driver.findElements(By.xpath("//li"));
		progList.get(0).click();
		batchDD.click();
		List<WebElement>batchList= driver.findElements(By.xpath("//li"));
		executor.executeScript("arguments[0].click();", batchList.get(0));
		
		assignStdSaveBtn.click();
			
	}
	
	public void validateAssignStafftWithOutStatus(String emailid)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		assignstaffEmailId.click();
		List<WebElement>emailidList= driver.findElements(By.xpath("//li"));
		ArrayList<String> StudtEmailids = new ArrayList<>();
		for(WebElement element : emailidList)
		{
			StudtEmailids.add(element.getText());
			
		}
		for(int i=0;i<StudtEmailids.size();i++)
		{
			if(StudtEmailids.get(i).equals(emailid))
			{
				 
			     executor.executeScript("arguments[0].click();", emailidList.get(i));
			}
		}
		
		prognameDD.click();
		List<WebElement>progList= driver.findElements(By.xpath("//li"));
		progList.get(7).click();
		batchDD.click();
		List<WebElement>batchList= driver.findElements(By.xpath("//li"));
		executor.executeScript("arguments[0].click();", batchList.get(0));
		
		
		assignStdSaveBtn.click();
			
	}
	
	public void validateAssignStafftWithOutEmailID()
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		prognameDD.click();
		List<WebElement>progList= driver.findElements(By.xpath("//li"));
		progList.get(0).click();
		batchDD.click();
		List<WebElement>batchList= driver.findElements(By.xpath("//li"));
		executor.executeScript("arguments[0].click();", batchList.get(0));
		executor.executeScript("arguments[0].click();", activeRadioBtn);
		
		assignStdSaveBtn.click();
			
	}
	
	public void validateErrMsgAssignStafftWithOutEmailID()
	{
		Assert.assertTrue(assignstaffEmailErrmsg.getText().equals("Email Id is required.") , "Invalid Error msg for emaild id");
	}
	
	public void validateErrMsgAssignStdtWithOutStatus()
	{
		Assert.assertTrue(assignstdStatusErrmsg.getText().equals("Status is required.") , "Invalid Error msg for status");
	}
	
	
	public void validateAssignStdtWithOutBatch(String emailid)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		emailDD.click();
		List<WebElement>emailidList= driver.findElements(By.xpath("//li"));
		ArrayList<String> StudtEmailids = new ArrayList<>();
		for(WebElement element : emailidList)
		{
			StudtEmailids.add(element.getText());
			
		}
		for(int i=0;i<StudtEmailids.size();i++)
		{
			if(StudtEmailids.get(i).equals(emailid))
			{
				 
			     executor.executeScript("arguments[0].click();", emailidList.get(i));
			}
		}
		prognameDD.click();
		List<WebElement>progList= driver.findElements(By.xpath("//li"));
		progList.get(0).click();
		executor.executeScript("arguments[0].click();", activeRadioBtn);
		assignStdSaveBtn.click();
			
	}
	
	public void validateAssignStaffWithOutBatch(String emailid)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		assignstaffEmailId.click();
		List<WebElement>emailidList= driver.findElements(By.xpath("//li"));
		ArrayList<String> StudtEmailids = new ArrayList<>();
		for(WebElement element : emailidList)
		{
			StudtEmailids.add(element.getText());
			
		}
		for(int i=0;i<StudtEmailids.size();i++)
		{
			if(StudtEmailids.get(i).equals(emailid))
			{
				 
			     executor.executeScript("arguments[0].click();", emailidList.get(i));
			}
		}
		
		prognameDD.click();
		List<WebElement>progList= driver.findElements(By.xpath("//li"));
		executor.executeScript("arguments[0].click();", progList.get(0));
		executor.executeScript("arguments[0].click();", activeRadioBtn);
		assignStdSaveBtn.click();
			
	}
	
	public void validateErrMsgAssignStdtWithOutProgram()
	{
		Assert.assertTrue(assignstdProgErrmsg.getText().equals("Program Name is required.") , "Invalid Error msg for Program Name");
	}
	
	
	public void validateAssignStdtWithOutProgram(String emailid)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		emailDD.click();
		List<WebElement>emailidList= driver.findElements(By.xpath("//li"));
		ArrayList<String> StudtEmailids = new ArrayList<>();
		for(WebElement element : emailidList)
		{
			StudtEmailids.add(element.getText());
			
		}
		for(int i=0;i<StudtEmailids.size();i++)
		{
			if(StudtEmailids.get(i).equals(emailid))
			{
				 
			     executor.executeScript("arguments[0].click();", emailidList.get(i));
			}
		}
		
		executor.executeScript("arguments[0].click();", activeRadioBtn);
		assignStdSaveBtn.click();
			
	}
	@FindBy(xpath="//div[@role='button'][1]")
	WebElement assignstaffEmailId;
	
	public void validateAssignStafftWithOutProgram(String emailid) throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		assignstaffEmailId.click();
		List<WebElement>emailidList= driver.findElements(By.xpath("//li"));
		ArrayList<String> StudtEmailids = new ArrayList<>();
		for(WebElement element : emailidList)
		{
			
			StudtEmailids.add(element.getText());
			
		}
		for(int i=0;i<StudtEmailids.size();i++)
		{
			if(StudtEmailids.get(i).equals(emailid))
			{
				 				
				executor.executeScript("arguments[0].click();", emailidList.get(i));
			}
		}
					
		executor.executeScript("arguments[0].click();", activeRadioBtn);
		assignStdSaveBtn.click();
			
	}
	
	public void validateErrMsgAssignStdtWithOutBatch()
	{
		Assert.assertTrue(assignstdBatchErrmsg.getText().equals("Batch Name is required.") , "Invalid Error msg for Batch name");
	}
	
	
	
	public void validateAssignStdtClickCloseBtn(String emailid) throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		emailDD.click();
		List<WebElement>emailidList= driver.findElements(By.xpath("//li"));
		ArrayList<String> StudtEmailids = new ArrayList<>();
		for(WebElement element : emailidList)
		{
			StudtEmailids.add(element.getText());
			
		}
		for(int i=0;i<StudtEmailids.size();i++)
		{
			if(StudtEmailids.get(i).equals(emailid))
			{
				 
			     executor.executeScript("arguments[0].click();", emailidList.get(i));
			}
		}
		
		prognameDD.click();
		List<WebElement>progList= driver.findElements(By.xpath("//li"));
		progList.get(3).click();
		batchDD.click();
		Thread.sleep(500);
		List<WebElement>batchList= driver.findElements(By.xpath("//li"));
		executor.executeScript("arguments[0].click();", batchList.get(0));
		executor.executeScript("arguments[0].click();", activeRadioBtn);
		executor.executeScript("arguments[0].click();", assignStdCloseBtn);
	
			
	}
	public void validateAssignStafftClickCloseBtn(String emailid,String elementaction) throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		emailDD.click();
		List<WebElement>emailidList= driver.findElements(By.xpath("//li"));
		ArrayList<String> StudtEmailids = new ArrayList<>();
		for(WebElement element : emailidList)
		{
			StudtEmailids.add(element.getText());
			
		}
		for(int i=0;i<StudtEmailids.size();i++)
		{
			if(StudtEmailids.get(i).equals(emailid))
			{
				 
			     executor.executeScript("arguments[0].click();", emailidList.get(i));
			}
		}
		
		prognameDD.click();
		List<WebElement>progList= driver.findElements(By.xpath("//li"));
		progList.get(3).click();
		batchDD.click();
		Thread.sleep(500);
		List<WebElement>batchList= driver.findElements(By.xpath("//li"));
		executor.executeScript("arguments[0].click();", batchList.get(0));
		executor.executeScript("arguments[0].click();", activeRadioBtn);
		if(elementaction.equalsIgnoreCase("close"))
			executor.executeScript("arguments[0].click();", assignSaffCloseBtn);
			else
				executor.executeScript("arguments[0].click();", assignStdCancelBtn);
		
			
	}
	public void validateAssignStdtClickCancelBtn(String emailid) throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		emailDD.click();
		List<WebElement>emailidList= driver.findElements(By.xpath("//li"));
		ArrayList<String> StudtEmailids = new ArrayList<>();
		for(WebElement element : emailidList)
		{
			StudtEmailids.add(element.getText());
			
		}
		for(int i=0;i<StudtEmailids.size();i++)
		{
			if(StudtEmailids.get(i).equals(emailid))
			{
				 
			     executor.executeScript("arguments[0].click();", emailidList.get(i));
			}
		}
		
		prognameDD.click();
		List<WebElement>progList= driver.findElements(By.xpath("//li"));
		progList.get(3).click();
		batchDD.click();
		Thread.sleep(500);
		List<WebElement>batchList= driver.findElements(By.xpath("//li"));
		executor.executeScript("arguments[0].click();", batchList.get(0));
		executor.executeScript("arguments[0].click();", activeRadioBtn);
		executor.executeScript("arguments[0].click();", assignSaffCloseBtn);
				
	}
	
	public void validatepopIsClosed()
	{
		Assert.assertFalse(assignStdCloseBtn.isEnabled(), "Assign student popup is still open");
	}
	
		String assignStaffPopupWindow = "//div[@role='dialog']";
	
		public void validateStaffpopIsClosed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(assignStaffPopupWindow)));
		 LOG.error("Assign staff alert disappeared successfully");
		}catch (NoSuchElementException  e) {
			LOG.error("Assign staff alert was not found or is stale.");
		}
	}

	
	
	@FindBy(xpath="//span[@class='pi pi-times ng-tns-c133-9']/..")
	WebElement delAlertCloseBtn;
	@FindBy(xpath="//div[@class='p-toast-detail ng-tns-c90-10']/..")
	private WebElement msgDeleteSuccess;
	@FindBy(xpath="//div[@class='p-toast-summary ng-tns-c90-10']/..")
	private WebElement msgUserDelete;
	@FindBy(xpath="//span[contains(text(),'Yes')]/..")
     private WebElement deleteYesBtn;
	@FindBy(xpath="//span[contains(text(),'No')]/..")
    private WebElement deleteNoBtn;
	@FindBy(xpath="//span[contains(text(),'Confirm')]/..")
    private WebElement deleteConfirmMsg;
	@FindBy(xpath = "//button[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only'] ")
	WebElement rowDeleteButton;
	@FindBy(xpath="//p-confirmdialog/div/div")
	private WebElement deletePopupWindow;
	public void clickRowDeleteButton() {
		rowDeleteButton.click();
	}
	public void validateRowDeleteBtn() {
		Assert.assertTrue(deleteYesBtn.isEnabled(), "Yes button is disabled for assign student popup");
		Assert.assertTrue(deleteNoBtn.isEnabled(), "No button is disabled for assign student popup");
		Assert.assertEquals(deleteConfirmMsg.getText(), "Confirm",
				"Confirm heading is not present in the student popup");
		LOG.info("Is  Yes button in Delete popup window enabled? " + deleteYesBtn.isEnabled());
	}
		
	public void validatePopupAlertExists() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("deletePopupWindow")));
		 	LOG.info("Deletion alert disappeared successfully");
		}catch (NoSuchElementException  e) {
			LOG.info("Deletion alert was not found or is stale.");
		}
	}
		
		public void singleUserDeleteInRow(String alertAction, List<String> UserID) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		List<String> ids = new ArrayList<>(UserID);
		List<String> originalList =sortFnc(2);
				//sorting("ID", 2);
		Collections.sort(ids);
		idIcon.click();
		boolean gotoNextPage = false;
		WebElement deleteBtn = null;
		int index =0;
		do {
			for (int i = index; i < ids.size(); i++) {
				String id = ids.get(i);
				try {
					WebElement chkbox=driver.findElement(By.xpath("//tr/td[contains(text(),'" + id + "')]//preceding-sibling::td[1]"));
					chkbox.click();
					deleteBtn=driver.findElement(By.xpath("//tr/td[contains(text(),'" + id + "')]//following-sibling::td[4]//button[2]"));
					deleteBtn.click();
					Thread.sleep(1000);
					if (alertAction.equalsIgnoreCase("yes")) {
						deleteYesBtn.click();
						String actualMsg =msgDeleteSuccess.getText().trim();
						LOG.info("actualMsg is "+actualMsg);
						String expectedMessage = "Successful\nUser Deleted".trim();
						Thread.sleep(1000);
						softAssert.assertEquals(actualMsg, expectedMessage, "Actual message is not matching with expected");
						Thread.sleep(1000);
						softAssert.assertTrue(!originalList.contains(id));
						softAssert.assertAll();
					} else if (alertAction.equalsIgnoreCase("no")) {
						deleteNoBtn.click();
						chkbox.click();
						validatePopupAlertExists();
	    			} else if (alertAction.equalsIgnoreCase("close")) {
	    				delAlertCloseBtn.click();
						chkbox.click();
						validatePopupAlertExists();
					}
				} catch (NoSuchElementException ex) {
					 gotoNextPage = true;
		                break;
				}
				index++;
			}
			 if (gotoNextPage && index< ids.size()) {
		            if (nextBtn.isEnabled()) {
		            	nextBtn.click();
		            } else {
		                  break;
		            }
		        }
			 if(index == ids.size())
		        	break;
		    } while (gotoNextPage || !ids.isEmpty());
		
	}
		
		@FindBy(xpath="//span[@class='p-checkbox-icon']/..")
		private WebElement checkBox;
		@FindBy(xpath="//button[@class='p-button-danger p-button p-component p-button-icon-only']")
		private WebElement headerDeleteBtn;
		
		public void clickCheckBox() {
		    try {
		        checkBox.click();
		    } catch (NoSuchElementException ex) {
		    	LOG.info("Checkbox element not found on the page.");
		    }
		}
		
		public void validateHeaderDelete() {
			try {
				boolean isheaderDeleteBtn = headerDeleteBtn.isEnabled();
				if (isheaderDeleteBtn) {
				   LOG.info("Delete button is enabled after clicking the checkbox.");
				} else {
					LOG.info("Delete button is not enabled after clicking the checkbox.");
				}
			} 	catch (NoSuchElementException e) {
				LOG.info("Delete button not found on the page.");
		    }
		}
		
		public void multipleUserDelete(String alertAction, List<String> UserID) throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
			List<String> ids = new ArrayList<>(UserID);
			List<String> originalList = sortFnc(2);
					//sorting("ID", 2);
			Collections.sort(ids);
			idIcon.click();
			boolean gotoNextPage = false;
			WebElement deleteBtn = null;
			int index = 0;
			String id = "";
			do {
				for (int i = index; i < ids.size(); i++) {
					id = ids.get(i);
					try {
						WebElement checkbox = driver.findElement(
								By.xpath("//tr/td[contains(text(),'" + id + "')]//preceding-sibling::td[1]"));
						checkbox.click();
						Thread.sleep(500);
					} catch (NoSuchElementException ex) {
						gotoNextPage = true;
						break;
					}
					index++;
				}
				if (gotoNextPage && index < ids.size()) {
					if (nextBtn.isEnabled()) {
						nextBtn.click();
					} else {
						break;
					}
				}
				if (index == ids.size())
					break;
			} while (gotoNextPage || !ids.isEmpty());
			headerDeleteBtn.click();
			Thread.sleep(1000);
			if (alertAction.equalsIgnoreCase("yes")) {
				deleteYesBtn.click();
				String actualMsg = msgDeleteSuccess.getText().trim();
				LOG.info("actualMsg is " + actualMsg);
				String expectedMessage = "Successful\nUsers Deleted".trim();
				Thread.sleep(1000);
				softAssert.assertEquals(actualMsg, expectedMessage, "Actual message is not matching with expected");
				Thread.sleep(1000);
				softAssert.assertTrue(!originalList.contains(id));
				softAssert.assertAll();
			} else if (alertAction.equalsIgnoreCase("no")) {
				deleteNoBtn.click();
				validatePopupAlertExists();
			} else if (alertAction.equalsIgnoreCase("close")) {
				delAlertCloseBtn.click();
				validatePopupAlertExists();
			}
		}
}
