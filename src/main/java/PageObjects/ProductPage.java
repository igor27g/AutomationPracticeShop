package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {
    private WebDriverWait wait;

    By addToCartButton = By.cssSelector("p>button[name='Submit']");
    By iconPlusQuantity = By.cssSelector("i[class='icon-plus']");
    By moduleInfo = By.cssSelector("div[id='layer_cart']");
    By closeInfoWindow = By.cssSelector("span[title='Close window']");
    By proccedCheckOutButton = By.cssSelector("div[class='button-container']>a");

    public ProductPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

    public ShoppingCartSummary addToCartAndConfirmProduct() {
        addToCartAndConfirm();
        return new ShoppingCartSummary(driver);
    }

    public ShoppingCartSummary addTwoProductToCartAndConfirmProduct() {
        addQuantityProduct();
        addToCartAndConfirm();
        return new ShoppingCartSummary(driver);
    }

    private void addQuantityProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(iconPlusQuantity)).click();
    }
    //udoskonalic na liczbe klikniec

    private void addToCartAndConfirm() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(moduleInfo));
        wait.until(ExpectedConditions.elementToBeClickable(proccedCheckOutButton)).click();
    }



}
