package qa.pages.mailService;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.pages.BasePage;

public class MailHomePage extends BasePage {
    public MailHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(className = "application-mail")
    private WebElement pageLocator;

    @FindBy( id= "PH_logoutLink")
    private WebElement logOutButton;

    @FindBy( id= "PH_user-email")
    private WebElement userEmail;

    @Step
    public MailHomePage waitPageVisible(){
        wait.until(ExpectedConditions.visibilityOf (pageLocator));
        return this;
    }

    @Step("click 'LogOut'")
    public MailHomePage clickLogOutButton(){
        logOutButton.click();
        return this;
    }

    @Step("Get username value")
    public String getUserEmail(){
        return userEmail.getText();
    }
}