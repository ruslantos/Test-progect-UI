package qa.pages.onlineStore;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.pages.BasePage;

public class AccountHomePage extends BasePage {

    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    @FindBy(className = "header_user_info")
    private WebElement userInfo;

    @FindBy(id = "account-creation_form")
    private WebElement pageLocator;

    public AccountHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("Wait page visible")
    public AccountHomePage waitPageVisible() {
        wait.until(ExpectedConditions.visibilityOf(pageLocator));
        return this;
    }

    @Step("Get accountName")
    public String getAccountName() {
        return userInfo.getText();
    }
}