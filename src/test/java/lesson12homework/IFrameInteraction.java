package lesson12homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameInteraction {
    public static void main(String[] args) {

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the webpage
            driver.get("https://the-internet.herokuapp.com/nested_frames");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Switch to the top frame
            driver.switchTo().frame("frame-top");

            // Switch to the left frame and validate its content
            driver.switchTo().frame("frame-left");
            WebElement leftContent = driver.findElement(By.tagName("body"));
            System.out.println("Left Frame Content: " + leftContent.getText());

            // Switch back to the top frame and then to the middle frame
            driver.switchTo().parentFrame();
            driver.switchTo().frame("frame-middle");
            WebElement middleContent = driver.findElement(By.id("content"));
            System.out.println("Middle Frame Content: " + middleContent.getText());

            // Switch back to the top frame and then to the right frame
            driver.switchTo().parentFrame();
            driver.switchTo().frame("frame-right");
            WebElement rightContent = driver.findElement(By.tagName("body"));
            System.out.println("Right Frame Content: " + rightContent.getText());

            // Switch back to the main content and then to the bottom frame
            driver.switchTo().defaultContent();
            driver.switchTo().frame("frame-bottom");
            WebElement bottomContent = driver.findElement(By.tagName("body"));
            System.out.println("Bottom Frame Content: " + bottomContent.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            //driver.quit();
        }
    }
}
