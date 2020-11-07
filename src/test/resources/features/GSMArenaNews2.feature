Feature: GSM Arena Second feature
  In order to use Cucumber in my project, I want to check how to test GSM Arena News page

  @demo
  Scenario: GSM Arena open page - passing
    Given I am on main page
    When I open 'News' page
    Then page 'News' should be open
    And page 'News' should contains all items

