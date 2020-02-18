package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartSummary extends BasePage {
    private WebDriverWait wait;

    By confirmButton = By.cssSelector("p[class='cart_navigation clearfix']>a");
    By amountProductsInCart = By.cssSelector("span[id='summary_products_quantity']");
    By totalPriceSummary = By.cssSelector("span[id='total_price']");

    public ShoppingCartSummary(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

    public AuthenticationPage confirmSummary() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
        return new AuthenticationPage(driver);
    }

    public Integer howManyProductsContainsCart() {
        String amountProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(amountProductsInCart)).getText().substring(0,2).trim();
        return Integer.parseInt(amountProduct);
    }

    public Double getTotalAmount() {
        String price = wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceSummary)).getText();
        String priceAfterConvert = price.substring(1,price.length()).trim();
        return Double.parseDouble(priceAfterConvert);
    }




}
