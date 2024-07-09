package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.ProfilePage;

public class ProfileUpdateTest extends BaseTest {

    @Test
    public void testProfileUpdate() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        HomePage homePage = new HomePage(driver);

        // Login with valid credentials
        loginPage.login(config.getProperty("validUsername"), config.getProperty("validPassword"));
        String desiredUrl = config.getProperty("homeurl");
        wait.until(ExpectedConditions.urlToBe(desiredUrl));

        //Go to update contact info page
        homePage.updateContactInfo();

        // Update profile info
        String credentials = config.getProperty("updateInfo");
        String fn = credentials.split(",")[0];
        String ln = credentials.split(",")[1];
        String ad = credentials.split(",")[2];
        String ct = credentials.split(",")[3];
        String st = credentials.split(",")[4];
        String zp = credentials.split(",")[5];
        String sn = credentials.split(",")[6];

        profilePage.updateProfile(fn);

        //check info was updated
        String actualMessage = profilePage.getUpdateMessage();
        String expectedMessage = "Profile Updated";
        Assert.assertEquals(actualMessage, expectedMessage, "Profile update message is not as expected.");
    }
}
