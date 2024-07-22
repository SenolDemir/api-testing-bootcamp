@user
Feature: User Functions

  Scenario: Create a new user
    When I send a valid user information
    Then new user should be created
