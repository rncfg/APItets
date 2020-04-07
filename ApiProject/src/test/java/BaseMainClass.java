import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseMainClass {

    protected final String mainUrl = "https://reqres.in";

    @BeforeTest
    public void setup() {
        RestAssured.baseURI = mainUrl;
    }
}
