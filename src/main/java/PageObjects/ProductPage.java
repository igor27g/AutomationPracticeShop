package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {
    private WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }


}
