package com.domain.pages;

import com.github.javafaker.Faker;
import java.util.HashMap;
import java.util.Map;
public class UserModel {

    Faker faker = new Faker();




    public Map<String, Object> createUserByMap(){

        Map<String, Object> userBody = new HashMap<>();
        userBody.put("id", faker.number().numberBetween(1,50));
        userBody.put("username", faker.name().username());
        userBody.put("firstName", faker.name().firstName());
        userBody.put("lastName", faker.name().lastName());
        userBody.put("email",faker.internet().emailAddress());
        userBody.put("password", faker.internet().password());
        userBody.put("phone", faker.phoneNumber().phoneNumber());
        userBody.put("userStatus", faker.number().numberBetween(1,10));

        return userBody;
}

        public User createUserByCustomClass(){

        User userBody = new User();
        userBody.setId(faker.number().numberBetween(1,50));
        userBody.setUsername(faker.name().username());
        userBody.setFirstName(faker.name().firstName());
        userBody.setLastName(faker.name().lastName());
        userBody.setEmail(faker.internet().emailAddress());
        userBody.setPassword(faker.internet().password());
        userBody.setPhone(faker.phoneNumber().phoneNumber());
        userBody.setUserStatus(faker.number().numberBetween(1,10));

        return userBody;
    }
















}
