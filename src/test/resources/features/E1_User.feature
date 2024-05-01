

@tag
Feature: User page validation
  I want to use this template for my feature file


 Background: Logged on the LMS portal as admin
    Given Admin is on dashboard page after Login

  #@tag1
  Scenario: Validate landing in User page
    When Admin clicks "User" from navigation bar
    Then Admin should see the "Manage User" in the URL

  #@tag2
  Scenario: Validate the heading
    When Admin clicks "User" from navigation bar
    Then Admin should see a heading with text "Manage user" on the page

  @tag3
  Scenario: Validate the text and pagination icon below the data table
    When Admin clicks "User" from navigation bar
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table.
    
   @tag4
  Scenario: Validate data table headers in the User Page
    When Admin clicks "User" from navigation bar
    Then Admin Should see the data table with column names Id, Name, location, Phone Number, Edit/Delete
    
    @tag5
  Scenario: Validating the default state of Delete button
    When Admin clicks "User" from navigation bar
    Then Admin should see a Delete button on the top left hand side as Disabled
    
     @tag6
  Scenario: Validate "+ A New user" button in User Page
    When Admin clicks "User" from navigation bar
    Then Admin should be able to see the "+ A New User" button above the data table-NewUser
    
     @tag7
    Scenario: Validate "+ Assign staff"  button in User page
    When Admin clicks "User" from navigation bar
    Then Admin should be able to see the "+ Assign staff" button above the data table-Assign Staff
    
     @tag8
    Scenario: Validate "+ Assign Student"  button in User page
    When Admin clicks "User" from navigation bar
    Then Admin should be able to see the "+ Assign Student" button above the data table-Assign Student
    
     @tag9
    Scenario: Validate search box in User page
    When Admin clicks "User" from navigation bar
    Then Admin should be able to see the search text box above the data table
    
     @tag10
  Scenario: Validate number of data rows in the data 
    When Admin clicks "User" from navigation bar
    Then Admin should see two  records displayed on the data table
