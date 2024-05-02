Feature: Delete multiple batches

  Scenario: Validate the delete icon below the header
    Given Admin is on dashboard page after Login
    And Admin clicks "Batch" from navigation bar
    And None of the checkboxes in data table are selected
    Then The delete icon under the "Manage Batch" header should be disabled

  Scenario: Check for single row delete
    Given Admin is on dashboard page after Login
    And Admin clicks "Batch" from navigation bar
    And One of the checkbox in a row is selected
    When Click delete icon below "Manage Batch" header
    Then The respective row in the data table is deleted
    
    Scenario: Check for multi row delete
     Given Admin is on dashboard page after Login
    And Admin clicks "Batch" from navigation bar
    And Two or more checkboxes/row is selected
    When Click delete icon below "Manage Batch" header
    Then The respective row in the data table is deleted
    
    
