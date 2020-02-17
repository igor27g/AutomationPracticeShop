package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasePage {
    private WebDriverWait wait;

    public SummaryPage (WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }




}
