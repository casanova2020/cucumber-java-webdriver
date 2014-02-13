Feature: Withdrawal

  Scenario: Account balance should not go to negative
    Given an valid account with balance 100 to withdraw
    When try to withdraw 200 should throw error
    Then the balance after withdraw should be 100

  Scenario: Account balance should be debited properly
    Given an valid account with balance 100 to withdraw
    When i withdraw the amount 50 from the account
    Then the balance after withdraw should be 50

  Scenario: Account balance should not go to zero
    Given an valid account with balance 100 to withdraw
    When try to withdraw 100 should throw error
    Then the balance after withdraw should be 100

