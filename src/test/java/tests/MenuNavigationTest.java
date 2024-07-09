package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BillPayPage;
import pages.LoginPage;
import pages.HomePage;
import pages.ProfilePage;
import pages.AccountsOverviewPage;
import pages.TransactionHistoryPage;
import pages.TransferFundsPage;
import pages.OpenAccountPage;

public class MenuNavigationTest extends BaseTest {
    @Test
    public void testBillPay() throws InterruptedException {

        //Login with valid credentials
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BillPayPage billPayPage = new BillPayPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);
        TransactionHistoryPage transactionHistoryPage = new TransactionHistoryPage(driver);
        TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);


        loginPage.login(config.getProperty("validUsername"), config.getProperty("validPassword"));

        //Check the URL
        String desiredUrl = config.getProperty("homeurl");
        wait.until(ExpectedConditions.urlToBe(desiredUrl));
        String actualUrl = driver.getCurrentUrl();
        System.out.println("The actual url is: " + actualUrl + " and the desired url is: " + desiredUrl);

        //Navigate through each page
        homePage.openNewAccount();
        String actualMessage = openAccountPage.getPageName();
        String expectedMessage = "Open New Account";
        Assert.assertEquals(actualMessage, expectedMessage, "Redirection not successful!");

        homePage.accountOverview();
         actualMessage = accountsOverviewPage.getPageName();
         expectedMessage = "Accounts Overview";
        Assert.assertEquals(actualMessage, expectedMessage, "Redirection not successful!");

        homePage.transferFunds();
         actualMessage = transferFundsPage.getPageName();
         expectedMessage = "Transfer Funds";
        Assert.assertEquals(actualMessage, expectedMessage, "Redirection not successful!");

        homePage.billPay();
         actualMessage = billPayPage.getPageName();
         expectedMessage = "Bill Payment Service";
        Assert.assertEquals(actualMessage, expectedMessage, "Redirection not successful!");

        homePage.findTransactions();
         actualMessage = transactionHistoryPage.getPageName();
         expectedMessage = "Find Transactions";
        Assert.assertEquals(actualMessage, expectedMessage, "Redirection not successful!");

        homePage.updateContactInfo();
        actualMessage = profilePage.getPageName();
        expectedMessage = "Update Profile";
        Assert.assertEquals(actualMessage, expectedMessage, "Redirection not successful!");

        homePage.requestLoan();

    }

}
