package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//input[@value='Log In']");
    private By forgetButton = By.linkText("Forgot login info?");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String username) {
        WebElement userField = wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        userField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passField = driver.findElement(passwordField);
        passField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void forgetPassword() {
        WebElement forgetPW = driver.findElement(forgetButton);
        forgetPW.click();
    }
}
