Feature: Authentication
  Provide authentication support for the frontend

  Scenario: Sign in as a staff member
    Given I navigate to "/signin"
    And I have the credentials
    | username | password |
    | Mike     | 12345    |
    When I enter the credentials and press sign in
    Then I am signed in as a "staff"

  Scenario: Sign in as a customer
    Given I navigate to "/signin"
    And I have the credentials
    | username | password      |
    | Janet    | jeremybearimy |
    When I enter the credentials and press sign in
    Then I am signed in as a "cust"

  Scenario: Attempt a sign in with invalid credentials
    Given I navigate to "/signin"
    And I have the credentials
    | username | password |
    | Mike     | wrong    |
    | wrong    | wrong    |
    When I enter the credentials and press sign in
    Then An error appears showing "Invalid username/password"
