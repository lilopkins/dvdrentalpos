Feature: Browsable films
  Provide browsable data

  @Selenium
  Scenario: View list of films
    When I navigate to "/browse"
    Then A pageable element is visible
    And the robot quits

  @Selenium
  Scenario: View a film
    When I navigate to "/film/1"
    Then "h1.title" is visible
    And "ul" is visible
    And the robot quits

  @Selenium
  Scenario: View list of actors
    When I navigate to "/actors"
    Then A pageable element is visible
    And the robot quits

  @Selenium
  Scenario: View an actor
    When I navigate to "/actor/1"
    Then "h1.name" is visible
    And "ul" is visible
    And the robot quits
