Feature: Edit Batch

  Background: 
    Given Admin is on dashboard page after Login
    And Admin clicks "Batch" from navigation bar
    And The edit icon on row level in data table is enabled
    And Admin clicks the edit icon

  Scenario: Check if the fields are updated
    When Update the fields with valid values for the "batch","no of classes" and click save
    Then The updated batch details should appear on the data table

  Scenario: Check if the update throws error with invalid value
    When Update the fields with invalid values for "description","no of classes" and click save
    Then Error message should appear for description and no of classes

  Scenario: Check if you get error message when mandatory fields are erased
    When Erase data from mandatory field
    Then Error message should appear for mandatory fields

  Scenario: Check if description field is optional in update
    When Erase data from description field
    Then The updated batch details should not appear on the data table
