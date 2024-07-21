@user
Feature: User Functions

  Scenario: Create a new user
    Given I connect to the user api service
    When I send a valid user information
    Then new user should be created
