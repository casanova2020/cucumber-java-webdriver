Feature: Cheque

  Scenario: Cheque Date should not  be past date
    Given a cheque with past date
    When the cheque is deposited
    Then the cheque should bounce

   Scenario: Cheque number should be valid
     Given a cheque with invalid number
     When the cheque is deposited
     Then the cheque should be invalid

  Scenario: Valid details cheque can be deposited
    Given a cheque with valid details
    When the cheque is deposited
    Then the cheque should pass


