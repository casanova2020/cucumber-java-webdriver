Feature: Login

  Scenario: Login to appstudio
    Given Im on the appstudio home page
    When I enter email and password
    And I click Login button
    Then I should be able to login
    And  I close browser

  Scenario: Login to appstudio
    Given Im on the appstudio home page
    When I enter invalid email and password
    And I click Login button
    #Then I should see error text
    And  I close browser
#
#  Scenario: Creating an organisation
#    Given Im on the appstudio home page
#    When I enter email and password
#    And I click on create Organisation
#    And I fill all the fields
#    And I click on Save button
#    Then I should able to See an Organisation

  Scenario: compiling issues in flatplan
    Given Im on the appstudio home page
    When I enter email and password
    And I click Login button
    Then I should be able to login
    And I am on flatplan
    And click on the first issue
    And click on compile button
    Then I all the issues has to be compiled
    And  I close browser


#  Scenario: Creating the publication in the organisation
#    Given I'm in a Organisation
#    When I click on Create publication
#    And I fill all the fields
#    And I Click on Save
#    Then I should able to See a Publication
