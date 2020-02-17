package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage extends BasePage {

    private WebDriverWait wait;

    public AddressPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }


}
