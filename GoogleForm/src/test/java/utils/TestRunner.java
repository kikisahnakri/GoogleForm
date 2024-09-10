package utils;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepsDefinition", "utils"},
        tags = "@SmokeTest",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}

)

public class TestRunner {
}
