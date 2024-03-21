Feature: Login Function
  As a user I want to be able to login with my valid username and password

  @SmokeTest @FireTest
  Scenario: Login with valid username and password
    Given Navigate to campus website
    And Enter username and password
    When Click on login button
    Then User should login successfully