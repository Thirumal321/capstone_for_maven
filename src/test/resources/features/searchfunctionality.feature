Feature: Search Functionality

  Scenario: Search for a product and apply filters
    Given User is on home page
    When User searches for "Java"
    And User applies filters
    Then Search results should be displayed