Feature: API Model
  As an API user I need to be able to use an API model.

  Scenario: Get a list of all resources.
    Given The webserver is started
    When I send the request
    Then The request returns status code 200

  Scenario: Get an individual resource.

  Scenario Outline: Create a new resource.
    Given the JSON for a new resource: "<json>"
    And I have a valid API token
    When the endpoint "<endpoint>" is accessed with a "PUT" request
    Then a paged list of resources is returned

    Examples:
    | endpoint | json |
    | /api/v1/actors | {"firstName": "Johnny", "lastName": "Depp"} |
    | /api/v1/films  | {"title": "Bohemian Rhapsody", "description": "The story of the legendary British rock band Queen and lead singer Freddie Mercury, leading up to their famous performance at Live Aid (1985).", "language": 1, "rentalDuration": 3, "rentalRate": 3.99, "length": 134, "replacementCost": 1.22, "rating": "PG-13"} |


  Scenario: Update a resource.

  Scenario: Delete a resource.
