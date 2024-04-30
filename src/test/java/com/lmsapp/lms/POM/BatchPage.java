package com.lmsapp.lms.POM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class BatchPage {

	WebDriver driver;

	public static Logger LOG = LoggerFactory.getLogger(CommonMethodsObject.class);

	public BatchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[contains(text(),'Manage Batch')]")
	WebElement manageBatchHeader;

	@FindBy(xpath = "//span[contains(text(), 'Batch')]")
	WebElement batchMenu;

	@FindBy(xpath = "//p-table/div/p-paginator/div")
	WebElement paginatorControl;

	@FindBy(xpath = "//span[contains(text(),'A New Batch')]")
	WebElement newBatchBtn;

	@FindBy(xpath = "//div[2]/div[1]/button")
	WebElement deleteIconBtn;
	
	@FindBy(xpath ="//*[@id=\"filterGlobal\"]")
	WebElement searchBatchTextbox;

	@FindBy(xpath = "//div/div[1]/table/tbody")
	WebElement dataTable;

	@FindBy(xpath = "//table/thead/tr/th[2]")
	WebElement batchNameTblHeader;

	@FindBy(xpath = "//table/thead/tr/th[3]")
	WebElement batchDescTblHeader;

	@FindBy(xpath = "//table/thead/tr/th[4]")
	WebElement batchStatusTblHeader;

	@FindBy(xpath = "//table/thead/tr/th[5]")
	WebElement batchNoOfClassesTblHeader;

	@FindBy(xpath = "//table/thead/tr/th[6]")
	WebElement batchProgramNameTblHeader;

	@FindBy(xpath = "//table/thead/tr/th[7]")
	WebElement batchEditDeleteTblHeader;

	@FindBy(xpath = "//table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]")
	WebElement rowCheckBoxBtn;

	@FindBy(xpath = "//*[@id='pr_id_14-label']")
	WebElement batchDetails;

	@FindBy(xpath = "//input[@id='batchName']")
	WebElement batchNameTextbox;

	@FindBy(xpath = "//input[@id='batchDescription']")
	WebElement batchDescriptionTextbox;

	@FindBy(xpath = "//input[@id='batchNoOfClasses']")
	WebElement batchClassesTextbox;

	@FindBy(xpath = "//*[@id=\"programName\"]")
	WebElement programNameDropdown;

	@FindBy(xpath = " //*[@id=\"programName\"]/div/div[2]/span")
	WebElement programDropdownBtn;

	@FindBy(xpath = "//div/div/div[2]/div[4]")
	WebElement statusRadioBtn;

	@FindBy(xpath = "//div/div/div[2]/div[4]/div[2]/p-radiobutton")
	WebElement activeRadioBtn;

	@FindBy(xpath = "//div/div/div[2]/div[4]/div[3]/p-radiobutton")
	WebElement inactiveRadioBtn;

	@FindBy(xpath = "//div/div/div[2]/div[1]/small")
	WebElement nameInvalidMsg;

	@FindBy(xpath = "//div/div/div[2]/div[2]/small")
	WebElement descInvalidMsg;

	@FindBy(xpath = "//div/div/div[2]/div[3]/small")
	WebElement programNameInvalidMsg;

	@FindBy(xpath = "//div/div/div[2]/small")
	WebElement statusInvalidMsg;

	@FindBy(xpath = "//div/div/div[2]/div[5]/small")
	WebElement noOfClassesInvalidMsg;

	@FindBy(xpath = "//div/div/div[2]/div[2]/small[2]")
	WebElement descMandatoryErrorMsg;

	@FindBy(xpath = "//button[@label=\"Save\"]")
	WebElement saveBtn;

	@FindBy(xpath = "//p-confirmdialog/div/div")
	WebElement deleteConfirmAlert;

	@FindBy(xpath = "//p-confirmdialog/div/div/div[3]/button[1]")
	WebElement noDeleteBtn;

	@FindBy(xpath = "//p-confirmdialog/div/div/div[3]/button[2]")
	WebElement yesDeleteBtn;

	@FindBy(xpath = "//p-dialog/div/div/div[2]/div[3]/p-dropdown/div/div[3]/div/ul/p-dropdownitem[1]/li/span")
	WebElement ulItem;

	@FindBy(xpath = "//p-toast/div/p-toastitem/div/div/div/div[1]")
	WebElement successMsg;

	@FindBy(xpath = "//p-toast/div/p-toastitem/div/div/div/div[2]")
	WebElement deleteBatchMsg;

	List<WebElement> listItem;

	public String verifyHeader() {

		return manageBatchHeader.getText();
	}

	public void clickBatchMenu() {
		batchMenu.click();
	}

	public boolean checkDeleteIcon() {

		return deleteIconBtn.isEnabled();
	}

	public void clickNewBatchButton()  {
		newBatchBtn.click();
		
	}

	public String checkUrl() {
		return driver.getCurrentUrl();

	}

	public boolean checkPagination() {
		return paginatorControl.isEnabled();
	}

	

	public String checkPopUp() {

		String header = driver.findElement(By.xpath("//div/div/div/span")).getText();
		System.out.println(header);
		return header;

	}

	public boolean checkNameTextbox() {

		return batchNameTextbox.isDisplayed();

	}

	public boolean checkDescriptionTextbox() {

		return batchDescriptionTextbox.isDisplayed();
	}

	public boolean checkClassesTextbox() {

		return batchClassesTextbox.isDisplayed();
	}

	public boolean checkProgramNameDropdown() {

		return programNameDropdown.isDisplayed();

	}
	
	public boolean checkStatusRadioBtn() {

		return statusRadioBtn.isDisplayed();
	}


	public boolean checkActiveRadioButton() {

		return activeRadioBtn.isDisplayed();

	}

	public boolean checkInactiveRadioButton() {

		return activeRadioBtn.isDisplayed();

	}

	public void clickSaveButton() {
		saveBtn.click();
	}

	public boolean checkNameErrorMsg() {

		return nameInvalidMsg.isDisplayed();
	}

	public boolean checkDescErrorMsg() {

		return descInvalidMsg.isDisplayed();
	}

	public boolean checkProgramNameErrorMsg() {

		saveBtn.click();
		return programNameInvalidMsg.isDisplayed();
	}

	public boolean checkStatusErrorMsg() {
		saveBtn.click();
		return statusInvalidMsg.isDisplayed();

	}

	public boolean checkDescMandatoryErrorMsg() {
		return descMandatoryErrorMsg.isDisplayed();
	}

	public boolean checknoOfClassesErrorMsg() {
		saveBtn.click();
		return statusInvalidMsg.isDisplayed();

	}

	public String getSuccessMessage() {
		return successMsg.getText();
	}

	public String getBatchDeletedMsg() {
		return deleteBatchMsg.getText();
	}

	public void enterBatchName(String batchName) throws InterruptedException {
		batchNameTextbox.sendKeys(batchName);
		

	}

	public void enterBatchDesc(String string) throws InterruptedException {
				
		batchDescriptionTextbox.clear();
		batchDescriptionTextbox.sendKeys(string);
		//Thread.sleep(1000);

	}

	public void selectBatchProgramName() throws InterruptedException {
		
		if(programDropdownBtn.isEnabled()) {
		try {
		programDropdownBtn.click();
		ulItem.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		//Thread.sleep(8000);
		// saveBtn.click();

	}

	public boolean checkNewBatchBtn() {
		return newBatchBtn.isDisplayed();

	}

	public boolean checkBatchTableheaders(String field) throws InterruptedException {

		// System.out.println(driver.findElement(By.xpath("//table/thead/tr/th[2]")).getText());
		boolean match = false;
		Thread.sleep(2000);
		List<WebElement> myList = driver.findElements(By.xpath("//table/thead/tr/th[contains(text(),field)]"));

		for (WebElement we : myList) {
			for (int i = 0; i < myList.size(); i++) {
				if (we.getText().equals(field)) {

					//System.out.println("Matched");
					match = true;

				}
			}
		}

		return match;

	}

	public ArrayList validateCheckBox() {

		// Find all rows in the table

		List<WebElement> rows = dataTable.findElements(By.tagName("tr"));

		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[1]/p-tablecheckbox";
		ArrayList<Boolean> arr = new ArrayList<Boolean>();
		for (int i = 1; i <= rows.size(); i++) {
			boolean bool = driver.findElement(By.xpath(before_xpath + i + after_xpath)).isDisplayed();
			arr.add(bool);

		}

		return arr;

	}

	public ArrayList<Boolean> validateEditIcon() {

		// Find all rows in the table

		List<WebElement> rows = dataTable.findElements(By.tagName("tr"));

		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[7]/div/span[1]";
		ArrayList<Boolean> arr = new ArrayList<Boolean>();
		for (int i = 1; i <= rows.size(); i++) {
			boolean bool = driver.findElement(By.xpath(before_xpath + i + after_xpath)).isEnabled();
			arr.add(bool);

		}

		return arr;
	}

	public ArrayList<Boolean> validateDeleteIcon() {
		// Find all rows in the table

		List<WebElement> rows = dataTable.findElements(By.tagName("tr"));

		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[7]/div/span[2]";
		ArrayList<Boolean> arr = new ArrayList<Boolean>();
		for (int i = 1; i <= rows.size(); i++) {
			boolean bool = driver.findElement(By.xpath(before_xpath + i + after_xpath)).isEnabled();
			arr.add(bool);

		}

		return arr;
	}

	
	public void selectStatusRadiobtn() throws InterruptedException {
		activeRadioBtn.click();
		Thread.sleep(1000);

	}

	public void enterNoOfClasses(String s) {
		;
		// String s=String.valueOf(i);//Now it will return "i"
	batchClassesTextbox.clear();
		batchClassesTextbox.sendKeys(s);

	}

	public Boolean checkNewBatch() {

		return checkDescErrorMsg();

	}

	public void checkAlertMsg() throws InterruptedException {

		Assert.assertTrue(deleteConfirmAlert.isDisplayed());

	}

	public void clickYesOption() throws InterruptedException {
		yesDeleteBtn.click();
		Thread.sleep(1000);

	}

	public void clickNoOption() throws InterruptedException {
		noDeleteBtn.click();
		Thread.sleep(1000);
	}
     String batchName;
	public void clickRowDeleteIcon() throws InterruptedException {

		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[7]/div/span[2]";
		batchName = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
		driver.findElement(By.xpath(before_xpath + "1" + after_xpath)).click();
		Thread.sleep(1000);
	}

	public void clickHeaderDeleteIcon() {
		deleteIconBtn.click();

	}

	public void clickRowCheckBox() {
		// TODO Auto-generated method stub
		rowCheckBoxBtn.click();
	}

	public void clickMultipleRowCheckBox() {
		// table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]

		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[1]/p-tablecheckbox/div/div[2]";
		for (int i = 1; i <= 2; i++) {
			driver.findElement(By.xpath(before_xpath + i + after_xpath)).click();
		}

	}

	public void clickRowEditIcon() {

		// table/tbody/tr[1]/td[7]/div/span[1]/button/span[1]
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[7]/div/span[1]";
		driver.findElement(By.xpath(before_xpath + "1" + after_xpath)).click();
	}

	public void checkRowEditIcon() {

		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[7]/div/span[1]";
		driver.findElement(By.xpath(before_xpath + "1" + after_xpath)).isEnabled();
	}

	public void eraseMandatoryField() throws InterruptedException {

		// batchDescriptionTextbox.clear();
		batchDescriptionTextbox.sendKeys(Keys.CONTROL + "a");
		batchDescriptionTextbox.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
//		batchDescriptionTextbox.click();

		batchClassesTextbox.sendKeys(Keys.CONTROL + "a");
		batchClassesTextbox.sendKeys(Keys.BACK_SPACE);

		Thread.sleep(5000);
	}

	public void eraseDescriptionField() throws InterruptedException {
		// TODO Auto-generated method stub
		batchDescriptionTextbox.sendKeys(Keys.CONTROL + "a");
		batchDescriptionTextbox.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
	}

	public boolean checkSuccessMsg() {
		// TODO Auto-generated method stub
		boolean bool=false;
		try {
		 bool =  successMsg.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	public boolean checkdeletedRow() throws InterruptedException {
		// TODO Auto-generated method stub
		boolean rowFound = false;
		System.out.println(batchName);
		searchBatchTextbox.sendKeys(batchName);
		//Thread.sleep(1000);
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
		System.out.println(rows.size());
		if(rows.size()>=1) {
			
			rowFound = true;
		}else if(rows.size()==0) {
			rowFound = false;
		}
		return rowFound;
	}

}
