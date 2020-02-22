package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage extends BasePage {

    private WebDriverWait wait;
    Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    By summerDressesCategory = By.cssSelector("div[id='subcategories']>ul>li:nth-child(3)>div");
    By summerDressesProduct = By.cssSelector(".product_list>li");
    By summerDressesProductButton = By.cssSelector(".product_list>li>div>div:nth-child(2)>:nth-child(4)>a>span");
    By proccedToCheckoutButton = By.cssSelector("a[title='Proceed to checkout']");


    public CategoryPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 20);
    }

    public ShoppingCartSummary chooseProductFromSubcategories() {
        wait.until(ExpectedConditions.elementToBeClickable(summerDressesCategory)).click();
        clickAddToCartButton();
        wait.until(ExpectedConditions.elementToBeClickable(proccedToCheckoutButton)).click();
        return new ShoppingCartSummary(driver);
    }

    private void clickAddToCartButton(){
        js.executeScript("window.scrollBy(0,700)");
        actions.moveToElement(driver.findElement(summerDressesProduct)).build().perform();
        actions.moveToElement(driver.findElement(summerDressesProductButton)).click().build().perform();
    }






}
