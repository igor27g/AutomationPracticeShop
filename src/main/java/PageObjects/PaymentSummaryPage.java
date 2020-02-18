package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentSummaryPage extends BasePage{

    private WebDriverWait wait;

    By confirmMyOrderButton = By.cssSelector("p[id='cart_navigation']>button");

    public PaymentSummaryPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

    public OrderConfirmationPage confirmMyOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmMyOrderButton)).click();
        return new OrderConfirmationPage(driver);
    }



}
