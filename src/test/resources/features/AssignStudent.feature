Feature: Validate Assign Student Functionality in Manage User Page

  Background: 
    Given User is on dashboard page after Login and clicks User on the navigation bar

  Scenario: Validate Assign Student Popup window
   Given Admin is in manage user page
    When The admin clicks on "Assign Student" button
  Then Admin should see a pop up open for assign student details with empty form along with Save and Cancel button and close  icon on the top right corner of the window
 
  Scenario: Validate Assign Student Popup window Form
    Given Admin is in manage user page
     When The admin clicks on "Assign Student" button
     Then Admin should see User Role as R03,and other fields Student Email id,Program Name,Batch Name and Status with respective input boxes.

   Scenario: Validate Assign Student Popup window Form for Radio buttons
     Given Admin is in manage user page
     When The admin clicks on "Assign Student" button
     Then Admin should see two radio button for Status

  #Scenario: Empty Form Submission
    #Given Admin is in manage user page
    #And  The admin clicks on "Assign Student" button
    #When Admin clicks "Save" button with entering any data
    #Then Admin gets a Error message alert
    

   
       #Scenario Outline: Form Submission without Program Name
    #Given Given Admin is in Assign Student details pop up page
    #When Admin clicks "Save" button without giving Program Name  for "<student>"
    #Then Admin gets a Error message alert as ProgramName is required
     #Examples: 
      #| student | 
      #|java12@gmail.com| 
    
   

     #Scenario Outline: Form Submission for without selecting batch
    #Given Given Admin is in Assign Student details pop up page
    #When Admin clicks "Save" button without giving BatchName  for "<student>"
    #Then Admin gets a Error message alert as BatchName is required
     #Examples: 
      #| student | 
      #|java12@gmail.com| 
    
    #Scenario Outline: Form Submission for without selecting Status
    #Given Admin is in manage user page
    #And  The admin clicks on "Assign Student" button
    #When Admin clicks "Save" button without giving status for "<student>"
    #Then Admin gets a Error message alert as Status is required
     #Examples: 
      #| student | 
      #|java12@gmail.com|
      
      
     #Scenario Outline: Form Submission by closing wihtout saving the Form
    #Given Given Admin is in Assign Student details pop up page
    #When Admin clicks Close(X) Icon on Assign Student form for "<student>"
    #Then Assign Student popup window should be closed without saving
     #Examples: 
      #| student | 
      #|java12@gmail.com| 
      
      
        #Scenario Outline: Form Submission by cancelling wihtout saving the Form
    #Given Given Admin is in Assign Student details pop up page
    #When Admin clicks Cancel Icon on Assign Student form for "<student>"
    #Then Assign Student popup window should be closed without saving
     #Examples: 
      #| student | 
      #|java12@gmail.com| 
    #
    
    
    
    
    
    
