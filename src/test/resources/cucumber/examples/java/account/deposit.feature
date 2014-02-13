Feature:Deposit

  Scenario: Should throw an error for invalid account number
    Given an account with account number zero
    Then the account should not accept any deposit

  Scenario: Account balance should be credited properly
    Given an valid account with balance 100
    When i deposit the amount 200 into the account
    Then the balance should be 300

