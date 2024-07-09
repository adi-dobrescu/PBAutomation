package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TransferFundsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fromAccount() {
        WebElement accountType = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select#fromAccountId")));
        Select dropdown1 = new Select(accountType);
        dropdown1.selectByIndex(0);
    }

    public void toAccount() {
        WebElement accountType = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select#toAccountId")));
        Select dropdown2 = new Select(accountType);
        dropdown2.selectByIndex(1);

    }

    public void transferFunds(String money) {
        WebElement transferMoney = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#amount")));
        transferMoney.sendKeys(money);
    }

    public void transferButton() {
        WebElement transferMoney = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Transfer']")));
        transferMoney.click();
    }

    public String getTransferOutcome(){
        WebElement transferOutcome=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#showResult .title")));
        return transferOutcome.getText();
    }

    public String getPageName(){
        WebElement pageName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#showForm .title")));
        return pageName.getText();
    }

}
