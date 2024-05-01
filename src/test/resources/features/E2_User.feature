
@tag
Feature: User page validation
  I want to use this template for my feature file
  
 Background: Logged on the LMS portal as admin
 Given Admin is on dashboard page after Login-User2
 
  @tag1
  Scenario: Verify Check box on the data table
    When Admin clicks "User" from navigation bar-User2
    Then Each row in the data table should have a checkbox


  @tag2
  Scenario: Verify edit icon on the data table

    When Admin clicks "User" from navigation bar-User2
    Then Each row in the data table should have a edit icon that is enabled

    @tag3
    Scenario: Verify  delete icon on the data table
    
    When Admin clicks "User" from navigation bar-User2
    Then Each row in the data table should have a delete icon that is enabled
    
    