package com.lmsapp.lms.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmsapp.lms.POM.CommonMethodsObject;
import com.lmsapp.lms.POM.User1_PageObject;
import com.lmsapp.lms.POM.User2_PageObject;
import com.lmsapp.lms.POM.User3_PageObject;
import com.lmsapp.lms.utilities.TestSetup;
import io.cucumber.java.en.*;

public class E3_UserStepDefinition {

	WebDriver driver;
	TestSetup testsetup;
	CommonMethodsObject commonobj;
	public User3_PageObject user3obj;
	public static Logger LOG = LoggerFactory.getLogger(E1_UserStepDefinition.class);
	
	public E3_UserStepDefinition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		user3obj=testsetup.pageobjectmanager.getUser3MethodsObject();
	}
	
	@Given("Admin is on Manage User Page-User3")
	public void admin_is_on_manage_user_page_user3() {
	  commonobj.loginUser();
	  user3obj.NavigatingUser();
	}

	@When("Admin enters user name into search box-User3.")
	public void admin_enters_user_name_into_search_box_user3() {
		user3obj.NavigatingUser();
	}

	@Then("Admin should see user displayed with the entered name-User3")
	public void admin_should_see_user_displayed_with_the_entered_name_user3() {
	   user3obj.DisplayEnterName();
	   user3obj.UserDisplayed();
	}

	@When("Admin enters the keywords not present in the data table on the Search box-User3")
	public void admin_enters_the_keywords_not_present_in_the_data_table_on_the_search_box_user3() {
		
		user3obj.Invalidata();
	}

	@Then("Admin should see zero entries on the data table-User3")
	public void admin_should_see_zero_entries_on_the_data_table_user3() {
	    user3obj.NodataDisplayed();
	}
	
	@When("Admin clicks {string} button")
	public void admin_clicks_button(String string) {
	 user3obj.NewUser();
	}

	@Then("Admin should see pop up open for user details")
	public void admin_should_see_pop_up_open_for_user_details() {
		user3obj.UsetWindow();
	}

	@Then("Admin should see all text boxes for the fields")
	public void admin_should_see_all_text_boxes_for_the_fields() {
		user3obj.TextBoxes();
	}

	@Then("Admin should see drop downs for the fields")
	public void admin_should_see_drop_downs_for_the_fields() {
	   user3obj.Countdropdown();
	}

	
	
}
