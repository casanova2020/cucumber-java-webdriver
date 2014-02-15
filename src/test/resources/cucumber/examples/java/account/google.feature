Feature: Test Google search

  Background:
    Given A webdriver

  Scenario Outline: Test the web driver
    When I enter "<url>"
    Then "<value>" page should appear

  Examples:
    |url | value |
    |http://www.google.com|google|
    |http://www.yahoo.com|yahoo |


  Scenario: Login example
    When I enter "https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/"
    Then Login box should appear
    When I enter the login details
    And Click on sign in
    Then I should see all my mails
    Then I signout from gmail
    And  I close the browser

  Scenario: Login example
    When I enter "https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/"
    Then Login box should appear
    When I enter invalid login details
    And Click on sign in
    Then I should see error message
    And  I close the browser