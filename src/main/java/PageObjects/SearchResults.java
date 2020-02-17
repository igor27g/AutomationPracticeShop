package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResults extends BasePage {
    private WebDriverWait wait;

    By listProduct = By.cssSelector("ul.product_list>li>div>div>div>a>img");


    public SearchResults(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }


    public ProductPage chooseProductFromSearchResult() {
        List<WebElement> listProductResult = driver.findElements(listProduct);
        listProductResult.size();
        listProductResult.get(0).click();
        return new ProductPage(driver);
    }


}
