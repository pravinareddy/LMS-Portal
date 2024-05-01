package com.lmsapp.lms.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmsapp.lms.POM.CommonMethodsObject;
import com.lmsapp.lms.POM.User5_PageObject;
import com.lmsapp.lms.utilities.TestSetup;
import io.cucumber.java.en.*;

public class E5_UserStepDefination {
	WebDriver driver;
	TestSetup testsetup;
	CommonMethodsObject commonobj;
	public User5_PageObject user5obj;
	public static Logger LOG = LoggerFactory.getLogger(E1_UserStepDefinition.class);
	
	public E5_UserStepDefination(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		user5obj=testsetup.pageobjectmanager.getUser5MethodsObject();
	}
	
	@Given("Admin is on Manage User Page")
	public void admin_is_on_manage_user_page() {
	   commonobj.loginUser();
	}

	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() {
	  user5obj.CheckingEditIcon();
	}

	@Then("A new pop up with User details appears")
	public void a_new_pop_up_with_user_details_appears() {
	    user5obj.CheckingdataTable();
	}

	@Given("Admin is on User details pop up")
	public void admin_is_on_user_details_pop_up() {
		commonobj.loginUser();
		user5obj.NavigatingUser();
		 user5obj.CheckingEditIcon();
	}

	@When("Update the fields with valid data and click submit")
	public void update_the_fields_with_valid_data_and_click_submit() {
		  user5obj.UpdateEmail();
		user5obj.ClickSubmit();
	}

	@Then("Admin gets message {string} and see the updated values in data table")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) {
		user5obj.updateSuccess();
	}

	@When("Update the fields with invalid values and click submit")
	public void update_the_fields_with_invalid_values_and_click_submit() {
		user5obj.UpdateInvaliEmail();
		user5obj.ClickSubmit();
	}

	@Then("Admin should get Error message")
	public void admin_should_get_error_message() {
		user5obj.updateSuccessWithAlert();
	}

	@When("Update the mandatory fields with valid values and click submit")
	public void update_the_mandatory_fields_with_valid_values_and_click_submit() {
		user5obj.MandotoryFields();
		user5obj.ClickSubmit();
	}

	@When("Update the optional fields with valid values and click submit")
	public void update_the_optional_fields_with_valid_values_and_click_submit() {
		user5obj.OptionalFields();
		user5obj.ClickSubmit();
	}

	@When("Admin enters only numbers or special char in the text fields")
	public void admin_enters_only_numbers_or_special_char_in_the_text_fields() {
		user5obj.NumSplChar();
	}

	@When("Admin clicks Cancel button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
		user5obj.Cancel();
	}

	@Then("Admin can see the User details popup disappears and can see nothing changed for particular User")
	public void admin_can_see_the_user_details_popup_disappears_and_can_see_nothing_changed_for_particular_user() {
		user5obj.DataBoday();
	}

}
