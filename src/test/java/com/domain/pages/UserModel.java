package com.domain.pages;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class UserModel {

    Faker faker = new Faker();



    public Map<String, Object> createUser(){

        Map<String, Object> userBody = new HashMap<>();
        userBody.put("id", faker.number().numberBetween(5, 50));
        userBody.put("username", faker.name().username());
        userBody.put("firstName", faker.name().firstName());
        userBody.put("email", faker.internet().emailAddress());
        userBody.put("lastName", faker.name().lastName());
        userBody.put("password", faker.internet().password());
        userBody.put("phone", faker.phoneNumber().phoneNumber());
        userBody.put("userStatus", faker.number().numberBetween(5, 50));

        return userBody;

    }












}
