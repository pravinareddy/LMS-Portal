package com.lmsapp.lms.POM;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aventstack.extentreports.util.Assert;

public class Program1_POM {
	
WebDriver driver;
@FindBy(xpath="//*[@id=\"program\"]")
WebElement programlink;
@FindBy(xpath="//div/mat-card/mat-card-title/div[2]/div[1]/button")
WebElement deletebutton;
@FindBy(xpath="//*[@id=\"new\"]/span[2]")
WebElement newprogram;
@FindBy(xpath="//div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody")
WebElement table;
@FindBy(xpath="//*[@id=\"filterGlobal\"]")
WebElement searchBar;
@FindBy(xpath="//*[@id=\"saveProgram\"]")
WebElement savebtn;
@FindBy(xpath="//div/div/div[3]/button[1]")
WebElement cancelbtn;
@FindBy(xpath="//div/div/div[1]/div/button")
WebElement closeicon;
@FindBy(xpath="//*[@id=\"programName\"]")
WebElement programtxt;
@FindBy(xpath="//*[@id=\"programDescription\"]")
WebElement programdescrip;
@FindBy(xpath="//*[@id=\"category\"]/div/div[2]")
WebElement radiobtn;
@FindBy(xpath="//div/div/div[2]/div[1]/small")
WebElement error1;
@FindBy(xpath="//div/div/div[2]/div[2]/small")
WebElement error2;
@FindBy(xpath="//div/div/div[2]/small")
WebElement error3;
@FindBy(xpath="//*[@id=\"category\"]/div/div[2]/span")
WebElement status_button;
@FindBy(xpath="/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[5]/td[5]/div/span/button[2]/span[1]")
WebElement deletebtn;
@FindBy(xpath="/html/body/app-root/app-program/p-confirmdialog/div/div/div[1]/span")
WebElement confirmbtn;
@FindBy(xpath="/html/body/app-root/app-program/p-confirmdialog/div/div/div[3]/button[2]")
WebElement yesbtn;
@FindBy(xpath="/html/body/app-root/app-program/p-confirmdialog/div/div/div[3]/button[1]")
WebElement nobtn;
@FindBy(xpath="/html/body/app-root/app-program/p-confirmdialog/div/div/div[2]/span")
WebElement confirmationbtn;
	
public static Logger LOG = LoggerFactory.getLogger(CommonMethodsObject.class);

public Program1_POM(WebDriver driver) {

    this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
public void click_program_navigation()
{
    programlink.click();
}
public void get_manageprogram_url(){
	String home_url=driver.getCurrentUrl();
	System.out.println("*****Url of home page*******"+ home_url);
	System.out.println("--------Admin cannot see the Manage program in the Url---------");
}
public void get_heading() {
	String msg = driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-title/div[1]")).getText();
	System.out.println("---------**Result getext**--------"+msg);

}
public void get_pagenumbers() {
	String msg1 = driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/p-paginator/div/span[1]")).getText();
	System.out.println("-------Result page numbers--------"+msg1);
}

public void get_footer() {
	
	String msg2 = driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[2]/div")).getText();
	System.out.println("-------Result footer--------"+msg2);	
}


public void check_buton_delete() {
WebElement deletebutton = driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-title/div[2]/div[1]/button"));

// Check if the button is disabled
if (deletebutton.getAttribute("disabled") != null) {
    System.out.println("--------Button is disabled---------");
}

}

public void click_new_program() {
	By newprogram=By.xpath("//*[@id=\"new\"]/span[2]");
	driver.findElement(newprogram).click();
	System.out.println("*A new program window is opened *****");

}

public void get_rows_in_table() {
	WebElement table = driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody"));

	java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));

	if (rows.size() == 5) {
	  System.out.println("-------*Table has 5 rows---------");
	} else {
	  System.out.println("Table does not have 5 rows.");
	}
}

public void get_column_values_datatable() {
	WebElement table = driver.findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table"));
	java.util.List<WebElement> allheaders = driver.findElements(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr"));
	for(WebElement headers_title : allheaders) {
		String value = headers_title.getText();
		System.out.println(value);
	}
}

/*
public void check_sort_icon_on_headers() {
	   java.util.List<WebElement> headers = driver.findElements(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table"));

    // Verify the presence of sort arrow icons beside each column header
	   for (WebElement header : headers) {
        // Check if the header contains a sort arrow icon
        if (header.findElements(By.tagName("span")).size() > 0) {
            System.out.println("Sort arrow icon found beside column header: " + header.getText());
        } else {
            System.out.println("Sort arrow icon not found beside column header: " + header.getText());
        }
    }}
*/
 
public void check_all_checkboxes_in_all_rows() {
	 java.util.List<WebElement> checkboxes = driver.findElements(By.xpath("//tr//input[@type='checkbox']"));

  // Verify if checkboxes are visible in all rows
  boolean allVisible = true;
  for (WebElement checkbox : checkboxes) {
      if (!checkbox.isDisplayed()) {
          allVisible = true;
          break;
      }
  } 
  if(allVisible) {
	  System.out.println("Checkboxes are visible in all rows of the table");
  }
  else {
	  System.out.println("Checkboxes are not visible in all rows of the table");
  }
}

public void check_editdelete_in_rows() {
	java.util.List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
	boolean allVisible = true;
	java.util.List<WebElement> editDeleteButtons = driver.findElements(By.xpath("//td/button[contains(text(), 'Edit') or contains(text(), 'Delete')]"));
	for (WebElement button : editDeleteButtons) {
	    if (!button.isDisplayed()) {
	        allVisible = false;
	        break;
	    }
	}
	if (allVisible) {
	    System.out.println("Edit/Delete buttons are visible in all rows of the table.");
	} else {
	    System.out.println("Edit/Delete buttons are not visible in all rows of the table.");
	}
	}

public void verify_searchBar() {
	
	WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"filterGlobal\"]"));	
	String expectedText= "Search...";
	String actualText= searchBar.getAttribute("placeholder");
	System.out.println("Placeholder value:"+actualText);
	if(searchBar.isDisplayed()) {
		System.out.println("-----------Search box displayed-------");
	}	
	assertEquals(actualText,expectedText);
}
	

public void verify_empty_form() {
	WebElement savebtn=driver.findElement(By.xpath("//*[@id=\"saveProgram\"]"));
	Boolean disp1=savebtn.isDisplayed();
	System.out.println("save button is displayed "+disp1);
	
	WebElement cancelbtn=driver.findElement(By.xpath("//div/div/div[3]/button[1]"));
	Boolean disp2 = cancelbtn.isDisplayed();
	System.out.println("cancel button is displayed "+disp2);
	
	WebElement closeicon = driver.findElement(By.xpath("//div/div/div[1]/div/button"));
	Boolean disp3 = closeicon.isDisplayed();
	System.out.println("close button is displayed "+disp3);

}
public void verify_two_inputfields() {
	WebElement programtxt=driver.findElement(By.xpath("//*[@id=\"programName\"]"));
	Boolean field=programtxt.isDisplayed();
	System.out.println("Program name field is displayed "+field);
	WebElement programdescrip=driver.findElement(By.xpath("//*[@id=\"programDescription\"]"));
	Boolean field1=programdescrip.isDisplayed();
	System.out.println("Program desc field is displayed "+field1);
}


public void verify_radio_btn() {
	WebElement radioBtn = driver.findElement(By.xpath("//*[@id=\"category\"]/div/div[2]"));
	Boolean field2 = radioBtn.isDisplayed();
	System.out.println("Radio buttons are displayed"+field2);
	
}

public void save_without_anydata() {
	
	WebElement savebtn=driver.findElement(By.xpath("//*[@id=\"saveProgram\"]"));
	savebtn.click();
	String error1=driver.findElement(By.xpath("//div/div/div[2]/div[1]/small")).getText();
	System.out.println("------error alert-----"+error1);
	String error2 = driver.findElement(By.xpath("//div/div/div[2]/div[2]/small")).getText();
	System.out.println("*****Error alert*****"+error2);
	String error3 =driver.findElement(By.xpath("/html/body/app-root/app-program/p-dialog/div/div/div[2]/small")).getText();	
	System.out.println("------error alert-----"+error3);
	WebElement programtxt= driver.findElement(By.xpath("//*[@id=\"programName\"]"));
	programtxt.sendKeys("Abcdefg");
	WebElement savebtn1=driver.findElement(By.xpath("//*[@id=\"saveProgram\"]"));
	savebtn1.click();
	String error6 = driver.findElement(By.xpath("//div/div/div[2]/div[2]/small")).getText();
	System.out.println("*****Error alert*****"+error6);
	String error7 =driver.findElement(By.xpath("/html/body/app-root/app-program/p-dialog/div/div/div[2]/small")).getText();	
	System.out.println("------error alert-----"+error7);
	

}

public void with_splchar_input() {
	
	WebElement programtxt= driver.findElement(By.xpath("//*[@id=\"programName\"]"));
	programtxt.clear();
	programtxt.sendKeys("111");
	WebElement programdescrip=driver.findElement(By.xpath("//*[@id=\"programDescription\"]"));
	programdescrip.sendKeys("!@#$");
	
	WebElement savebtn=driver.findElement(By.xpath("//*[@id=\"saveProgram\"]"));
	savebtn.click();
	
	String error4=driver.findElement(By.xpath("//div/div/div[2]/div[1]/small")).getText();
	System.out.println("------error alert-----"+error4);
	String error5=driver.findElement(By.xpath("//div/div/div[2]/div[1]/small")).getText();
	System.out.println("------error alert-----"+error5);
	
}
public void sucess_program_created() {
	WebElement programtxt=driver.findElement(By.xpath("//*[@id=\"programName\"]"));
	programtxt.clear();
	programtxt.sendKeys("SDET216");
	WebElement programdescrip=driver.findElement(By.xpath("//*[@id=\"programDescription\"]"));
	programdescrip.sendKeys("Design Framework");
	WebElement radioBtn = driver.findElement(By.xpath("//*[@id=\"category\"]/div/div[2]"));
	radioBtn.click();
	WebElement savebtn=driver.findElement(By.xpath("//*[@id=\"saveProgram\"]"));
	savebtn.click();
	String alert=driver.findElement(By.xpath("//div/p-toastitem/div/div/div/div[2]")).getText();
	System.out.println("-------Success Program Created Alert-------"+alert);
	
	
}

public void validate_edit_and_programname() {
	WebElement editbtn= driver.findElement(By.xpath("//div/div[1]/table/tbody/tr[2]/td[5]/div/span/button[1]/span[1]"));
	editbtn.click();
	WebElement programtxt=driver.findElement(By.xpath("//*[@id=\"programName\"]"));
	programtxt.clear();
	programtxt.sendKeys("SDET317");
	WebElement savebtn=driver.findElement(By.xpath("//*[@id=\"saveProgram\"]"));
	savebtn.click();
	String alert=driver.findElement(By.xpath("/html/body/app-root/app-program/p-toast/div")).getText();
	System.out.println("------- Program Updated Alert-------"+alert);
	
}
	public void validate_edit_statusbutton() {
		WebElement editbtn= driver.findElement(By.xpath("//div/div[1]/table/tbody/tr[1]/td[5]/div/span/button[1]"));
		editbtn.click();
		WebElement status_button = driver.findElement(By.xpath("//*[@id=\"category\"]/div/div[2]/span"));
		status_button.click();
		WebElement savebtn=driver.findElement(By.xpath("//*[@id=\"saveProgram\"]"));
		savebtn.click();
		String alert=driver.findElement(By.xpath("/html/body/app-root/app-program/p-toast/div")).getText();
		System.out.println("------- Program Updated Alert-------"+alert);
	}
	
	/*
	
	public void validate_edit_invalid_input() {
		WebElement editbtn= driver.findElement(By.xpath("//div/div[1]/table/tbody/tr[4]/td[5]/div/span/button[1]"));
		editbtn.click();
		WebElement programtxt=driver.findElement(By.xpath("//*[@id=\"programName\"]"));
		programtxt.clear();
		programtxt.sendKeys("123456");
		WebElement programdescrip=driver.findElement(By.xpath("//*[@id=\"programDescription\"]"));
		programdescrip.clear();
		programdescrip.sendKeys("Design Framework");
		WebElement savebtn=driver.findElement(By.xpath("//*[@id=\"saveProgram\"]"));
		String error1=driver.findElement(By.xpath("//div/div/div[2]/div[1]/small")).getText();
		System.out.println("------error alert-----"+error1);
		String error2 = driver.findElement(By.xpath("//div/div/div[2]/div[2]/small")).getText();
		System.out.println("*****Error alert*****"+error2);
	}
	
	*/

   public void validate_delete(){
	WebElement deletebtn = driver.findElement(By.xpath("//div/div[1]/table/tbody/tr[1]/td[5]/div/span/button[2]"));
	deletebtn.click();
	WebElement confirmBtn = driver.findElement(By.xpath("//div/div/div[1]/span"));
    String cnbtn = confirmBtn.getText();
    System.out.println("*****Confirm*****"+cnbtn);
    WebElement yesbtn = driver.findElement(By.xpath("//div/div/div[3]/button[2]"));
    String ybtn = yesbtn.getText();
    System.out.println("****Yes****"+ybtn);
    WebElement nobtn = driver.findElement(By.xpath("//div/div/div[3]/button[1]"));
    String Nbtn= nobtn.getText();
    System.out.println("****No btn******"+Nbtn);
}
   
   public void validate_confirmdelete() {
	   
	   WebElement deletebtn = driver.findElement(By.xpath("/html/body/app-root/app-program/p-confirmdialog/div/div/div[2]/span"));
	   deletebtn.click();
	   WebElement confirmationbtn = driver.findElement(By.xpath("//div/div/div[2]/span"));
	   String confirmationbtn1 = confirmationbtn.getText();
	   System.out.println("****Confirmation btn******"+confirmationbtn1);
	   	   
   }
   
   public void validate_yesindelete() {
	   WebElement deletebtn = driver.findElement(By.xpath("/html/body/app-root/app-program/p-confirmdialog/div/div/div[2]/span"));
	   deletebtn.click();
	   WebElement yesbtn = driver.findElement(By.xpath("//div/div/div[3]/button[2]"));
	   yesbtn.click();
	   String alert=driver.findElement(By.xpath("/html/body/app-root/app-program/p-toast/div")).getText();
	   System.out.println("*****Deleted*****"+alert);
	   
   }
}