package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_SubscribeFunctionTest extends BaseDriver {


    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;

    @Test(priority = 1)
    public void subscribeTest(){

        String expectedText = "My Account";
        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.emailInput.sendKeys("omenoo@mailinator.com");
        loginPageElements.passwordInput.sendKeys("Omen1234");
        loginPageElements.loginButton.click();

        String warningText = myAccountPageElements.myAccountHeader.getText();
        Assert.assertEquals(warningText,expectedText);

        myAccountPageElements.newsLetterButton.click();
        myAccountPageElements.yesRadioButton.click();
        myAccountPageElements.continueButton.click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertTrue(myAccountPageElements.successMessage.getText().toLowerCase().contains("success"));

    }

    @Test
    public void unsubscribeTest(){

        String expectedText = "My Account";
        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.emailInput.sendKeys("omenoo@mailinator.com");
        loginPageElements.passwordInput.sendKeys("Omen1234");
        loginPageElements.loginButton.click();

        String warningText = myAccountPageElements.myAccountHeader.getText();
        Assert.assertEquals(warningText,expectedText);

        myAccountPageElements.newsLetterButton.click();
        myAccountPageElements.noRadioButton.click();
        myAccountPageElements.continueButton.click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertTrue(myAccountPageElements.successMessage.getText().toLowerCase().contains("success"));
    }

    @Test
    public void radioButtonTest(){

        String expectedText = "My Account";
        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.emailInput.sendKeys("omenoo@mailinator.com");
        loginPageElements.passwordInput.sendKeys("Omen1234");
        loginPageElements.loginButton.click();

        String warningText = myAccountPageElements.myAccountHeader.getText();
        Assert.assertEquals(warningText,expectedText);

        myAccountPageElements.newsLetterButton.click();

        if (myAccountPageElements.yesRadioButton.isSelected())
        {
            myAccountPageElements.noRadioButton.click();
        }
        else
        {
            myAccountPageElements.yesRadioButton.click();
        }

        myAccountPageElements.continueButton.click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertTrue(myAccountPageElements.successMessage.getText().toLowerCase().contains("success"));
    }

    @Test
    public void editTest(){

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.emailInput.sendKeys("omenoo@mailinator.com");
        loginPageElements.passwordInput.sendKeys("Omen1234");
        loginPageElements.loginButton.click();

        myAccountPageElements.editAccountButton.click();

        myAccountPageElements.firstName.clear();
        myAccountPageElements.firstName.sendKeys("Alex");
        myAccountPageElements.lastName.clear();
        myAccountPageElements.lastName.sendKeys("De Souza");
        myAccountPageElements.emailInput.clear();
        myAccountPageElements.emailInput.sendKeys("alex@abc.com");
        myAccountPageElements.telInput.clear();
        myAccountPageElements.telInput.sendKeys("9876543221");
        myAccountPageElements.continueButton.click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertTrue(myAccountPageElements.successMessage.getText().toLowerCase().contains("success"));
    }

}
