package lesson21;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class TestTwo extends BaseClass {
    public WebDriver driver = null;
    @Test
    public void testTwo() {

        // launch application
        driver.get("https://www.tutorialspoint.com/selenium/practice/links.php");

        // get page title
        System.out.println("Page title is: " + driver.getTitle() + " obtained from testTwo");
    }
    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver = setBrowser("edge");
    }

    @AfterMethod
    public void tearDown() {

        // quitting browser
        driver.quit();
    }
}