package lesson17.Guru99_POM_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99Login {

    /**
     * All WebElements are identified by the @FindBy annotation
     */

    // WebDriver instance to interact with the browser
    WebDriver driver;

    // Locator for the username input field using @FindBy annotation
    @FindBy(name = "uid")
    WebElement user99GuruName;

    // Locator for the password input field using @FindBy annotation
    @FindBy(name = "password")
    WebElement password99Guru;

    // Locator for the title text on the login page using @FindBy annotation
    @FindBy(className = "barone")
    WebElement titleText;

    // Locator for the login button using @FindBy annotation
    @FindBy(name = "btnLogin")
    WebElement login;

    // Constructor to initialize WebDriver and WebElements
    public Guru99Login(WebDriver driver) {
        this.driver = driver;

        // Initializes the WebElements using the PageFactory
        PageFactory.initElements(driver, this);
    }

    // Method to set the username in the username text box
    public void setUserName(String strUserName) {
        user99GuruName.sendKeys(strUserName);
    }

    // Method to set the password in the password text box
    public void setPassword(String strPassword) {
        password99Guru.sendKeys(strPassword);
    }

    // Method to click on the login button
    public void clickLogin() {
        login.click();
    }

    // Method to get the title text of the login page
    public String getLoginTitle() {
        return titleText.getText();
    }

    /**
     * This POM method will be exposed in test cases to log in to the application.
     *
     * @param strUserName Username to be entered in the login form
     * @param strPasword Password to be entered in the login form
     */
    public void loginToGuru99(String strUserName, String strPasword) {
        // Fill in the username
        this.setUserName(strUserName);

        // Fill in the password
        this.setPassword(strPasword);

        // Click the Login button
        this.clickLogin();
    }
}