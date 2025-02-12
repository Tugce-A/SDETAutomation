Feature: Login tests
   @test1 @p1
  Scenario: Verify that login is successful when valid username and valid password are used
    Given go to login page
    And type valid username on login page
    And type valid password on login page
    When click login button on login page
    Then Products header should visible on the inventory page

  @test2 @p2
  Scenario: Verify that login is unsuccessful when invalid username and valid password are used
    Given go to login page
    And type invalid username on login page
    And type valid password on login page
    When click login button on login page
    Then error message is displayed on the login page

    @test3 @p3
    Scenario Outline: Verify that login with different type of credentials
      Given go to login page
      And user types username as "<username>"
      And user types password as "<password>"
      When click login button on login page
      Examples:
        |username       |password         |
        |standard_user  |secret_sauce     |
        |InvalidUser    |secret_sauce     |
        |standard_user  |secret_sauce     |
        |standard_user  |InvalidPassword   |

  @test4 @p4 @p5
  Scenario: Verify that login is unsuccessful when invalid username and invalid password are used
    Given go to login page
    And type "InvalidUsername" username on login page
    And type "InvalidPassword" password on login page
    When click login button on login page
    Then error message is displayed on the login page