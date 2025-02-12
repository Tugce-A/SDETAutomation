package lesson20.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/lesson20/features",
        glue = {"lesson20/stepDefinitions","lesson20/hooks"},
        plugin = {"pretty","html:target/cucumber-html-report.html","json:target/cucumber-json-report.json","junit:target/cucumber-junit-report.xml","rerun:target/rerun.txt"},
        tags = ("@test1 or @test2 or @test4 or @test6")
        //tags = ("@test1 and @test2")
        //tags = ("not @test2")
)

public class TestRunner {
}
