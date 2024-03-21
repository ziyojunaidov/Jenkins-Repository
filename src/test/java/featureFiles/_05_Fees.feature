Feature: Fees function

  Background:
    Given Navigate to campus website
    And Enter username and password
    And Click on login button
    And Navigate to Fees Page

    @FireTest
  Scenario: Add a fee
    And Click on add button
    And Fill the form out
    |Batch1000|
    |qwerty   |
    |BT100    |
    |1111    |
    When Click on save and exit button
    Then Success message should be displayed

      @FireTest
    Scenario: Delete a fee
      And Search for the fee
        |Batch1000|
        |qwerty   |
        |1111    |
      And Click on delete button
      When Click on delete confirm
      Then Success message should be displayed