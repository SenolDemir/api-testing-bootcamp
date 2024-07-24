@user
Feature: User Functions

  @crud
  Scenario: Create a new user
    When I send a request to create a new user with valid information
    Then new user should be created

  @crud
  Scenario: Read created user information
    When I send request to read user information by "username"
    Then user information by "username" should be displayed

  @crud
  Scenario: Update created user information
    When I send request to update user information by "username"
    Then user information by "username" should be updated

  @crud
  Scenario: Delete created user
    When I send request to delete user by "username"
    Then user information by "username" should be deleted
