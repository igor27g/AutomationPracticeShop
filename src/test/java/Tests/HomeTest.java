package Tests;

import PageObjects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class HomeTest extends BaseTest {


    private String productName = "T-shirt";

    Random rand = new Random();


    @Test
    public void buyProductUsingSearchWithoutAccount(){
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        ShoppingCartSummary shoppingCartSummary = homePage.findProductInSearch(productName).chooseProductFromSearchResult().addProductToCartAndConfirm();
        OrderConfirmationPage orderConfirmationPage = shoppingCartSummary.confirmSummary()
                .createNewEmail("xyz" + rand.nextInt(1000) +   "@ovh.pl").chooseTitle()
                .chooseTitle()
                .newAccount("Tom", "Kowalski", "password","Streei 11"
                        , "New York","12345","123456789", "future Reference")
                .buttonProccedClick()
                .AcceptTermsAndButtonProccedClick()
                .payByBankWire()
                .confirmMyOrder();


        Assertions.assertAll("Checking order summary",
                () -> Assertions.assertEquals(1,"1","some text")
                );
//
//        homePage.findProductInSearch(productName)
//                .chooseProductFromSearchResult()
//                .addProductToCartAndConfirm()
//                .confirmSummary()
//                .createNewEmail(")
//                .chooseTitle()
//                .newAccount()
//                .buttonProccedClick()
//                .AcceptTermsAndButtonProccedClick()
//                .payByBankWire()
//                .confirmMyOrder();
//        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
//        String isTextCorrect = orderConfirmationPage.getOrderText();
//        String someText = searchResults.getSomeText();
//        Assertions.assertAll("Checking properties of order",
//                () -> Assertions.assertEquals("aa", )
//                );
    }

    //ShoppingCartSummary
    // OrderConfirmationPage

    @Test
    public void CheckingValueCart() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        SearchResults searchResults = homePage.findProductInSearch(productName);
        Integer amount = searchResults.chooseProductFromSearchResult().addProductToCartAndConfirm().howManyProductsContainsCart();
        Assertions.assertEquals(1,amount, "Wrong total amount product/products in cart");
    }

}
