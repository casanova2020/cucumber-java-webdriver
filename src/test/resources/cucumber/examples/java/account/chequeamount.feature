Feature:  Cheques
  Scenario: Cheque amount should not be zero
    Given A cheque with amount zero
    When Cheque is deposited
    Then Cheque should bounce


  Scenario: Cheque amount should be less than account balance
    Given A cheque amount less than account balance and not zero
    When Cheque is deposited
    Then Cheque should pass


  Scenario:  Cheque value should not be greater than account balance
    Given A cheque greater than account balance
    When Cheque is deposited
    Then Cheque should bounce

  Scenario: Cheque value should not be less than zero
    Given A cheque amount less than zero
    When Cheque is deposited
    Then Cheque should bounce

  Scenario: Cheque name should match account name
    Given a cheque with valid details
    When Cheque is deposited
    Then Cheque should pass


