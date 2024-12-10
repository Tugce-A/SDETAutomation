package lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeworkOrangeHRMSeleniumTask1 {

    public static void main(String[] args) throws InterruptedException {

        // Configure ChromeOptions to start maximized
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        // Configure browser to maximized
        driver.manage().window().maximize();

        // Navigate to the OrangeHRM Demo Login Page
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Allow the page to load (basic sleep)
        Thread.sleep(2000);

        // Locate and enter Username
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");

        // Locate and enter Password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        // Locate and click the Login button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        // Wait for the Dashboard page to load (basic sleep)
        Thread.sleep(2000);

        // Validate the Dashboard title
        WebElement dashboardHeader = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String actualHeaderText = dashboardHeader.getText();
        String expectedHeaderText = "Dashboard";

        if (actualHeaderText.equals(expectedHeaderText)) {
            System.out.println("Test Passed: Dashboard header text is correct.");
        } else {
            System.out.println("Test Failed: Expected '" + expectedHeaderText + "', but got '" + actualHeaderText + "'.");
        }

        // Log out from the application
        WebElement profileDropdown = driver.findElement(By.cssSelector(".oxd-userdropdown-name"));
        profileDropdown.click();

        // Wait for the dropdown to appear (basic sleep)
        Thread.sleep(1000);

        WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Logout']"));
        logoutButton.click();

        // Wait for redirection to the login page (basic sleep)
        Thread.sleep(2000);

        // Verify redirection to the login page
        WebElement loginPanel = driver.findElement(By.cssSelector("div.orangehrm-login-branding"));
        if (loginPanel.isDisplayed()) {
            System.out.println("Successfully logged out.");
        } else {
                System.out.println("Log out failed.");
        }

        // Clean up: Close the browser
        driver.quit();
        }
    }
