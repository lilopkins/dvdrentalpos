Feature: Get actor list
  As a user I need to be able to get a JSON list of actors from the database.

  Scenario: Get a JSON list of actors.
    Given The webserver is started
    When I send the request
    Then The request returns status code 200
