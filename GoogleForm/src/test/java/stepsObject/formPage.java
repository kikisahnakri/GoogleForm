package stepsObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Hooks;

import java.time.Duration;

public class formPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public formPage() {
        this.driver = Hooks.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public By fieldNameApplication = By.xpath("//div[@class='o3Dpx']/div[1]//div[@class='Xb9hP']/input");
    public By fieldUserApplication = By.xpath("(//input[@class='whsOnd zHQkBf'])[2]");
    public By sendButton = By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[3]/div[1]/div[1]/div/span/span");
    public By fieldDate = By.xpath("//div[@class='rFrNMe yqQS1 hatWr zKHdkd']//input[@class='whsOnd zHQkBf']");
    public By Messge = By.xpath("//div[@class='vHW8K']");

    public void openLoginPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void inputNameApplication(String nameApplication) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(fieldNameApplication));
            element.clear();
            element.sendKeys(nameApplication);
        } catch (Exception e) {
            System.out.println("Error interacting with name application field: " + e.getMessage());
        }
    }

    public void selectApplicationType(String userType) {
        By xpathh = By.xpath("//div[contains(@data-value, '" + userType + "')]");
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(xpathh));
            element.click();
        } catch (Exception e) {
            System.out.println("Error selecting application type: " + e.getMessage());
        }
    }

    public void inputNumberOfUserApplication(String userApplication) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(fieldUserApplication));
            element.clear();
            element.sendKeys(userApplication);
        } catch (Exception e) {
            System.out.println("Error interacting with user application field: " + e.getMessage());
        }
    }

    public void inputDate(String date) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(fieldDate));
            element.clear();
            element.sendKeys(date);
        } catch (Exception e) {
            System.out.println("Error interacting with date field: " + e.getMessage());
        }
    }

    public void clickSendBtn() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(sendButton));
            element.click();
        } catch (Exception e) {
            System.out.println("Error clicking login button: " + e.getMessage());
        }
    }

    public String getMessage() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Messge));
            return element.getText();
        } catch (Exception e) {
            System.out.println("Error getting error message: " + e.getMessage());
            return "";
        }
    }
}
