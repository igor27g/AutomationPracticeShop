package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends BasePage {

    private WebDriverWait wait;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

    By dropdownSubjectHeadingList = By.id("id_contact");
    By inputEmail = By.id("email");
    By inputOrder = By.id("id_order");
    By inputFile = By.id("fileUpload");



    WebElement dropdownSubject = driver.findElement(dropdownSubjectHeadingList);
    Select dropdown = new Select(dropdownSubject);



    public ContactUsPage SendAMessage(String email, String orderNumber) {
        dropdown.selectByIndex(0);
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputOrder).sendKeys(orderNumber);
        driver.findElement(inputFile).sendKeys("D:\\Users\\Igor\\Desktop\\AutomationPracticeShop\\testFile.txt");
        return new ContactUsPage(driver);
    }




}
