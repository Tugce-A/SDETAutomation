package lesson13;

import org.junit.*;

public class TestAnnotations {

    /**
     * This method is executed once before all tests in the class.
     * It is used for setting up resources that are shared across all tests.
     * Annotated with @BeforeClass in JUnit 4.
     */
    @BeforeClass
    public static void BeforeClass() {
        System.out.println("Before Tests"); // Indicates the start of the test suite
    }

    /**
     * This method is executed before each test method in the class.
     * It is used for initializing resources or setting up conditions specific to individual tests.
     * Annotated with @Before in JUnit 4.
     */
    @Before
    public void BeforeTest() {
        System.out.println("Before Test"); // Indicates the setup for an individual test
    }

    /**
     * This is a test method where the actual test logic is written.
     * Annotated with @Test in JUnit 4.
     */
    @Test
    public void MyTest() {
        System.out.println("My Tests"); // Represents the test execution
    }

    /**
     * This method is executed after each test method in the class.
     * It is used for cleaning up resources or resetting states after a test.
     * Annotated with @After in JUnit 4.
     */
    @After
    public void AfterTest() {
        System.out.println("After Test"); // Indicates cleanup after an individual test
    }

    /**
     * This method is executed once after all tests in the class.
     * It is used for cleaning up shared resources or performing final actions after the test suite.
     * Annotated with @AfterClass in JUnit 4.
     */
    @AfterClass
    public static void AfterClass() {
        System.out.println("AfterClass"); // Indicates the end of the test suite
    }
}
