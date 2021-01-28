package qa.pages.onlineStore;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.pages.BasePage;

public class MainStorePage extends BasePage {

    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    @FindBy(className = "login")
    private WebElement signInButton;

    @FindBy(id = "email_create")
    private WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement submitCreateButton;

    @FindBy(xpath = "//div[contains(@class,'header-container')]")
    private WebElement pageLocator;

    public MainStorePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("Wait page visible")
    public MainStorePage waitPageVisible() {
        wait.until(ExpectedConditions.visibilityOf(pageLocator));
        return this;
    }

    @Step("Click 'Sign in'")
    public MainStorePage clickSignInButton() {
        signInButton.click();
        return this;
    }

    @Step("Set email")
    public MainStorePage setEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Click 'Create an account' Button")
    public AccountCreationPage submitCreateButton() {
        submitCreateButton.click();
        return PageFactory.initElements(webDriver, AccountCreationPage.class);
    }
}