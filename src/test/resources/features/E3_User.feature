@tag
 Feature: User page validation
  I want to use this template for my feature file


 Background: Admin is on dashboard page after Login
 and clicks User on the navigation bar
 Given Admin is on Manage User Page-User3


    @tag1
    Scenario: Search user by name
    When Admin enters user name into search box-User3.
    Then Admin should see user displayed with the entered name-User3


    @tag2
    Scenario: Validating the Search with unrelated keyword 
    When Admin enters the keywords not present in the data table on the Search box-User3
    Then Admin should see zero entries on the data table-User3
    
    @tag3 
    Scenario: Validate User Details Popup window
    When Admin clicks "+ A New User" button
    Then Admin should see pop up open for user details 
    
    @tag4 
    Scenario: Validate input fields and text boxes in user details form
    When Admin clicks "+ A New User" button
    Then Admin should see all text boxes for the fields
    
    @tag5
    Scenario: Validate drop downs in new user form
    When Admin clicks "+ A New User" button
    Then Admin should see drop downs for the fields
    
 