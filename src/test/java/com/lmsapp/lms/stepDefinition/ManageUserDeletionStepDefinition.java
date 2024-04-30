package com.lmsapp.lms.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmsapp.lms.POM.CommonMethodsObject;
import com.lmsapp.lms.POM.ManageUserPOM2;
import com.lmsapp.lms.utilities.TestSetup;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.internal.org.jline.utils.Log;

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
	
	public static Logger LOG = LoggerFactory.getLogger(ManageUserDeletionStepDefinition.class);
	
	
	/*
	 * @When("Admin clicks the delete icon after selecting the users") public void
	 * admin_clicks_the_delete_icon_after_selecting_the_users(List<String> UserID )
	 * throws InterruptedException {
	 * 
	 * System.out.println("inside step");
	 * 
	 * //manageuser2.deleteUser(UserID); manageuser2.delete1(UserID);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion"
	 * ) public void
	 * admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion
	 * (String string) {
	 * 
	 * }
	 * 
	 * @When("Admin clicks {string} option") public void admin_clicks_option(String
	 * string) {
	 * 
	 * }
	 * 
	 * @Then("Admin gets a message {string} alert and do not see that user in the data table"
	 * ) public void
	 * admin_gets_a_message_alert_and_do_not_see_that_user_in_the_data_table(String
	 * string) {
	 * 
	 * }
	 */
	
	@When("Admin clicks the delete icon on row level in Manage User Page")
	public void admin_clicks_the_delete_icon_on_row_level_in_manage_user_page() {
		manageuser2.clickRowDeleteButton();
	}

	@Then("Admin should see a alert open with heading Confirm along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_confirm_along_with_yes_and_no_button_for_deletion() {
		manageuser2.validateRowDeleteBtn();
	}

	@When("Admin clicks the row level delete icon after selecting the user and clicks {string} option")
	public void admin_clicks_the_row_level_delete_icon_after_selecting_the_user_and_clicks_option(String deleteAction, List<String> userId) throws InterruptedException {
		manageuser2.singleUserDeleteInRow(deleteAction, userId);
	}

	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
	    LOG.info("Alert is closed");
	}

	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {
		 LOG.info("Alert is closed");
	}

	@Then("Admin gets a message <Successful User Deleted> alert and do not see that user in the data table")
	public void admin_gets_a_message_successful_user_deleted_alert_and_do_not_see_that_user_in_the_data_table() {
		 LOG.info("User has been deleetd successfully");
	}
	
	@When("Admin clicks any checkbox in the data table")
	public void admin_clicks_any_checkbox_in_the_data_table() {
		manageuser2.clickCheckBox();
	}

	@Then("Admin should see common delete option enabled under header Manage Program")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {
		manageuser2.validateHeaderDelete();
	}

	@When("Admin clicks the delete icon under header after selecting the multiple user and clicks {string} option")
	public void admin_clicks_the_delete_icon_under_header_after_selecting_the_multiple_user_and_clicks_option(String deleteAction,List<String> userId) throws InterruptedException {
		manageuser2.multipleUserDelete(deleteAction, userId);
	}



}
