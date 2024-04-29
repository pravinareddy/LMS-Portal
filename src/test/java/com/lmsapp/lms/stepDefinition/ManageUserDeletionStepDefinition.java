package com.lmsapp.lms.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.lmsapp.lms.POM.CommonMethodsObject;
import com.lmsapp.lms.POM.ManageUserPOM2;
import com.lmsapp.lms.utilities.TestSetup;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageUserDeletionStepDefinition {
	
	
	WebDriver driver;
	TestSetup testsetup;
	CommonMethodsObject commonobj;
	ManageUserPOM2 manageuser2;
	
	public ManageUserDeletionStepDefinition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		manageuser2=testsetup.pageobjectmanager.getManageUser2Obj();
		
	}
	
	
	
	
	@When("Admin clicks the delete icon after selecting the users")
	public void admin_clicks_the_delete_icon_after_selecting_the_users(List<String> UserID ) throws InterruptedException {
		
		System.out.println("inside step");
		
		//manageuser2.deleteUser(UserID);
		manageuser2.delete1(UserID);
	   
	}

	
	
	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String string) {
	   
	}

	@When("Admin clicks {string} option")
	public void admin_clicks_option(String string) {
	   
	}

	@Then("Admin gets a message {string} alert and do not see that user in the data table")
	public void admin_gets_a_message_alert_and_do_not_see_that_user_in_the_data_table(String string) {
	 
	}


}
