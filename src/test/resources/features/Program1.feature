Feature: Manage User for validating sorting ,deleting and assigning functionality
    Background: 
    Given User is on dashboard page after Login
 
# Manage Program Page Validation
    #1
 Scenario: Validate landing in program page and the heading
When Admin clicks Program in the navigation bar
Then  Admin  see the Manage Program in the URL
And Admin clicks Program from navigation bar
Then Admin should see tht heading with text Manage Program on that page
#2
Scenario: Validate text and pagination below the table and the footer
When Admin clicks Program link on navigation bar
Then Admin should see the text as showing x to y of z entries along with pagination icon below the table
And Admin should see the footer as In total there are z programs z- Total number of records 
And Admin should see the disabled delete button 
#3
Scenario: Validate Add New Program 
When Admin clicks Program on the navigation bar
Then Admin should see a A New Program button on the program page 
#4
Scenario: Validate the rows of data table  and columns data table
When Admin clicks Program on the navigation bar
Then Admin see the rows of data in the table displayed on the page are 5
When Admin see data table with column headers (Program Name, Program Description, Program Status, Edit,Delete)
#5
Scenario: Verify Sort arrow icon on the data table
When Admin clicks Program on the navigation bar
Then Admin should see the sort arrow icon beside to each column header except Edit and Delete 
Then Admin should see check box on the left side in all rows of the data table 
#6
Scenario: Verify Edit and Delete buttons
When Admin clicks Program on the navigation bar
Then Admin should see the Edit and Delete buttons on each row of the data table
#7
Scenario: Verify Search bar on the Program page
When Admin clicks Program link in the navigation bar
Then Admin should see Search bar with text as "Search..." 

# Add a New Program 
#8
Scenario: Validate Program Details Popup window
When Admin clicks A New Program button
Then Admin should see a popup to for adding a new program with SAVE and CANCEL button and Close Icon 
And Admin should see two input fields and their respective text boxes in the program details window
And Admin should see two radio button for Program Status
#9
Scenario: Validate  Empty form submission and invalid program name 
When Admin clicks Add A New Program button 
Then Admin clicks Save button without any data and Admin gets a Error message alert 
When Admin enters only numbers or special char in name and desc column and Admin gets a Error message alert

#10 
Scenario: Validating save button by creating new program with valid values and clicks save button 
When Admin clicks  A New Program button in manage program page 
Then Enter all the required fields with valid values and click Save button and  Successful Program Created alert

 #Edit Program Details 
   #11
Scenario: Validate Edit Feature and Edit Program Name
When  Admin clicks Edit button on the data table for any row
Then Admin edits the Name  and clicks save button and Admin gets Successful Program Updated alert 
 #12
Scenario: Change Program Status and Validate invalid values on the text column and validate save button 
When  Admin clicks Edit button on  data table for any row
Then Admin changes the Status and clicks save button and gets Successful Program Updated alert 
#When Admin enters only numbers or special char in name and desc column andgets error message alert
#Then Admin clicks Save button on edit popup and gets Successful Program Updated alert 

   #Delete program
#13
Scenario: Validate details for deletion form
When Admin clicks Delete button on the data table for any row
Then Admin should see a alert open with heading "Confirm" along with YES and NO button for deletion
When Admin clicks Delete button on the data table for any row
Then Admin should see a message "Are you sure you want to delete Program name?"
When Admin clicks YES button on the alert
Then Admin gets a message Successful Program Deleted alert

 
