package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmationCompletePage extends BasePage {
    private WebDriverWait wait;

    By priceAmount = By.cssSelector("span[class='price']");


    public OrderConfirmationCompletePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 25);
    }

    public Double getTotalAmount() {
        String price = wait.until(ExpectedConditions.visibilityOfElementLocated(priceAmount)).getText();
        String priceAfterConvert = price.substring(1,price.length()).trim();
        return Double.parseDouble(priceAfterConvert);
    }


}
