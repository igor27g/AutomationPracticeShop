package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage extends BasePage {
    private WebDriverWait wait;

    By proccedButton = By.cssSelector("button[name='processCarrier']");
    By terms = By.cssSelector("div#uniform-cgv");

    public ShippingPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

    public PaymentMethodPage AcceptTermsAndButtonProccedClick() {
        wait.until(ExpectedConditions.elementToBeClickable(terms)).click();
        wait.until(ExpectedConditions.elementToBeClickable(proccedButton)).click();
        return new PaymentMethodPage(driver);
    }


}
