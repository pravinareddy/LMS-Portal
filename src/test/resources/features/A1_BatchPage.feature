@tag
Feature: Batch Page Validation

  Background: 
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar

  Scenario: Validate landing in Batch page
    Then Admin should see the "Manage Batch" in the URL

  Scenario: Validate header in the Batch Page
    Then Admin should see the "Manage Batch" in the header

  Scenario: Validate pagination in the Batch Page
    Then Admin should see the pagination controls under the data table

  Scenario Outline: Validate data table headers in the Batch Page
    Then Admin Should see the data table with "<headers>" Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete
Examples:
|headers|
|Batch Name|
|Batch Description|
|Batch Status|
|No Of Classes|
|Program Name|
|Edit / Delete|

  Scenario: Validate Delete button in Batch Page
    Then Admin should be able to see the "Delete" icon button that is disabled

  Scenario: Validate "+ A New batch" in Batch Page
    Then Admin should be able to see the "+ A New batch" button

  Scenario: Validate data rows
    Then Each row in the data table should have a checkbox
    And Each row in the data table should have a edit icon that is enabled
    And Each row in the data table should have a delete icon that is enabled
