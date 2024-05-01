package com.lmsapp.lms.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lmsapp.lms.POM.CommonMethodsObject;
import com.lmsapp.lms.POM.User4_PageObject;
import com.lmsapp.lms.utilities.TestSetup;

import io.cucumber.java.en.*;

public class E4_UserStepDefinition {
	WebDriver driver;
	TestSetup testsetup;
	CommonMethodsObject commonobj;
	public User4_PageObject user4obj;
	public static Logger LOG = LoggerFactory.getLogger(E4_UserStepDefinition.class);
	
	public E4_UserStepDefinition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		user4obj=testsetup.pageobjectmanager.getUser4MethodsObject();
	}
	
	@Given("Admin is on  User details pop up-User4")
	public void admin_is_on_user_details_pop_up_user4() {
		commonobj.loginUser();
		user4obj.NavigatingUser();
		user4obj.NewUser();
	}

	@When("Admin enters mandatory fields in the form and clicks on submit button.")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_submit_button() throws InterruptedException {
	Thread.sleep(2000);   
	   user4obj.TextFieldsValid();

	   user4obj.ClickSubmit();
	}

	@Then("Admin gets message User added Successfully.")
	public void admin_gets_message_user_added_successfully() {
	  user4obj.HandlingAlert();
	}

	@When("Admin skips to add value in mandatory field")
	public void admin_skips_to_add_value_in_mandatory_field() {
		 user4obj.OptionalFields();
		 
	}

	@Then("Admin should see error message below the test field and the field will be highlighed in red color")
	public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighed_in_red_color() {
		user4obj.ClickSubmit();
		user4obj.CheckigAlert();
	}

	@When("Admin enters invalid data in all of the  fields in the form and clicks on submit button")
	public void admin_enters_invalid_data_in_all_of_the_fields_in_the_form_and_clicks_on_submit_button() {
	    user4obj.NumSplChar();
	    user4obj.ClickSubmit();
	}

	@Then("Admin gets error message and user is not created")
	public void admin_gets_error_message_and_user_is_not_created() {
	 user4obj.HandlingAlert();
	}

	@When("Admin clicks on submit button without entering data")
	public void admin_clicks_on_submit_button_without_entering_data() {
	   user4obj.ClickSubmit();
	}

	@Then("user won't be created and Admin gets error message")
	public void user_won_t_be_created_and_admin_gets_error_message() {
		user4obj.CheckigAlert();
	}

	@When("Admin clicks Cancel or Close Icon on User Details form")
	public void admin_clicks_cancel_close_x_icon_on_user_details_form() {
	   user4obj.ClickCancel();
	}

	@Then("User Details popup window should be closed without saving")
	public void user_details_popup_window_should_be_closed_without_saving() {
	    user4obj.FailedStatus();
	}

	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
	user4obj.ClickCancel();
	}

	@Then("Admin can see the User details popup disappears without adding any user")
	public void admin_can_see_the_user_details_popup_disappears_without_adding_any_user() {
	   user4obj.FindDataBody();
	}

	@When("Fill in all the fields with valid values and click submit")
	public void fill_in_all_the_fields_with_valid_values_and_click_submit() {
	   user4obj.TextFieldsValid();
	   user4obj.SelectRoleStatus("R02");
	   user4obj.SelectUserRole("Active");
	   user4obj.SelectVisaStatus("GC-EAD");
	   user4obj.ClickSubmit();
	}

	@Then("The newly added user should be present in the data table in Manage User page")
	public void the_newly_added_user_should_be_present_in_the_data_table_in_manage_user_page() {
	    user4obj.FindDataBody();
	}


}
