Feature: API Model
  As an API user I need to be able to use an API model.

  Scenario Outline: Get a list of all resources.
    When the endpoint "<endpoint>" is accessed with a "GET" request
    Then the response has status 200
    And a paged list of resources is returned

    Examples:
      | endpoint           |
      | /api/v1/actors     |
      | /api/v1/addresses  |
      | /api/v1/categories |
      | /api/v1/cities     |
      | /api/v1/countries  |
      | /api/v1/films      |
      | /api/v1/languages  |
      | /api/v1/staff      |

  Scenario Outline: Get an individual resource.
    When the endpoint "<endpoint>" is accessed with a "GET" request
    Then the response has status 200

    Examples:
      | endpoint             |
      | /api/v1/actors/1     |
      | /api/v1/addresses/1  |
      | /api/v1/categories/1 |
      | /api/v1/cities/1     |
      | /api/v1/countries/1  |
      | /api/v1/films/1      |
      | /api/v1/languages/1  |
      | /api/v1/staff/1      |

  Scenario Outline: Create a new resource.
    Given the JSON body: "<json>"
    And I have a valid API token
    When the endpoint "<endpoint>" is accessed with a "PUT" request
    Then the response has status 200

    Examples:
      | endpoint           | json |
      | /api/v1/actors     | {\"firstName\": \"Johnny\", \"lastName\": \"Depp\"} |
      | /api/v1/countries  | {\"country\": \"Sweden\"} |
      | /api/v1/cities     | {\"city\": \"Stockholm\", \"country\": {\"id\": 1}} |

  Scenario Outline: Update a resource.
    Given the JSON body: "<json>"
    And I have a valid API token
    When the endpoint "<endpoint>" is accessed with a "PUT" request
    Then the response has status 200
    And the response matches "<result>"

    Examples:
    | endpoint         | json | result |
    | /api/v1/cities/1 | {\"id\": 1, \"city\": \"Malmo\", \"country\": {\"id\": 1}} | {\"id\":1,\"city\":\"Malmo\",\"country\":{\"id\":1,\"country\":null}} |

  Scenario Outline: Delete a resource.
    Given I have a valid API token
    When the endpoint "<endpoint>" is accessed with a "DELETE" request
    Then the response has status 200

    Examples:
      | endpoint             |
      | /api/v1/actors/1     |
      | /api/v1/cities/1     |
      | /api/v1/countries/1  |
