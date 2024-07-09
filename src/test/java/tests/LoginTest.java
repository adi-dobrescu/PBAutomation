package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() throws InterruptedException {

        //Login with valid credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getProperty("validUsername"), config.getProperty("validPassword"));

        //Check the URL
        String desiredUrl = config.getProperty("homeurl");
        wait.until(ExpectedConditions.urlToBe(desiredUrl));
        String actualUrl = driver.getCurrentUrl();
        System.out.println("The actual url is: " + actualUrl + " and the desired url is: " + desiredUrl);

        //Assert the redirection to home page
        Assert.assertEquals(actualUrl, desiredUrl, "User is not redirected to the correct page after login.");

    }

    }
