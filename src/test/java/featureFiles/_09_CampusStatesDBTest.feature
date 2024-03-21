Feature: States function database test
  Check if all states names from UI are in the database

  Scenario: Check if the data is correct
    Given Navigate to campus website
    And Enter username and password
    And Click on login button
    And Navigate to States page
    When Send "Select name from states" as query
    Then Check if the result from UI are in the database