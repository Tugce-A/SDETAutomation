package lesson16;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenshotParticularElement {

    @Test
    public void way1() throws IOException {

        // Initialize browser
        WebDriver driver = new ChromeDriver();

        //navigate to url
        driver.get("https://demoqa.com");

        // Locate the element on the web page
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"app\"]/header/a/img"));

        // Get screenshot of the visible part of the web page
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Convert the screenshot into BufferedImage
        BufferedImage fullScreen = ImageIO.read(screenshot);

        //Find location of the webelement logo on the page
        Point location = logo.getLocation();

        //Find width and height of the located element logo
        int width = logo.getSize().getWidth();
        int height = logo.getSize().getHeight();

        //cropping the full image to get only the logo screenshot
        BufferedImage logoImage = fullScreen.getSubimage(location.getX(), location.getY(),
                width, height);
        ImageIO.write(logoImage, "png", screenshot);

        //Save cropped Image at destination location physically.
        FileUtils.copyFile(screenshot, new File("src/test/java/lesson16/particularElementScreenshot.PNG"));

        driver.quit();
    }

@Test
        public void way2() throws IOException {

            // Initialize browser
            WebDriver driver = new ChromeDriver();

            //navigate to url
            driver.get("https://demoqa.com");

            // Locate the web element
            WebElement logo = driver.findElement(By.xpath("//*[@id=\"app\"]/header/a/img"));

            // capture screenshot with getScreenshotAs() of the WebElement class
            File f = logo.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(f, new File("src/test/java/lesson16/logoScreeshot.png"));

            driver.close();
        }
}
