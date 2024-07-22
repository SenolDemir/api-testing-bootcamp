package com.domain.step_definitions;

import com.domain.pages.UserModel;
import com.domain.pages.UserPOJO;
import com.domain.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class UserStepDefs {

    Response response;
    UserModel userModel = new UserModel();
    Faker faker = new Faker();




    @When("I send a valid user information")
    public void iSendAValidUserInformation() {


        Map<String, Object> newUser = userModel.createUser();

        response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(newUser)
                .when()
                .post("/user");

        response.prettyPrint();


    }



    @Then("new user should be created")
    public void new_user_should_be_created() {

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());



    }


}
