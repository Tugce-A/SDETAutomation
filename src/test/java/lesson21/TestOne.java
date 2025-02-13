package lesson21;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class TestOne extends BaseClass {
    public WebDriver driver = null;
    @Test
    public void testOne() {

        // launch application
        driver.get("https://www.tutorialspoint.com/selenium/practice/links.php");

        // get page title
        System.out.println("Page title is: " + driver.getTitle() + " obtained from testOne");
    }
    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver = setBrowser("chrome");
    }
    @AfterMethod
    public void tearDown() {

        // quitting browser
        driver.quit();
    }
}