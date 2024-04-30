package com.lmsapp.lms.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmsapp.lms.POM.CommonMethodsObject;
import com.lmsapp.lms.POM.ManageUserPOM2;
import com.lmsapp.lms.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.internal.org.jline.utils.Log;

public class ManageUserAssignStudentStepDefintion {
	
	WebDriver driver;
	TestSetup testsetup;
	CommonMethodsObject commonobj;
	ManageUserPOM2 manageuser2;

	public static Logger LOG = LoggerFactory.getLogger(ManageUserAssignStudentStepDefintion.class);

	
	public ManageUserAssignStudentStepDefintion(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		manageuser2=testsetup.pageobjectmanager.getManageUser2Obj();
		
	}
		
	
	@Given("Admin is in manage user page")
	public void admin_is_in_manage_user_page() {
		manageuser2.navigateToUser();
	
	}

	@When("The admin clicks on {string} button")
	public void the_admin_clicks_on_button(String string) {
		manageuser2.clickassignStudentBtn();
	   
	}


	@Then("Admin should see a pop up open for assign student details with empty form along with Save and Cancel button and close  icon on the top right corner of the window")
	public void admin_should_see_a_pop_up_open_for_assign_student_details_with_empty_form_along_with_save_and_cancel_button_and_close_icon_on_the_top_right_corner_of_the_window() {
		manageuser2.assignStdtPopupvalidation1();
		LOG.info("All the buttons are enabled on AssignStudent popup window");
	}
	
	@Then("Admin should see User Role as R03,and other fields Student Email id,Program Name,Batch Name and Status with respective input boxes.")
	public void admin_should_see_user_role_as_r03_and_other_fields_student_email_id_program_name_batch_name_and_status_with_respective_input_boxes() {
		manageuser2.assignStdtPopupvalidation2();
		LOG.info("Empty page validation for Assign Student Popup window is done sucessfuly");
	}
	
	@Then("Admin should see two radio button for Status")
	public void admin_should_see_two_radio_button_for_status() {
		manageuser2.assignStdtPopupvalidation3();
	    
	}
	
	@When("Admin clicks {string} button with entering any data")
	public void admin_clicks_button_with_entering_any_data(String string) {
		manageuser2.clickSaveBtn();
	}

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() {
		manageuser2.validateEmptyFormErrMsg();
		LOG.info("Empty Form validation done successfully");
	}
	
//	@When("Admin clicks {string} button without entering Student Email id")
//	public void admin_clicks_button_without_entering_student_email_id(String string) {
//	  
//	}
//
//	@Then("Admin gets a Error message alert as Student Email id is required")
//	public void admin_gets_a_error_message_alert_as_student_email_id_is_required() {
//	   
//	}
//	
//	@When("Admin clicks {string} button without selecting program")
//	public void admin_clicks_button_without_selecting_program(String string) {
//	  
//	}
//
//	@Then("Admin gets a Error message alert as Program is required")
//	public void admin_gets_a_error_message_alert_as_program_is_required() {
//	    
//	}
//	@When("Admin clicks {string} button without selecting batch")
//	public void admin_clicks_button_without_selecting_batch(String string) {
//	
//	}
	
//	@Then("Admin gets a Error message alert as Batch is required")
//	public void admin_gets_a_error_message_alert_as_batch_is_required() {
//	
//	}

	
	@When("Admin clicks {string} button without giving status for {string}")
	public void admin_clicks_button_without_giving_status_for(String string, String emailid) {
		manageuser2.validateAssignStdtWithOutStatus(emailid);
	}


	@Then("Admin gets a Error message alert as Status is required")
	public void admin_gets_a_error_message_alert_as_status_is_required() {
		manageuser2.validateErrMsgAssignStdtWithOutStatus();
	}
	
	@Given("Given Admin is in Assign Student details pop up page")
	public void given_admin_is_in_assign_student_details_pop_up_page() {
		manageuser2.clickassignStudentBtn();
	}

	@When("Admin clicks {string} button without giving Program Name  for {string}")
	public void admin_clicks_button_without_giving_program_name_for(String string, String emailid) {
		manageuser2.validateAssignStdtWithOutProgram(emailid);
	}
	@Then("Admin gets a Error message alert as ProgramName is required")
	public void admin_gets_a_error_message_alert_as_program_name_is_required() {
		manageuser2.validateErrMsgAssignStdtWithOutProgram();
	  
	}

	@When("Admin clicks {string} button without giving BatchName  for {string}")
	public void admin_clicks_button_without_giving_batch_name_for(String string, String emailid) {
		manageuser2.validateAssignStdtWithOutBatch(emailid);
	}

	@Then("Admin gets a Error message alert as BatchName is required")
	public void admin_gets_a_error_message_alert_as_batch_name_is_required() {
		manageuser2.validateErrMsgAssignStdtWithOutBatch();
	}
	
	@When("Admin clicks Close\\(X) Icon on Assign Student form for {string}")
	public void admin_clicks_close_x_icon_on_assign_student_form_for(String emailid) throws InterruptedException {
		manageuser2.validateAssignStdtClickCloseBtn(emailid);
	}
	

	@Then("Assign Student popup window should be closed without saving")
	public void assign_student_popup_window_should_be_closed_without_saving() {
		
		manageuser2.validatepopIsClosed();
	 
	}
	
	@When("Admin clicks Cancel Icon on Assign Student form for {string}")
	public void admin_clicks_cancel_icon_on_assign_student_form_for(String emailid) throws InterruptedException {
		manageuser2.validateAssignStdtClickCancelBtn(emailid);
	}




	


}
