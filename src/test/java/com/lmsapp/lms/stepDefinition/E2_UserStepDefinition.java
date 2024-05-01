package com.lmsapp.lms.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmsapp.lms.POM.CommonMethodsObject;
import com.lmsapp.lms.POM.User1_PageObject;
import com.lmsapp.lms.POM.User2_PageObject;
import com.lmsapp.lms.utilities.TestSetup;
import io.cucumber.java.en.*;

public class E2_UserStepDefinition {

	WebDriver driver;
	TestSetup testsetup;
	CommonMethodsObject commonobj;
	public User2_PageObject user2obj;
	public static Logger LOG = LoggerFactory.getLogger(E1_UserStepDefinition.class);
	
	public E2_UserStepDefinition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		user2obj=testsetup.pageobjectmanager.getUser2MethodsObject();
	}
	
	
	@Given("Admin is on dashboard page after Login-User2")
	public void admin_is_on_dashboard_page_after_login_user2() {
		commonobj.loginUser();
	}

	@When("Admin clicks {string} from navigation bar-User2")
	public void admin_clicks_from_navigation_bar_user2(String string) {
		user2obj.NavigatingUser();
	}

	@Then("Each row in the data table should have a checkbox")
	public void each_row_in_the_data_table_should_have_a_checkbox() throws InterruptedException {
		user2obj.CheckBoxCount();
	}

	@Then("Each row in the data table should have a edit icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
		user2obj.EditEnabledButton();
	}

	@Then("Each row in the data table should have a delete icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() throws InterruptedException {
	  Thread.sleep(2000); 
	  user2obj.DeleteButtonEnabled();
	}

	
}
