package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {
    private WebDriverWait wait;

    By buttonAddToCart = By.cssSelector("p>button[name='Submit']");
    By moduleInfo = By.cssSelector("div[id='layer_cart']");
    By closeInfoWindow = By.cssSelector("span[title='Close window']");
    By proccedCheckOutButton = By.cssSelector("div[class='button-container']>a");

    public ProductPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

    public SummaryPage addProductToCart() {
        driver.findElement(buttonAddToCart).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(moduleInfo));
        wait.until(ExpectedConditions.elementToBeClickable(proccedCheckOutButton)).click();
        return new SummaryPage(driver);
    }

}
