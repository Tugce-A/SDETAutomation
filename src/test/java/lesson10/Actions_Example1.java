package lesson10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class Actions_Example1 {
    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = new FirefoxDriver();

        // Adding implicit wait of 10 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the target URL
        driver.get( "http://demo.guru99.com/test/newtours/");

        // Locate the "Home" link element
        WebElement link_Home = driver.findElement(By.linkText("Home"));

        // Locate the table cell containing the "Home" element
        WebElement td_Home = driver.findElement(By.xpath("//html/body/div" + "/table/tbody/tr/td" + "/table/tbody/tr/td" + "/table/tbody/tr/td" + "/table/tbody/tr"));



        // Create an Actions instance for mouse interactions
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder.moveToElement(link_Home).build();

        // Get and print the background color before hover
        String bgColor = td_Home.getCssValue("background-color");
        System.out.println("Before hover: " + bgColor);

        // Perform the mouse hover action
        mouseOverHome.perform();

        // Get and print the background color after hover
        bgColor = td_Home.getCssValue("background-color");
        System.out.println("After hover: " + bgColor);


        //driver.quit();
    }

}
