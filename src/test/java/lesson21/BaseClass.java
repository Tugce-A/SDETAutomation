package lesson21;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
    public WebDriver setBrowser(String browserName) throws MalformedURLException {
        WebDriver driver = null;
        DesiredCapabilities dc = new DesiredCapabilities();
        if(browserName.equalsIgnoreCase("chrome")) {
            dc.setBrowserName("chrome");
        } else if(browserName.equalsIgnoreCase("edge")) {
            dc.setBrowserName("MicrosoftEdge");
        }

        // Initiate RemoteWebDriver
        driver = new RemoteWebDriver(new URL("http://localhost:4444"),dc);
        return driver;
    }
}