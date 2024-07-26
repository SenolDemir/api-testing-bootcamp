  @pet
  Feature: Pet Model Functions


    Scenario: User should be able to create a new pet
      When logged in user send post request with valid pet information
      Then new pet should be created

      Scenario: User should read the information of created pet
        When  logged user send request to get created pet information
        Then pet info should be displayed

        Scenario: User should upload image file for created pet
          When logged user send post request to upload file for craeted pet
          Then image file should be added to pet information

      Scenario: User should be able to update created pet
        When user send put request to update created pet information
        Then pet info should be updated