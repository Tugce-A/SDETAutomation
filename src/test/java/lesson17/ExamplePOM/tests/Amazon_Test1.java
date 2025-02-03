package lesson17.ExamplePOM.tests;

import lesson17.ExamplePOM.pages.AmazonPage;
import lesson17.ExamplePOM.utilities.ConfigReader;
import lesson17.ExamplePOM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Amazon_Test1 {

    // Test to navigate to Amazon.com and search for a product manually
    @Test(priority = 1)
    public void test() {
        // Navigate to Amazon website using the URL defined in the configuration file
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Locate the search box using the driver and perform a search for "telefon"
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("telefon" + Keys.ENTER);

        // Locate the search result text element to validate the search result message
        WebElement sonucYazisiElementi = Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisiElementi.getText());

        // Assert that the search results are as expected (matches the given result count)
        Assert.assertTrue(sonucYazisiElementi.getText().equals("1-16 of 133 results for \"telefon\""));
    }

    // Test to perform the same search operation using Page Object Model (POM)
    @Test(priority = 2)
    public void testPOM() {

        // Navigate to Amazon website using the URL defined in the configuration file
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Initialize the AmazonPage object using the driver
        AmazonPage amazonPage = new AmazonPage(Driver.getDriver());

        // Use the search box WebElement from the Page Object to search for "nutella"
        amazonPage.aramaKutusu.sendKeys("nutella" + Keys.ENTER);

        // Print the search result text to the console
        System.out.println(amazonPage.sonucYazisiElementi.getText());

        // Assert that the search result contains the search term "nutella"
        Assert.assertTrue(amazonPage.sonucYazisiElementi.getText().contains("nutella"));
    }
}