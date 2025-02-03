package lesson17.ExamplePOM.tests;

import lesson17.ExamplePOM.pages.AmazonPage;
import lesson17.ExamplePOM.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Amazon_Test2 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        // Navigate to the Amazon homepage
        driver.get("https://www.amazon.com/");

        // Select the "Books" category from the dropdown menu
        AmazonPage amazonPage = new AmazonPage(driver);
        Select select = new Select(amazonPage.dropdownMenu);
        select.selectByVisibleText("Books");

        // Perform a search for "java"
        amazonPage.aramaKutusu.sendKeys("java" + Keys.ENTER);

        // Print the number of search results to the console
        System.out.println(amazonPage.sonucYazisiElementi.getText());

        // Verify that the name of the first product contains the word "Java"
        Assert.assertTrue(amazonPage.ilkUrunIsim.getText().contains("Java"));
    }
}