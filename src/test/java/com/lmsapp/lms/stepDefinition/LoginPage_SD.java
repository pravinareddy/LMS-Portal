package com.lmsapp.lms.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.lmsapp.lms.POM.CommonMethodsObject;
import com.lmsapp.lms.POM.LoginPageOM;
import com.lmsapp.lms.POM.DashBoardPageOM;
import com.lmsapp.lms.utilities.ConfigReader;
import com.lmsapp.lms.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage_SD {

	WebDriver driver;
	TestSetup testsetup;
	CommonMethodsObject commonobj;
	String url = ConfigReader.getProperty("Url");
	String wrongUrl = ConfigReader.getProperty("wrongUrl");
	LoginPageOM loginPage;
	DashBoardPageOM  dashBoardPageOM; 
	String user = ConfigReader.getProperty("username");
	String password = ConfigReader.getProperty("password");

	public LoginPage_SD(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		loginPage = testsetup.pageobjectmanager.getLoginPageObject();
		dashBoardPageOM = testsetup.pageobjectmanager.getDashBoardPageObject();

	}

	// 1st Test Case

	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
		driver.get(url);
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		loginPage.navigateToURL(url);
	}

	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() {
		assert loginPage.isHomePageVisible();
	}

	// 2nd Test Case
	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
		loginPage.navigateToURL(wrongUrl);
	}

	@Then("Admin should receive 404 page not found error")
	public void admin_should_receive_404_page_not_found_error() {
		assert loginPage.is404ErrorVisible();
	}

	// 3rd Test Case
	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) {
		// Needs to be implemented
	}

	// 4th Test Case
	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
		assert loginPage.getSignInContentText().equals("Please login to LMS application");
	}

	// 5th Test Case
	@Then("Admin should see logo on the left side")
	public void admin_should_see_logo_on_the_left_side() {
		//assert loginPage.isLogoOnLeftSide();
		assert loginPage.isCompanyLogoVisible(); 
	}

	// 6th Test Case
	@Then("Admin should see LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() {
		assert loginPage.isCompanyLogoVisible(); 
	}

	// 7th Test Case
	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {
		assert loginPage.getCompanyName().equals("Please login to LMS application"); 
	}

		
	// 8th Test Case
	@Then("Admin should see Please login to LMS application")
	public void admin_should_see_the_text_please_login_to_lms_application() {
		assert loginPage.getSignInContentText().equals("Please login to LMS application");
	}

	// 9th Test Case
	@Then("Admin should see two text fields")
	public void admin_should_see_two_text_fields() {
		assert loginPage.isUserInputFieldPresent() && loginPage.isPasswordInputFieldPresent();
	}

	// 10th Test Case
	@Then("Admin should see User in the first text field")
	public void admin_should_see_in_the_first_text_field() {
		assert loginPage.getFirstTextFieldValue().equals("User");
	}

	// 11th Test Case
	@Then("Admin should see * symbol next to user text")
	public void admin_should_see_symbol_next_to_user_text() {
		assert loginPage.isUserSymbolVisible();
	}

	// 12th Test Case
	@Then("Admin should see password in the second text field")
	public void admin_should_see_in_the_second_text_field() {
		assert loginPage.getSecondTextFieldValue().equalsIgnoreCase("Password");
	}

	// 13th Test Case
	@Then("Admin should see * symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text() {
		assert loginPage.isPasswordSymbolVisible();
	}

	/*
	 * // 14th Test Case
	 * 
	 * @Then("Admin should see input field on the centre of the page") public void
	 * admin_should_see_input_field_on_the_centre_of_the_page() { assert
	 * loginPage.isInputFieldCentered(); }
	 */

	// 15th Test Case
	@Then("Admin should see the login button")
	public void admin_should_see_the_login_button() {
		assert loginPage.isLoginButtonVisible();
	}

	/*
	 * // 16th Test Case
	 * 
	 * @Then("Admin should see the login button centered on the page") public void
	 * admin_should_see_the_login_button_centered_on_the_page() { // Assuming you
	 * have a method to verify the button position // assert
	 * loginPage.isLoginButtonCentered(); }
	 */

	/*
	 * // 17th Test Case
	 * 
	 * @Then("Admin should see user in gray color") public void
	 * admin_should_see_user_in_gray_color() { assert
	 * loginPage.isUserTextColorGray(); }
	 */
	// 18th Test Case
	/*
	 * @Then("Admin should see password in gray color") public void
	 * admin_should_see_password_in_gray_color() { assert
	 * loginPage.isPasswordTextColorGray(); }
	 */

	// 19th Test Case

	@Given("Admin is on the Home Page")
	public void admin_is_on_the_home_page() {
		loginPage.navigateToURL("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/login");
		assert loginPage.isHomePageVisible();
	}

	@When("Admin enters valid credentials and clicks the login button")
	public void admin_enters_valid_credentials_and_clicks_the_login_button() {
		loginPage.enterUsername(user);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
	}

	@Then("Admin should land on the dashboard page")
	public void admin_should_land_on_the_dashboard_page() {
		assert dashBoardPageOM.isDashboardVisible();
	}

	// 20th Test Case
	@When("Admin enters invalid credentials and clicks the login button")
	public void admin_enters_invalid_credentials_and_clicks_the_login_button() {
		loginPage.enterUsername("wronguser");
		loginPage.enterPassword("wrongpassword");
		loginPage.clickLoginButton();
	}

	@Then("an error message should appear saying Please check username\\/password")
	public void an_error_message_should_appear() {
		assert loginPage.getErrorMessage().equals("Invalid username and password Please try again");
	}

	// 21st Test Case
	@When("Admin enters only the password and clicks the login button")
	public void admin_enters_only_the_password_and_clicks_the_login_button() {
		loginPage.enterUsername(" ");
		loginPage.enterPassword("password");
		loginPage.clickLoginButton();
	}
	

	@Then("an error message should appear1 saying Please check username\\/password")
	public void an_error_message_should_appear1() {
		System.out.println("loginPage.getErrorMessage() ::::::::::"+loginPage.getErrorMessage());
		assert loginPage.getErrorMessage().contains("Please");
	}
	
	
	// 22nd Test Case
	@When("Admin enters only the username and clicks the login button")
	public void admin_enters_only_the_username_and_clicks_the_login_button() {
		loginPage.enterUsername("user");
		loginPage.enterPassword("  ");
		loginPage.clickLoginButton();
	}

	@Then("an error message should appear2 saying Please check username\\/password")
	public void an_error_message_should_appear2() {
		System.out.println("loginPage.getErrorMessage() ::::::::::"+loginPage.getErrorMessage());
		assert loginPage.getErrorMessage().contains("Please check username/password");
	}
	
	// 23rd Test Case
	@When("Admin enters valid credentials and presses the enter key")
	public void admin_enters_valid_credentials_and_presses_the_enter_key() {
		loginPage.enterUsername(user);
		loginPage.enterPassword(password);
		loginPage.pressEnterInLoginButton();
	}
	
	@Then("Admin should land on the dashboard page1")
	public void admin_should_land_on_the_dashboard_page1() {
		assert dashBoardPageOM.isDashboardVisible();
	}
	
	
	
	//24th Test Case 
	@When("Admin enters valid credentials and clicks the login button with the mouse")
	public void admin_enters_valid_credentials_and_clicks_the_login_button_with_the_mouse() {
		loginPage.enterUsername(user);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
	}
	
	@Then("Admin should land on the dashboard page2")
	public void admin_should_land_on_the_dashboard_page2() {
		assert dashBoardPageOM.isDashboardVisible();
	}
	
	
	@Then("close the browser")
	public void close_the_browser() {
		driver.quit();
	}

}
