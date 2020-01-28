package BasePackage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
    protected RequestSpecification requestSpecification;


    @Before

    public void Init() throws Exception {
        RestAssured.baseURI = "https://rickandmortyapi.com/api/";
    }

    @After
    public void Teardown() {

    }
}
