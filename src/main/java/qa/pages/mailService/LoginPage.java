package qa.pages.mailService;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.pages.BasePage;

public class LoginPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    @FindBy(name = "login")
    private WebElement userNameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(css = ".btn.btn-success")
    private WebElement loginbtn;

    @FindBy(css = "[data-testid='enter-password']")
    private WebElement enterPasswordButton;

    @FindBy(css = "[data-testid='login-to-mail']")
    private WebElement loginToMailButton;

    @FindBy(css = "[title='выход']")
    private WebElement logOutButton;

    @FindBy(xpath = "//div[contains(@class,'mailbox-container')]")
    private WebElement mailboxContainer;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("Wait page visible")
    public LoginPage waitPageVisible() {
        wait.until(ExpectedConditions.visibilityOf(mailboxContainer));
        return this;
    }

    @Step("Set username")
    public LoginPage setUsername(String username) {
        userNameInput.sendKeys(username);
        return this;
    }

    @Step("Set password")
    public LoginPage setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Click 'Submit password' Button")
    public LoginPage clickEnterPasswordButton() {
        enterPasswordButton.click();
        return this;
    }

    @Step("Click 'Login' Button")
    public MailHomePage clickLoginToMailButton() {
        loginToMailButton.click();
        return PageFactory.initElements(webDriver, MailHomePage.class);
    }
}