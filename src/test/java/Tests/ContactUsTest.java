package Tests;

import PageObjects.ContactUsPage;
import PageObjects.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactUsTest extends BaseTest {

    private String email = "testerMessage1@gmail111.com";
    private String orderNumber = "123456";
    private String filePath = "D:\\Users\\Igor\\Desktop\\AutomationPracticeShop\\testFile.txt";
    private String textMessage = "Lorem ipsum lorem ipsum";


    @Test
    public void sendClaim() {
        ContactUsPage contactUsPage = new HomePage(driver).goTo(configuration.getBaseUrl()).clickContactUs().SendAMessage(email,orderNumber,filePath,textMessage);
        Assertions.assertEquals("Your message has been successfully sent to our team.", contactUsPage.getAlertMessage());
    }

    @Test
    public void checkTwitterIcon() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl()).clickTwitterIcon();
        Assertions.assertEquals("https://twitter.com/seleniumfrmwrk", driver.getCurrentUrl(), "wrong url");
    }




}