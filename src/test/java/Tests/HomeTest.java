package Tests;

import PageObjects.HomePage;
import PageObjects.OrderConfirmationPage;
import PageObjects.ProductPage;
import PageObjects.SearchResults;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class HomeTest extends BaseTest {


    private String productName = "T-shirt";

    Random rand = new Random();


    @Test
    public void buyProductUsingSearchWithoutAccount(){
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        SearchResults searchResults = homePage.findProductInSearch(productName);
        ProductPage productPage = searchResults.chooseProductFromSearchResult();
        homePage.findProductInSearch(productName)
                .chooseProductFromSearchResult()
                .addProductToCartAndConfirm()
                .confirmSummary()
                .createNewEmail("xyz" + rand.nextInt(1000) +   "@ovh.pl")
                .chooseTitle()
                .newAccount("Tom", "Kowalski", "password","Streei 11"
                        , "New York","12345","123456789", "future Reference")
                .buttonProccedClick()
                .AcceptTermsAndButtonProccedClick()
                .payByBankWire()
                .confirmMyOrder();
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        String isTextCorrect = orderConfirmationPage.getOrderText();
        String someText = searchResults.getSomeText();
//        Assertions.assertAll("Checking properties of order",
//                () -> Assertions.assertEquals("aa", )
//                );


    }

}
