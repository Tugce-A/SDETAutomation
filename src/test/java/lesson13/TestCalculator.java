package lesson13;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestCalculator {

    /**
     * This test verifies the addition functionality.
     * - Calls the `add` method with parameters 7 and 4.
     * - Asserts that the result is equal to 11.
     */
    @Test
    public void testAddition() {
        assertEquals(12, TestCalculator.add(7, 4)); // Checks if the sum of 7 and 4 equals 11
    }

    /**
     * This test verifies the subtraction functionality.
     * - Calls the `subtract` method with parameters 3 and 2.
     * - Asserts that the result is equal to 1.
     */
    @Test
    public void testSubtraction() {
        assertEquals(1, TestCalculator.subtract(3, 2)); // Checks if subtracting 2 from 3 equals 1
    }

    /**
     * This method performs addition of two integers.
     *
     * @param a - First integer
     * @param b - Second integer
     * @return Sum of a and b
     */
    public static int add(int a, int b) {
        return a + b; // Returns the sum of the two integers
    }

    /**
     * This method performs subtraction of two integers.
     *
     * @param x - First integer
     * @param y - Second integer
     * @return Result of subtracting y from x
     */
    public static int subtract(int x, int y) {
        return x - y; // Returns the result of subtracting y from x
    }
}
