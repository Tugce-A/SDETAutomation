package lesson19.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lesson19.utilities.Driver;

public class Hooks {

    @Before
    public void setUp() {
        Driver.getDriver();
    }

    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}
