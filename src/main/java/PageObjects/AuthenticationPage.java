package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage extends BasePage {
    private WebDriverWait wait;

    By emailInput = By.cssSelector("input[id='email_create']");
    By emailSubmitButton = By.cssSelector("button[id='SubmitCreate']");

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

    public CreateAccountPage createNewEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(emailSubmitButton).click();
        return new CreateAccountPage(driver);
    }






}
