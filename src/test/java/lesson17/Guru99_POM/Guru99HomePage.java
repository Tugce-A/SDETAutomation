package lesson17.Guru99_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99HomePage {

    // Constructor to initialize the WebDriver instance
    public Guru99HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // WebDriver instance to interact with the browser
    WebDriver driver;

    // Locator to find the user name displayed on the home page
    By homePageUserName = By.xpath("//table//tr[@class='heading3']");

    // Method to get the user name displayed on the home page dashboard
    public String getHomePageDashboardUserName() {
        return driver.findElement(homePageUserName).getText();
    }
}