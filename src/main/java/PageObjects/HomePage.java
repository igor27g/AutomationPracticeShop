package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {
    private WebDriverWait wait;

    By searchInput = By.cssSelector("input[id='search_query_top']");
    By searchSubmit = By.cssSelector("button[name='submit_search']");
    By frameLocator = By.cssSelector("iframe[class='fancybox-iframe']");
    By addToCartButton = By.cssSelector("button[class='exclusive']>span");
    By proccedToCheckoutButton = By.cssSelector("a[title='Proceed to checkout']");

    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 25);
    }

    public HomePage goTo(String url) {
        driver.navigate().to(url);
        return new HomePage(driver);
    }

    public SearchResults findProductInSearch(String productName){
        driver.findElement(searchInput).sendKeys(productName);
        driver.findElement(searchSubmit).click();
        return new SearchResults(driver);
    }

    public HomePage addProductToCart() {
        List<WebElement> list = driver.findElements(By.cssSelector("ul[id='homefeatured']>li>div>div>div"));
        list.get(0).click();
        return this;
    }

    public ShoppingCartSummary clickAddToCartButton() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(proccedToCheckoutButton)).click();

        return new ShoppingCartSummary(driver);
    }


}



// Choose product from HomePage
//    Actions action = new Actions(driver);
//       WebElement element =  driver.findElement(By.cssSelector("div[id='block_top_menu']>ul>li)"));
//       action.moveToElement(element).click().build().perform();
////        WebElement productText = driver.findElement(By.xpath("//a[contains(text(), 'T-shirts')])"));
//
//
////        List<WebElement> list = driver.findElements(By.cssSelector("ul[id='homefeatured']>li>div>div:nth-child(2)>div[class='button-container']>a>span"));
////        wait.until(ExpectedConditions.visibilityOfAllElements(list));
////        list.get(0).click();