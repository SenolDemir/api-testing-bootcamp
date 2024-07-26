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

import java.io.File;

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
                .assertThat().header("Date", notNullValue())
                .log().all();

        // check id not 0 same as default
        JsonPath jsonPath = response.jsonPath();
        assertNotEquals(0, jsonPath.getInt("id"));
        assertNotEquals(0, jsonPath.getInt("tags[0].id"));

        //get id of created pet for following operations
        ScenarioContext.setScenarioContext(Context.ID, jsonPath.getInt("id"));
        ScenarioContext.setScenarioContext(Context.USERNAME, jsonPath.getString("name"));


    }

    @When("logged user send request to get created pet information")
    public void loggedUserSendRequestToGetCreatedPetInformation() {

        int petId = (Integer) ScenarioContext.getScenarioContext(Context.ID);

        response = given().log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("api_key", "special-key")
                .and()
                .pathParams("petId", petId)
                .when().get("/pet/{petId}");
    }

    @Then("pet info should be displayed")
    public void petInfoShouldBeDisplayed() {

        response
                .then().statusCode(200)
                .assertThat().contentType("application/json")
                .and()
                .assertThat().header("Content-Type", equalTo("application/json"))
                .and()
                .assertThat().header("Date", notNullValue())
                .assertThat().body("name", equalTo(ScenarioContext.getScenarioContext(Context.USERNAME)))
                .log().all();

        response.prettyPrint();


    }

    @When("logged user send post request to upload file for craeted pet")
    public void loggedUserSendPostRequestToUploadFileForCraetedPet() {

        int petId = (Integer) ScenarioContext.getScenarioContext(Context.ID);

        File imageFile = new File("src/test/resources/testdata/dog-puppy-on-garden.jpg");

        response = given().log().headers()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("api_key", "special-key")
                .and()
                .multiPart("file", imageFile)
                .contentType("multipart/form-data")
                .and()
                .pathParams("petId", petId)
                .when().post("/pet/{petId}/uploadImage");

        response.prettyPrint();

    }

    @Then("image file should be added to pet information")
    public void imageFileShouldBeAddedToPetInformation() {

        response
                .then().statusCode(200)
                .assertThat().contentType("application/json")
                .and()
                .assertThat().header("Content-Type", equalTo("application/json"))
                .and()
                .assertThat()
                .body("message", notNullValue());


        JsonPath jsonPath = response.jsonPath();
        jsonPath.getString("message").contains("general file\\nFile uploaded to ./dog-puppy-on-garden.jpg");


        response.prettyPrint();


    }


    @When("user send put request to update created pet information")
    public void userSendPutRequestToUpdateCreatedPetInformation() {



    }

    @Then("pet info should be updated")
    public void petInfoShouldBeUpdated() {


    }


}
