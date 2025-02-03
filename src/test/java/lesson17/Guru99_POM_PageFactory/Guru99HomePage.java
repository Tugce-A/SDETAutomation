package lesson17.Guru99_POM_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99HomePage {

    // WebDriver instance to interact with the browser
    WebDriver driver;

    // Locator for the username displayed on the home page using @FindBy annotation
    @FindBy(xpath = "//table//tr[@class='heading3']")
    WebElement homePageUserName;

    // Method to get the username displayed on the home page dashboard
    public String getHomePageDashboardUserName() {
        return homePageUserName.getText();
    }

    // Constructor to initialize the WebDriver and WebElements
    public Guru99HomePage(WebDriver driver) {
        this.driver = driver;

        // Initializes the WebElements using the PageFactory
        PageFactory.initElements(driver, this);
    }
}