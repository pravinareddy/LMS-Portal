package com.lmsapp.lms.stepDefinition;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.lmsapp.lms.POM.CommonMethodsObject;
import com.lmsapp.lms.POM.Program1_POM;
import com.lmsapp.lms.POM.Program2_POM;
import com.lmsapp.lms.utilities.TestSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Program2_StepDefinition {
	WebDriver driver;
	TestSetup testsetup;
	CommonMethodsObject commonobj;
	 Program1_POM programobj;
	 Program2_POM programobj2;
	 Collection<String> descendingOriginalList;
	public Program2_StepDefinition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		programobj = testsetup.pageobjectmanager.getProgramMethodsObject();
		programobj2=testsetup.pageobjectmanager.getProgramMethodsObject2();
}
//	Navigation Validation
//Scenario 1
@Given("User is on dashboard page after login")
public void user_is_on_dashboard_page_after_login() {
    commonobj.loginUser();
}
@When("Admin clicks on Batch link on Manage Program page")
public void admin_clicks_on_batch_link_on_manage_program_page() {
    programobj2.click_batch_linkUrl();
}
@Then("Admin is re-directed to Batch page")
public void admin_is_re_directed_to_batch_page() {
  System.out.println("Admin is redirected to batch page successfully");
}
@When("Admin clicks on User link on Manage Program page")
public void admin_clicks_on_user_link_on_manage_program_page() {
  programobj2.click_user_link();
}
@Then("Admin is re-directed to User page")
public void admin_is_re_directed_to_user_page() {
	System.out.println("Admin is redirected to user page successfully");
	}
@When("Admin clicks on Logout link on Manage Program page")
public void admin_clicks_on_logout_link_on_manage_program_page() {
  programobj2.click_logout();
}
@Then("Admin is re-directed to Login page")
public void admin_is_re_directed_to_login_page() {
	System.out.println("Admin is redirected to logout successfully");
}

//Multiple program delete
//Scenario 3
@When("Validate Common Delete button enabled after clicking on any checkbox")
public void validate_common_delete_button_enabled_after_clicking_on_any_checkbox() {
    programobj2.validate_common_delete();
}

@Then("Admin should see common delete option enabled under header Manage Program")
public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {
   System.out.println("The Common Delete Button is Enabled");
}


@When("Admin clicks YES button on the popup to delete the selected programs")
public void admin_clicks_yes_button_on_the_popup_to_delete_the_selected_programs() {
  programobj2.multipledelete_by_multipleselect_using_YES();
}

@Then("Admin should land on Manage Program page and can see the selected programs are deleted from the data table")
public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_deleted_from_the_data_table() {
   System.out.println("Selected Programs are deleted from the table");
}

@When("Admin clicks NO button on the popup")
public void admin_clicks_no_button_on_the_popup() {
    programobj2.multipledelete_by_multipleselect_using_NO();
}

@Then("Admin should land on Manage Program page and can see the selected programs are not deleted from the data table")
public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_not_deleted_from_the_data_table() {
   System.out.println("The selected programs are not deleted from table by clicking NO Button");
}
//Scenario 3
//
//@When("The admin clicks on {string} sort icon")
//public void the_admin_clicks_on_sort_icon(String headerElement) {
//programobj2.sortPrograms(headerElement);
//}
//@Then("Admin should see Program details are sorted by  Program Name")
//public void admin_should_see_program_details_are_sorted_by_program_name() {
// System.out.println("sorted with Program Name");
//}
//@Then("Admin should see Program details are sorted by Program Description")
//public void admin_should_see_program_details_are_sorted_by_program_description() {
//	System.out.println("sorted with Program Description");
//}
//@Then("Admin should see  Program details are sorted by Program Status")
//public void admin_should_see_program_details_are_sorted_by_program_status() {
//	System.out.println("sorted with Program Status");
//}

}
