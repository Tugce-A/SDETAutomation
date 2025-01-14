package lesson12homework;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class CookiesManagement {
    public static void main(String[] args) {

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the webpage
            driver.get("https://www.browserstack.com/test-on-the-right-mobile-devices");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Add a new cookie
            Cookie newCookie = new Cookie("testCookie", "testValue");
            driver.manage().addCookie(newCookie);
            System.out.println("Cookie added: " + newCookie);

            // Retrieve all cookies
            Set<Cookie> cookies = driver.manage().getCookies();
            System.out.println("All Cookies:");
            for (Cookie cookie : cookies) {
                System.out.println(cookie);
            }

            // Validate the added cookie
            Cookie retrievedCookie = driver.manage().getCookieNamed("testCookie");
            if (retrievedCookie != null && retrievedCookie.getValue().equals("testValue")) {
                System.out.println("Test Passed: Cookie is added successfully.");
            } else {
                System.out.println("Test Failed: Cookie is not found or value is incorrect.");
            }

            // Delete a specific cookie by name
            driver.manage().deleteCookieNamed("testCookie");
            System.out.println("Cookie 'testCookie' deleted.");

            // Validate the deletion
            if (driver.manage().getCookieNamed("testCookie") == null) {
                System.out.println("Test Passed: Cookie deletion is successful.");
            } else {
                System.out.println("Test Failed: Cookie deletion is unsuccessful.");
            }

            // Delete all cookies
            driver.manage().deleteAllCookies();
            System.out.println("All cookies deleted.");

            // Validate all cookies are deleted
            if (driver.manage().getCookies().isEmpty()) {
                System.out.println("Test Passed: All cookies are deleted successfully.");
            } else {
                System.out.println("Test Failed: Some cookies are still present.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            //driver.quit();
        }
    }
}
