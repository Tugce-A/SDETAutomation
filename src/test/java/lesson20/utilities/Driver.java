package lesson20.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null){
            driver = new ChromeDriver();
        }
        return driver;
    }
    public static void quitDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }

}
