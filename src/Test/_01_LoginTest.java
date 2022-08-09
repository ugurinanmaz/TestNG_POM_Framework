package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_LoginTest extends BaseDriver {

    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;

    @Test(priority = 1)
    public void loginPositiveTest(){

        String exepctedText = "My Account";
        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.emailInput.sendKeys("omenoo@mailinator.com");
        loginPageElements.passwordInput.sendKeys("Omen1234");
        loginPageElements.loginButton.click();

        String warningText = myAccountPageElements.myAccountHeader.getText();

        Assert.assertEquals(warningText,exepctedText);

    }

    @Test(priority = 2)
    public void loginNegativeTest(){

        String expectedText = "Warning: No match for E-Mail Address and/or Password.";
        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.emailInput.sendKeys("omenoo@mailinator.com");
        loginPageElements.passwordInput.sendKeys("Omen12345");
        loginPageElements.loginButton.click();

        String warningText = loginPageElements.warning.getText();
        boolean warningIsDisplayed = loginPageElements.warning.isDisplayed();

        Assert.assertTrue(warningIsDisplayed);
        Assert.assertEquals(warningText,expectedText);

    }


}
