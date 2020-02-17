package Tests;

import PageObjects.HomePage;
import org.junit.jupiter.api.Test;

public class HomeTest extends BaseTest {


    private String productName = "T-shirt";



    @Test
    public void buyProductUsingSearchWithoutAccount(){
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        homePage.findProductInSearch(productName).chooseProductFromSearchResult().addProductToCartAndConfirm().confirmSummary();




//        Assertions.assertEquals("1", products, "It is diffrent amount products");

        //write name product in search OK
        // click icon search OK
        // go to resultsPage OK
        // open product info OK
        // add to cart OK
        // confirm adding to cart OK
        // go to summaryPage OK
        // check order in summary OK
        // confirm summary OK
        // go authenticationPage
        // make same random helpet to create email
    }

}
