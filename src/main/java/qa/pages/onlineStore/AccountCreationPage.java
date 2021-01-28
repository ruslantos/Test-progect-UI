package qa.pages.onlineStore;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.pages.BasePage;

public class AccountCreationPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    @FindBy(id = "customer_firstname")
    private WebElement firstnameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastnameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "postcode")
    private WebElement postcodeInput;

    @FindBy(id = "id_state")
    private WebElement stateSelector;

    @FindBy(id = "phone_mobile")
    private WebElement phoneMobileInput;

    @FindBy(id = "submitAccount")
    private WebElement submitAccountButton;

    @FindBy(id = "SubmitCreate")
    private WebElement submitCreateButton;

    @FindBy(id = "account-creation_form")
    private WebElement pageLocator;

    public AccountCreationPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("Wait page visible")
    public AccountCreationPage waitPageVisible() {
        wait.until(ExpectedConditions.visibilityOf(pageLocator));
        return this;
    }

    @Step("Set firstname")
    public AccountCreationPage setFirstname(String firstname) {
        firstnameInput.sendKeys(firstname);
        return this;
    }

    @Step("Set lastname")
    public AccountCreationPage setLastname(String lastname) {
        lastnameInput.sendKeys(lastname);
        return this;
    }

    @Step("Set password")
    public AccountCreationPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Set address")
    public AccountCreationPage setAdress(String address) {
        addressInput.sendKeys(address);
        return this;
    }

    @Step("Set city")
    public AccountCreationPage setCity(String city) {
        cityInput.sendKeys(city);
        return this;
    }

    @Step("Set phone")
    public AccountCreationPage setPhone(String phone) {
        phoneMobileInput.sendKeys(phone);
        return this;
    }

    @Step("Set Postcode")
    public AccountCreationPage setPostcode(String postcode) {
        postcodeInput.sendKeys(postcode);
        return this;
    }

    @Step("Select state")
    public AccountCreationPage selectState(String state) {
        Select select = new Select(stateSelector);
        select.selectByVisibleText(state);
        return this;
    }

    @Step("Click 'Register' button")
    public AccountHomePage clickRegisterButton() {
        submitAccountButton.click();
        return PageFactory.initElements(webDriver, AccountHomePage.class);
    }
}