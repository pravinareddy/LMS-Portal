Feature: Manage User for validating sorting  functionality

  Background: 
    Given User is on dashboard page after Login and clicks User on the navigation bar

  Scenario: Deleting single user at a time
    When Admin clicks the delete icon after selecting the users
      | U03 |
      | U19 |
    Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion
    When Admin clicks "Yes" option
    Then Admin gets a message "Successful User Deleted" alert and do not see that user in the data table
