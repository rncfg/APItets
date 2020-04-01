package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class POSTreq {

    @Test(description = "POST")
    public void postRequestExampleTest() {


        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "leader");

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.post("https://reqres.in/api/users");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
        String name = response.jsonPath().get("name");
        Assert.assertEquals(name, "morpheus");
        String job = response.jsonPath().get("job");
        Assert.assertEquals(job, "leader");

        System.out.println(response.getBody().asString());
    }
    @Test(description = "POST")
    public void postReqNegativeTest(){


        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "sydney@fife");

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.post("https://reqres.in/api/register");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400);
        String error = response.jsonPath().get("error");
        Assert.assertEquals(error,"Missing password" );
    }

}
