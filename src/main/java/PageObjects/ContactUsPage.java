package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends HomePage {

    private WebDriverWait wait;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

}
