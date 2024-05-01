@LMS_2

Feature: LMS Dashboard Verification

  @testcase-1
  Scenario: Verify after login admin lands on manage program as dashboard page
    Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see manage program as header

  @testcase-2
  Scenario: Verify the response time
    Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button
    Then Maximum navigation time in milliseconds, defaults to 30 seconds

  @testcase-3
  Scenario: Verify broken link
    Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button
    Then HTTP response >= 400. Then the link is broken

  @testcase-4
  Scenario: Verify LMS title
    Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see LMS - Learning management system as title

  @testcase-5
  Scenario: Verify LMS title alignment
    Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button
    Then LMS title should be on the top left corner of page

  @testcase-6
  Scenario: Validate navigation bar text
    Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see correct spelling in navigation bar text

  @testcase-7
  Scenario: Validate LMS title has correct spelling and space
    Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see correct spelling and space in LMS title

  @testcase-8
  Scenario: Validate alignment for navigation bar
    Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see the navigation bar text on the top right side

  @testcase-9
  Scenario: Validate navigation bar order 1st Program
    Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see program in the 1st place

  @testcase-10
  Scenario: Validate navigation bar order 2nd Batch
    Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see batch in the 2nd place

  @testcase-11
  Scenario: Validate navigation bar order 3rd User
    Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see user in the 3rd place

  @testcase-12
  Scenario: Validate navigation bar order 4th Logout
    Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see logout in the 4th place

  @testcase-13
  Scenario: Verify Logout button function
    Given Admin is in dashboard page
    When Admin click Logout button on navigation bar
    Then Admin should land on login page
