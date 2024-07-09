package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OpenAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;


    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectAccountType() {
        WebElement accountType = wait.until(ExpectedConditions.elementToBeClickable(By.id("type")));
        Select dropdown1 = new Select(accountType);
        dropdown1.selectByIndex(0);
    }

    public void selectFromAccount() {
        WebElement fromAccount = wait.until(ExpectedConditions.elementToBeClickable(By.id("fromAccountId")));
        Select dropdown2 = new Select(fromAccount);
        dropdown2.selectByIndex(0);
        }


    public void openAccount() {
        WebElement openAccount = driver.findElement(By.cssSelector("input"));
        openAccount.click();    }

    public String getPageName(){
        WebElement pageName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#openAccountForm .title")));
        return pageName.getText();
    }
}
