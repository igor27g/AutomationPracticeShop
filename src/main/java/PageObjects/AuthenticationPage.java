package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage extends BasePage {
    private WebDriverWait wait;

    By emailCreateInput = By.cssSelector("input[id='email_create']");
    By emailLoginInput = By.cssSelector("input[id='email']");
    By passwordLoginInput = By.cssSelector("input[id='passwd']");
    By createAccountButton = By.cssSelector("button[id='SubmitCreate']");
    By signInButton = By.cssSelector("button[id='SubmitLogin']");


    public AuthenticationPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

    public CreateAccountPage createNewEmail(String email) {
        driver.findElement(emailCreateInput).sendKeys(email);
        driver.findElement(createAccountButton).click();
        return new CreateAccountPage(driver);
    }

    public AddressPage logIn(String email, String password) {
        driver.findElement(emailLoginInput).sendKeys(email);
        driver.findElement(passwordLoginInput).sendKeys(password);
        driver.findElement(signInButton).click();
        return new AddressPage(driver);
    }






}
