import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class OpenRozetkaTest {

    @Test
    public void openRozetraTest(){
        open("");
        $(":das").click();
        sleep(10000);
    }
}
