package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class _03_AddressBookTest extends BaseDriver {

    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;

    @Test
    public void addressBookTest(){
        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.emailInput.sendKeys("omenoo@mailinator.com");
        loginPageElements.passwordInput.sendKeys("Omen1234");
        loginPageElements.loginButton.click();

        myAccountPageElements.addressBookButton.click();
        myAccountPageElements.newAddressButton.click();

        myAccountPageElements.firstName.clear();
        myAccountPageElements.firstName.sendKeys("Alex");
        myAccountPageElements.lastName.clear();
        myAccountPageElements.lastName.sendKeys("De Souza");
        myAccountPageElements.address1Input.clear();
        myAccountPageElements.address1Input.sendKeys("10300 NRG drive ");
        myAccountPageElements.address2Input.clear();
        myAccountPageElements.address2Input.sendKeys("PoolSide SkyBridge");
        myAccountPageElements.cityInput.clear();
        myAccountPageElements.cityInput.sendKeys("Austin");
        Select countrySelect = new Select(myAccountPageElements.countryDropDown);
        countrySelect.selectByVisibleText("United States");
        wait.until(ExpectedConditions.elementToBeClickable(myAccountPageElements.countryDropDown));
        Select state=new Select(myAccountPageElements.stateDropDown);
        state.selectByIndex(10);

        myAccountPageElements.yesRadioButton.click();
        myAccountPageElements.continueButton.click();

        System.out.println(myAccountPageElements.editAddedMessage.getText());

        myAccountPageElements.editButton.click();
        myAccountPageElements.address2Input.clear();
        myAccountPageElements.noRButton.click();
        myAccountPageElements.continueButton.click();

        System.out.println(myAccountPageElements.editUpdatedMessage.getText());
        Assert.assertEquals(myAccountPageElements.editUpdatedMessage.getText(), "Your address has been successfully updated");

        myAccountPageElements.deleteButton.click();
        System.out.println(myAccountPageElements.editDeletedMessage.getText());

        Assert.assertTrue(myAccountPageElements.successMessage.getText().toLowerCase().contains("success"));

    }

}
