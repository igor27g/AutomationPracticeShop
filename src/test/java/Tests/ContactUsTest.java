package Tests;

import PageObjects.ContactUsPage;
import PageObjects.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class ContactUsTest extends BaseTest {

    @RepeatedTest(3)
    public void sendClaim() {
        ContactUsPage contactUsPage = new HomePage(driver).goTo(configuration.getBaseUrl()).clickContactUs()
                .SendAMessage(testData.getUser().getEmail(),testData.getClaimInformation().getOrderNumber()
                        ,testData.getClaimInformation().getFilePath()
                        ,testData.getClaimInformation().getTextMessage());
        Assertions.assertEquals("Your message has been successfully sent to our team.", contactUsPage.getAlertMessage(),
                "No succesful message found");
    }

    @Test
    public void checkTwitterIcon() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl()).clickTwitterIcon();
        Assertions.assertEquals(testData.getClaimInformation().getTwitterUrl(), driver.getCurrentUrl(), "No url twitter found");
    }




}
