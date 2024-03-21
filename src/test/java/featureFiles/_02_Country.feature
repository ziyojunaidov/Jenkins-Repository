Feature: Country function
  As a user I want to be able to create, update and delete different
  countries so I can register students from different countries

  Background: Runs before each scenario
    Given Navigate to campus website
    And Enter username and password
    And Click on login button
    And Navigate to countries page

    @SmokeTest
  Scenario: Create a new Country
   # Given Navigate to campus website
   # And Enter username and password
   # And Click on login button
    # And Navigate to countries page
    And Click on add button
    And Enter country name and country code
    When Click on save button
    Then Success message should be displayed

    Scenario: Update a country
     # Given Navigate to campus website
      #And Enter username and password
      #And Click on login button
      #And Navigate to countries page
      And Search for the country
      And Click on edit button
      And Change the country code
      When Click on save button
      Then Success message should be displayed

      @SmokeTest
      Scenario: Delete a country
        #Given Navigate to campus website
        #And Enter username and password
        #And Click on login button
        #And Navigate to countries page
        And Search for the country
        And Click on delete button
        When Click on delete confirm
        Then Success message should be displayed

  @SmokeTest @FireTest
        Scenario: Create a new country with parameters
          And Click on add button
          And Enter "Batch100" as country name and "qwerty" as country code
          When Click on save button
          Then Success message should be displayed
