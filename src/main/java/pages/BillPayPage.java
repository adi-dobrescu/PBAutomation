package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BillPayPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BillPayPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By payeeName = By.cssSelector("input[name='payee.name']");
    private By address = By.cssSelector("input[name='payee.address.street']");
    private By city = By.cssSelector("input[name='payee.address.city']");
    private By state = By.cssSelector("input[name='payee.address.state']");
    private By zipCode = By.cssSelector("input[name='payee.address.zipCode']");
    private By phoneNumber = By.cssSelector("input[name='payee.phoneNumber']");
    private By accountNumber = By.cssSelector("input[name='payee.accountNumber']");
    private By verifyAccountNumber = By.cssSelector("input[name='verifyAccount']");
    private By amount = By.cssSelector("input[name='amount']");
    private By sendButton = By.cssSelector("[value='Send Payment']");

    public void completePaymentDetails(String a, String b, String c, String d, String e, String f, String g, String h, String i) {
        WebElement a1 = wait.until(ExpectedConditions.elementToBeClickable(payeeName));
        a1.sendKeys(a);
        WebElement b1 = driver.findElement(address);
        b1.sendKeys(b);
        WebElement c1 = driver.findElement(city);
        c1.sendKeys(c);
        WebElement d1 = driver.findElement(state);
        d1.sendKeys(d);
        WebElement e1 = driver.findElement(zipCode);
        e1.sendKeys(e);
        WebElement f1 = driver.findElement(phoneNumber);
        f1.sendKeys(f);
        WebElement g1 = driver.findElement(accountNumber);
        g1.sendKeys(g);
        WebElement h1 = driver.findElement(verifyAccountNumber);
        h1.sendKeys(h);
        WebElement i1 = driver.findElement(amount);
        i1.sendKeys(i);
    }

    public void selectAccountId(){
        WebElement fromAccount = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[name='fromAccountId']")));
        Select dropdown1 = new Select(fromAccount);
        dropdown1.selectByIndex(0);
    }

    public void sendPayment(){
        WebElement sendBtn = driver.findElement(sendButton);
        sendBtn.click();
    }

    public String getPaymentStatus(){
        WebElement paymentStatus=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#billpayResult .title")));
        return paymentStatus.getText();
    }

    public String getPageName(){
        WebElement pageName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#billpayForm .title")));
        return pageName.getText();
    }
}
