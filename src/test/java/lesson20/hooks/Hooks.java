package lesson20.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lesson20.utilities.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp() {
        Driver.getDriver();
    }

    @After
    public void tearDown(Scenario sc){
        if (sc.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            sc.attach(screenshot, "image/png", "Screenshot attached for failed scenario");
        }
        else
        {TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            sc.attach(screenshot, "image/png", "Screenshot attached for successful scenario");}
        Driver.quitDriver();
    }
}
