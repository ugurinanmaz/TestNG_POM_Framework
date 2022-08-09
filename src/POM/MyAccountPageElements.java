package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPageElements {

    public MyAccountPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='My Account']")
    public WebElement myAccountHeader;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement successMessage;

    @FindBy(xpath = "(//a[text()='Newsletter'])[1]")
    public WebElement newsLetterButton;

    @FindBy(css = "input[value='1']")
    public WebElement yesRadioButton;

    @FindBy(css = "input[value='0']")
    public WebElement noRadioButton;

    @FindBy(css = "input[value='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "(//a[text()='Edit Account'])[1]")
    public WebElement editAccountButton;

    @FindBy(id = "input-firstname")
    public WebElement firstName;

    @FindBy(id = "input-lastname")
    public WebElement lastName;

    @FindBy(id = "input-email")
    public WebElement emailInput;

    @FindBy(id = "input-telephone")
    public WebElement telInput;

    @FindBy(xpath = "//a[text()='Address Book']")
    public WebElement addressBookButton;

    @FindBy(id = "input-company")
    public WebElement companyInput;

    @FindBy(id = "input-address-1")
    public WebElement address1Input;

    @FindBy(id = "input-address-2")
    public WebElement address2Input;

    @FindBy(id = "input-city")
    public WebElement cityInput;

    @FindBy(id = "input-postcode")
    public WebElement postcodeInput;

    @FindBy(id = "input-country")
    public WebElement countryDropDown;

    @FindBy(id = "input-zone")
    public WebElement stateDropDown;

    @FindBy(xpath = "(//input[@name='default'])[1]")
    public WebElement yesRButton;

    @FindBy(xpath = "(//input[@name='default'])[2]")
    public WebElement noRButton;

    @FindBy(xpath = "//a[text()='New Address']")
    public WebElement newAddressButton;

    @FindBy(xpath = "(//a[text()='Edit'])[1]")
    public WebElement editButton;

    @FindBy(xpath = "(//a[text()='Delete'])[2]")
    public WebElement deleteButton;

    @FindBy(xpath = "//*[text()=' Your address has been successfully added']")
    public WebElement editAddedMessage;

    @FindBy(xpath = "//*[text()=' Your address has been successfully updated']")
    public WebElement editUpdatedMessage;

    @FindBy(xpath = "//*[text()=' Your address has been successfully deleted']")
    public WebElement editDeletedMessage;




}
