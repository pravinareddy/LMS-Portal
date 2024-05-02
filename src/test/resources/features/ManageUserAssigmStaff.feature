Feature: Validate Assign Staff Functionality in Manage User Page

  Background: 
    Given User is on dashboard page after Login and clicks User on the navigation bar

  #Scenario: Validate Assign Staff Popup window
    #Given Admin is in manage user page
    #When The admin clicks on Assign Staff button
    #Then Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close  icon on the top right corner of the window

     #Scenario: Validate Assign Staff Popup window Form
    #Given Admin is in manage user page
     #When The admin clicks on Assign Staff button
     #Then Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes.
    
       #Scenario: Validate Assign Staff  Popup window Form for Radio buttons
     #Given Admin is in manage user page
     #When The admin clicks on Assign Staff button
     #Then Admin should see two radio button for Status
     
       #Scenario: Empty Form Submission
    #Given Admin is in manage user page
    #And  The admin clicks on Assign Staff button
    #When Admin clicks "Save" button with entering any data
    #Then Admin gets a Error message alert for assign staff
    
    
    #Scenario: Form Submission without Email ID
    #Given Admin is in Assign Staff details pop up page
    #When Admin clicks "Save" button without giving Email ID
    #Then Admin gets a Error message alert as Email ID  is required
 
    Scenario Outline: Form Submission without Program Name
    Given Admin is in Assign Staff details pop up page
    When Admin clicks save button without giving Program Name  for "<student>"
    Then Admin gets a Error message alert as ProgramName is required
     Examples: 
      | student | 
      |saranya@gmail.com| 
      
    #Scenario Outline: Form Submission for without selecting batch
    #Given Admin is in Assign Staff details pop up page
    #When Admin clicks save button without giving BatchName  for "<student>"
    #Then Admin gets a Error message alert as BatchName is required
     #Examples: 
      #| student | 
      #|saranya@gmail.com| 
      
      #
    #Scenario Outline: Form Submission for without selecting Status
    #Given Admin is in Assign Staff details pop up page
    #When Admin clicks Save button without giving Status for "<student>"
    #Then Admin gets a Error message alert as Status is required
     #Examples: 
      #| student | 
      #|saranya@gmail.com|
      
      
      
    #Scenario Outline: Form Submission by closing wihtout saving the Form
    #Given Admin is in Assign Staff details pop up page
    #When Admin clicks Close(X) Icon on Assign staff form for "<student>"
    #Then Assign Student popup window should be closed without saving
     #Examples: 
      #| student | 
      #|saranya@gmail.com| 
      
      
    #Scenario Outline: Form Submission by cancelling wihtout saving the Form
    #Given Admin is in Assign Staff details pop up page
    #When Admin clicks Cancel Icon on Assign Student form for "<student>"
    #Then Assign Student popup window should be closed without saving
     #Examples: 
      #| student | 
      #|saranya@gmail.com| 
      
     
     
     
     
     
     
     