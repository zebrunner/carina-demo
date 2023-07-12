Feature: Login user to MFP

  Scenario: login using credentials
    Given Welcome page is opened
    When I click Log In button in Welcome Page
    Then Login page is opened
    Given Login page is opened
    When I enter login and password
    And I click Log In button
    Then Dashboard page is opened



