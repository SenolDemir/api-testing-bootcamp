  @pet
  Feature: Pet Model Functions


    Scenario: User should be able to create a new pet
      When logged in user send post request with valid pet information
      Then new pet should be created

      Scenario: User should be able to update created pet
        When user send put request to update created pet information
        Then pet info should be updated