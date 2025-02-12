Feature: Login Features for SauceDemo
  Scenario: Verify that login is successful when valid username and password are used
    Given go to login page
    And type valid username on login page
    And type valid password on login page
    When click login button on login page
    Then Products header should visible on the inventory page
