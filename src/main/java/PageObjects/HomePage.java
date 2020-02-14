package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 9);
    }

    public HomePage goTo(String url) {
        driver.navigate().to(url);
        return new HomePage(driver);
    }


}
