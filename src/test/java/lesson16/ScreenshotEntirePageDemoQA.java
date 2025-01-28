package lesson16;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenshotEntirePageDemoQA {
    public static void main(String[] args) throws IOException {

        // Initialize browser
        WebDriver driver = new ChromeDriver();

        //navigate to url
        driver.get("https://demoqa.com");


        // capture screenshot and store the image
        Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(s.getImage(),"PNG",new File("src/test/java/lesson16/fullPageScreenshotDemoQA.png"));

        //closing the webdriver
        driver.close();
    }
}