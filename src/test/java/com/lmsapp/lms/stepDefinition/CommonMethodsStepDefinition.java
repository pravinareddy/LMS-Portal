package com.lmsapp.lms.stepDefinition;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lmsapp.lms.POM.CommonMethodsObject;
import com.lmsapp.lms.utilities.TestSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonMethodsStepDefinition {

	WebDriver driver;
	TestSetup testsetup;
	CommonMethodsObject commonobj;

	public CommonMethodsStepDefinition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup=testsetup;
		this.driver=testsetup.drivermanager.getDriverManager();
		commonobj=testsetup.pageobjectmanager.getCommonMethodsObject();

	}

	@Given("User is on dashboard page after Login and clicks User on the navigation bar")
	public void user_is_on_dashboard_page_after_login_and_clicks_user_on_the_navigation_bar() {
		commonobj.loginUser();
	}

	@When("The user select Get Started button in user panel")
	public void the_user_select_get_started_button_in_user_panel() {

	}

	@Then("The user should be redirected to user page")
	public void the_user_should_be_redirected_to_user_page() {

	}
}
