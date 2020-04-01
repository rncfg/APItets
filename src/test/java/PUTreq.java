package com.example.tests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PUTreq {

    @Test(description = "PUT")
    public void postRequestExampleTest() {


        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "zion resident");

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.put("https://reqres.in/api/users/2");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        String name = response.jsonPath().get("name");
        Assert.assertEquals(name, "morpheus");
        String job = response.jsonPath().get("job");
        Assert.assertEquals(job, "zion resident");

        System.out.println(response.getBody().asString());
    }

}
