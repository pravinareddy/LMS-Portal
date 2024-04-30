Feature: Manage User for validating sorting  functionality

  Background: 
    Given User is on dashboard page after Login and clicks User on the navigation bar
    

	Scenario: Sorting users by ID
	When The admin clicks on "ID" sort icon 
	Then Admin should see User details are sorted by id
	
#	Scenario: Sorting users by Name
#	When The admin clicks on "Name" sort icon 
#	Then Admin should see User details are sorted by Name
#	
#	Scenario: Sorting users by Location
#	When The admin clicks on "Location" sort icon 
#	Then Admin should see User details are sorted by Location
#	
#	Scenario: Sorting users by PhoneNumber
#	When The admin clicks on "phonenumber" sort icon 
#	Then Admin should see User details are sorted by PhoneNumber
	
	    