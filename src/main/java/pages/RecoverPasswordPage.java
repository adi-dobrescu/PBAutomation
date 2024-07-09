package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RecoverPasswordPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void completeFirstName(String fname) {
        WebElement completeFirstName = driver.findElement(By.cssSelector("input#firstName"));
        completeFirstName.sendKeys(fname);}

    public void completeLastName(String lname) {
        WebElement completeLastName = driver.findElement(By.cssSelector("input#lastName"));
        completeLastName.sendKeys(lname);}

    public void completeAddress(String adr) {
        WebElement completeAddress = driver.findElement(By.cssSelector("tbody tr:nth-of-type(3) [type]"));
        completeAddress.sendKeys(adr);}

    public void completeCity(String city) {
        WebElement completeCity = driver.findElement(By.cssSelector("tbody tr:nth-of-type(4) [type]"));
        completeCity.sendKeys(city);}

    public void completeState(String state) {
        WebElement completeState = driver.findElement(By.cssSelector("tbody tr:nth-of-type(5) [type]"));
        completeState.sendKeys(state);}

    public void completeZipCode(String zip) {
        WebElement completeZipCode = driver.findElement(By.cssSelector("tbody tr:nth-of-type(6) [type]"));
        completeZipCode.sendKeys(zip);}

    public void completeSSN(String snn) {
        WebElement completeSSN = driver.findElement(By.cssSelector("input#ssn"));
        completeSSN.sendKeys(snn);}

    public void findInfo() {
        WebElement findInfo = driver.findElement(By.cssSelector("[value='Find My Login Info']"));
        findInfo.click();}
}
