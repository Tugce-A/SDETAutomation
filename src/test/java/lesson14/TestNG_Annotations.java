package lesson14;

// Import necessary TestNG annotations
import org.testng.annotations.*;

public class TestNG_Annotations {

    // This method runs before the entire test suite starts
    @BeforeSuite
    public void test1() {
        System.out.println("1");
    }

    // This method runs before any test within the <test> tag in the XML file
    @BeforeTest
    public void test2() {
        System.out.println("2");
    }

    // This method runs before the first method in the current class
    @BeforeClass
    public void test3() {
        System.out.println("3");
    }

    // This method runs before methods in the specified groups are executed
    @BeforeGroups
    public void test4() {
        System.out.println("4");
    }

    // This method runs before each test method in the class
    @BeforeMethod
    public void test5() {
        System.out.println("5");
    }

    // The following are test methods that will execute as part of the test
    @Test
    public void test6() {
        System.out.println("6");
    }

    @Test
    public void test7() {
        System.out.println("6");
    }

    @Test
    public void test8() {
        System.out.println("6");
    }

    @Test
    public void test9() {
        System.out.println("6");
    }

    // This method runs after the entire test suite has finished execution
    @AfterSuite
    public void test1TearDown() {
        System.out.println("Terminate suite in test1");
    }
}
