package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateAccountPage extends BasePage {
    private WebDriverWait wait;

    By customerFirstNameInput = By.cssSelector("input[id='customer_firstname']");
    By customerLastNameInput = By.cssSelector("input[id='customer_lastname']");
    By customerPasswordInput = By.cssSelector("input[id='passwd']");
    By customerFirstNameAddressInput = By.cssSelector("input[id='firstname']");
    By customerLastNameAddressInput = By.cssSelector("input[id='lastname']");
    By customerAddressInput = By.cssSelector("input[id='address1']");
    By customerCityInput = By.cssSelector("input[id='city']");
    By customerPostalCodeInput = By.cssSelector("input[id='postcode']");
    By customerMobilePhoneInput = By.cssSelector("input[id='phone_mobile']");
    By customerFutureReferenceInput = By.cssSelector("input[id='alias']");
    By submitButton = By.cssSelector("button[id='submitAccount']");


    public CreateAccountPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

    public CreateAccountPage chooseTitle() {
        List<WebElement> allCheckBox = driver.findElements(By.cssSelector("div[class='radio']"));
        allCheckBox.size();
        for(WebElement element : allCheckBox) {
            if(!(element.isSelected())){
                element.click();
            }
        }
        return this;
    }

    public AddressPage createNewAccount(String firstName, String lastName, String password, String address, String city,
                                        String postalCode, String mobilePhone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerFirstNameInput)).sendKeys(firstName);
        driver.findElement(customerLastNameInput).sendKeys(lastName);
        driver.findElement(customerPasswordInput).sendKeys(password);
        driver.findElement(customerAddressInput).sendKeys(address);
        driver.findElement(customerCityInput).sendKeys(city);
        new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("Arizona");
        driver.findElement(customerPostalCodeInput).sendKeys(postalCode);
        driver.findElement(customerMobilePhoneInput).sendKeys(mobilePhone);
        driver.findElement(submitButton).click();
        return new AddressPage(driver);
    }

}
