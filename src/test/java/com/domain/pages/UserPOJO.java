package com.domain.pages;


import lombok.Data;

@Data  // To generate Constructors and Getters Setters By using Lombok
public class UserPOJO {

    /*
    '{
      "id": 0,
      "username": "string",
      "firstName": "string",
      "lastName": "string",
      "email": "string",
      "password": "string",
      "phone": "string",
      "userStatus": 0
    }'
     */


    int id;
    String username;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    int userStatus;

    /*
        UserPOJO user = new UserPOJO();
        user.setUserStatus(faker.number().numberBetween(5, 50));
        user.setUsername(faker.name().username());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        user.setPhone(faker.phoneNumber().phoneNumber());
        user.setUserStatus(faker.number().numberBetween(5, 50));
     */



}
