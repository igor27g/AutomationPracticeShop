package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage extends BasePage {
    private WebDriverWait wait;

    By proccedButton = By.cssSelector("button[name='processCarrier']");
    By terms = By.cssSelector("div[id='uniform-cgv']");
    By errorAlert = By.cssSelector("p[class='fancybox-error']");

    public ShippingPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

    public PaymentMethodPage AcceptTermsAndClickProcceedButton() {
        wait.until(ExpectedConditions.elementToBeClickable(terms)).click();
        clickProccedButton();
        return new PaymentMethodPage(driver);
    }

    public ShippingPage NotAcceptTermsAndClickProcceedButton() {
        clickProccedButton();
        return new ShippingPage(driver);
    }

    public String  getTextAlert() {
        String errorAlertText = wait.until(ExpectedConditions.visibilityOfElementLocated(errorAlert)).getText();
        return errorAlertText;
    }

    private void clickProccedButton() {
        wait.until(ExpectedConditions.elementToBeClickable(proccedButton)).click();
    }
}
