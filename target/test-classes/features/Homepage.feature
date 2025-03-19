Feature: Home Page Functionality

  Scenario: Verify Search Bar Display
    Given User is on the Bookswagon home page
    Then Search bar should be displayed
    When User searches for Product "JAVA THE COMPLETE REFERENCE, 13E"