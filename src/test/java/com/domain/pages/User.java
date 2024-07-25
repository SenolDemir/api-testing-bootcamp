package com.domain.pages;


/*
{
    "firstName": "Emil",
    "lastName": "Walsh",
    "password": "vj5knqzev4o",
    "userStatus": 28,
    "phone": "(425) 630-9894",
    "id": 7,
    "email": "kieth.blick@yahoo.com",
    "username": "bethany.dach"
}
 */

import lombok.Builder;
import lombok.Data;

@Data
public class User {

    int id;
    String username;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    int userStatus;



}
