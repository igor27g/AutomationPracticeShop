package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage extends BasePage {

    private WebDriverWait wait;

    public CategoryPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

}
