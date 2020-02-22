package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmationPage extends BasePage {
    private WebDriverWait wait;

    By orderCompleteSelector = By.cssSelector("p[class='cheque-indent']");
    By submitButton = By.cssSelector("p>button[type='submit']");
    By priceAmount = By.cssSelector("span[class='price']");




    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

    public OrderConfirmationCompletePage confirmCompleteOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        return new OrderConfirmationCompletePage(driver);
    }

    public String getOrderText() {
        String orderCompleteText = driver.findElement(orderCompleteSelector).getText();
        return orderCompleteText;
    }

    public Double getTotalAmount() {
        String price = wait.until(ExpectedConditions.visibilityOfElementLocated(priceAmount)).getText();
        String priceAfterConvert = price.substring(1,price.length()).trim();
        return Double.parseDouble(priceAfterConvert);
    }



}
