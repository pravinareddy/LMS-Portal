Feature: Validate Assign Staff Functionality in Manage User Page

  Background: 
    Given User is on dashboard page after Login and clicks User on the navigation bar

  #Scenario: Validate Assign Staff Popup window
    #Given Admin is in manage user page
    #When The admin clicks on Assign Staff button
    #Then Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close  icon on the top right corner of the window

     Scenario: Validate Assign Staff Popup window Form
    Given Admin is in manage user page
     When The admin clicks on Assign Staff button
     Then Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes.
    