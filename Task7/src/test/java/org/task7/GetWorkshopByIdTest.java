package org.task7;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetWorkshopByIdTest {


    @Test
    public void GetTitle() {
        RestAssured.baseURI = "https://api.oos.dmytrominochkin.cloud/api/v1/Workshop/GetById/08db6cb8-3c33-415f-83e5-3528fa4ccd7e";
        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();
        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "");


        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("IT club", response.jsonPath().get("title"));

    }


}
