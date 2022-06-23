Feature: Authentication through UI
  Provide authentication support for the frontend

  @Selenium
  Scenario: Sign in as a staff member
    Given I navigate to "/signin"
    When I enter the credentials "Mike" "12345" and press sign in
    Then I am signed in as a "staff"
    And the robot quits

  @Selenium
  Scenario: Sign in as a customer
    Given I navigate to "/signin"
    When I enter the credentials "Mary" "12345" and press sign in
    Then I am signed in as a "cust"
    And the robot quits

  @Selenium
  Scenario: Attempt a sign in with invalid credentials
    Given I navigate to "/signin"
    When I enter the credentials "Janet" "jeremybearimy" and press sign in
    Then An error appears showing "Invalid username/password"
    And the robot quits
