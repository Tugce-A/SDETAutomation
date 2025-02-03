package lesson17.Guru99_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99Login {

    // WebDriver instance to interact with the browser
    WebDriver driver;

    // Locator for the username input field
    By user99GuruName = By.name("uid");

    // Locator for the password input field
    By password99Guru = By.name("password");

    // Locator for the title text on the login page
    By titleText = By.className("barone");

    // Locator for the login button
    By login = By.name("btnLogin");

    // Constructor to initialize the WebDriver instance
    public Guru99Login(WebDriver driver) {
        this.driver = driver;
    }

    // Method to set the username in the username text box
    public void setUserName(String strUserName) {
        driver.findElement(user99GuruName).sendKeys(strUserName);
    }

    // Method to set the password in the password text box
    public void setPassword(String strPassword) {
        driver.findElement(password99Guru).sendKeys(strPassword);
    }

    // Method to click on the login button
    public void clickLogin() {
        driver.findElement(login).click();
    }

    // Method to get the title text of the login page
    public String getLoginTitle() {
        return driver.findElement(titleText).getText();
    }

    /**
     * This POM method will be exposed in the test cases to log in to the application.
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