package lesson15;

// Importing necessary classes for WebDriver and TestNG functionalities
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GroupsExamples {
    // WebDriver instance to control the browser
    WebDriver driver;

    // Test method for the contact form page, included in the "contactFormPage" group
    @Test(groups = "contactFormPage")
    public void test01() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("a", "a");
        softAssert.assertAll();
        WebElement userName= driver.findElement(By.id("username"));
        userName.sendKeys("baris");
        // Prints a message specific to the contact form page
        System.out.println("Only works for contact form");
    }

    // Test method for the home page, included in the "homePage" and "regression" groups
    @Test(groups = {"homePage", "regression"})
    public void test02() {
        // Prints a message specific to the home page
        System.out.println("Only works for home page");
    }

    // Test method for regression testing, included in the "regression" group
    @Test(groups = "regression")
    public void test03() {
        // Prints a message specific to regression testing
        System.out.println("Only works for Regression Testing");
    }

    // Test method for the sustainability page, included in the "sustainabilityPage" group
    @Test(groups = "sustainabilityPage")
    public void test04() {
        // Prints a message specific to the sustainability page
        System.out.println("Only works for sustainability page");
    }

    // Test method for subpages, included in the "Subpages" group
    @Test(groups = "Subpages")
    public void subPages() {
        // Initializes the Chrome WebDriver
        driver = new ChromeDriver();

        // Navigates to different subpages
        driver.get("https://www.trendyol.com/butik/l");
        driver.navigate().to("https://www.trendyol.com/butik/liste/9/ayakkabi-canta");
        driver.navigate().back(); // Navigates back to the previous page
        driver.navigate().to("https://www.trendyol.com/butik/liste/5/elektronik");
    }
}
