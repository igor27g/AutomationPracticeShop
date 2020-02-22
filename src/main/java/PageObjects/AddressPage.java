package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage extends BasePage {
    private WebDriverWait wait;

    By proccedButton = By.cssSelector("button[name='processAddress']");


    public AddressPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

    public ShippingPage clickProccedButton() {
        wait.until(ExpectedConditions.elementToBeClickable(proccedButton)).click();
        return new ShippingPage(driver);
    }



}
