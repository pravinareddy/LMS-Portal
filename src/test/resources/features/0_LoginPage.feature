@LMS_1

Feature: Home Page Verification

  @testcase-1
  Scenario: Verify admin is able to land on home page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should land on the home page

  @testcase-2
  Scenario: Verify admin is able to land on home page with invalid URL
    Given Admin launch the browser
    When Admin gives the invalid LMS portal URL
    Then Admin should receive 404 page not found error

  @testcase-3
  Scenario: Verify for broken link
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then HTTP response >= 400. Then the link is broken

  @testcase-4
  Scenario: Verify the text spelling in the page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see correct spellings in all fields

  @testcase-5
  Scenario: Verify the company logo
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see logo on the left side

  @testcase-6
  Scenario: Verify application name
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see LMS - Learning Management System

  @testcase-7
  Scenario: Verify company name
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see company name below the app name

  @testcase-8
  Scenario: Validate sign in content
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see Please login to LMS application

  @testcase-9
  Scenario: Verify text field is present
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see two text fields

  @testcase-10
  Scenario: Verify text on the first text field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see User in the first text field

  @testcase-11
  Scenario: Verify asterisk next to user text
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see * symbol next to user text

  @testcase-12
  Scenario: Verify text on the second text field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see password in the second text field

  @testcase-13
  Scenario: Verify asterisk next to password text
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see * symbol next to password text

  #@testcase-14
  #Scenario: Verify the alignment input field for the login
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL
    #Then Admin should see input field on the centre of the page

  @testcase-15
  Scenario: verify Login is present
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see the login button

  #@testcase-16
  #Scenario: Verify the alignment of the login button
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL
    #Then Admin should see the login button centered on the page
#
  #@testcase-17
  #Scenario: Verify input descriptive test in user field
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL
    #Then Admin should see user in gray color

  #@testcase-18
  #Scenario: Verify input descriptive test in password field
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL
    #Then Admin should see password in gray color

  @testcase-19
  Scenario: Validate login with valid credentials
    Given Admin is on the Home Page
    When Admin enters valid credentials and clicks the login button
    Then Admin should land on the dashboard page

  @testcase-20
  Scenario: Validate login with invalid credentials
    Given Admin is on the Home Page
    When Admin enters invalid credentials and clicks the login button
    Then an error message should appear saying Please check username/password

  @testcase-21
  Scenario: Validate login credentials with null username
    Given Admin is on the Home Page
    When Admin enters only the password and clicks the login button
    Then an error message should appear saying Please check username/password

  @testcase-22
  Scenario: Validate login credentials with null password
    Given Admin is on the Home Page
    When Admin enters only the username and clicks the login button
    Then an error message should appear saying Please check username/password

  @testcase-23
  Scenario: Verify login button action through keyboard
    Given Admin is on the Home Page
    When Admin enters valid credentials and presses the enter key
    Then Admin should land on the dashboard page

  @testcase-24
  Scenario: Verify login button action through mouse
    Given Admin is on the Home Page
    When Admin enters valid credentials and clicks the login button with the mouse
    Then Admin should land on the dashboard page
