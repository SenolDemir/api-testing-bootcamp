@pet
Feature: Pet Model Functions

  @crud
  Scenario: User should be able to create a new pet
    When logged in user send post request with valid pet information
    Then new pet should be created

  @crud
  Scenario: User should read the information of created pet
    When  logged user send request to get created pet information
    Then pet info should be displayed


  Scenario: User should upload file for created pet
    When logged user send post request to upload file for craeted pet
    Then image file should be added to pet information

  @crud
  Scenario: User should be able to delete pet with given id
    When user send delete request for pet with given id
    Then pet information should be deleted