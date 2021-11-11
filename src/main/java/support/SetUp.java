package support;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SetUp {

    /**
     * Remote web driver variable
     */
    private static RemoteWebDriver driver;

    /**
     * Empty constructor for singleton class
     */
    private SetUp() {

    }

    /**
     * Method for instantiation of web driver
     * @return
     */
    public static WebDriver createDriver() {
        if (driver != null) {
            return driver;
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    /**
     * Method for closing driver
     */
    public static void quitDriver() {
        driver.quit();
        driver = null;
    }

}
