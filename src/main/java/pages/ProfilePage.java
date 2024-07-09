package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By updateNameField = By.cssSelector("input[name='customer.firstName']");
    private By updateProfileButton = By.cssSelector("input[type='button'][value='Update Profile']");
    private By updateMessage = By.cssSelector("div#updateProfileResult h1.title");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void updateFirstName(String firstName) throws InterruptedException {
        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(updateNameField));
        Thread.sleep(500);
        nameField.clear();
        nameField.sendKeys(firstName);
    }

    public void clickUpdateProfileButton() {
        WebElement updateBtn = wait.until(ExpectedConditions.elementToBeClickable(updateProfileButton));
        updateBtn.click();
    }

    public String getUpdateMessage() {
        WebElement updateMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(updateMessage));
        return updateMsg.getText();
    }

    public void updateProfile(String firstName) throws InterruptedException {
        updateFirstName(firstName);
        clickUpdateProfileButton();
    }

    public String getPageName(){
        WebElement pageName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#updateProfileForm .title")));
        return pageName.getText();
    }
}