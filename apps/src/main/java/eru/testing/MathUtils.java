package eru.testing;

public class MathUtils {

    /**
     * Returns the factorial of n (n!).
     * Throws IllegalArgumentException if n is negative.
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Returns true if n is a prime number, false otherwise.
     * Numbers less than 2 are not prime.
     */
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the greatest common divisor of a and b using
     * the Euclidean algorithm.
     * Throws IllegalArgumentException if both a and b are zero.
     */
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("gcd(0, 0) is undefined");
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
