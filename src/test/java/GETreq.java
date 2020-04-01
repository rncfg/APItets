import static io.restassured.RestAssured.get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class GETreq {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test(description = "GET")
    public void getRequestExampleTest() throws JSONException {
        Response response = get("/api/users?page=2");
                      int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }
    @Test(description = "GET")
    public void getRequestNegativeTest() throws JSONException{
        Response response = get("/api/users/23");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404);
    }

}
