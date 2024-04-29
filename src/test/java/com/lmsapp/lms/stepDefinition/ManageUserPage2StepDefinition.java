package com.lmsapp.lms.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.lmsapp.lms.POM.CommonMethodsObject;
import com.lmsapp.lms.POM.ManageUserPOM2;
import com.lmsapp.lms.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.internal.org.jline.utils.Log;

public class ManageUserPage2StepDefinition {
	
	WebDriver driver;
	TestSetup testsetup;
	CommonMethodsObject commonobj;
	ManageUserPOM2 manageuser2;
	
	
	
	public ManageUserPage2StepDefinition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		manageuser2=testsetup.pageobjectmanager.getManageUser2Obj();
		
	}
		
	@Given("User is on dashboard page after Login and clicks User on the navigation bar")
	public void user_is_on_dashboard_page_after_login_and_clicks_user_on_the_navigation_bar() {
		commonobj.loginUser();
		manageuser2.navigateToUser();
	}
	
	
	
	@When("The admin clicks on {string} sort icon")
	public void the_admin_clicks_on_sort_icon(String headerElement) {
		manageuser2.sortUsers(headerElement);
	  
	}


	@Then("Admin should see User details are sorted by id")
	public void admin_should_see_user_details_are_sorted_by_id() {
	   
	}
	
	
	@Then("Admin should see User details are sorted by Name")
	public void admin_should_see_user_details_are_sorted_by_name() {
		
		Log.info("Sorted with Name header");
	    
	}

	@Then("Admin should see User details are sorted by Location")
	public void admin_should_see_user_details_are_sorted_by_location() {
		Log.info("Sorted with Location header");
	 
	}

	@Then("Admin should see User details are sorted by PhoneNumber")
	public void admin_should_see_user_details_are_sorted_by_phone_number() {
		Log.info("Sorted with PhoneNumber  header");
	  
	}


}
