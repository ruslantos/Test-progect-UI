package qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String name) {
        WebDriver driver = null;
        if ("CHROME".equalsIgnoreCase(name)) {
            System.setProperty("webdriver.chrome.driver", "src/main/java/qa/util/driver/chromewebdriver/87/chromedriver.exe");
            driver = new ChromeDriver();
        } else if ("FIREFOX".equalsIgnoreCase(name)) {
            System.setProperty("webdriver.gecko.driver", "src/main/java/qa/util/driver/geckodriver/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }
}