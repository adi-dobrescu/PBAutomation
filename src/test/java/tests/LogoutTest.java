package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() throws InterruptedException {

        //Login with valid credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getProperty("validUsername"), config.getProperty("validPassword"));

        String homeUrl = config.getProperty("homeurl");
        wait.until(ExpectedConditions.urlToBe(homeUrl));

        //Logout
        HomePage homePage = new HomePage(driver);
        homePage.setLogOut();

        //Assert redirection to login page after logout
        String desiredUrl = config.getProperty("loginurl");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(desiredUrl), "User is not redirected to the correct page after logout.");
        System.out.println("The actual url is: " + actualUrl + " and the desired url is: " + desiredUrl);
    }
}
