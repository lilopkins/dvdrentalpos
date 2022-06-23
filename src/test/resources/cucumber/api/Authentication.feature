Feature: Authentication
  As an API user, I need to be able to obtain an authentication token and validate it's currency.

  Scenario: Obtain a new token
    Given the JSON body: "{\"username\":\"Customer\", \"password\":\"12345\"}"
    When the endpoint "/api/v1/auth/signin" is accessed with a "POST" request
    Then the response has status 200

  Scenario: Validate a current token
    Given I have a valid API token
    When the endpoint "/api/v1/auth/status" is accessed with a "GET" request
    Then the response matches "\"AUTHENTICATED\""

  Scenario: Validate a current token
    Given I have an expired API token
    When the endpoint "/api/v1/auth/status" is accessed with a "GET" request
    Then the response matches "\"EXPIRED_TOKEN\""

  Scenario: Attempt to use an invalid token
    Given I have an invalid API token
    When the endpoint "/api/v1/auth/status" is accessed with a "GET" request
    Then the response matches "\"INVALID_TOKEN\""

  Scenario: Make a request without a token
    When the endpoint "/api/v1/auth/status" is accessed with a "GET" request
    Then the response matches "\"NO_TOKEN\""
