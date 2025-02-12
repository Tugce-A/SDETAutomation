package lesson20.runner;

import io.cucumber.junit.CucumberOptions;


@CucumberOptions(
features = "@target/rerun.txt",
glue="lesson20/stepDefinitions",
plugin = {"pretty","rerun:target/failed-cucumber-html-report.html"})

public class FailedTestRunner extends TestRunner {
}
