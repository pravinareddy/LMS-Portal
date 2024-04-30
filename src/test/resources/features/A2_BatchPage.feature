Feature: Batch Page Validation

  Background: 
    Given Admin is on dashboard page after Login
    And Admin clicks "Batch" from navigation bar

  Scenario: Validate pop up for adding batch
    When Admin clicks "+ A New Batch" button
    Then A new pop up with Batch details appears
