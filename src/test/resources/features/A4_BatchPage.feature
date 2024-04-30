Feature: Delete Batch

  #Scenario: Validate row level delete icon
    #Given Admin is on dashboard page after Login
    #And Admin clicks "Batch" from navigation bar
    #When Admin clicks the enabled delete icon
    #Then Alert appears with yes and No option

  Scenario: Validate accept alert
    Given Admin is on dashboard page after Login
    And Admin clicks "Batch" from navigation bar
    And Admin clicks the Delete icon
    When You click yes option
    Then Batch deleted alert pops and batch is no more available in data table

  #Scenario: Validate reject alert
    #Given Admin is on dashboard page after Login
    #And Admin clicks "Batch" from navigation bar
    #And Admin clicks the Delete icon
    #When you click No option
    #Then Batch is still listed in data table
