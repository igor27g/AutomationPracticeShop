package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class HomePage extends BasePage {
    private WebDriverWait wait;

    private String size = "L";

    By contactUsButton = By.cssSelector("a[title='Contact Us']");
    By searchInput = By.cssSelector("input[id='search_query_top']");
    By searchSubmit = By.cssSelector("button[name='submit_search']");
    By frameLocator = By.cssSelector("iframe[class='fancybox-iframe']");
    By iconPlusQuantity = By.cssSelector("i[class='icon-plus']");
    By addToCartButton = By.cssSelector("button[class='exclusive']>span");
    By proccedToCheckoutButton = By.cssSelector("a[title='Proceed to checkout']");
    By dropdownListSize = By.cssSelector("select[id='group_1']");
    By iconTwitter = By.cssSelector("li[class='twitter']");

    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 40);
    }

    public HomePage goTo(String url) {
        driver.navigate().to(url);
        wait.until(ExpectedConditions.elementToBeClickable(searchSubmit));
        return new HomePage(driver);
    }

    public HomePage clickTwitterIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(iconTwitter)).click();
        changeTab();
        return this;
    }


    public HomePage addProductToCart() {
        List<WebElement> list = driver.findElements(By.cssSelector("ul[id='homefeatured']>li>div>div>div"));
        list.get(0).click();
        return this;
    }


    public SearchResults findProductInSearch(String productName){
        driver.findElement(searchInput).sendKeys(productName);
        driver.findElement(searchSubmit).click();
        return new SearchResults(driver);
    }

    public ContactUsPage clickContactUs() {
        wait.until(ExpectedConditions.elementToBeClickable(contactUsButton)).click();
        return new ContactUsPage(driver);
    }

    //Refactor tych metod
    // Frame locator refactor

    public ShoppingCartSummary clickAddToCartButton() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
        clickAddToCart2();
        return new ShoppingCartSummary(driver);
    }

    public ShoppingCartSummary addTwoProductsAndClickAddToCartButton() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
        wait.until(ExpectedConditions.elementToBeClickable(iconPlusQuantity)).click();
        clickAddToCart2();
        return new ShoppingCartSummary(driver);
    }

    public ShoppingCartSummary changeSizeAndClickAddToCartButton() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
        changeSize(size);
        clickAddToCart2();
        return new ShoppingCartSummary(driver);
    }

    public ShoppingCartSummary changeColorAndClickAddToCartButton() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
        List <WebElement> listColors = driver.findElements(By.cssSelector("ul[id='color_to_pick_list']>*"));
        listColors.get(1).click();
        clickAddToCart2();
        return new ShoppingCartSummary(driver);
    }

    private void clickAddToCart2() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(proccedToCheckoutButton)).click();
    }

    private void changeSize(String size) {
        WebElement dropdownSize = driver.findElement(dropdownListSize);
        Select dropdown = new Select(dropdownSize);
        dropdown.selectByVisibleText(size);
    }

    private void changeTab() {
            Set<String> windows = driver.getWindowHandles();
            String parentWindow = driver.getWindowHandle();
            windows.remove(parentWindow);
            String secondWindow = windows.iterator().next();
            driver.switchTo().window(secondWindow);

    }

}

