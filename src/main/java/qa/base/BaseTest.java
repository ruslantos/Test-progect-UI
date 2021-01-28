package qa.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import qa.util.PropertyLoader;
import qa.util.ScreenshotUtils;
import qa.util.WebDriverFactory;

public class BaseTest {
    public static WebDriver webDriver;
    public static String username;
    public static String password;
    protected String websiteUrl;
    protected String onlineStoreUrl;

    @BeforeClass
    public void init() {
        websiteUrl = PropertyLoader.loadProperty("site.url");
        onlineStoreUrl = PropertyLoader.loadProperty("site2.url");
        username = PropertyLoader.loadProperty("user.username");
        password = PropertyLoader.loadProperty("user.password");
        webDriver = WebDriverFactory.getDriver(PropertyLoader.loadProperty("browser.name"));
        webDriver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) {
        if (testResult.getStatus() != ITestResult.SUCCESS) {
            ScreenshotUtils.screenshot(webDriver);
        }
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}