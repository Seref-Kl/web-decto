package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "utils"},
        plugin = {
                "pretty"
        })
public class TestRunner extends AbstractTestNGCucumberTests {

}
