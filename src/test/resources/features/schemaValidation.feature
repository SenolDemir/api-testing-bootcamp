
@schema
Feature: Schema Validation

#  to make validation we need to get a response body from API.
#  so that, we use user create scenario to have a json body to validate with scheme
#  the last step is particular validation step, others come from user.feature
#  so that, validation step defined in user step class


  Scenario: Create a new user
    When I send a request to create a new user with valid information
    Then new user should be created


  Scenario: Response should be validated with Json schema
    When I send request to read user information by "username"
    Then response body should match the json schema




