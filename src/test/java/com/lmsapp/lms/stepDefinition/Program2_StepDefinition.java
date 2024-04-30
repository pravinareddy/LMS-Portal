package com.lmsapp.lms.stepDefinition;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
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
	Collection<String> descendingOriginalList;
	CommonMethodsObject commonobj;
	Program1_POM programobj;
	Program2_POM programobj2;
	 
	public Program2_StepDefinition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		programobj = testsetup.pageobjectmanager.getProgramMethodsObject();
		programobj2 = testsetup.pageobjectmanager.getProgramMethodsObject2();
		

}
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
		System.out.println("Admin is redirected to batch page");
	    
	}

	@When("Admin clicks on User link on Manage Program page")
	public void admin_clicks_on_user_link_on_manage_program_page() {
		
	   programobj2.click_user_link();
	}

	@Then("Admin is re-directed to User page")
	public void admin_is_re_directed_to_user_page() {
	   System.out.println("Admin is redirected to user page");
	}

	@When("Admin clicks on Logout link on Manage Program page")
	public void admin_clicks_on_logout_link_on_manage_program_page() {
		programobj2.click_logout_link();
	}

	@Then("Admin is re-directed to Login page")
	public void admin_is_re_directed_to_login_page() {
	    System.out.println("Admin is redirected to login page");
	}
	
//	@When("Admin clicks on the {string} sort icon by {int} clicks")
//	public void admin_clicks_on_the_sort_icon_by_clicks(String columnHeading, int clickCount) {
//	  programobj2.click_program_navigation();
//	  java.util.List<String> descendingOriginalList = programobj2.sorting(columnHeading,clickCount);
//	}
//	@Then("Admin should see User details are sorted by {string} Descending order")
//	public void admin_should_see_user_details_are_sorted_by_descending_order(String string) {
//		
//		java.util.List<String> sortedDescendingList = descendingOriginalList.stream().sorted(Comparator.reverseOrder())
//			        .collect(Collectors.toList());
//		 Assert.assertTrue(descendingOriginalList.equals(sortedDescendingList),"Descending Sorted List is not matching");
//		 System.out.println("Original List is"+ descendingOriginalList);
//		 System.out.println("Sorted List is"+ sortedDescendingList);
//	}
	
	@When("The admin clicks on {string} sort icon")
	public void the_admin_clicks_on_sort_icon(String headerElement) {
		programobj2.sortProgram(headerElement);   
	}

	@Then("Admin should see Program details are sorted by  Program Name")
	public void admin_should_see_program_details_are_sorted_by_program_name() {
	    System.out.println("----------Sorted with program name-------");
	}

	@Then("Admin should see Program details are sorted by Program Description")
	public void admin_should_see_program_details_are_sorted_by_program_description() {
	    System.out.println("----------Sorted with program decription-------");

	}

	@Then("Admin should see  Program details are sorted by Program Status")
	public void admin_should_see_program_details_are_sorted_by_program_status() {
	    System.out.println("-------Sorted with program status-------");

	   
	}

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
		System.out.println("The selected programs are not deleted from table by clicking NO Button");
	}
	
		
}
