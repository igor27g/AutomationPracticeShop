package Tests;

import PageObjects.HomePage;
import PageObjects.OrderConfirmationPage;
import PageObjects.ShippingPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {

    private String email = "testerLogin2019@gmail.com";
    private String password = " passwordTester2019";



    @Test
    public void addOneProductAndLoginUser() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        OrderConfirmationPage orderConfirmationPage = homePage.addProductToCart().clickAddToCartButton().confirmSummary()
                .logIn(email, password)
                .buttonProccedClick()
                .AcceptTermsAndButtonProccedClick()
                .payByBankWire()
                .confirmMyOrder();
        Assertions.assertAll("Checking order summary",
                () -> Assertions.assertEquals(18.51, orderConfirmationPage.getTotalAmount(), "Total amount is wrong")
        );
    }

    @Test
    public void addTwoProductAndLoginUser() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        OrderConfirmationPage orderConfirmationPage = homePage.addProductToCart().addOneMoreProductAndAddToCartButton()
                .confirmSummary()
                .logIn(email, password)
                .buttonProccedClick()
                .AcceptTermsAndButtonProccedClick()
                .payByBankWire()
                .confirmMyOrder();
        Assertions.assertAll("Checking order summary",
                () -> Assertions.assertEquals(35.02, orderConfirmationPage.getTotalAmount(), "Total amount is wrong")
        );
    }

    @Test
    public void addOneProductAndNotAcceptTerms() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        ShippingPage shippingPage = homePage.addProductToCart().clickAddToCartButton().confirmSummary()
                .logIn(email, password)
                .buttonProccedClick()
                .NotAcceptTermsAndButtonProccedClick();
        Assertions.assertAll("Checking order summary",
                () -> Assertions.assertEquals("You must agree to the terms of service before continuing."
                        , shippingPage.getTextAlert(), "Wrong text alert")
        );
    }




}