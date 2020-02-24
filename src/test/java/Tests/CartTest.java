package Tests;

import PageObjects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {

    private String email = "testerLogin2019@gmail.com";
    private String password = " passwordTester2019";



    @Test
    public void addToCartFromHomePage() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        OrderConfirmationPage orderConfirmationPage = homePage.addProductToCartFromProductList().clickAddToCartButton().confirmSummary()
                .loginUser(testData.getUser().getEmail(), testData.getUser().getPassword())
                .clickProccedButton()
                .AcceptTermsAndClickProcceedButton()
                .payByBankWire()
                .confirmMyOrder();
        Assertions.assertAll("Checking order summary",
                () -> Assertions.assertEquals(18.51, orderConfirmationPage.getTotalAmount()
                        , "Total price of product is not what expected. Expected 18.51, but was...")
        );
    }

    @Test
    public void changeSizeProduct() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        OrderConfirmationPage orderConfirmationPage = homePage.addProductToCartFromProductList().changeSizeAndClickAddToCartButton()
                .confirmSummary()
                .loginUser(testData.getUser().getEmail(), testData.getUser().getPassword())
                .clickProccedButton()
                .AcceptTermsAndClickProcceedButton()
                .payByBankWire()
                .confirmMyOrder();
        Assertions.assertAll("Checking order summary",
                () -> Assertions.assertEquals(18.51, orderConfirmationPage.getTotalAmount()
                        , "Total price of product is not what expected. Expected 35.02, but was...")
                /// Assertions for size
        );
    }

    @Test
    public void changeColorProduct() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        OrderConfirmationPage orderConfirmationPage = homePage.addProductToCartFromProductList().changeColorAndClickAddToCartButton()
                .confirmSummary()
                .loginUser(testData.getUser().getEmail(), testData.getUser().getPassword())
                .clickProccedButton()
                .AcceptTermsAndClickProcceedButton()
                .payByBankWire()
                .confirmMyOrder();
        Assertions.assertAll("Checking order summary",
                () -> Assertions.assertEquals(18.51, orderConfirmationPage.getTotalAmount(),
                        "Total price of product is not what expected. Expected 35.02, but was...")
                // Assertions for color
        );
    }



    @Test
    public void changeQuantityProduct() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        OrderConfirmationPage orderConfirmationPage = homePage.addProductToCartFromProductList().addTwoProductsAndClickAddToCartButton()
                .confirmSummary()
                .loginUser(testData.getUser().getEmail(), testData.getUser().getPassword())
                .clickProccedButton()
                .AcceptTermsAndClickProcceedButton()
                .payByBankWire()
                .confirmMyOrder();
        Assertions.assertAll("Checking order summary",
                () -> Assertions.assertEquals(35.02, orderConfirmationPage.getTotalAmount(),
                        "Total price of product is not what expected. Expected 35.02, but was...")
                // Assertions for quantity
        );
    }

    @Test
    public void addProductFromCategory() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        OrderConfirmationPage orderConfirmationPage = homePage.addProductToCartFromCategory().chooseProductFromSubcategories()
                .confirmSummary()
                .loginUser(testData.getUser().getEmail(), testData.getUser().getPassword())
                .clickProccedButton()
                .AcceptTermsAndClickProcceedButton()
                .payByBankWire()
                .confirmMyOrder();
        Assertions.assertAll("Checking order summary",
                () -> Assertions.assertEquals(30.98, orderConfirmationPage.getTotalAmount(),
                        "Total price of product is not what expected. Expected 30.98, but was...")
        );

    }

    @Test
    public void addOneProductFromHomePageAndNotAcceptTerms() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        ShippingPage shippingPage = homePage.addProductToCartFromProductList().clickAddToCartButton().confirmSummary()
                .loginUser(testData.getUser().getEmail(), testData.getUser().getPassword())
                .clickProccedButton()
                .NotAcceptTermsAndClickProcceedButton();
        Assertions.assertAll("Checking order summary",
                () -> Assertions.assertEquals("You must agree to the terms of service before continuing."
                        , shippingPage.getTextAlert(), "No alert message found")
        );
    }






}
