package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BrowserStackDemoSeleniumTask1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bstackdemo.com/");

        // *Task 1: Count Products and Validate Text*
        // Locate product elements using CSS Selector
        List<WebElement> products = driver.findElements(By.cssSelector(".shelf-item"));
        List<WebElement> products2 = driver.findElements(By.className("shelf-item"));
        List<WebElement> products3 = driver.findElements(By.xpath("//div[@class='shelf-item']"));

        //Total number of products
        System.out.println("Total number of products: " + products.size());

        //Validate that the text "25 Product(s) found." is displayed using isDisplayed()
        String productCountGetText = driver.findElement(By.className("products-found")).getText();
        System.out.println(productCountGetText);

        WebElement productCountText = driver.findElement(By.className("products-found"));
        System.out.println("Is the text '25 Product(s) found.' displayed? " + productCountText.isDisplayed());




        // **Task 2: Count iPhone Devices and List Their Models**
        // Locate iPhone products using XPath locator
        List<WebElement> iPhoneDevices = driver.findElements(By.xpath("//p[contains(text(),'iPhone')]"));
        System.out.println("Number of iPhones on the page: " + iPhoneDevices.size());

        // Print the models of iPhones with for loop
        for (int i = 0; i < iPhoneDevices.size(); i++) {
            WebElement iPhone = iPhoneDevices.get(i);
            System.out.println("iPhone Model: " + iPhone.getText());
        }
        //Or you can use enhanced for loop
        // for (WebElement iPhone : iPhoneDevices) {
        //            System.out.println("iPhone Model: " + iPhone.getText());
        //        }




        // ***Task 3: Count "Add to Cart" Buttons and Interact***
        // Locate "Add to cart" buttons using CSS Selector
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector(".shelf-item__buy-btn"));
        System.out.println("Number of Add Cart Button: " + addToCartButtons.size());

        // Click the fourth "Add to cart" button (index starts from 0)
        addToCartButtons.get(3).click();




        // ****Task 4: Login and Cart Validation****
        // Click the Sign In Link
        WebElement signInLink = driver.findElement(By.cssSelector("#signin"));
        signInLink.click();

        Thread.sleep(3000);
        // Enter the username in userNameField
        WebElement usernameField = driver.findElement(By.id("react-select-2-input"));

        usernameField.sendKeys("demouser");
        usernameField.sendKeys(Keys.ENTER);

        // Enter the username in passwordField
        WebElement passwordField = driver.findElement(By.id("react-select-3-input"));
        passwordField.sendKeys("testingisfun99");
        passwordField.sendKeys(Keys.ENTER);

        // Click the LOG IN button
        WebElement loginButton = driver.findElement(By.id("login-btn"));
        loginButton.click();

        Thread.sleep(3000);

        // Validate login by checking the presence of the Logout Link
        WebElement logoutLink = driver.findElement(By.id("logout"));
        boolean isLoggedIn = logoutLink.isDisplayed();
        System.out.println("User logged in successfully. " + isLoggedIn);

        // Locate the first product and its name by XPath
        // WebElement firstProduct = driver.findElement(By.xpath(" (//p[@class='shelf-item__title'])[1]"));
        // String firstProductName = firstProduct.getText();
        // System.out.println("First product name: " + firstProductName);

        // Locate the first product and its name by CSS Selectors
        List<WebElement> allProductTitles = driver.findElements(By.cssSelector(".shelf-item__title"));
        String firstProductName = allProductTitles.getFirst().getText();
        System.out.println("First product name: " + firstProductName);

        // Click "Add to cart" for the first product
        List<WebElement> addToCartButtonsAfterLogin = driver.findElements(By.cssSelector(".shelf-item__buy-btn"));
        addToCartButtonsAfterLogin.getFirst().click();

        Thread.sleep(3000);

        // Validate cart count updates to 2
        WebElement cartCount = driver.findElement(By.xpath("//span[@class='bag__quantity']"));
        System.out.println("Cart count: " + cartCount.getText());

        //Close the cart with X button
        WebElement closeCartButton = driver.findElement(By.cssSelector(".float-cart__close-btn"));
        closeCartButton.click();
        Thread.sleep(3000);

        //Locate the cart icon and open it
        WebElement openCart = driver.findElement(By.cssSelector(".bag.bag--float-cart-closed"));
        openCart.click();
        Thread.sleep(3000);

        //Validate product name
        String expectedProduct1 = "iPhone 12 Pro";
        String expectedProduct2 = "iPhone 12";


        List<WebElement> productNamesOnCart = driver.findElements(By.xpath("//p[@class='title']"));

        boolean isValidationSuccessful = true; // Flag variable to track validation status

        for (WebElement product : productNamesOnCart) {
            String productNameOnCartText = product.getText(); // Get the product name text

            if (productNameOnCartText.contains(expectedProduct1) || productNameOnCartText.contains(expectedProduct2)) {
                System.out.println("Product found in cart: " + productNameOnCartText);
            } else {
                isValidationSuccessful = false; // Mark validation as failed if an unexpected product is found
                System.out.println("Validation Failed. Unexpected product in cart: " + productNameOnCartText);
            }
        }

        // Check the overall result after the loop
        if (isValidationSuccessful) {
            System.out.println("The product cart contains the correct products.");
        } else {
            System.out.println("Product cart validation failed.");
        }

        //Locate and Click the Logout link
        WebElement logOutLink = driver.findElement(By.cssSelector("#logout"));
        logOutLink.click();
        Thread.sleep(3000);

        //Verify Sign In Link2 is displayed successfully
       WebElement signInLink2 = driver.findElement(By.cssSelector("#signin"));
        if (signInLink2.isDisplayed()) {
            System.out.println("User logged out successfully.");
        } else {
            System.out.println("Logout Failed");
        }
        //driver.quit();
    }
}
