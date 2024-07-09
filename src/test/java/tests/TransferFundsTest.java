package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.AccountsOverviewPage;
import pages.TransferFundsPage;

import java.util.concurrent.TimeUnit;

public class TransferFundsTest extends BaseTest {

    @Test
    public void testLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);
        TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        double money = Double.parseDouble(config.getProperty("moneyAmount"));

        loginPage.login(config.getProperty("validUsername"), config.getProperty("validPassword"));
        String desiredUrl = config.getProperty("homeurl");
        wait.until(ExpectedConditions.urlToBe(desiredUrl));

        double[] initialBalances = new double[2];
        double[] finalBalances = new double[2];

        homePage.accountOverview();

        for (int i = 0; i < 2; i++) {
            initialBalances[i]=accountsOverviewPage.getAccountBalance(String.valueOf(i+1));}

        homePage.transferFunds();

        transferFundsPage.fromAccount();

        transferFundsPage.toAccount();

        transferFundsPage.transferFunds(config.getProperty("moneyAmount"));

        transferFundsPage.transferButton();

        String transferOutcome=transferFundsPage.getTransferOutcome();

        homePage.accountOverview();

        for (int i = 0; i < 2; i++) {
            finalBalances[i]=accountsOverviewPage.getAccountBalance(String.valueOf(i+1));}

        Assert.assertEquals(finalBalances[0], initialBalances[0]-money, "The balance for 1st account is not updated");
        Assert.assertEquals(finalBalances[1], initialBalances[1]+money, "The balance for 2nd account is not updated");

        System.out.println(transferOutcome);
    }

}
