package Tests;

import PageObjects.HomePage;
import org.junit.jupiter.api.Test;

public class HomeTest extends BaseTest {


    private String productName = "T-shirt";

    @Test
    public void firstTest(){
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl())
                .findProductInSearch(productName);



        //write name product in search OK
        // click icon search OK
        // go to results Page
        // open product info
        // add to cart
    }

}
