package lesson18.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/lesson18/resources",
        glue = {"lesson18/stepdefinitions"},
        plugin = {"pretty","html:target/cucumber-html-report.html"},
        tags = ""
)
public class Runner {
}
