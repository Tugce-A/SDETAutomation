package lesson17.LoginTestSauceDemo;

import org.testng.annotations.Test;

public class LoginTest extends BaseTestDriver {

    /**
     * Test to log in with valid credentials
     * - Enters a valid username and password
     * - Clicks the login button
     * - Expected outcome: Successful login (further validation can be added)
     */
    @Test(priority = 1)
    public void validCredentialsLogin() {
        loginPage.enterUsername("standard_user");  // Enter valid username
        loginPage.enterPassword("secret_sauce");   // Enter valid password
        loginPage.clickSubmitButton();             // Submit the login form
    }

    /**
     * Test to log in with invalid credentials
     * - Enters an invalid username and valid password
     * - Clicks the login button
     * - Expected outcome: Login failure with an error message (further validation can be added)
     */
    @Test(priority = 2)
    public void invalidCredentialsLogin() {
        loginPage.enterUsername("dummy");          // Enter invalid username
        loginPage.enterPassword("secret_sauce");   // Enter valid password
        loginPage.clickSubmitButton();             // Submit the login form
    }
}
