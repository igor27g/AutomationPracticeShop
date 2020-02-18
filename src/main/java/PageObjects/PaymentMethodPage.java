package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentMethodPage extends BasePage {
    private WebDriverWait wait;

    By bankWireButton = By.cssSelector("p[class='payment_module']");

    public PaymentMethodPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

    public PaymentSummaryPage payByBankWire() {
        wait.until(ExpectedConditions.elementToBeClickable(bankWireButton)).click();
        return new PaymentSummaryPage(driver);
    }

}
