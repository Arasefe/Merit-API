package uiTests;

import org.junit.jupiter.api.Test;
import utils.Driver;

public class MeritUi {

    @Test
    public void test1(){
        Driver.getDriver().get("https://www.amazon.com");
    }
}
