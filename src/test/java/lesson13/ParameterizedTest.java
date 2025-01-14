package lesson13;

import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTest {
    /**
     * This test demonstrates a parameterized test with string values.
     * The test will run for each value provided in the @ValueSource annotation.
     *
     * @param names - The string values passed as parameters to the test.
     */
    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(strings = {"Jane", "Kevin", "Tom"}) // Provides a set of string parameters
    public void test(String names){
        System.out.println(names); // Prints each name to the console
    }

    /**
     * This test demonstrates a parameterized test with integer values.
     * The test will run for each value provided in the @ValueSource annotation.
     *
     * @param numbers - The integer values passed as parameters to the test.
     */
    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(ints = {7, 11, 4}) // Provides a set of integer parameters
    public void test2(int numbers){
        System.out.println(numbers); // Prints each number to the console
    }
}
