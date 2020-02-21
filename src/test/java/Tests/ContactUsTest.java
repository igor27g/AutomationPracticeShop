package Tests;

import PageObjects.ContactUsPage;
import PageObjects.HomePage;
import org.junit.jupiter.api.Test;

public class ContactUsTest extends BaseTest {

    private String email = "testerMessage1@gmail111.com";
    private String orderNumber = "123456";

    @Test
    public void sendClaim() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        ContactUsPage contactUsPage = homePage.clickContactUs().SendAMessage(email,orderNumber);
    }




}
