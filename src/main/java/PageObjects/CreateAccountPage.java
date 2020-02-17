package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    //State dropdown
    By customerPostalCodeInput = By.cssSelector("input[id='postCode']");
    //country dropdown
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

    public AddressPage newAccount(String firstName, String lastName, String password, String address, String city,
                                                     String postalCode, String mobilePhone, String futureReference) {
        driver.findElement(customerFirstNameInput).sendKeys(firstName);
        driver.findElement(customerLastNameInput).sendKeys(lastName);
        driver.findElement(customerPasswordInput).sendKeys(password);
        driver.findElement(customerFirstNameAddressInput).sendKeys(firstName);
        driver.findElement(customerLastNameAddressInput).sendKeys(lastName);
        driver.findElement(customerAddressInput).sendKeys(address);
        driver.findElement(customerCityInput).sendKeys(city);
        driver.findElement(customerPostalCodeInput).sendKeys(postalCode);
        driver.findElement(customerMobilePhoneInput).sendKeys(mobilePhone);
        driver.findElement(customerFutureReferenceInput).sendKeys(futureReference);
        driver.findElement(submitButton).click();
        return new AddressPage(driver);
    }

}
