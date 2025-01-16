package lesson14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Example {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");
        String actualCurrentURL= driver.getCurrentUrl();
        String expectedURL = "https://www.google.com.tr/";

        Assert.assertEquals(actualCurrentURL,expectedURL);
    }
}
