package com.lmsapp.lms.stepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.lmsapp.lms.utilities.ExcelReader;
import com.lmsapp.lms.POM.BatchPage;
import com.lmsapp.lms.POM.CommonMethodsObject;
import com.lmsapp.lms.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BatchPageStepDefinition {

	WebDriver driver;
	TestSetup testsetup;
	CommonMethodsObject commonobj;
	BatchPage batchPageobj;
	ArrayList<Boolean> rows = new ArrayList<Boolean>();

	public BatchPageStepDefinition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		batchPageobj = new BatchPage(driver);

	}

	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		commonobj.loginUser();

	}

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String string) {
		batchPageobj.clickBatchMenu();

	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String string) {

		Assert.assertTrue(batchPageobj.checkUrl().contains("Batch"), "Missing Manage Batch in Url!!");
	}

	@Then("Admin should see the {string} in the header")
	public void admin_should_see_the_in_the_header(String headerName) {

		Assert.assertEquals(batchPageobj.verifyHeader(), headerName);

	}

	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {

		Assert.assertTrue(batchPageobj.checkPagination());

	}

	@Then("Admin Should see the data table with {string} Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete")
	public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete(
			String string) throws InterruptedException {

		Assert.assertTrue(batchPageobj.checkBatchTableheaders(string), "Incorrect Header!!");
	}

	@Then("Admin should be able to see the {string} icon button that is disabled")
	public void admin_should_be_able_to_see_the_icon_button_that_is_disabled(String string) {

		Assert.assertFalse(batchPageobj.checkDeleteIcon());
	}

	@Then("Admin should be able to see the {string} button")
	public void admin_should_be_able_to_see_the_button(String string) {

		Assert.assertTrue(batchPageobj.checkNewBatchBtn());
	}

	@Then("Each row in the data table should have a checkbox")
	public void each_row_in_the_data_table_should_have_a_checkbox() {

		ArrayList<Boolean> checkBox = batchPageobj.validateCheckBox();
		for (int i = 0; i < checkBox.size(); i++) {
			System.out.println(checkBox.get(i));
			Assert.assertTrue(checkBox.get(i));
		}
	}

	@Then("Each row in the data table should have a edit icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
		ArrayList<Boolean> editIcon = batchPageobj.validateEditIcon();
		for (int i = 0; i < editIcon.size(); i++) {
			System.out.println(editIcon.get(i));
			Assert.assertTrue(editIcon.get(i));
		}
	}

	@Then("Each row in the data table should have a delete icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
		ArrayList<Boolean> deleteIcon = batchPageobj.validateDeleteIcon();
		for (int i = 0; i < deleteIcon.size(); i++) {
			System.out.println(deleteIcon.get(i));
			Assert.assertTrue(deleteIcon.get(i));
		}
	}

	@When("Admin clicks {string} button")
	public void admin_clicks_button(String string) {
		batchPageobj.clickNewBatchButton();
	}

	@Then("A new pop up with Batch details appears")
	public void a_new_pop_up_with_batch_details_appears() {

		Assert.assertEquals(batchPageobj.checkPopUp(), "Batch Details");
	}

	@Given("Admin clicks {string} button and a new pop up with Batch details appears")
	public void admin_clicks_button_and_a_new_pop_up_with_batch_details_appears(String string)
			throws InterruptedException {

		batchPageobj.clickNewBatchButton();
	}

	@Then("The pop up should include the fields Name and Description as text box")
	public void the_pop_up_should_include_the_fields_name_number_of_classes_and_description_as_text_box() {

		Assert.assertTrue(batchPageobj.checkNameTextbox());

		Assert.assertTrue(batchPageobj.checkDescriptionTextbox());

	}

	@Then("Program Name as drop down")
	public void program_name_as_drop_down() {

		Assert.assertTrue(batchPageobj.checkProgramNameDropdown());
	}

	@Then("Status as radio button")
	public void status_as_radio_button() {

		Assert.assertTrue(batchPageobj.checkStatusRadioBtn());

	}

	@Then("Number of classes as text box")
	public void number_of_classes_as_text_box() {

		Assert.assertTrue(batchPageobj.checkClassesTextbox());
	}

	@When("Fill in all the fields except description with valid values for {string} and click save")
	public void fill_in_all_the_fields_except_description_with_valid_values_for_and_click_save(String batchname)
			throws InterruptedException {

		String newBatch = batchname + generateRandom(999);

		batchPageobj.enterBatchName(newBatch);
		batchPageobj.selectBatchProgramName();
		batchPageobj.selectStatusRadiobtn();
		batchPageobj.enterNoOfClasses(String.valueOf(generateRandom(10)));
		batchPageobj.clickSaveButton();
		
	}

	@Then("The newly added batch should be present in the data table in Manage Batch page")
	public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page() {
		
		try {
			Assert.assertTrue(batchPageobj.checkSuccessMsg());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("Fill in all the fields with valid values for {string} and click save")
	public void fill_in_all_the_fields_with_valid_values_and_click_save(String batch) throws InterruptedException {

		String newBatch = batch + generateRandom(999);
		batchPageobj.enterBatchName(newBatch);

		batchPageobj.enterBatchDesc(newBatch);

		batchPageobj.selectBatchProgramName();
		batchPageobj.selectStatusRadiobtn();
		;
		batchPageobj.enterNoOfClasses(String.valueOf(generateRandom(5)));

		batchPageobj.clickSaveButton();

	}

	

	@When("Admin enters invalid Batch Name as {string}")
	public void admin_enters_invalid_batch_name_as(String string) throws InterruptedException {
		batchPageobj.enterBatchName(string);
	}

	@Then("Error message for Invalid Batch Name should appear")
	public void error_message_for_invalid_batch_name_should_appear() {
		Assert.assertTrue(batchPageobj.checkNameErrorMsg());
	}

	@Then("Error message should appear")
	public void error_message_should_appear() {
		Assert.assertTrue(batchPageobj.checkNameErrorMsg());
		Assert.assertTrue(batchPageobj.checkDescErrorMsg());
		Assert.assertTrue(batchPageobj.checkProgramNameErrorMsg());
		Assert.assertTrue(batchPageobj.checkStatusErrorMsg());
		Assert.assertTrue(batchPageobj.checknoOfClassesErrorMsg());
	}

	@When("Any of the mandatory fields are {string}")
	public void any_of_the_mandatory_fields_are_blank(String string) {
		batchPageobj.clickSaveButton();
	}

	@Given("The delete icon on row level in data table is enabled")
	public void the_delete_icon_on_row_level_in_data_table_is_enabled() {
		// batchPageobj.enableDeleteIcon();

	}

	@Given("Admin clicks the Delete icon")
	public void admin_clicks_delete_icon() throws InterruptedException {

		batchPageobj.clickRowDeleteIcon();
	}

	@When("Admin clicks the enabled delete icon")
	public void admin_clicks_the_enabled_delete_icon() throws InterruptedException {

		batchPageobj.clickRowDeleteIcon();

	}

	@Then("Alert appears with yes and No option")
	public void alert_appears_with_yes_and_no_option() throws InterruptedException {

		batchPageobj.checkAlertMsg();

	}

	@When("You click yes option")
	public void you_click_yes_option() throws InterruptedException {
		batchPageobj.clickYesOption();
	}

	@Then("Batch deleted alert pops and batch is no more available in data table")
	public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_data_table() throws InterruptedException {
		Assert.assertEquals(batchPageobj.getBatchDeletedMsg(), "batch Deleted");
		Assert.assertFalse(batchPageobj.checkdeletedRow());

	}

	@When("you click No option")
	public void you_click_no_option() throws InterruptedException {
		batchPageobj.clickNoOption();
	}

	@Then("Batch is still listed in data table")
	public void batch_is_still_listed_in_data_table() throws InterruptedException {
		// Assert.assertFalse(batchPageobj.getBatchDeletedMsg(),"batch Deleted");
		System.out.println(batchPageobj.checkdeletedRow());
		Assert.assertTrue(batchPageobj.checkdeletedRow());
	}

	@Given("The edit icon on row level in data table is enabled")
	public void the_edit_icon_on_row_level_in_data_table_is_enabled() {

		batchPageobj.checkRowEditIcon();

	}

	@When("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() throws InterruptedException {
		batchPageobj.clickRowEditIcon();
	}

	@Given("None of the checkboxes in data table are selected")
	public void none_of_the_checkboxes_in_data_table_are_selected() {

	}

	@Then("The delete icon under the {string} header should be disabled")
	public void the_delete_icon_under_the_header_should_be_disabled(String string) {
		Assert.assertFalse(batchPageobj.checkDeleteIcon());
	}

	@Given("One of the checkbox in a row is selected")
	public void one_of_the_checkbox_row_is_selected() throws InterruptedException {
		batchPageobj.clickRowCheckBox();

	}

	@When("Click delete icon below {string} header")
	public void click_delete_icon_below_header(String string) throws InterruptedException {
		batchPageobj.clickHeaderDeleteIcon();
		batchPageobj.clickYesOption();
	}

	@Then("The respective row in the data table is deleted")
	public void the_respective_row_in_the_data_table_is_deleted() {
		Assert.assertEquals(batchPageobj.getBatchDeletedMsg(), "Batches Deleted");
	}

	@Given("Two or more checkboxes\\/row is selected")
	public void two_or_more_checkboxes_row_is_selected() throws InterruptedException {
		batchPageobj.clickMultipleRowCheckBox();
		Thread.sleep(5000);
	}

	@When("Update the fields with valid values for the {string} and click save")
	public void update_the_fields_with_valid_values_for_the_and_click_save(String batch) throws InterruptedException {

		String newBatchDesc = batch + generateRandom(999);
		String newClasses = String.valueOf(generateRandom(999));

		batchPageobj.enterBatchDesc(newBatchDesc);
		batchPageobj.selectBatchProgramName();
		batchPageobj.selectStatusRadiobtn();
		batchPageobj.enterNoOfClasses(newClasses);
		batchPageobj.clickSaveButton();

	}

	@Then("The updated batch details should appear on the data table")
	public void the_updated_batch_details_should_appear_on_the_data_table() throws InterruptedException {

		Assert.assertEquals(batchPageobj.getSuccessMessage(), "Successful");
		System.out.println(batchPageobj.checkUpdatedRow());
		Assert.assertTrue(batchPageobj.checkUpdatedRow());

	}

	@When("Update the fields with invalid values for {string} and click save")
	public void update_the_fields_with_invalid_values_and_click_save(String batch) throws InterruptedException {
		String newDesc = generateRandom(999) + batch;

		batchPageobj.enterBatchDesc(newDesc);
		batchPageobj.selectStatusRadiobtn();
		batchPageobj.enterNoOfClasses("");
		batchPageobj.clickSaveButton();
		//Thread.sleep(1000);
	}

	@Then("Error message should appear for invalid fields")
	public void error_message_should_appear_for_invalid_fields() {
		Assert.assertTrue(batchPageobj.checkDescErrorMsg());

		Assert.assertTrue(batchPageobj.checknoOfClassesErrorMsg());
	}

	@When("Erase data from mandatory field")
	public void erase_data_from_mandatory_field() throws InterruptedException {
		batchPageobj.eraseMandatoryField();

		batchPageobj.clickSaveButton();

	}

	@When("Erase data from description field")
	public void erase_data_from_description_field() throws InterruptedException {
		batchPageobj.eraseDescriptionField();
		batchPageobj.clickSaveButton();
		Thread.sleep(5000);
	}

	@Then("Error message should appear for mandatory fields")
	public void error_message_should_appear_for_mandatory_fields() {

		Assert.assertTrue(batchPageobj.checkDescMandatoryErrorMsg());

		Assert.assertTrue(batchPageobj.checknoOfClassesErrorMsg());
	}

	@Then("The updated batch details should not appear on the data table")
	public void the_updated_batch_details_should_not_appear_on_the_data_table() {

		Assert.assertTrue(batchPageobj.checkDescMandatoryErrorMsg());
	}

	@When("select program name from dropdown")
	public void select_program_name_from_dropdown() throws InterruptedException {
		batchPageobj.checkBatchProgramName();
		// batchPageobj.clickSaveButton();
	}

	@Then("The updated program name for the batch should appear on the data table")
	public void the_updated_program_name_for_the_batch_should_appear_on_the_data_table() {
		Assert.assertTrue(batchPageobj.checkUpdatedProgramName());
	}

	public int generateRandom(int bounderyNum) {
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(bounderyNum);
		return generatedNum;
	}

}