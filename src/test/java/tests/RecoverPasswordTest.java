package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RecoverPasswordPage;

public class RecoverPasswordTest extends BaseTest {
    @Test
    public void testRecover() throws InterruptedException {

        //login with valid info
        LoginPage loginPage = new LoginPage(driver);
        loginPage.forgetPassword();
        RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(driver);

        //get valid credentials
        String credentials = config.getProperty("validInfo");
        System.out.println(credentials);
        String fn = credentials.split(",")[0];
        String ln = credentials.split(",")[1];
        String ad = credentials.split(",")[2];
        String ct = credentials.split(",")[3];
        String st = credentials.split(",")[4];
        String zp = credentials.split(",")[5];
        String sn = credentials.split(",")[6];

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".form2 .button")));

        recoverPasswordPage.completeFirstName(fn);
        recoverPasswordPage.completeLastName(ln);
        recoverPasswordPage.completeAddress(ad);
        recoverPasswordPage.completeCity(ct);
        recoverPasswordPage.completeSSN(sn);
        recoverPasswordPage.completeState(st);
        recoverPasswordPage.completeZipCode(zp);
        recoverPasswordPage.findInfo();

        //check if password was recovered
        String actualUrl = driver.getCurrentUrl();
        WebElement rstPw= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#rightPanel p:nth-child(2)")));
        Assert.assertEquals(rstPw.getText(), "Your login information was located successfully. You are now logged in.", "Credentials not recovered");


    }
}
