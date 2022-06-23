Feature: Authentication through UI
  Provide authentication support for the frontend

  @Selenium
  Scenario: Sign in as a staff member
    Given I navigate to "/signin"
    And I have the credentials
    | username | password |
    | Mike     | 12345    |
    When I enter the credentials and press sign in
    Then I am signed in as a "staff"

  @Selenium
  Scenario: Sign in as a customer
    Given I navigate to "/signin"
    And I have the credentials
    | username | password      |
    | Janet    | jeremybearimy |
    When I enter the credentials and press sign in
    Then I am signed in as a "cust"

  @Selenium
  Scenario: Attempt a sign in with invalid credentials
    Given I navigate to "/signin"
    And I have the credentials
    | username | password |
    | Mike     | wrong    |
    | wrong    | wrong    |
    When I enter the credentials and press sign in
    Then An error appears showing "Invalid username/password"
