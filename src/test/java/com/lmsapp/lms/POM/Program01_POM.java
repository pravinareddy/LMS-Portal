package com.lmsapp.lms.POM;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Program01_POM {
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
//		@FindBy(xpath="//div/div/div[1]/span")
//		WebElement confirmbtn;
		public static Logger LOG = LoggerFactory.getLogger(CommonMethodsObject.class);
		public Program01_POM(WebDriver driver) 
	   {
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
		String msg = driver.findElement(By.xpath("//div/mat-card/mat-card-title/div[1]")).getText();
		System.out.println("---------**Result getext**--------"+msg);
		}
		public void get_pagenumbers() {
		String msg1 = driver.findElement(By.xpath("//div/mat-card/mat-card-content/p-table/div/p-paginator/div/span[1]")).getText();
		System.out.println("-------Result page numbers--------"+msg1);
		}
		public void get_footer() {
			String msg2 = driver.findElement(By.xpath("//div/mat-card/mat-card-content/p-table/div/div[2]/div")).getText();
			System.out.println("-------Result footer--------"+msg2);
		}
		public void check_buton_delete() {
	     if (deletebutton.getAttribute("disabled") != null) {
         System.out.println("----**Button is disabled***-----");
	     } else {
         System.out.println("------**Button is enabled**-----");
	     }	}
		public void click_new_program() {
			newprogram.click();
			System.out.println("*********A new program window is opened *****");
		}
		public void get_rows_in_table() {
	java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
	if (rows.size() == 5) {
		System.out.println("-------****Table has 5 rows*****---------");
	} else {
		System.out.println("Table does not have 5 rows.");
		}	}
		public void get_column_values_datatable() {
    	java.util.List<WebElement>  allheaders = driver.findElements(By.xpath("//div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr"));
        for (WebElement headers_title : allheaders) {
    	String value=headers_title.getText();        
        System.out.println(value);
        }	}
		public void check_sort_icon_on_headers() {
			java.util.List<WebElement> headers = driver.findElements(By.xpath("//th"));
       for (WebElement header : headers) {
                 WebElement sortIcon = null;
         try {     sortIcon = header.findElement(By.tagName("//i"));
             System.out.println("Sort arrow icon not found beside column header: " + header.getText());
         } catch (org.openqa.selenium.NoSuchElementException e) {
             System.out.println("Sort arrow icon  found beside column header: " + header.getText());
         }     }}
		public void check_all_checkboxes_in_all_rows() {
			java.util.List<WebElement> checkboxes = driver.findElements(By.xpath("//tr//input[@type='checkbox']"));
			// Verify if checkboxes are visible in all rows
			boolean allVisible = true;
			for (WebElement checkbox : checkboxes) {
         if (!checkbox.isDisplayed()) {
             allVisible = true;
             break;  }}
     	if (allVisible) {System.out.println("Checkboxes are visible in all rows of the table.");
     	} else { System.out.println("Checkboxes are not visible in all rows of the table.");
     	}	}
		public void check_editdelete_in_rows() {
			java.util.List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
			boolean allVisible = true;
			java.util.List<WebElement> editDeleteButtons = driver.findElements(By.xpath("//td/button[contains(text(), 'Edit') or contains(text(), 'Delete')]"));
			for (WebElement button : editDeleteButtons) {
				if (!button.isDisplayed()) {
	        allVisible = false;
	        break;
	    }	}
			if (allVisible) {   System.out.println("Edit/Delete buttons are visible in all rows of the table.");
		} else {   System.out.println("Edit/Delete buttons are not visible in all rows of the table.");
		}	}
		public void verify_searchBar() {
    	String expectedText= "Search...";
    	String actualText= searchBar.getAttribute("placeholder");
    	System.out.println("Placeholder value:"+actualText);
    	if(searchBar.isDisplayed()) {
    		System.out.println("-----------Search box displayed-------");
    	}	
    	assertEquals(actualText,expectedText);
    	}
    
    	public void verify_empty_form() {
    	Boolean disp1=savebtn.isDisplayed();
    	System.out.println("save button is displayed "+disp1);
    	Boolean disp2=cancelbtn.isDisplayed();
    	System.out.println("cancel  button is displayed "+disp2);
    	Boolean disp3=closeicon.isDisplayed();
    	System.out.println("close icon is displayed");
    	}
    	public void verify_two_inputfields() {
    	Boolean field=programtxt.isDisplayed();
    	System.out.println("program name  field is displayed "+field);
    	Boolean field1=programdescrip.isDisplayed();
    	System.out.println("program description field is displayed "+field1);
    	}
    	public void verify_radio_btn() {
    	Boolean field2=radiobtn.isDisplayed();
    	System.out.println("Radio buttons are displayed"+field2);
    	    }
    	public void save_without_anydata() {
    	savebtn.click();    	
    	String errormsg=error1.getText();
       	System.out.println("------error alert-----"+errormsg);    	
       	String errormsg1=error2.getText();
    	System.out.println("*****Error alert*****"+errormsg1); 
    	String errormsg2=error3.getText();
    	System.out.println("----Error alert-----"+errormsg2);  
    	programtxt.sendKeys("fegrty");
    	savebtn.click();   
    	String errormsg3=error2.getText();
    	System.out.println("####----Error alert---###"+errormsg3);   
    	String errormsg4=error3.getText();
    	System.out.println("####----Error alert---###"+errormsg4);    	
    	}
    	public void with_splchar_input() {
    	programtxt.clear();    	programtxt.sendKeys("1298h6556746k6756");
    	programdescrip.clear();    	programdescrip.sendKeys("$$ijjjiii@@@&79*&7958867&##");
    	savebtn.click();
    	String errormsg5=error1.getText();
    	System.out.println("------error alert-----"+errormsg5);
       	String errormsg6=error2.getText();    
       	System.out.println("*****Error alert*****"+errormsg6);
    	}
    	public void sucess_program_created() {
       	programtxt.sendKeys("AAAABBB9466");
       	programdescrip.sendKeys("Automation xyyyyx BDD ");
       	radiobtn.click();
       	savebtn.click();
       	String alert=driver.findElement(By.xpath("//div/p-toastitem/div/div/div/div[2]")).getText();
    	System.out.println("-------Success Program Created Alert-------"+alert);
      }
       public void validate_edit_and_programname() {
    	  WebElement editbtn=driver.findElement(By.xpath("//div/div[1]/table/tbody/tr[1]/td[5]/div/span/button[1]/span[1]"));
    	editbtn.click();
     	programtxt.clear();   
     	programtxt.sendKeys("asjh76746745khjggh");
       	savebtn.click();
    	String alert=driver.findElement(By.xpath("/html/body/app-root/app-program/p-toast/div")).getText();
    	System.out.println("-------Program updated Alert-------"+alert);
       }
       public void validate_edit_statusbutton() {
	   WebElement editbtn=driver.findElement(By.xpath("//div/div[1]/table/tbody/tr[1]/td[5]/div/span/button[1]/span[1]"));
		editbtn.click();
		status_button.click();
		savebtn.click();
		String alert=driver.findElement(By.xpath("/html/body/app-root/app-program/p-toast/div")).getText();
		System.out.println("-----Success alert----"+alert);
   }
//   public void validate_edit_invalid_inputs() {
//	   WebElement editbtn=driver.findElement(By.xpath("//div/div[1]/table/tbody/tr[1]/td[5]/div/span/button[1]/span[1]"));
//	   editbtn.click();
//	   programtxt.clear();    
//	   programtxt.sendKeys("647788060037688");
//	   programdescrip.clear(); 
//	   programdescrip.sendKeys("@*^^%");
//	   error1.getText();       
//	   System.out.println("------error alert-----"+error1);
//      	error2.getText();  
//      	System.out.println("*****Error alert*****"+error2);
//	      }

  		public void validate_delete() {
  			deletebtn.click();
  			confirmbtn.getText();   
  			String cnbtn = confirmbtn.getText();
  			System.out.println("*****Confirm*****"+cnbtn);
  			String ybtn=yesbtn.getText();		
  			System.out.println("****Yes****"+ybtn);
  			nobtn.getText();
  			String Nbtn= nobtn.getText();
  			System.out.println("****No btn******"+Nbtn); 
  }
  		public void validate_confirmdelete() {
  			WebElement deletebtn1=driver.findElement(By.xpath("/html/body/app-root/app-program/p-confirmdialog/div/div/div[2]/span"));
  			deletebtn1.click();
   			String confirmation1=confirmationbtn.getText();
   			System.out.println("******confirmation*******"+confirmation1);
  		}
  
  		public void validate_yes_in_delete() {
  			WebElement deletebtn2=driver.findElement(By.xpath("/html/body/app-root/app-program/p-confirmdialog/div/div/div[2]/span"));
  			deletebtn2.click();
  			yesbtn.click();
  			String alert=driver.findElement(By.xpath("/html/body/app-root/app-program/p-toast/div/p-toastitem/div/div/div/div[2]")).getText();
  			System.out.println("-----Success alert----"+alert);
  		}
	   }


