package com.domain.step_definitions;


import com.domain.pages.Context;
import com.domain.pages.ScenarioContext;
import com.domain.pages.User;
import com.domain.pages.UserModel;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;



public class UserStepDefs {

    Response response;
    Faker faker = new Faker();

    UserModel userModel = new UserModel();
    User userBody = new User();




    @When("I send a request to create a new user with valid information")
    public void iSendARequestToCreateANewUserWithValidInformation() {


        userBody.setId(faker.number().numberBetween(1, 50));
        userBody.setUsername(faker.name().username());
        userBody.setFirstName(faker.name().firstName());
        userBody.setLastName(faker.name().lastName());
        userBody.setEmail(faker.internet().emailAddress());
        userBody.setPassword(faker.internet().password());
        userBody.setPhone(String.valueOf(faker.number().digits(10)));
        userBody.setUserStatus(faker.number().numberBetween(1, 10));

        ScenarioContext.setScenarioContext(Context.USERNAME, userBody.getUsername());
        ScenarioContext.setScenarioContext(Context.ID, userBody.getId());
        
        response = given().log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(userBody)
                .when()
                .post("/user");

        response.prettyPrint();


    }


    @Then("new user should be created")
    public void new_user_should_be_created() {

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());

    }


    @When("I send request to read user information by {string}")
    public void iSendRequestToReadUserInformationBy(String username) {


        username = ScenarioContext.getScenarioContext(Context.USERNAME).toString();
        response = given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .pathParam("username", username)
                .when()
                .get("user/{username}");

        response.prettyPrint();

    }

    @Then("user information by {string} should be displayed")
    public void userInformationByShouldBeDisplayed(String username) {

        username = ScenarioContext.getScenarioContext(Context.USERNAME).toString();
        int id = ((Integer) ScenarioContext.getScenarioContext(Context.ID));


        JsonPath jsonPath = response.jsonPath();

        assertEquals(200, response.getStatusCode());
        assertEquals("application/json",  response.contentType());

        assertEquals(username, jsonPath.getString("username"));
        assertEquals(id, jsonPath.getInt("id"));
        assertTrue(jsonPath.getString("email").contains("@"));

        ScenarioContext.setScenarioContext(Context.FIRSTNAME, jsonPath.getString("firstName"));
        ScenarioContext.setScenarioContext(Context.LASTNAME, jsonPath.getString("lastName"));
        ScenarioContext.setScenarioContext(Context.EMAIL, jsonPath.getString("email"));
        ScenarioContext.setScenarioContext(Context.PASSWORD, jsonPath.getString("password"));


    }

    @When("user send valid {string} and {string}")
    public void userSendValidAnd(String username, String password) {

        username = ScenarioContext.getScenarioContext(Context.USERNAME).toString();
        password = ScenarioContext.getScenarioContext(Context.PASSWORD).toString();

        response = given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .queryParam("username", username)
                .and()
                .queryParam("password", password)
                .when()
                .get("/user/login");

        response.prettyPrint();

    }

    @Then("user should logged in successfully")
    public void userShouldLoggedInSuccessfully() {

        assertEquals(200, response.getStatusCode());
        assertEquals("application/json",  response.contentType());

    }

    @When("user send request to log out")
    public void userSendRequestToLogOut() {

        response = given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .when()
                .get("/user/logout");

        response.prettyPrint();

    }

    @Then("user should logged out successfully")
    public void userShouldLoggedOutSuccessfully() {


        assertEquals(200, response.getStatusCode());
        assertEquals("application/json",  response.contentType());
        assertEquals("ok", response.path("message"));


    }



    @When("I send request to update user information by {string}")
    public void iSendRequestToUpdateUserInformationBy(String username) {

        username = ScenarioContext.getScenarioContext(Context.USERNAME).toString();
        int id = ((Integer) ScenarioContext.getScenarioContext(Context.ID));

        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("username", username);
        user.put("firstName", faker.name().firstName());
        user.put("lastName", faker.name().lastName());
        user.put("email", faker.internet().emailAddress());
        user.put("password", faker.internet().password());
        user.put("phone", String.valueOf(faker.number().digits(10)));
        user.put("userStatus", faker.number().numberBetween(5, 50));

        response = given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .pathParam("username", username)
                .body(user)
                .when()
                .put("user/{username}");

        response.prettyPrint();


    }

    @Then("user information by {string} should be updated")
    public void userInformationByShouldBeUpdated(String username) {

        JsonPath jsonPath = response.jsonPath();

        username = ScenarioContext.getScenarioContext(Context.USERNAME).toString();
        int id = ((Integer) ScenarioContext.getScenarioContext(Context.ID));

        assertEquals(200, response.getStatusCode());
        assertEquals("application/json",  response.contentType());
        assertEquals(id,  jsonPath.getInt("message"));

    }

    @When("I send request to delete user by {string}")
    public void iSendRequestToDeleteUserBy(String username) {

        username = ScenarioContext.getScenarioContext(Context.USERNAME).toString();
        response = given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .pathParam("username", username)
                .when()
                .delete("user/{username}");

        response.prettyPrint();

    }

    @Then("user information by {string} should be deleted")
    public void userInformationByShouldBeDeleted(String username) {

        username = ScenarioContext.getScenarioContext(Context.USERNAME).toString();

        JsonPath jsonPath = response.jsonPath();

        assertEquals(200, response.getStatusCode());
        assertEquals("application/json",  response.contentType());
        assertEquals(username,  jsonPath.getString("message"));


    }

    @Then("response body should match the json schema")
    public void response_body_should_match_the_json_schema() {

        response
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));

    }





}
