import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void preSuite(){
        Configuration.baseUrl = "https://rozetka.com.ua/";
//        Configuration.browserSize = "1024x1080";
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
    }
}
