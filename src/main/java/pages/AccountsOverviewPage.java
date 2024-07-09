package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class AccountsOverviewPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AccountsOverviewPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public double getAccountBalance(String accIndex) {
        WebElement accBalance = driver.findElement(By.cssSelector("tbody tr:nth-of-type("+accIndex+") td:nth-of-type(2)"));
        double initialAccountBalance = Double.parseDouble(accBalance.getText().replace("$", ""));
        return initialAccountBalance;
    }

    public String getPageName(){
        WebElement pageName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#showOverview .title")));
        return pageName.getText();
    }
}
