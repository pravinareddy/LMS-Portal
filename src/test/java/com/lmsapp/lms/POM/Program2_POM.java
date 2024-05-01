package com.lmsapp.lms.POM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class Program2_POM {
	WebDriver driver;

	@FindBy(xpath="//*[@id=\"batch\"]")
	WebElement batchlink;
	@FindBy(xpath="//*[@id=\"user\"]")
	WebElement userlink;
	@FindBy(xpath="//*[@id=\"logout\"]")
	WebElement logoutlink; 
	@FindBy(xpath="//*[@id=\"program\"]")
	WebElement programlink;
	@FindBy(xpath="//th[@psortablecolumn=\"programName\"]")
	WebElement  programnameIcon;
	@FindBy(xpath="//th[@psortablecolumn=\"programDescription\"]")
	WebElement programdescriptionIcon;
	@FindBy(xpath="//th[@psortablecolumn=\"programStatus\"]")
	WebElement ProgramStatusIcon;
	@FindBy(xpath="//div/p-paginator/div/button[3]")
 	WebElement nextBtn;

	// Multiple delete
	@FindBy(xpath="//div/mat-card/mat-card-title/div[2]/div[1]/button/span[1]")
 	WebElement commondeleteBtn;
	@FindBy(xpath="//*[@class=\"p-checkbox-box p-component\"]")
 	WebElement checkbox1;
	@FindBy(xpath="//div/div[1]/table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]")
	WebElement checkbox2;
	@FindBy(xpath="//div/div[1]/table/tbody/tr[2]/td[1]/p-tablecheckbox/div/div[2]")
	WebElement checkbox3;
	@FindBy(xpath="/html/body/app-root/app-program/p-confirmdialog/div/div/div[3]/button[2]")
	WebElement yesbtn;
	@FindBy(xpath="//div/div/div[3]/button[1]")
	WebElement nobtn;    
	@FindBy(xpath="/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[3]")
	WebElement nextbutton;
	@FindBy(xpath="//div/span[2]/button[2]")
	WebElement active_link;
	@FindBy(xpath="//div/button[4]")
	WebElement lastbutton ;
	@FindBy(xpath="//div/p-paginator/div/span[2]/button[5]")
	WebElement endofpage;  
	@FindBy(xpath="//div/p-paginator/div/button[2]")
	WebElement firstlink;
	@FindBy(xpath="//div/span[2]/button[4]")
	WebElement previousbutton;
		
	
	public static Logger LOG = LoggerFactory.getLogger(CommonMethodsObject.class);

	public Program2_POM(WebDriver driver) {

	    this.driver = driver;
			PageFactory.initElements(driver, this);
	
	}
	
	public void click_batch_linkUrl() {
		batchlink.click();
		String BatchUrl= driver.getCurrentUrl(); 
		System.out.println("**Url of home page**"+ BatchUrl);
		Assert.assertTrue(BatchUrl.contains("batch"));

		}
	
	public void click_user_link() {
		userlink.click();
		String userurl = driver.getCurrentUrl();
		System.out.println("**Url of user page**"+userurl);
		Assert.assertTrue(userurl.contains("user"));
			
	}
	public void click_logout_link() {
		logoutlink.click();
		String logouturl = driver.getCurrentUrl();
		System.out.println("**Url of user page**"+logouturl);
		Assert.assertTrue(logouturl.contains("login"));

	}
	
	public void click_program_navigation()
	{
	programlink.click();
	}
		
	public ArrayList<String> sortFnc(int columnIndex) {
		List<WebElement> originalList;
		ArrayList<String> originalListItems = new ArrayList<>();
		boolean endOfpage = true;
		String classAttributeValue = nextBtn.getAttribute("class");
		try {
			while (endOfpage) {
				originalList = driver.findElements(By.xpath("//tr/td[" + columnIndex + "]"));
				//System.out.println(originalList.size());

				for (WebElement element : originalList) {
					//System.out.println(element.getText());
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
	public void sortProgram(String headerElement) {

		ArrayList<String> sortedList = new ArrayList<>();
		ArrayList<String> aftersortedlList = new ArrayList<>();
		int columnIndex = 0;
		WebElement sortElement = null;
		try {
			switch (headerElement.toLowerCase()) {
			case "programname":
				sortElement = programnameIcon;
				columnIndex = 2;
				break;
			case "programdescription":
			sortElement = programdescriptionIcon;
				columnIndex = 3;
				break;
			case "programstatus":
			sortElement = ProgramStatusIcon;
				columnIndex = 4;
				break;
							}
			// ascending order sorting
			sortedList = sortFnc(columnIndex);
			Collections.sort(sortedList);
			sortElement.click();
			aftersortedlList = sortFnc(columnIndex);
			Assert.assertEquals(sortedList, aftersortedlList);

			// Descending order sorting
			Collections.sort(sortedList, Collections.reverseOrder());
			sortElement.click();
			aftersortedlList = sortFnc(columnIndex);
			Assert.assertEquals(sortedList, aftersortedlList);

			LOG.info("Sorting validated successfully ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void validate_common_delete() {
		checkbox1.click();
		boolean enabled=commondeleteBtn.isEnabled();
		System.out.println("---------Common Delete Button is Enabled-------"+enabled);
	}

			public void multipledelete_by_multipleselect_using_YES() {
			checkbox2.click();
			checkbox3.click();
				commondeleteBtn.click();
				yesbtn.click();
				String alert1=driver.findElement(By.xpath("/html/body/app-root/app-program/p-toast/div")).getText();
				System.out.println("----------Selected programs are Successfully deleted ------"+alert1);
		
		}
			public void multipledelete_by_multipleselect_using_NO() {
				checkbox2.click();
				checkbox3.click();
				commondeleteBtn.click();
				nobtn.click();
				Boolean checkbx1=checkbox2.isDisplayed();
		    	System.out.println("*CheckBox2 is displayed*"+checkbx1);
		    	Boolean checkbx2=checkbox3.isDisplayed();
		    	System.out.println("*Checkbox3 is displayed"+checkbx2);
	
			}
			
			//Pagenation			
			public void validate_next_pagelink() {
				nextbutton.click();
				boolean isNextPageLinkActive = active_link.isEnabled();
				if (isNextPageLinkActive) {
					System.out.println("*Next page link is active*");
				} else {
					System.out.println("****Next page link is inactive***");
				}
			}

			public void validate_last_pagelink() {
				lastbutton.click();
				String pageno=endofpage.getText();
	   			System.out.println("*End Page Number"+pageno);
	   			boolean isNextPageLinkActive = nextbutton.isEnabled();
				if (isNextPageLinkActive) {
					System.out.println("*Next Button is Enabled*");
				} else {
					System.out.println("Next Button is Disabled");
				}
			}
			
			public void validate_first_pagelink() {
				lastbutton.click();
				firstlink.click();
				String pageno1=previousbutton.getText();
	   			System.out.println("******Previous page*******"+pageno1);
	   			boolean isNextPageLinkActive = previousbutton.isEnabled();
				if (isNextPageLinkActive) {
					System.out.println("******Previous Button is Enabled******");
				} else {
					System.out.println("*********Previous Button is Disabled*********");
				}
				
			}
			
	}