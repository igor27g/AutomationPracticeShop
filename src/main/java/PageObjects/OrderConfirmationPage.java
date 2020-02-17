package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmationPage extends BasePage {
    private WebDriverWait wait;

    By orderCompleteSelector = By.cssSelector("p[class='cheque-indent']");


    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

    public String getOrderText() {
        String orderCompleteText = driver.findElement(orderCompleteSelector).getText();
        return orderCompleteText;
    }




}
