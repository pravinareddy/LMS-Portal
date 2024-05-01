package com.lmsapp.lms.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.lmsapp.lms.POM.CommonMethodsObject;
import com.lmsapp.lms.POM.DashBoardPageOM;
import com.lmsapp.lms.POM.LoginPageOM;
import com.lmsapp.lms.utilities.ConfigReader;
import com.lmsapp.lms.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashBoardPage_SD {

	WebDriver driver;
	TestSetup testsetup;
	CommonMethodsObject commonobj;
	String url = ConfigReader.getProperty("Url");
	String wrongUrl = ConfigReader.getProperty("wrongUrl");
	LoginPageOM loginPage;
	DashBoardPageOM dashBoardPage;
	String user = ConfigReader.getProperty("username");
	String password = ConfigReader.getProperty("password");

	public DashBoardPage_SD(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		loginPage = testsetup.pageobjectmanager.getLoginPageObject();
		dashBoardPage = testsetup.pageobjectmanager.getDashBoardPageObject();
	}

	@Given("Admin is in Home Page")
	public void admin_is_in_home_page() {
		dashBoardPage.navigateTo(url);
		assert driver.getCurrentUrl().contains("LMS application") : "Not on Home Page";
	}

	@When("Admin enter valid credentials and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
		dashBoardPage.login(user, password);
	}

	@Then("Admin should see manage program as header")
	public void admin_should_see_manage_program_as_header() {
		assert dashBoardPage.isManageProgramVisible() : "Manage program header is not visible";
	}

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) {
		long startTime = System.currentTimeMillis();
		dashBoardPage.navigateToSomePage();
		long endTime = System.currentTimeMillis();
		assert (endTime - startTime) <= int1 * 1000 : "Navigation time exceeded";
	}

	@Then("Admin should see LMS - Learning management system as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
		assert "LMS - Learning Management System".equals(dashBoardPage.getTitle()) : "Title does not match";
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		assert dashBoardPage.isTitlePositionedTopLeft() : "Title is not on the top left corner";
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() {
		assert dashBoardPage.checkTextOnNavigationBar("Expected Text") : "Spelling error in navigation bar text";
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
		assert dashBoardPage.isLMSTitleSpelledCorrectly() : "Spelling or spacing issues in LMS title";
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
		assert dashBoardPage.isNavigationBarOnTopRight() : "Navigation bar text is not on the top right side";
	}

	@Then("Admin should see program in the 1st place")
	public void admin_should_see_program_in_the_1st_place() {
		assert dashBoardPage.isItemAtPosition("Program", 1) : "Program is not in the 1st place";
	}

	@Then("Admin should see batch in the 2nd place")
	public void admin_should_see_batch_in_the_2nd_place() {
		assert dashBoardPage.isItemAtPosition("Batch", 2) : "Batch is not in the 2nd place";
	}

	@Then("Admin should see user in the 3rd place")
	public void admin_should_see_user_in_the_3rd_place() {
		assert dashBoardPage.isItemAtPosition("User", 3) : "User is not in the 3rd place";
	}

	@Then("Admin should see logout in the 4th place")
	public void admin_should_see_logout_in_the_4th_place() {
		assert dashBoardPage.isItemAtPosition("Logout", 4) : "Logout is not in the 4th place";
	}

	@Given("Admin is in dashboard page")
	public void admin_is_in_dashboard_page() {
		dashBoardPage.navigateTo(url);
		dashBoardPage.login(user, password);
		assert driver.getCurrentUrl().contains("api-hackathon") : "Not on Dashboard page";
	}

	@When("Admin click Logout button on navigation bar")
	public void admin_click_logout_button_on_navigation_bar() {
		dashBoardPage.clickLogout();
		assert dashBoardPage.isOnLoginPage() : "Admin did not land on login page after logout";
	}

	@Then("Admin should land on login page")
	public void admin_should_land_on_login_page() {
		assert dashBoardPage.isOnLoginPage() : "Admin did not land on login page";
	}

}
