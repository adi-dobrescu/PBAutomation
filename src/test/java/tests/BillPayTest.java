package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.BillPayPage;


public class BillPayTest extends BaseTest {
    @Test
    public void testBillPay() throws InterruptedException {

        //Login with valid credentials
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BillPayPage billPayPage = new BillPayPage(driver);

        loginPage.login(config.getProperty("validUsername"), config.getProperty("validPassword"));

        //Check the URL
        String desiredUrl = config.getProperty("homeurl");
        wait.until(ExpectedConditions.urlToBe(desiredUrl));
        String actualUrl = driver.getCurrentUrl();
        System.out.println("The actual url is: " + actualUrl + " and the desired url is: " + desiredUrl);

        homePage.billPay();
        //Get the payment info
        String credentials = config.getProperty("billPayDetails");
        System.out.println(credentials);

        String a = credentials.split(",")[0];
        String b = credentials.split(",")[1];
        String c = credentials.split(",")[2];
        String d = credentials.split(",")[3];
        String e = credentials.split(",")[4];
        String f = credentials.split(",")[5];
        String g = credentials.split(",")[6];
        String h = credentials.split(",")[7];
        String i = credentials.split(",")[8];

        billPayPage.completePaymentDetails(a,b,c,d,e,f,g,h,i);
        billPayPage.selectAccountId();
        billPayPage.sendPayment();

        String actualMessage = billPayPage.getPaymentStatus();
        String expectedMessage = "Bill Payment Complete";
        Assert.assertEquals(actualMessage, expectedMessage, "Bill Payment not successful!");

    }

}