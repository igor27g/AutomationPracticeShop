package Tests;

import PageObjects.HomePage;
import PageObjects.OrderConfirmationPage;
import PageObjects.ShippingPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {
    @Test
    public void addToCartFromHomePage() throws InterruptedException {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        OrderConfirmationPage orderConfirmationPage = homePage.addProductToCartFromProductList().clickAddToCartButton().confirmSummary()
                .loginUser(testData.getUser().getEmail(),testData.getUser().getPassword())
                .clickProccedButton()
                .AcceptTermsAndClickProcceedButton()
                .payByBankWire()
                .confirmMyOrder();
                Assertions.assertEquals(18.51, orderConfirmationPage.getTotalAmount()
                        , "Total price of product is not what expected. Expected 18.51, but was...");
    }

    @Test
    public void changeSizeProduct() throws InterruptedException {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        OrderConfirmationPage orderConfirmationPage = homePage.addProductToCartFromProductList().changeSizeAndClickAddToCartButton()
                .confirmSummary()
                .loginUser(testData.getUser().getEmail(), testData.getUser().getPassword())
                .clickProccedButton()
                .AcceptTermsAndClickProcceedButton()
                .payByBankWire()
                .confirmMyOrder();
        Assertions.assertEquals(18.51, orderConfirmationPage.getTotalAmount()
                        , "Total price of product is not what expected. Expected 35.02, but was...");
    }
//
    @Test
    public void changeColorProduct() throws InterruptedException {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        OrderConfirmationPage orderConfirmationPage = homePage.addProductToCartFromProductList().changeColorAndClickAddToCartButton()
                .confirmSummary()
                .loginUser(testData.getUser().getEmail(), testData.getUser().getPassword())
                .clickProccedButton()
                .AcceptTermsAndClickProcceedButton()
                .payByBankWire()
                .confirmMyOrder();
        Assertions.assertEquals(18.51, orderConfirmationPage.getTotalAmount(),
                        "Total price of product is not what expected. Expected 35.02, but was...");
    }



    @Test
    public void changeQuantityProduct() throws InterruptedException {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        OrderConfirmationPage orderConfirmationPage = homePage.addProductToCartFromProductList().addTwoProductsAndClickAddToCartButton()
                .confirmSummary()
                .loginUser(testData.getUser().getEmail(), testData.getUser().getPassword())
                .clickProccedButton()
                .AcceptTermsAndClickProcceedButton()
                .payByBankWire()
                .confirmMyOrder();
                Assertions.assertEquals(35.02, orderConfirmationPage.getTotalAmount(),
                        "Total price of product is not what expected. Expected 35.02, but was...");
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
                Assertions.assertEquals(30.98, orderConfirmationPage.getTotalAmount(),
                        "Total price of product is not what expected. Expected 30.98, but was...");
    }

    @Test
    public void addOneProductFromHomePageAndNotAcceptTerms() throws InterruptedException {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        ShippingPage shippingPage = homePage.addProductToCartFromProductList().clickAddToCartButton().confirmSummary()
                .loginUser(testData.getUser().getEmail(), testData.getUser().getPassword())
                .clickProccedButton()
                .NotAcceptTermsAndClickProcceedButton();
        Assertions.assertEquals("You must agree to the terms of service before continuing."
                        , shippingPage.getTextAlert(), "No alert message found");
    }






}
