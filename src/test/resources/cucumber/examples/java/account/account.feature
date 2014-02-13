@foo
Feature: Account Details

  Background: An Account
    Given A valid Account

  Scenario: Account number should not be zero
    Then Account number should not be zero

  Scenario: Balance should be greater than zero
    Then Balance should be greater than zero
#
#  Scenario: Account name should not be  blank
#  Then Account name should not be  blank