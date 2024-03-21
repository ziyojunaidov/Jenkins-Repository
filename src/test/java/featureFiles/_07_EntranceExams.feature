Feature: Entrance Exams

  Scenario Outline: Create an entrance exam
    Given Navigate to campus website
    And Enter username and password
    And Click on login button
    And Navigate to Entrance Exams page
    And Click on add button
    And Fill the create exam form
    |<Exam Name>|
    And Add a description
    |<Description>|
    And Add a note
    |<Note>|
    When Click on save button
    Then Success message should be displayed

    Examples:
    |Exam Name      |Description         |Note               |
    |Batch100 Exam1|Batch100 is the best|We are coming strong|
    |Batch200 Exam2|Batch200 is the best|We are good         |
    |Batch300 Exam3|Batch300 is the best|We are number one   |