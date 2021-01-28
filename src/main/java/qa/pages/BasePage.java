package qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriverWait wait;
    protected WebDriver webDriver;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}