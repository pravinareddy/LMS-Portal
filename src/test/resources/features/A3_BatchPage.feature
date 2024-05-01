
Feature: Add Batch 
  Background: 
    Given Admin is on dashboard page after Login 
    And Admin clicks "Batch" from navigation bar
    And Admin clicks "+ A New Batch" button and a new pop up with Batch details appears
    

Scenario: Check if the fields exist in pop up

Then The pop up should include the fields Name and Description as text box
And Program Name as drop down
And Status as radio button
And Number of classes as text box

Scenario: Check if description is optional field
When Fill in all the fields except description with valid values for "batch" and click save
Then The newly added batch should be present in the data table in Manage Batch page

Scenario: Check if the batch details are added in data table
When Fill in all the fields with valid values for "batch" and click save
Then The newly added batch should be present in the data table in Manage Batch page


Scenario Outline: Check for error messages for invalid Batch Name field
    When Admin enters invalid Batch Name as "<batchname>"
    Then Error message for Invalid Batch Name should appear

    Examples: 
      |batchname| 
      |1| 
      |a|
      |1a|
      |$1|
   
Scenario: Check for error messages for mandatory fields
When Any of the mandatory fields are "blank" 
Then Error message should appear 
