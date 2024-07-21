package com.domain.step_definitions;

import com.domain.utilities.ConfigurationReader;
import org.junit.Before;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Hooks {


    @Before
    public void setup(){

       baseURI = ConfigurationReader.get("baseUri");
    }


}
