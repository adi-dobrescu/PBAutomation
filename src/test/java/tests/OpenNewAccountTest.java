package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.OpenAccountPage;

public class OpenNewAccountTest extends BaseTest {

    @Test
    public void openNewAcc() throws InterruptedException {

        //Objects for the pages that we interact with
        LoginPage loginPage = new LoginPage(driver);
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        HomePage homePage = new HomePage(driver);

        //Login with valid credentials
        loginPage.login(config.getProperty("validUsername"), config.getProperty("validPassword"));
        String desiredUrl = config.getProperty("homeurl");
        wait.until(ExpectedConditions.urlToBe(desiredUrl));

        //Open new account
        homePage.openNewAccount();
        openAccountPage.selectAccountType(); //select account type
        Thread.sleep(500);

        openAccountPage.selectFromAccount(); //select from which account to take the money
        Thread.sleep(500);
        openAccountPage.openAccount();

        //Check if the account was opened
        WebElement createdAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#openAccountResult .title")));
        String openAccountText = createdAccount.getText();

        Assert.assertEquals(openAccountText, "Account Opened!", "Account not opened.");
        System.out.println("The actual message is: " + openAccountText);

    }

}
