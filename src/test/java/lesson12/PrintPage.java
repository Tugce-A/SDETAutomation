package lesson12;

import org.openqa.selenium.Pdf; // Import class for handling PDF files
import org.openqa.selenium.PrintsPage; // Import interface for printing page content
import org.openqa.selenium.WebDriver; // Import WebDriver interface
import org.openqa.selenium.chrome.ChromeDriver; // Import ChromeDriver for Chrome browser automation
import org.openqa.selenium.print.PageMargin; // Import class to define page margins
import org.openqa.selenium.print.PageSize; // Import class to define page size
import org.openqa.selenium.print.PrintOptions; // Import class to define print options

public class PrintPage { // Main class definition
    public static void main(String[] args) { // Main method entry point
        // Uncomment the desired method to test specific functionality
        // TestOrientation(); // Call the method to test orientation settings
        // TestMargin(); // Call the method to test margin settings
        //TestSize();
    }

    // Method to test the ability to set and retrieve the print orientation
    public static void TestOrientation() {
        WebDriver driver = new ChromeDriver(); // Create a new ChromeDriver instance
        driver.manage().window().maximize(); // Maximize the browser window
        driver.get("https://www.selenium.dev/"); // Navigate to the Selenium website
        PrintOptions printOptions = new PrintOptions(); // Create a PrintOptions instance
        printOptions.setOrientation(PrintOptions.Orientation.PORTRAIT); // Set print orientation to Portrait
        PrintOptions.Orientation current_orientation = printOptions.getOrientation(); // Retrieve the current orientation
        System.out.println(current_orientation); // Print the current orientation to the console
    }

    // Method to test the ability to set and retrieve the page range for printing
    public static void TestRange() {
        WebDriver driver = new ChromeDriver(); // Create a new ChromeDriver instance
        driver.get("https://www.selenium.dev/"); // Navigate to the Selenium website
        PrintOptions printOptions = new PrintOptions(); // Create a PrintOptions instance
        printOptions.setPageRanges("1-2"); // Set the page range to pages 1 to 2
        String[] current_range = printOptions.getPageRanges(); // Retrieve the set page ranges as an array
        System.out.println(current_range.length); // Print the number of pages in the range to the console
    }

    // Method to test the ability to set and retrieve the page size for printing
    public static void TestSize() {
        WebDriver driver = new ChromeDriver(); // Create a new ChromeDriver instance
        driver.get("https://www.selenium.dev/"); // Navigate to the Selenium website
        PrintOptions printOptions = new PrintOptions(); // Create a PrintOptions instance
        printOptions.setPageSize(new PageSize(27.94, 21.59)); // Set the page size to A4 dimensions in cm
        double currentHeight = printOptions.getPageSize().getHeight(); // Retrieve the height of the page size
        double currentWidth = printOptions.getPageSize().getWidth(); // Retrieve the width of the page size
        System.out.println("Page Height: " + currentHeight); // Print the page height to the console
        System.out.println("Page Weight " + currentWidth); // Print the page width to the console
    }

    // Method to test the ability to set and retrieve page margins for printing
    public static void TestMargin() {
        WebDriver driver = new ChromeDriver(); // Create a new ChromeDriver instance
        driver.get("https://www.selenium.dev/"); // Navigate to the Selenium website
        PrintOptions printOptions = new PrintOptions(); // Create a PrintOptions instance
        PageMargin margins = new PageMargin(1.0, 1.0, 1.0, 1.0); // Define page margins with 1.0 units on all sides
        printOptions.setPageMargin(margins); // Set the margins in the PrintOptions instance
        double topMargin = margins.getTop(); // Retrieve the top margin value
        double bottomMargin = margins.getBottom(); // Retrieve the bottom margin value
        double leftMargin = margins.getLeft(); // Retrieve the left margin value
        double rightMargin = margins.getRight(); // Retrieve the right margin value
        System.out.println("Margins - Top: " + topMargin + ", Bottom: " + bottomMargin +
                ", Left: " + leftMargin + ", Right: " + rightMargin); // Print all margin values
    }

    // Method to test the ability to set and retrieve the scale factor for printing
    public static void TestScale() {
        WebDriver driver = new ChromeDriver(); // Create a new ChromeDriver instance
        driver.get("https://www.selenium.dev/"); // Navigate to the Selenium website
        PrintOptions printOptions = new PrintOptions(); // Create a PrintOptions instance
        printOptions.setScale(0.50); // Set the scale factor to 50%
        double current_scale = printOptions.getScale(); // Retrieve the current scale factor
        System.out.println("Current Scale: " + current_scale); // Print the scale factor to the console
    }

    // Method to test the ability to include background graphics in the printed page
    public static void TestBackground() {
        WebDriver driver = new ChromeDriver(); // Create a new ChromeDriver instance
        driver.get("https://www.selenium.dev/"); // Navigate to the Selenium website
        PrintOptions printOptions = new PrintOptions(); // Create a PrintOptions instance
        printOptions.setBackground(true); // Enable background graphics in the print options
        boolean current_background = printOptions.getBackground(); // Retrieve the current background setting
        System.out.println("Background Enabled: " + current_background); // Print the background setting
    }

    // Method to test the ability to enable shrink-to-fit functionality for printing
    public static void TestShrinkToFit() {
        WebDriver driver = new ChromeDriver(); // Create a new ChromeDriver instance
        driver.get("https://www.selenium.dev/"); // Navigate to the Selenium website
        PrintOptions printOptions = new PrintOptions(); // Create a PrintOptions instance
        printOptions.setShrinkToFit(true); // Enable shrink-to-fit functionality
        boolean current_shrink_to_fit = printOptions.getShrinkToFit(); // Retrieve the current shrink-to-fit setting
        System.out.println("Shrink-to-Fit Enabled: " + current_shrink_to_fit); // Print the shrink-to-fit setting
    }

    // Method to test printing a page using the PrintsPage interface
    public static void PrintWithPrintsPageTest() {
        WebDriver driver = new ChromeDriver(); // Create a new ChromeDriver instance
        driver.get("https://www.selenium.dev/"); // Navigate to the Selenium website
        PrintsPage printer = (PrintsPage) driver; // Cast the WebDriver instance to PrintsPage
        PrintOptions printOptions = new PrintOptions(); // Create a PrintOptions instance
        Pdf printedPage = printer.print(printOptions); // Print the page and retrieve it as a Pdf object
        if (printedPage == null) { // Check if the printed page is null
            throw new AssertionError("Assertion failed: Printed page is null!"); // Throw an error if the page is null
        }
        System.out.println("Printed page successfully generated."); // Print success message if the page is valid
    }
}


