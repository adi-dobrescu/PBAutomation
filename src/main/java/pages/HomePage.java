package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openNewAccount() {
        WebElement openNewAccount = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Open New Account")));
        openNewAccount.click();}

    public void accountOverview() {
        WebElement accountsOverview = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Accounts Overview")));
        accountsOverview.click();}

    public void transferFunds() {
        WebElement transferFunds = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Transfer Funds")));
        transferFunds.click();}

    public void billPay() {
        WebElement userLogout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Bill Pay")));
        userLogout.click();}

    public void findTransactions() {
        WebElement findTransactions = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Find Transactions")));
        findTransactions.click();}

    public void updateContactInfo() {
        WebElement userLogout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Update Contact Info")));
        userLogout.click();}

    public void requestLoan() {
        WebElement requestLoan = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Request Loan")));
        requestLoan.click();}

    public void setLogOut() {
       WebElement userLogout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log Out")));
         userLogout.click();}

}
