package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasePage {
    private WebDriverWait wait;

    By confirmButton = By.cssSelector("p[class='cart_navigation clearfix']>a");
    By amountProductsInCart = By.cssSelector("span[id='summary_products_quantity']");

    public SummaryPage (WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

    public AuthenticationPage confirmSummary() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
        return new AuthenticationPage(driver);
    }

    public String howManyProductsContainsCart() {
        String amountProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(amountProductsInCart)).getText().substring(0,2).trim();
        return amountProduct;
    }




}
