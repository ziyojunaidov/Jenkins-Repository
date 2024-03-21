Feature: Data Table Example

  Scenario: Data table with 1 column
    Given Go to the website
    And Fill the form with valid information
    |John|
    |Snow|
    |6521 Winter Ave.|
    |New York City   |
    |New York        |
    |14652           |
    |johnsnow@gmail.com|
    |123456789         |
    |Male              |
    Then Save the form

    Scenario: Data table with 2 columns
      Given Go to the website
      And Enter valid data
      |Name|John|
      |LastName|Snow|
      |Address |6521 Winter Ave.|
      |City    |New York City   |
      |State   |New York        |
      |Zipcode |14652           |
      |Email   |johnsnow@gmail.com|
      |Phone   |123456789         |
      |Gender  |Male              |
      Then Save the form