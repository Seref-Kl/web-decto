package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class DriverManager {
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return driverThread.get();
    }

    public static void quitDriver() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
            driverThread.remove();
        }
    }

    public static WebDriver createDriver(String browser, String url, int implictyWait) {
        WebDriver driver;
        switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                WebDriverManager.chromedriver().clearDriverCache().setup();
                WebDriverManager.chromedriver().clearResolutionCache().setup();
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser type provided!");
        }
        driverThread.set(driver);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implictyWait));
        driver.findElement(By.cssSelector("a.kvkk_notification_btn")).click();
        return driver;
    }
}
