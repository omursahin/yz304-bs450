package eru.testing.solutions;

import eru.testing.MathUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MathUtilsTestSolution {

    // ==================== factorial ====================

    @Test
    public void factorial_zero_returnsOne() {
        assertThat(MathUtils.factorial(0), equalTo(1L));
    }

    @Test
    public void factorial_positiveNumber_returnsCorrectResult() {
        assertThat(MathUtils.factorial(5), equalTo(120L));
    }

    @Test
    public void factorial_one_returnsOne() {
        assertThat(MathUtils.factorial(1), equalTo(1L));
    }

    @Test
    public void factorial_negativeNumber_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.factorial(-1);
        });
    }

    @Test
    public void factorial_largeNumber_returnsCorrectResult() {
        assertThat(MathUtils.factorial(10), equalTo(3628800L));
    }

    // ==================== isPrime ====================

    @Test
    public void isPrime_two_returnsTrue() {
        assertTrue(MathUtils.isPrime(2));
    }

    @Test
    public void isPrime_one_returnsFalse() {
        assertFalse(MathUtils.isPrime(1));
    }

    @Test
    public void isPrime_negativeNumber_returnsFalse() {
        assertFalse(MathUtils.isPrime(-7));
    }

    @Test
    public void isPrime_compositeNumber_returnsFalse() {
        assertFalse(MathUtils.isPrime(15));
    }

    @Test
    public void isPrime_largePrime_returnsTrue() {
        assertTrue(MathUtils.isPrime(97));
    }

    // ==================== gcd ====================

    @Test
    public void gcd_twoPositiveNumbers_returnsCorrectResult() {
        assertThat(MathUtils.gcd(12, 8), equalTo(4));
    }

    @Test
    public void gcd_oneIsZero_returnsOther() {
        assertThat(MathUtils.gcd(0, 5), equalTo(5));
        assertThat(MathUtils.gcd(7, 0), equalTo(7));
    }

    @Test
    public void gcd_bothZero_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.gcd(0, 0);
        });
    }

    @Test
    public void gcd_negativeNumbers_returnsCorrectResult() {
        assertThat(MathUtils.gcd(-12, 8), equalTo(4));
    }

    @Test
    public void gcd_equalNumbers_returnsSameNumber() {
        assertThat(MathUtils.gcd(6, 6), equalTo(6));
    }
}
