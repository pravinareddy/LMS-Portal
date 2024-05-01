package com.lmsapp.lms.stepDefinition;

import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.stream.*;
import com.lmsapp.lms.POM.CommonMethodsObject;
import com.lmsapp.lms.POM.User1_PageObject;
import com.lmsapp.lms.utilities.TestSetup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import io.cucumber.java.en.*;

public class E1_UserStepDefinition {
	
	
	WebDriver driver;
	TestSetup testsetup;
	CommonMethodsObject commonobj;
	public User1_PageObject user1obj;
	public static Logger LOG = LoggerFactory.getLogger(E1_UserStepDefinition.class);
	
	public E1_UserStepDefinition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		user1obj=testsetup.pageobjectmanager.getUser1MethodsObject();
	}

	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		commonobj.loginUser();

	}

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String string) {
	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String string)  {
		user1obj.navigateToUser();
	   }

	
	@Then("Admin should see a heading with text {string} on the page")
	public void admin_should_see_a_heading_with_text_on_the_page(String string) {
		user1obj.ManageProgramValidation();
	}

	@Then("Admin should see the text as {string} along with Pagination icon below the table.")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String string) {
	    user1obj.CheckPaginationIcon();
	}

	@Then("Admin Should see the data table with column names Id, Name, location, Phone Number, Edit\\/Delete")
	public void admin_should_see_the_data_table_with_column_names_id_name_location_phone_number_edit_delete() {
		user1obj.CheckHeadignColumn();
	   
	}

	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
		user1obj.CheckDeleteButton();
	}

	
	@Then("Admin should be able to see the {string} button above the data table-NewUser")
	public void admin_should_be_able_to_see_the_button_above_the_data_table_new_user(String string) {
		 user1obj.CheckAddNewUser();
	}
	
	@Then("Admin should be able to see the {string} button above the data table-Assign Staff")
	public void admin_should_be_able_to_see_the_button_above_the_data_table_assign_staff(String string) throws InterruptedException {
		Thread.sleep(1000);
		user1obj.CheckAddNewStaff();
	}

	@Then("Admin should be able to see the {string} button above the data table-Assign Student")
	public void admin_should_be_able_to_see_the_button_above_the_data_table_assign_student(String string) throws InterruptedException {
		Thread.sleep(1000);
		user1obj.CheckAddNewStudent();
	}


	@Then("Admin should be able to see the search text box above the data table")
	public void admin_should_be_able_to_see_the_search_text_box_above_the_data_table() {
	   user1obj.CheckSearchIcon();
	}

	@Then("Admin should see two  records displayed on the data table")
	public void admin_should_see_two_records_displayed_on_the_data_table() {
		 user1obj.RowDataCount();
	}
	

}
