package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends BasePage {

    private WebDriverWait wait;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

    By dropdownSubjectHeadingList = By.id("id_contact");
    By inputEmail = By.id("email");
    By inputOrder = By.id("id_order");
    By inputFile = By.id("fileUpload");
    By textareaMessage = By.id("message");
    By submitButton = By.id("submitMessage");
    By alertText = By.cssSelector("p.alert-success");





    WebElement dropdownSubject = driver.findElement(dropdownSubjectHeadingList);
    Select dropdown = new Select(dropdownSubject);



    public ContactUsPage SendAMessage(String email, String orderNumber, String filePath, String textMessage) {
        dropdown.selectByIndex(1);
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputOrder).sendKeys(orderNumber);
        driver.findElement(inputFile).sendKeys(filePath);
        driver.findElement(textareaMessage).sendKeys(textMessage);
        driver.findElement(submitButton).click();
        return this;
    }

    public String getAlertMessage() {
       String alertTextMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(alertText)).getText();
       return alertTextMessage;
    }




}
