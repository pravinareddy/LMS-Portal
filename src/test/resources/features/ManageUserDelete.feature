Feature: Manage User for validating sorting  functionality

  Background:
  Given User is on dashboard page after Login and clicks User on the navigation bar
  
  #Scenario: Deleting single user at a time
    #When Admin clicks the delete icon after selecting the users
      #| U57 |
      #| U58 |
    #Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion
    #When Admin clicks "Yes" option
    #Then Admin gets a message "Successful User Deleted" alert and do not see that user in the data table

  Scenario: Validate Row level delete icon on  Manage User Page
    When Admin clicks the delete icon on row level in Manage User Page
    Then Admin should see a alert open with heading Confirm along with  <YES> and <NO> button for deletion

  Scenario: Validate No on Confirm Deletion Window
    When Admin clicks the row level delete icon after selecting the user and clicks "no" option
      | U100 |
    Then Admin can see the deletion alert disappears without deleting

  Scenario: Validate Close icon on Confirm Deletion Window
    When Admin clicks the row level delete icon after selecting the user and clicks "close" option
      | U100 |
    Then Admin can see the deletion alert disappears without any changes

  Scenario: Validate Yes on Confirm Deletion Window
    When Admin clicks the row level delete icon after selecting the user and clicks "yes" option
      | U100 |
    Then Admin gets a message <Successful User Deleted> alert and do not see that user in the data table

  Scenario: Validate Delete button on header enabled
    When Admin clicks any checkbox in the data table
    Then Admin should see common delete option enabled under header Manage Program

  Scenario: Validate No on Confirm Deletion Window for muliple user deletion
    When Admin clicks the delete icon under header after selecting the multiple user and clicks "no" option
      | U100 |
      | U106 |
    Then Admin can see the deletion alert disappears without deleting

  Scenario: Validate Yes on Confirm Deletion Window for muliple user deletion
    When Admin clicks the delete icon under header after selecting the multiple user and clicks "yes" option
      | U100 |
      | U106 |
    Then Admin gets a message <Successful User Deleted> alert and do not see that user in the data table

  Scenario: Validate Close icon on Confirm Deletion Window for muliple user deletion
    When Admin clicks the delete icon under header after selecting the multiple user and clicks "close" option
      | U100 |
      | U106 |
    Then Admin gets a message <Successful User Deleted> alert and do not see that user in the data table
