Feature: Edit Batch

  Scenario: Validate row level edit icon
    Given Admin is on dashboard page after Login
    And Admin clicks "Batch" from navigation bar
    And The edit icon on row level in data table is enabled
    When Admin clicks the edit icon
    Then A new pop up with Batch details appears

  
