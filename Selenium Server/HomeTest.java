package Tests;

import PageObjects.HomePage;
import org.junit.jupiter.api.Test;

public class HomeTest extends BaseTest {



    @Test
    public void firstTest() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        System.out.println("Go to page works fine");
    }

}
