package utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.config.Config;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks {
        private WebDriver driver;

    @Before()
    public void beforeScenario() {
        String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("url");
        String implicityWait = ConfigReader.getProperty("implicityWait");
        driver = DriverManager.createDriver(browser, url, Integer.parseInt(implicityWait));
    }

    @After()
    public void afterScenario(Scenario scenario) {
        DriverManager.quitDriver();
    }


}
