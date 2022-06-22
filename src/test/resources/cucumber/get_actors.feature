Feature: Actors
  As an API user I need to be able to get an actor from the database.

  Scenario: Get a JSON list of actors.
    Given The webserver is started
    When I send the request
    Then The request returns status code 200
