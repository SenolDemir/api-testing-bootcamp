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

 @login
  Scenario: Created user should log in successfully
    When user send valid "username" and "password"
    Then user should logged in successfully

   @login
  Scenario: Created user should log out successfully
    When user send request to log out
    Then user should logged out successfully

  @crud
  Scenario: Update created user information
    When I send request to update user information by "username"
    Then user information by "username" should be updated

  @crud
  Scenario: Delete created user
    When I send request to delete user by "username"
    Then user information by "username" should be deleted
