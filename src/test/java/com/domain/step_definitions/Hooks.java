package com.domain.step_definitions;

import com.domain.utilities.ConfigurationReader;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;


public class Hooks {


    @Before
    public void setup(){

       baseURI = ConfigurationReader.get("baseURI");



    }


}
