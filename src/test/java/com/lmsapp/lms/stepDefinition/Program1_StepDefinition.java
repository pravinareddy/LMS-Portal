package com.lmsapp.lms.stepDefinition;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.lmsapp.lms.POM.CommonMethodsObject;
import com.lmsapp.lms.POM.Program1_POM;
import com.lmsapp.lms.utilities.TestSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Program1_StepDefinition {
	WebDriver driver;
	TestSetup testsetup;
	CommonMethodsObject commonobj;
	 Program1_POM programobj;
	 
	public Program1_StepDefinition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		programobj = testsetup.pageobjectmanager.getProgramMethodsObject();
}
		@Given("User is on dashboard page after Login")
	public void user_is_on_dashboard_page_after_login() {
		commonobj.loginUser();
	}
// Scenario 1
	@When("Admin clicks Program in the navigation bar")
	public void admin_clicks_program_in_the_navigation_bar() {
	programobj.click_program_navigation();
		System.out.println("----Program link clicked-----");
	}
	@Then("Admin  see the Manage Program in the URL")
	public void admin_see_the_manage_program_in_the_url() {
		programobj.get_manageprogram_url();
	}
	@Then("Admin clicks Program from navigation bar")
	public void admin_clicks_program_from_navigation_bar() {
		programobj.click_program_navigation();
		System.out.println("----Program link clicked-----");
	}
	@Then("Admin should see tht heading with text Manage Program on that page")
	public void admin_should_see_tht_heading_with_text_manage_program_on_that_page() {
		programobj.get_heading();
		System.out.println("------the heading with manage program is there------");
	}
// Scenario 2
	@When("Admin clicks Program link on navigation bar")
	public void admin_clicks_program_link_on_navigation_bar() {
	  programobj.click_program_navigation();
	}
	@Then("Admin should see the text as showing x to y of z entries along with pagination icon below the table")
	public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table() {
	programobj.get_pagenumbers();
	}
	@Then("Admin should see the footer as In total there are z programs z- Total number of records")
	public void admin_should_see_the_footer_as_in_total_there_are_z_programs_z_total_number_of_records() {
	   programobj.get_footer();
	}
	@Then("Admin should see the disabled delete button")
	public void admin_should_see_the_disabled_delete_button() {
    programobj.check_buton_delete();
}
//Scenario 3
@When("Admin clicks Program on the navigation bar")
public void admin_clicks_program_on_the_navigation_bar() {
    programobj.click_program_navigation();
}
@Then("Admin should see a A New Program button on the program page")
public void admin_should_see_a_a_new_program_button_on_the_program_page() {
  programobj.click_new_program();
}
//Scenario 4
@Then("Admin see the rows of data in the table displayed on the page are {int}")
public void admin_see_the_rows_of_data_in_the_table_displayed_on_the_page_are(Integer int1) {
    programobj.get_rows_in_table();
}
@When("Admin see data table with column headers \\(Program Name, Program Description, Program Status, Edit,Delete)")
public void admin_see_data_table_with_column_headers_program_name_program_description_program_status_edit_delete() {
   programobj.get_column_values_datatable();
}

//Scenario 5
@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
 programobj.check_sort_icon_on_headers();
}
@Then("Admin should see check box on the left side in all rows of the data table")
public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {
    programobj.check_all_checkboxes_in_all_rows();
}
//Scenario 6
@Then("Admin should see the Edit and Delete buttons on each row of the data table")
public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
    programobj.check_editdelete_in_rows();
}
@When("Admin clicks Program link in the navigation bar")
public void admin_clicks_program_link_in_the_navigation_bar() {
   programobj.click_program_navigation();
}
//Scenario 7
@Then("Admin should see Search bar with text as {string}")
public void admin_should_see_search_bar_with_text_as(String string) {
   programobj.verify_searchBar();
}
//Add New Program
//Scenario 8

@When("Admin clicks A New Program button")
public void admin_clicks_a_new_program_button() {
  programobj.click_new_program();
	}
@Then("Admin should see a popup to for adding a new program with SAVE and CANCEL button and Close Icon")
public void admin_should_see_a_popup_to_for_adding_a_new_program_with_save_and_cancel_button_and_close_icon() {
   programobj.verify_empty_form();
 }
@Then("Admin should see two input fields and their respective text boxes in the program details window")
public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() {
   programobj.verify_two_inputfields();
}
@Then("Admin should see two radio button for Program Status")
public void admin_should_see_two_radio_button_for_program_status() {
    programobj.verify_radio_btn();
}
// Scenario 9
@When("Admin clicks Add A New Program button")
public void admin_clicks_add_a_new_program_button() {
    programobj.click_new_program();
    System.out.println("New program deatil form created");
}
@Then("Admin clicks Save button without any data and Admin gets a Error message alert")
public void admin_clicks_save_button_without_any_data_and_admin_gets_a_error_message_alert() {
   programobj.save_without_anydata();
}
@When("Admin enters only numbers or special char in name and desc column and Admin gets a Error message alert")
public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column_and_admin_gets_a_error_message_alert() {
    programobj.with_splchar_input();
}

//Scenario 10
@When("Admin clicks  A New Program button in manage program page")
public void admin_clicks_a_new_program_button_in_manage_program_page() {
   programobj.click_new_program();
}

@Then("Enter all the required fields with valid values and click Save button and  Successful Program Created alert")
public void enter_all_the_required_fields_with_valid_values_and_click_save_button_and_successful_program_created_alert() {
   programobj.sucess_program_created();
}
// Scenario 11

@When("Admin clicks Edit button on the data table for any row")
public void admin_clicks_edit_button_on_the_data_table_for_any_row() {
   System.out.println("-----edit button-----");
}

@Then("Admin edits the Name  and clicks save button and Admin gets Successful Program Updated alert")
public void admin_edits_the_name_and_clicks_save_button_and_admin_gets_successful_program_updated_alert() {
  programobj.validate_edit_and_programname();
}

// Scenario 12

@When("Admin clicks Edit button on  data table for any row")
public void admin_clicks_edit_button_on_data_table_for_any_row() {
  System.out.println("-----edit button-----");
}
@Then("Admin changes the Status and clicks save button and gets Successful Program Updated alert")
public void admin_changes_the_status_and_clicks_save_button_and_gets_successful_program_updated_alert() {
   programobj.validate_edit_statusbutton();
   }
//@When("Admin enters only numbers or special char in name and desc column andgets error message alert")
//public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column_andgets_error_message_alert() {
//    programobj.validate_edit_invalid_inputs();
//}
//@Then("Admin clicks Save button on edit popup and gets Successful Program Updated alert")
//public void admin_clicks_save_button_on_edit_popup_and_gets_successful_program_updated_alert() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//-------------------------------------------------
// Delete operation
//Scenario 13

@When("Admin clicks Delete button on the data table for any row")
public void admin_clicks_delete_button_on_the_data_table_for_any_row() {
System.out.println("---------delete window-----");
}
@Then("Admin should see a alert open with heading {string} along with YES and NO button for deletion")
public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String string) {
	 programobj.validate_delete();
}
@Then("Admin should see a message {string}")
public void admin_should_see_a_message(String string) {
    programobj.validate_confirmdelete();
}
@When("Admin clicks YES button on the alert")
public void admin_clicks_yes_button_on_the_alert() {
   programobj.validate_yes_in_delete();
}
@Then("Admin gets a message Successful Program Deleted alert")
public void admin_gets_a_message_successful_program_deleted_alert() {
   System.out.println("Successfully delete");
}
}