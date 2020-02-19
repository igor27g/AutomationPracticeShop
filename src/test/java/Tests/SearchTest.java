package Tests;

import PageObjects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class SearchTest extends BaseTest {


    private String productName = "Blouse";
    private String wrongNameProduct = "wrongNameProduct";

    Random rand = new Random();


    @Test
    public void addOneProductToCartAndCreatneNewAccount() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        ShoppingCartSummary shoppingCartSummary = homePage.findProductInSearch(productName).chooseProductFromSearchResult().addToCartAndConfirmProduct();
        int productsAmount = shoppingCartSummary.howManyProductsContainsCart();

        OrderConfirmationPage orderConfirmationPage = shoppingCartSummary.confirmSummary()
                .createNewEmail("xyz" + rand.nextInt(1000) + "@ovh.pl").chooseTitle()
                .chooseTitle()
                .newAccount("Tom", "Kowalski", "password", "Streei 11"
                        , "New York", "12345", "123456789", "future Reference")
                .buttonProccedClick()
                .AcceptTermsAndButtonProccedClick()
                .payByBankWire()
                .confirmMyOrder();

        Assertions.assertAll("Checking order summary",
                () -> Assertions.assertEquals(29.0, orderConfirmationPage.getTotalAmount(), "Total amount is wrong"),
                () -> Assertions.assertEquals(1, productsAmount, "Wrong amount product in cart")
        );
    }

    @Test
    public void findProductWithWrongName() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        SearchResults searchResults = homePage.findProductInSearch(wrongNameProduct);
        Assertions.assertEquals("No results were found for your search "  + "\"" + wrongNameProduct + "\"" , searchResults.getTextFromAlert());
    }

}
