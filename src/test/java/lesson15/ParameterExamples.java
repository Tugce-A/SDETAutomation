package lesson15;

// Importing necessary classes for TestNG functionalities
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterExamples {

    // Method demonstrating how to use TestNG parameters with annotations
    // Uncommented examples below show different parameter combinations that can be used with TestNG

    // @Parameters({"browser", "baseURL"})
    // @Test
    // public void method(String browser, String baseURL) {
    //     // Prints the values of browser and baseURL parameters
    //     System.out.println(browser);
    //     System.out.println(baseURL);
    // }

    // Test method using parameters "messaging" and "numbers"
    @Parameters({"messaging", "numbers"}) // Defines the parameters to be passed to this test method
    @Test
    public void messagingMethod(String messaging, String numbers) {
        // Prints the value of the "messaging" parameter
        System.out.println(messaging);

        // Prints the value of the "numbers" parameter
        System.out.println(numbers);
    }
}
