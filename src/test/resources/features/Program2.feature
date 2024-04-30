Feature: Manage user for validating sorting, deleting, navigating and 

Background:
Given User is on dashboard page after login

#Navigation Validation
#Scenario: Validate batch,user and logout link Manage Program Page 
#When Admin clicks on Batch link on Manage Program page
#Then  Admin is re-directed to Batch page
#When Admin clicks on User link on Manage Program page
#Then Admin is re-directed to User page
#When Admin clicks on Logout link on Manage Program page
#Then Admin is re-directed to Login page


#sorting 
Scenario: Sorting Program by Program Name 
When The admin clicks on "programname" sort icon 
Then Admin should see Program details are sorted by  Program Name 

#Scenario: Sorting  Program by  Program Description 
#When The admin clicks on "programdescription" sort icon 
#Then Admin should see Program details are sorted by Program Description
#
#Scenario: Sorting  Program by  Program Status
#When The admin clicks on "programstatus" sort icon 
#Then Admin should see  Program details are sorted by Program Status


#Pagination
#Scenario: Verify next page link 
#When Admin clicks Next page link on the program table 
#Then Admin should see the Pagination has Next active link
#


#Multiple delete
#Multiple program delete
# 3
#Scenario: Validate Common Delete button enabled after clicking on any checkbox
#When Validate Common Delete button enabled after clicking on any checkbox
#Then Admin should see common delete option enabled under header Manage Program
#
#Scenario: Validate multiple program deletion by selecting multiple check boxes
#When Admin clicks YES button on the popup to delete the selected programs 
#Then Admin should land on Manage Program page and can see the selected programs are deleted from the data table
#When Admin clicks NO button on the popup 
#Then Admin should land on Manage Program page and can see the selected programs are not deleted from the data table
 