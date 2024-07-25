package com.domain.step_definitions;

import com.domain.pages.Context;
import com.domain.pages.PetModel;
import com.domain.pages.ScenarioContext;
import com.domain.pages.pet.pojo.Pet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class PetStepDefs {

    Response response;
    PetModel petModel = new PetModel();


    @When("logged in user send post request with valid pet information")
    public void loggedInUserSendPostRequestWithValidPetInformation() {

        response = given().log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("api_key", "special-key")
                .and()
                .body(petModel.createPed())
                .when().post("/pet");

        response.prettyPrint();

    }


    @Then("new pet should be created")
    public void new_pet_should_be_created() {

        response
                .then().statusCode(200)
                .assertThat().contentType("application/json")
                .and()
                .assertThat().header("Content-Type", equalTo("application/json"))
                .and()
                .assertThat().header("Date", notNullValue());

        // check id not 0 same as default
        JsonPath jsonPath = response.jsonPath();
        assertNotEquals(0, jsonPath.getInt("id"));
        assertNotEquals(0, jsonPath.getInt("tags[0].id"));

        //get id of created pet for following operations
        ScenarioContext.setScenarioContext(Context.ID, jsonPath.getInt("id"));


    }


    @When("user send put request to update created pet information")
    public void userSendPutRequestToUpdateCreatedPetInformation() {




    }

    @Then("pet info should be updated")
    public void petInfoShouldBeUpdated() {


    }


}
