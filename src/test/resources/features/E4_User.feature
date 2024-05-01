@tag
Feature: Add new user
  I want to use this template for my feature file


Background: Admin is on the Manage User Page after clicking on User on the navigation bar
    Given Admin is on  User details pop up-User4


    @tag1
    Scenario: Check if user is created when only mandatory fields are entered with valid data
    When Admin enters mandatory fields in the form and clicks on submit button.
    Then Admin gets message User added Successfully.


    @tag2
    Scenario: Check if user is created when only optional fields are entered with valid data
    When Admin skips to add value in mandatory field
    Then Admin should see error message below the test field and the field will be highlighed in red color
    
    @tag3 
    Scenario: check if user is created when invalid data is entered in all of the fields
    When Admin enters invalid data in all of the  fields in the form and clicks on submit button
    Then Admin gets error message and user is not created 
    
    @tag4 
    Scenario: Empty form submission
    When Admin clicks on submit button without entering data 
    Then user won't be created and Admin gets error message
    
    @tag5
    Scenario: Validate Cancel/Close(X) icon on User Details form
    When Admin clicks Cancel or Close Icon on User Details form
    Then User Details popup window should be closed without saving
    
    
    @tag6
    Scenario:Validate Cancel button on User Details form
    When Admin clicks Cancel button 
    Then Admin can see the User details popup disappears without adding any user
    
     @tag7
    Scenario: Check if the user details are added in data table
    When Fill in all the fields with valid values and click submit
    Then The newly added user should be present in the data table in Manage User page