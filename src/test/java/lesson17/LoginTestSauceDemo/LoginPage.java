package lesson17.LoginTestSauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    // WebDriver instance to interact with the browser
    private final WebDriver driver;

    // Locators for the username input field, password input field, and login button
    private final By usernameLocator = By.id("user-name");
    private final By passwordLocator = By.id("password");
    private final By submitButtonLocator = By.id("login-button");

    // Locator for the dropdown menu (if applicable, to be implemented later)
    By dropdown = By.xpath("//dropdown");

    // Constructor to initialize the WebDriver instance
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter the username in the username text box
    public void enterUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    // Method to enter the password in the password text box
    public void enterPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    // Method to click the login button
    public void clickSubmitButton() {
        driver.findElement(submitButtonLocator).click();
    }
}