package com.lmsapp.lms.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmsapp.lms.POM.CommonMethodsObject;
import com.lmsapp.lms.POM.ManageUserPOM2;
import com.lmsapp.lms.utilities.TestSetup;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageUserAssignStaffStepDefinition {
	
	WebDriver driver;
	TestSetup testsetup;
	CommonMethodsObject commonobj;
	ManageUserPOM2 manageuser2;

	public static Logger LOG = LoggerFactory.getLogger(ManageUserAssignStudentStepDefintion.class);

	
	public ManageUserAssignStaffStepDefinition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		manageuser2=testsetup.pageobjectmanager.getManageUser2Obj();
		
	}
		
	@When("The admin clicks on Assign Staff button")
	public void the_admin_clicks_on_assign_staff_button() {
		manageuser2.clickassignStaffBtn();
	}

	@Then("Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close  icon on the top right corner of the window")
	public void admin_should_see_a_pop_up_open_for_assign_staff_details_with_empty_form_along_with_save_and_cancel_button_and_close_icon_on_the_top_right_corner_of_the_window() {
		manageuser2.assignStaffPopupvalidation1();
		LOG.info("All the buttons are enabled on AssignStudent popup window");
	}
	@Then("Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes.")
	public void admin_should_see_user_role_as_r02_and_other_fields_student_email_id_skill_program_name_batch_name_and_status_with_respective_input_boxes() {
		manageuser2.assignStaffPopupvalidation2();
		LOG.info("Empty form validation for AssignStaff done sucessfully");
	}
	

}


