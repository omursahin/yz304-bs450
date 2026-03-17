package eru.testing;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for MathUtils.
 *
 * Complete each test method following the Arrange-Act-Assert (AAA) pattern.
 * Replace the TODO comments with appropriate assertions.
 */
public class MathUtilsTest {

    // ==================== factorial ====================

    @Test
    public void factorial_zero_returnsOne() {
        // Arrange: n = 0
        // Act: call factorial(0)
        // Assert: result should be 1 (0! = 1)
        // TODO: Hint: assertEquals(expected, MathUtils.factorial(0))
    }

    @Test
    public void factorial_positiveNumber_returnsCorrectResult() {
        // Arrange & Act & Assert: test factorial(5) = 120
        // TODO: Hint: 5! = 5 * 4 * 3 * 2 * 1 = 120
    }

    @Test
    public void factorial_one_returnsOne() {
        // Test that factorial(1) returns 1
        // TODO: implement this test
    }

    @Test
    public void factorial_negativeNumber_throwsException() {
        // Arrange: n = -1
        // Act & Assert: should throw IllegalArgumentException
        // TODO: Hint: use assertThrows(IllegalArgumentException.class, () -> { ... })
    }

    @Test
    public void factorial_largeNumber_returnsCorrectResult() {
        // Test factorial(10) = 3628800
        // TODO: implement this test
    }

    // ==================== isPrime ====================

    @Test
    public void isPrime_two_returnsTrue() {
        // 2 is the smallest prime number
        // TODO: Hint: assertTrue or assertThat
    }

    @Test
    public void isPrime_one_returnsFalse() {
        // 1 is not a prime number
        // TODO: implement this test
    }

    @Test
    public void isPrime_negativeNumber_returnsFalse() {
        // Negative numbers are not prime
        // TODO: implement this test
    }

    @Test
    public void isPrime_compositNumber_returnsFalse() {
        // Test with a composite number (e.g., 4, 9, 15)
        // TODO: implement this test
    }

    @Test
    public void isPrime_largePrime_returnsTrue() {
        // Test with a larger prime number (e.g., 97)
        // TODO: implement this test
    }

    // ==================== gcd ====================

    @Test
    public void gcd_twoPositiveNumbers_returnsCorrectResult() {
        // gcd(12, 8) = 4
        // TODO: implement this test
    }

    @Test
    public void gcd_oneIsZero_returnsOther() {
        // gcd(0, 5) = 5 and gcd(7, 0) = 7
        // TODO: implement this test
    }

    @Test
    public void gcd_bothZero_throwsException() {
        // gcd(0, 0) is undefined, should throw IllegalArgumentException
        // TODO: implement this test
    }

    @Test
    public void gcd_negativeNumbers_returnsCorrectResult() {
        // gcd(-12, 8) = 4 (should work with negative inputs)
        // TODO: implement this test
    }

    @Test
    public void gcd_equalNumbers_returnsSameNumber() {
        // gcd(6, 6) = 6
        // TODO: implement this test
    }
}
