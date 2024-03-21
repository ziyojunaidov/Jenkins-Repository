Feature: Citizenship Function
  # Scenario outline runs the same scenario with different data set multiple times

  Background:
    Given Navigate to campus website
    And Enter username and password
    And Click on login button
    And Navigate to Citizenship page


  Scenario Outline: Create a citizenship
    And Click on add button
    And Enter "<CitizenshipName>" and "<CitizenshipShortName>"
    When Click on save button
    Then Success message should be displayed

    Examples: Data for creating citizenship
    |CitizenshipName|CitizenshipShortName|
    |Batch100       |qwerty          |
    |Batch200       |qwerty1         |
    |Batch300       |qwerty2         |
    |Batch400       |qwerty3         |

   # Create delete citizenship scenario with scenario outline and delete the citizenships you have created

  Scenario Outline: Delete citizenships
    And Search for the "<CitizenshipName>"
    And Click on delete button
    When Click on delete confirm
    Then Success message should be displayed

    Examples: Data for deleting citizenships
    |CitizenshipName|
    |Batch100       |
    |Batch200       |
    |Batch300       |
    |Batch400       |


