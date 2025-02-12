Feature: Login tests
  Background: Webdriver initialization
    Given initialize webdriver

    @test5
  Scenario: Verify that login is successful when valid username and valid password are used
    Given go to login page
    And type valid username on login page
    And type valid password on login page
    When click login button on login page
    Then Products header should visible on the inventory page



   @test6
  Scenario: Verify that login is unsuccessful when invalid username and valid password are used
    Given go to login page
    And type invalid username on login page
    And type valid password on login page
    When click login button on login page
    Then error message is displayed on the login page