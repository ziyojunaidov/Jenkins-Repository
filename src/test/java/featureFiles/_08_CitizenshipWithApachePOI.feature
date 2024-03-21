Feature: Citizenship with ApachePOI

  Background:
    Given Navigate to campus website
    And Enter username and password
    And Click on login button
    And Navigate to Citizenship page

    Scenario: Create citizenship by getting data from Excel file
      Then Create a citizenship by using Apache POI

